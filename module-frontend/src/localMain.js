import Vue from "vue";
import App from "./App.vue";
import Vuetify from "vuetify/lib";
import router from "./router";
import store from "./store";
import EnMessages from "@/messages/en.json";
import EsMessages from "@/messages/es.json";
import axios from "axios";

Vue.config.productionTip = false;

const loadApp = () => {
  window.t_manager.installComponents(Vue);

  ///////////////////////////ROUTER CONFIG///////////////////////////
  router.beforeEach((to, _from, next) => {
    if (to.matched.some(record => record.meta.requiresAuth)) {
      // this route requires auth, check if logged in
      // if not, redirect to login page.
      if (!store.state.token) {
        next({
          path: "/"
        });
      } else {
        next();
      }
    } else {
      next(); // make sure to always call next()!
    }
  });

  ///////////////////////////LANGUAGE CONFIG///////////////////////////
  const i18n = new Vue.loadLanguageUtils(Vue, {
    en: EnMessages,
    es: EsMessages
  });

  i18n.locale = store.state.language;
  store.$i18n = i18n;

  ///////////////////////////VUETIFY CONFIG///////////////////////////
  const vuetify = new Vue.loadCustomVuetify(Vue, Vuetify, i18n);

  ///////////////////////////REQUESTS CONFIG///////////////////////////
  axios.interceptors.request.use(request => {
    //cargando en todas las peticiones
    store.dispatch("loadingAction");
    //internacionalizacion en todas las urls
    request.headers["Accept-language"] = store.state.language;
    //token en todas las urls
    request.headers["Authorization"] = `Bearer ${store.state.token}`;

    return request;
  });

  axios.interceptors.response.use(
    response => {
      store.dispatch("successAction");
      return response;
    },
    error => {
      store.dispatch("errorAction", error);
      return Promise.reject({ ...error });
    }
  );

  ///////////////////////////AUTHENTICATION CONFIG///////////////////////////
  store.dispatch("updateToken", "token falso");
  router.push({ name: "home" });

  ///////////////////////////VUE CONFIG///////////////////////////
  const refreshId = setInterval(() => {
    if (store.state.token) {
      new Vue({
        i18n,
        router,
        store,
        vuetify,
        render: h => h(App)
      }).$mount(`#${store.state.module}`);

      clearInterval(refreshId);
    }
  }, 500);
};

//"http://3.121.59.80:9999/dist/t_manager_common.js"
if (!window.t_manager) {
  axios
    .get(`http://localhost:9999/dist/t_manager_common.js`)
    .then(result => {
      const el = document.createElement("script");
      el.type = "text/javascript";
      el.id = `t_manager_common_js`;
      el.text = result.data;
      document.head.appendChild(el);

      loadApp();
    })
    .catch(() => {});
} else {
  loadApp();
}
