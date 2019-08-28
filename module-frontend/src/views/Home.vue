<template>
  <div class="home">
    <img 
    alt="Vue logo" 
    src="../assets/logo.png" />
    <app-helloWorld/>
    <hr>
    <div class="flags">
      <button 
      v-for="(language, index) in languages" 
      :key="index" 
      @click="updateLanguage(language.id)">
        <app-country-flag 
        :country='language.flag'/>
      </button>
    </div>
  </div>
</template>

<script>
import CountryFlag from 'vue-country-flag'
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "home",
  components: {
    appHelloWorld : HelloWorld,
    appCountryFlag : CountryFlag
  },
  data() {
  	return {  	
  		languages : [
        {flag : 'es', id : 'es'},
        {flag : 'gb', id : 'en'}
      ]
  	}
  },
  methods: {
    updateLanguage(id){
      this.$store.dispatch('updateLanguage', id)
    }
  }
};
</script>
