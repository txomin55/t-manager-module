<template>
  <v-container>
    <v-row text-center wrap>
      <v-col>
        <v-img
          :src="require('../assets/logo.svg')"
          class="my-3"
          contain
          height="200"
        ></v-img>
      </v-col>
    </v-row>
    <v-row>
      <v-col class="text-center">
        <h1>{{ $t("helloWorld.welcomeMsg") }} (TEMPLATE)</h1>
        <h2>{{ msg1 }} (COMPUTED)</h2>
        <h2>{{ msg() }} (METHOD)</h2>
      </v-col>
    </v-row>
    <v-row>
      <v-col class="text-center">
        <h4>YOUR DATA</h4>
        {{ userData }}
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import { mapState } from "vuex";
export default {
  data: () => ({}),
  methods: {
    msg() {
      return this.$i18n.t("helloWorld.welcomeMsgSub");
    }
  },
  computed: {
    msg1() {
      return this.$i18n.t("helloWorld.welcomeMsgSub");
    },
    ...mapState({
      userData: state => state.userData
    })
  }
};
</script>
