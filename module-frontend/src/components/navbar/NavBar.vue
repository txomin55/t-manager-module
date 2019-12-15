<template>
  <v-app-bar app>
    <v-toolbar-title class="headline text-uppercase">
      <span>Your</span>
      <span class="font-weight-light">{{ module }}</span>
    </v-toolbar-title>
    <v-spacer></v-spacer>

    <template v-if="$vuetify.breakpoint.smAndUp">
      <v-btn text>
        <router-link :to="{ name: 'home' }">Home</router-link>
      </v-btn>
      <v-btn text>
        <router-link :to="{ name: 'foo' }">Foo</router-link>
      </v-btn>
      <v-btn text icon>
        <router-link :to="{ name: 'about' }" class="no-decoration"
          ><v-icon>mdi-help-circle-outline</v-icon></router-link
        >
      </v-btn>
      <v-btn text icon class="no-decoration">
        <v-icon @click="logout()" color="primary">mdi-logout-variant</v-icon>
      </v-btn>
    </template>
    <template v-else>
      <v-app-bar-nav-icon @click="drawer = !drawer"> </v-app-bar-nav-icon>

      <v-navigation-drawer v-model="drawer" app clipped left hide-overlay>
        <v-list>
          <v-list-item>
            <v-list-item-content>
              <v-list-item-title>Your links</v-list-item-title>
            </v-list-item-content>
          </v-list-item>
          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-home-outline</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title
                ><router-link :to="{ name: 'home' }">{{
                  $t("module.home")
                }}</router-link></v-list-item-title
              >
            </v-list-item-content>
          </v-list-item>

          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-creation</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title
                ><router-link :to="{ name: 'foo' }"
                  >Foo</router-link
                ></v-list-item-title
              >
            </v-list-item-content>
          </v-list-item>

          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-help-circle-outline</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title
                ><router-link :to="{ name: 'about' }">{{
                  $t("module.about")
                }}</router-link></v-list-item-title
              >
            </v-list-item-content>
          </v-list-item>

          <v-list-item>
            <v-list-item-action>
              <v-icon>mdi-logout-variant</v-icon>
            </v-list-item-action>
            <v-list-item-content>
              <v-list-item-title @click="logout()"
                ><a color="primary" class="underline">{{
                  $t("module.logout")
                }}</a></v-list-item-title
              >
            </v-list-item-content>
          </v-list-item>
        </v-list>
      </v-navigation-drawer>

      <v-navigation-drawer fixed temporary></v-navigation-drawer>
    </template>
  </v-app-bar>
</template>

<script>
import { mapState } from "vuex";

export default {
  data() {
    return {
      drawer: null
    };
  },
  computed: {
    ...mapState({
      module: state => state.module
    })
  },
  methods: {
    logout() {
      this.$store.dispatch("logout");
      this.$router.push({ name: "init" });
    }
  }
};
</script>

<style scoped>
.no-decoration {
  text-decoration: none;
}
.underline {
  text-decoration: underline;
}
</style>
