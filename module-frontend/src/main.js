import Vue from "vue";
import App from "./App.vue";
import Vuetify from "vuetify/lib";
import router from "./router";
import store from "./store";
import EnMessages from "@/messages/en.json";
import EsMessages from "@/messages/es.json";
import axios from "axios";

Vue.config.productionTip = false;

Vue.use(Vuetify);

///////////////////////////AUTHENTICATION CONFIG///////////////////////////
let firstTime = true;
const tokenUtils = new window.t_manager.TokenUtils(
  store.state.module,
  window.location.search.split("=")[1],
  token => {
    store.dispatch("updateToken", token);
    if (firstTime) {
      firstTime = false;
      router.push("/home");
    }
  },
  tManagerAccessToken => {
    store.dispatch("updateToken", tManagerAccessToken);
  }
);

if (!window.isModuleEnsambled) {
  const codeStr = window.location.search.split("=")[0];
  if (codeStr.match("code")) {
    tokenUtils.getAuthorizationToken();
  }
} else if (window.isModuleEnsambled[store.state.module]) {
  store.dispatch("updateToken", window.t_manager_access_token);
  tokenUtils.refreshTManagerToken();
  router.push("/home");
} else {
  throw alert("NO AUTH TOKEN");
}

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
const i18n = new window.t_manager.LanguageUtils(Vue, {
  es: EsMessages,
  en: EnMessages
});

i18n.locale = store.state.language;
store.$i18n = i18n;

///////////////////////////VUETIFY CONFIG///////////////////////////
const vuetify = new Vuetify({
  icons: {
    iconfont: "mdi"
  },
  theme: {
    dark: false,
    options: {
      customProperties: true
    }
  },
  lang: {
    t: (key, ...params) => i18n.t(key, params)
  }
});

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
    return response;
  },
  error => {
    store.dispatch("errorAction", error);
    return Promise.reject({ ...error });
  }
);

///////////////////////////VUE CONFIG///////////////////////////
new Vue({
  i18n,
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount(`#${store.state.module}`);
