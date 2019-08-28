import Vue from "vue";
import VueResource from 'vue-resource'
import App from "./App.vue";
import router from "./router";
import store from "./store";
import EnMessages from '@/messages/en.json';
import EsMessages from '@/messages/es.json';

const MODULE_NAME = 'module' //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

Vue.config.productionTip = false;

Vue.use(VueResource)

let firstTime = true;
if(!window.isModuleEnsambled || !window.isModuleEnsambled[MODULE_NAME]){
  if(window.location.search.split("=")[0].match("code")){
    
    const tokenUtils = new window.t_manager.TokenUtils(MODULE_NAME, window.location.search.split("=")[1], token => {
      window.access_token = token //TODO: CAMBIAR POR VUEX GENERAL??
      if(firstTime){	
        firstTime = false
        router.push('/home')
      }
    })
    
    tokenUtils.getAuthorizationToken()
  }
}else if(window.isModuleEnsambled['module']){
  window.access_token = window.t_manager_access_token //TODO: CAMBIAR POR VUEX GENERAL??
  if(firstTime){	
    firstTime = false
    router.push('/home')
  }
} else{
  throw alert("NO HAY TOKEN PARA AUTORIZACION")
}

const i18n = new window.t_manager.LanguageUtils(
  Vue,
  {
    es : EsMessages,
    en : EnMessages
  }
);

i18n.locale = store.getters.language

Vue.http.interceptors.push((request, next) => {  
  
  //internacionalizacion en todas las urls
  request.url = `${request.url}?lang=${store.getters.language}`
})

new Vue({
  i18n,
  router,
  store,
  render: h => h(App)
}).$mount("#app");
