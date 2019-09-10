<template>
  <v-container>
    <v-layout text-center wrap>
      <v-flex xs12>
        <v-img
          :src="require('../assets/logo.svg')"
          class="my-3"
          contain
          height="200"
        ></v-img>
      </v-flex>

      <v-flex xs12>
        <h1>{{ $t("helloWorld.welcomeMsg") }}</h1>
        <h2>{{ msg1 }}</h2>
        <h2>{{ msg() }}</h2>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
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
    }
  }
};
</script>
