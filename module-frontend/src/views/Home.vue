<template>
  <v-container>
    <v-row>
      <v-col>
        <app-hello-world />
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <v-btn
          v-for="(language, index) in languages"
          :key="index"
          @click="updateLanguage(language.id)"
        >
          <app-country-flag :country="language.flag" />
        </v-btn>
      </v-col>
    </v-row>
    <v-row text-center wrap>
      <v-col>
        <v-col 
          xs=12
          sm=6
          md=4
        >
          <v-combobox
            v-model="selectedTheme"
            :items="themes"
            label="Select a theme"
          >
          </v-combobox>
        </v-col>
        <v-col 
          xs=12
          sm=6
          md=4
        >
          <v-switch 
            v-model="dark" 
            label="Dark"
          >
          </v-switch>
        </v-col>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
import CountryFlag from "vue-country-flag";

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
