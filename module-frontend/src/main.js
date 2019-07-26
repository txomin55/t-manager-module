import Vue from "vue";
import VueResource from 'vue-resource'
import App from "./App.vue";
import router from "./router";
import store from "./store";
import EnMessages from '@/messages/en.json';
import EsMessages from '@/messages/es.json';

Vue.config.productionTip = false;

Vue.use(VueResource)

if(window.location.search.split("=")[0].match("code")){
	
	let firstTime = true;
	const tokenUtils = new window.t_manager.TokenUtils('module', window.location.search.split("=")[1], token => {
		window.access_token = token
		if(firstTime){	
			firstTime = false
			router.push('/home')
		}
	})
	
	tokenUtils.getAuthorizationToken()
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
