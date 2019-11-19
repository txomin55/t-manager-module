<template>
  <v-app>
    <app-navbar />

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
  }
};
</script>
