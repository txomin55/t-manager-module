<template>
  <v-app>
    <module-navbar v-if="!isEmbebed" />

    <v-content>
      <module-loading-handler />
      <module-error-handler />
      <router-view />
    </v-content>

    <module-footer v-if="!isEmbebed" />
  </v-app>
</template>

<script>
import ErrorHandler from "@/components/error/ErrorHandler";
import LoadingHandler from "@/components/loading/LoadingHandler";
import Footer from "@/components/footer/Footer";
import NavBar from "@/components/navbar/NavBar";

export default {
  components: {
    "module-navbar": NavBar,
    "module-error-handler": ErrorHandler,
    "module-loading-handler": LoadingHandler,
    "module-footer": Footer
  },
  data() {
    return {
      isEmbebed:
        window.isModuleEnsambled &&
        window.isModuleEnsambled[this.$store.state.module]
    };
  },
  mounted() {
    if (
      window.isModuleEnsambled &&
      window.isModuleEnsambled[this.$store.state.module]
    ) {
      this.$router.push({ name: "home" });

      this.$vuetify.theme.themes.light = window.t_manager.plugins.Themes[window.t_manager_theme].light;
      this.$vuetify.theme.themes.dark = window.t_manager.plugins.Themes[window.t_manager_theme].dark;
      this.$vuetify.theme.dark = window.t_manager_dark;
      this.$store.dispatch("updateLanguage", window.t_manager_language);
    }

    this.$store.dispatch("initUserData", () => {
      this.$store.dispatch("updateLanguage", this.$store.getters.getUserLocale);
    });
  }
};
</script>
