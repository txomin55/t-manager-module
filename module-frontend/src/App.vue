<template>

   <v-app>
    <v-app-bar app>
      <v-toolbar-title class="headline text-uppercase">
        <span>Vuetify</span>
        <span class="font-weight-light">MATERIAL DESIGN</span>
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-toolbar-items class="hidden-sm-and-down">
        <v-btn text>
          <router-link to="/">Home</router-link>
        </v-btn>
        <v-btn text>
          <router-link to="/fooCrud">Foo crud</router-link>
        </v-btn>
      </v-toolbar-items>
      <v-btn
        text
        href="https://github.com/vuetifyjs/vuetify/releases/latest"
        target="_blank"
      >
        <span class="mr-2">Latest Release</span>
      </v-btn>
    </v-app-bar>

    <v-content>
      <router-view/>
      <app-error-handler />
    </v-content>
  </v-app>
  
</template>

<script>
import ErrorHandler from "@/components/ErrorHandler";

export default {
  components: {
    "app-error-handler": ErrorHandler
  }
};
</script>

<style>

</style>
