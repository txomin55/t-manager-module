import Vue from "vue";
import VueResource from "vue-resource";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import EnMessages from "@/messages/en.json";
import EsMessages from "@/messages/es.json";

Vue.config.productionTip = false;

Vue.use(VueResource);

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

const i18n = new window.t_manager.LanguageUtils(Vue, {
  es: EsMessages,
  en: EnMessages
});

i18n.locale = this.$store.state.language;
store.$i18n = i18n;

Vue.http.interceptors.push((request, next) => {
  //internacionalizacion en todas las urls
  request.url = `${request.url}?lang=${store.getters["getLanguage"]}`;

  //token en todas las urls
  request.headers.set("token", store.getters["getToken"]);

  next();
});

new Vue({
  i18n,
  router,
  store,
  render: h => h(App)
}).$mount("#app");
