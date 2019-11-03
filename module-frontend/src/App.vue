<template>
  <v-app>
    <app-navbar v-if="isLogged" />

    <v-content>
      <app-loading-handler />
      <app-error-handler />
      <router-view />
    </v-content>

    <app-footer />
  </v-app>
</template>

<script>
import ErrorHandler from "@/components/error/ErrorHandler";
import LoadingHandler from "@/components/loading/LoadingHandler";
import Footer from "@/components/footer/Footer";
import NavBar from "@/components/navbar/NavBar";
import { mapState } from "vuex";

export default {
  components: {
    "app-navbar": NavBar,
    "app-error-handler": ErrorHandler,
    "app-loading-handler": LoadingHandler,
    "app-footer": Footer
  },
  computed: {
    ...mapState({
      isLogged: state => {
        return state.token;
      }
    })
  }
};
</script>
