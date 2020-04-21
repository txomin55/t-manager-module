<template>
  <v-app>
    <module-navbar v-if="!isEmbebed" />

    <module-notification-handler />

    <v-content>
      <module-loading-handler />
      <router-view v-if="userData"/>
    </v-content>

    <module-footer v-if="!isEmbebed" />
  </v-app>
</template>

<script>
import NotificationHandler from "@/components/notification/NotificationHandler";
import LoadingHandler from "@/components/loading/LoadingHandler";
import Footer from "@/components/footer/Footer";
import NavBar from "@/components/navbar/NavBar";
import {mapGetters} from "vuex";

export default {
  components: {
    "module-navbar": NavBar,
    "module-notification-handler": NotificationHandler,
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
  computed: {
    ...mapGetters({
      userData : "getUserData"
    })
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
