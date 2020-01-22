import * as ConfigApi from "../api/ConfigApi";
const DEFAULT_LOCALE = process.env.VUE_APP_DEFAULT_LOCALE;
const MODULE_NAME = process.env.VUE_APP_MODULE_NAME;

export default {
  state: {
    language: DEFAULT_LOCALE,
    token: null,
    status: null,
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
      state.error = null;
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
    errorAction(context, response) {
      context.commit("ERROR", response);
    },
    loadingAction(context) {
      context.commit("LOADING");
    },
    initUserData(context) {
      ConfigApi.getUserData(user => {
        context.commit("INIT_USER_DATA", user);
      });
    },
    logout(context) {
      context.commit("UPDATE_TOKEN", null);
      window.location.href = `/${MODULE_NAME}`;
    }
  }
};
