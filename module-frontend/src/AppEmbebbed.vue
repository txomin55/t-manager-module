<template>
  <v-app>
  
    <v-content>
      <app-loading-handler />
      <app-error-handler />
      <router-view />
    </v-content>

  </v-app>
</template>

<script>
import ErrorHandler from "@/components/error/ErrorHandler";
import LoadingHandler from "@/components/loading/LoadingHandler";

export default {
  components: {
    "app-error-handler": ErrorHandler,
    "app-loading-handler": LoadingHandler,
  }
};
</script>
