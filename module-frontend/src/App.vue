<template>
  <v-app>
    <app-navbar v-if="!isEmbebed" />

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

export default {
  components: {
    "app-navbar": NavBar,
    "app-error-handler": ErrorHandler,
    "app-loading-handler": LoadingHandler,
    "app-footer": Footer
  },
  data() {
    return {
      isEmbebed:
        window.isModuleEnsambled &&
        window.isModuleEnsambled[this.$store.state.module]
    };
  }
};
</script>
