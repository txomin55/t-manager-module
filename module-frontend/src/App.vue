<template>
  <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>Your</span>
        <span class="font-weight-light">{{ module }}</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>

      <template v-if="$vuetify.breakpoint.smAndUp">
        <v-btn text>
          <router-link to="/home">Home</router-link>
        </v-btn>
        <v-btn text>
          <router-link to="/fooCrud">Foo crud</router-link>
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
                  ><router-link to="/home">Home</router-link></v-list-item-title
                >
              </v-list-item-content>
            </v-list-item>
            <v-list-item>
              <v-list-item-action>
                <v-icon>mdi-creation</v-icon>
              </v-list-item-action>
              <v-list-item-content>
                <v-list-item-title
                  ><router-link to="/fooCrud"
                    >Foo crud</router-link
                  ></v-list-item-title
                >
              </v-list-item-content>
            </v-list-item>
          </v-list>
        </v-navigation-drawer>

        <v-navigation-drawer
          v-model="left"
          fixed
          temporary
        ></v-navigation-drawer>
      </template>
    </v-app-bar>

    <v-content>
      <app-error-handler />
      <router-view />
    </v-content>

    <v-footer app>
      <span class="white--text">&copy;T-Manager 2019</span>
    </v-footer>
  </v-app>
</template>

<script>
import ErrorHandler from "@/components/ErrorHandler";
import { mapState } from "vuex";

export default {
  components: {
    "app-error-handler": ErrorHandler
  },
  data() {
    return {
      drawer: null
    };
  },
  computed: {
    ...mapState({
      module: state => state.module
    })
  }
};
</script>

<style></style>
