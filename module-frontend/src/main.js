import Vue from "vue";
import App from "./App.vue";
import Vuetify from "vuetify/lib";
import router from "./router";
import store from "./store";
import EnMessages from "@/messages/en.json";
import EsMessages from "@/messages/es.json";
import vuetify from "./plugins/vuetify";
import axios from 'axios'

Vue.prototype.$http = axios;

Vue.config.productionTip = false;

Vue.use(VueResource);
Vue.use(Vuetify);

let firstTime = true;
if (
  !window.isModuleEnsambled ||
  !window.isModuleEnsambled[store.state.module]
) {
  const codeStr = window.location.search.split("=")[0];
  if (codeStr.match("code")) {
    const tokenUtils = new window.t_manager.TokenUtils(
      store.state.module,
      window.location.search.split("=")[1],
      token => {
        store.dispatch("updateToken", token);
        if (firstTime) {
          firstTime = false;
          router.push("/home");
        }
      }
    );
    tokenUtils.getAuthorizationToken();
  }
} else if (window.isModuleEnsambled["module"]) {
  if (firstTime) {
    store.dispatch("updateToken", window.t_manager_access_token);
    firstTime = false;
    router.push("/home");
  } else {
    setInterval(() => {
      store.dispatch("updateToken", window.t_manager_access_token);
    }, window.t_manager_access_token_validity);
  }
} else {
  throw alert("NO AUTH TOKEN");
}

router.beforeEach((to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    // this route requires auth, check if logged in
    // if not, redirect to login page.
    if (store.state.token) {
      next({
        path: '/',
        query: { redirect: to.fullPath }
      })
    } else {
      next()
    }
  } else {
    next() // make sure to always call next()!
  }
})

const i18n = new window.t_manager.LanguageUtils(Vue, {
  es: EsMessages,
  en: EnMessages
});

i18n.locale = store.state.language;
store.$i18n = i18n;

Vue.http.interceptors.request.use(
  request => {
    //internacionalizacion en todas las urls
    request.headers.set("Accept-language", store.state.language);
    //token en todas las urls
    request.headers.set("Authorization", `Bearer ${store.state.token}`);

    return request;
  }
);

Vue.http.interceptors.response.use(
  response => {
    return response;
  },
  error => {
    if (response.status != 200) {
      store.dispatch("errorAction", response);
    }
    
    return Promise.reject({ ...error })
  }
);


new Vue({
  i18n,
  router,
  store,
  vuetify,
  render: h => h(App)
}).$mount("#app");
