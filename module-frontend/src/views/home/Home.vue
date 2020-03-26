<template>
  <v-container>
    <router-link :to="{ name: 'home' }">{{ $t("module.home") }}</router-link>
    |
    <router-link :to="{ name: 'foo' }">Foo</router-link>
    |
    <router-link :to="{ name: 'about' }">{{ $t("module.about") }}</router-link>

    <v-row text-center wrap>
      <v-col>
        <v-img :src="logo" class="text-center" contain height="200"></v-img>
      </v-col>
    </v-row>
    <v-row>
      <v-col class="text-center">
        <h1>{{ $t("module.helloWorld.welcomeMsg") }} (TEMPLATE)</h1>
        <h2>{{ msg1 }} (COMPUTED)</h2>
        <h2>{{ msg() }} (METHOD)</h2>
      </v-col>
    </v-row>
    <v-row>
      <v-col class="text-center">
        <h4>ENV</h4>
        ({{ env }})
      </v-col>
    </v-row>
    <v-row>
      <v-col class="text-center">
        <h4>{{ $t("module.yourData") }}</h4>
        {{ userData }}
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <div class="text-center">
          <v-btn
            v-for="(language, index) in languages"
            :key="index"
            @click="updateLanguage(language.id)"
          >
            <app-country-flag :country="language.flag" />
          </v-btn>
        </div>
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-col sm="12" md="1">
        <v-combobox
          v-model="selectedTheme"
          :items="themes"
          :label="$t('module.selectTheme')"
        >
        </v-combobox>
      </v-col>
      <v-col sm="12" md="1">
        <v-switch v-model="dark" :label="$t('module.dark')"> </v-switch>
      </v-col>
    </v-row>
    <v-row justify="center">
      <v-btn v-for="(color, index) in colors" :key="index" :color="color">
        {{ color }}
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
import { mapState } from "vuex";
import CountryFlag from "vue-country-flag";

export default {
  name: "Home",
  components: {
    appCountryFlag: CountryFlag
  },
  data() {
    return {
      dark: false,
      selectedTheme: null,
      themes: Object.keys(window.t_manager.plugins.Themes),
      languages: [{ flag: "es", id: "es" }, { flag: "gb", id: "en" }],
      colors: [],
      env: process.env.VUE_APP_ENV,
      logo: `${process.env.VUE_APP_ADDRESS}/module/static/logo.svg`
    };
  },
  methods: {
    updateLanguage(id) {
      this.$store.dispatch("updateLanguage", id);
    },
    updateColors() {
      const theme = this.$vuetify.theme.dark
        ? this.$vuetify.theme.themes.dark
        : this.$vuetify.theme.themes.light;
      this.colors = Object.keys(theme);
    },
    msg() {
      return this.$i18n.t("module.helloWorld.welcomeMsgSub");
    }
  },
  computed: {
    msg1() {
      return this.$i18n.t("module.helloWorld.welcomeMsgSub");
    },
    ...mapState({
      userData: state => state.userData
    })
  },
  watch: {
    selectedTheme(val) {
      this.$vuetify.theme.themes.light =
        window.t_manager.plugins.Themes[val].light;
      this.$vuetify.theme.themes.dark =
        window.t_manager.plugins.Themes[val].dark;

      this.$vuetify.theme.dark = this.dark;
      this.updateColors();
    },
    dark(val) {
      this.$vuetify.theme.dark = val;
      this.updateColors();
    }
  },
  mounted() {
    this.updateColors();
  }
};
</script>
