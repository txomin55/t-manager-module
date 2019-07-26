<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png" />
    <h3>Access token</h3>
    {{accessToken}}
    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "home",
  components: {
    HelloWorld
  },
  data() {
  	return {  	
  		accessToken : window.access_token
  	}
  }
};
</script>
