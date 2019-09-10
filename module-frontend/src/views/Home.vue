<template>
  <v-container fluid>
      
      <v-row>
        <v-col>
          <img alt="Vue logo" src="../assets/logo.png" />
        </v-col>
      </v-row>
      
      <v-row>
        <v-col>
          <app-helloWorld />
        </v-col>
      </v-row>
      
      <v-row>
        <v-col>
          <div class="flags">
            <button
              v-for="(language, index) in languages"
              :key="index"
              @click="updateLanguage(language.id)"
            >
              <app-country-flag :country="language.flag" />
            </button>
          </div>
        </v-col>
      </v-row>

      <v-row>
        <v-col>
          <v-combobox
            v-model="selectedTheme"
            :items="themes"
            label="Select a theme"
          ></v-combobox>
        </v-col>
        <v-col>
          <v-switch v-model="dark" label="Dark"></v-switch>
        </v-col>
      </v-row>
      
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
      dark : false,
      selectedTheme : null,
      themes : Object.keys(window.t_manager.Themes),
      languages: [
        { flag: "es", id: "es" },
        { flag: "gb", id: "en" }
      ]
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
   selectedTheme(val){

    this.$vuetify.theme.themes.light = window.t_manager.Themes[val].light;
    this.$vuetify.theme.themes.dark = window.t_manager.Themes[val].dark;

    this.$vuetify.theme.dark = this.dark;

   } 
  }
};
</script>
