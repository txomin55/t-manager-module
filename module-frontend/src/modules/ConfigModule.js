const DEFAULT_LOCALE = 'es' //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

export default ({
    namespaced: true,
    state() {
        return {
            language : DEFAULT_LOCALE,
            token : null
          } 
    },
    mutations: { 
        UPDATE_TOKEN: (state, newToken) =>{
            state.token = newToken
        },
        UPDATE_LANGUAGE: (state, newLanguage) =>{
            state.language = newLanguage
            this.$i18n.locale = state.language
        }
    },
    actions: { 
        updateToken: (context, newToken) => {
            context.commit('UPDATE_TOKEN', newToken)
        },
        updateLanguage: (context, newLanguage) => {
            context.commit('UPDATE_LANGUAGE', newLanguage)
        }
    },
    getters: { 
        getLanguage: state => {
            return state.language
        },
        getToken: state => {
            return state.token
        }
    }
})