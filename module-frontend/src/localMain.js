import Vue from "vue";
import App from "./App.vue";
import Vuetify from "vuetify/lib";
import router from "./router";
import store from "./store";
import EnMessages from "@/messages/en.json";
import EsMessages from "@/messages/es.json";
import axios from "axios";
import LoadScript from "vue-plugin-load-script";

Vue.use(LoadScript);

window.Vue = Vue;
Vue.config.productionTip = false;

//"http://3.121.59.80:9999/dist/t_manager_common.js"
Vue.loadScript("http://localhost:9999/dist/t_manager_common.js")
  .then(() => {
    loadApp();
  })
  .catch(() => {
    console.error("NO HAY COMMONS");
  });

const loadApp = () => {
  ///////////////////////////INIT T-MANAGER COMMONS//////////////////////////
  window.t_manager.install(Vue);

  ///////////////////////////AUTHENTICATION CONFIG///////////////////////////
  store.dispatch("updateToken", "token falso");
  router.push("/home");

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
  const i18n = new window.t_manager.plugins.LanguageUtils(Vue, {
    en: EnMessages,
    es: EsMessages
  });

  i18n.locale = store.state.language;
  store.$i18n = i18n;

  ///////////////////////////VUETIFY CONFIG///////////////////////////
  const vuetify = new window.t_manager.plugins.CustomVuetify(
    Vue,
    Vuetify,
    i18n
  );

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
