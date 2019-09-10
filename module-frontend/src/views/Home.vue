<template>
  <v-container fluid>
    <v-layout text-center wrap>
      <v-flex xs12>
        <app-hello-world />
      </v-flex>
    </v-layout>
    <v-layout text-center wrap>
      <v-flex xs12>
        <v-btn
          v-for="(language, index) in languages"
          :key="index"
          @click="updateLanguage(language.id)"
        >
          <app-country-flag :country="language.flag" />
        </v-btn>
      </v-flex>
    </v-layout>
    <v-layout text-center wrap>
      <v-flex xs12>
        <v-flex xs2>
          <v-combobox
            v-model="selectedTheme"
            :items="themes"
            label="Select a theme"
          ></v-combobox>
        </v-flex>
        <v-flex xs1>
          <v-switch v-model="dark" label="Dark"></v-switch>
        </v-flex>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
import CountryFlag from "vue-country-flag";
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "home",
  components: {
    appHelloWorld: HelloWorld,
    appCountryFlag: CountryFlag
  },
  data() {
    return {
      dark: false,
      selectedTheme: null,
      themes: Object.keys(window.t_manager.Themes),
      languages: [{ flag: "es", id: "es" }, { flag: "gb", id: "en" }]
    };
  },
  methods: {
    updateLanguage(id) {
      this.$store.dispatch("updateLanguage", id);
    }
  },
  mounted() {
    this.$store.dispatch("fooModule/initFooData");
  },
  watch: {
    selectedTheme(val) {
      this.$vuetify.theme.themes.light = window.t_manager.Themes[val].light;
      this.$vuetify.theme.themes.dark = window.t_manager.Themes[val].dark;

      this.$vuetify.theme.dark = this.dark;
    },
    dark(val) {
      this.$vuetify.theme.dark = val;
    }
  }
};
</script>
