import * as ConfigApi from "../api/ConfigApi";
const DEFAULT_LOCALE = process.env.VUE_APP_DEFAULT_LOCALE;
const MODULE_NAME = process.env.VUE_APP_MODULE_NAME;

export default {
  state: {
    language: DEFAULT_LOCALE,
    token: null,
    status: null,
    statusApiCall: null,
    error: null,
    module: MODULE_NAME,
    userData: null
  },
  mutations: {
    LOADING(state) {
      state.status = "loading";
    },
    ERROR(state, errCode) {
      state.status = "error";
      state.error = errCode;
    },
    SUCCESS(state) {
      state.status = "success";
      state.error = "no_error";
    },
    SUCCESS_API(state) {
      state.statusApiCall = "success";
    },
    INIT_SUCCESS_API(state) {
      state.statusApiCall = null;
    },
    UPDATE_TOKEN(state, newToken) {
      state.token = newToken;
    },
    UPDATE_LANGUAGE(state, newLanguage) {
      state.language = newLanguage;
      this.$i18n.locale = state.language;
    },
    INIT_USER_DATA(state, user) {
      state.userData = user;
    }
  },
  actions: {
    updateToken(context, newToken) {
      context.commit("UPDATE_TOKEN", newToken);
    },
    updateLanguage(context, newLanguage) {
      context.commit("UPDATE_LANGUAGE", newLanguage);
    },
    successAction(context) {
      context.commit("SUCCESS");
    },
    successApiAction(context) {
      context.commit("SUCCESS_API");
    },
    initSuccessApiAction(context) {
      context.commit("INIT_SUCCESS_API");
    },
    errorAction(context, response) {
      context.commit("ERROR", response);
    },
    loadingAction(context) {
      context.commit("LOADING");
    },
    initUserData(context, cb) {
      ConfigApi.getUserData(user => {
        context.commit("INIT_USER_DATA", user);
        cb();
      });
    },
    logout(context) {
      ConfigApi.logout(() => {
        context.commit("UPDATE_TOKEN", null);
      });
    }
  },
  getters: {
    getUserData(state){
      return state.userData;
    },
    getUserCanCreateFoo(state){
      return state.userData.scope.includes("create-foo");
    },
    getUserCanEditFoo(state){
      return state.userData.scope.includes("update-foo");
    },
    getUserCanDeleteFoo(state){
      return state.userData.scope.includes("delete-foo");
    },
    getUserLocale(state){
      return state.userData.locale ? state.userData.locale : DEFAULT_LOCALE;
    }
  }
};
