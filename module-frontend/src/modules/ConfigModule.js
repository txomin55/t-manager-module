const DEFAULT_LOCALE = "es"; //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES
const MODULE_NAME = "module"; //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

export default {
  state: {
    language: DEFAULT_LOCALE,
    token: null,
    status: null,
    error: null,
    module: MODULE_NAME
  },
  mutations: {
    LOADING(state){
      state.status = "loading";
    },
    ERROR(state, errCode){
      state.status = "error";
      state.error = errCode;
    },
    SUCCESS(state){
      state.status = "success";
      state.error = null;
    },
    UPDATE_TOKEN(state, newToken){
      state.token = newToken;
    },
    UPDATE_LANGUAGE(state, newLanguage){
      state.language = newLanguage;
      this.$i18n.locale = state.language;
    }
  },
  actions: {
    updateToken(context, newToken){
      context.commit("UPDATE_TOKEN", newToken);
    },
    updateLanguage(context, newLanguage){
      context.commit("UPDATE_LANGUAGE", newLanguage);
    },
    successAction(context){
      context.commit("SUCCESS");
    },
    errorAction(context, response){
      context.commit("ERROR", response);
    },
    loading({ commit }) {
      commit("loading");
    }
  },
  getters: {
    getLanguage(state){
      return state.language;
    },
    getToken(state){
      return state.token;
    }
  }
};
