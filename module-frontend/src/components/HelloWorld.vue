<template>
  <v-container>
    <v-row text-center wrap>
      <v-v-col>
        <v-img
          :src="require('../assets/logo.svg')"
          class="my-3"
          contain
          height="200"
        ></v-img>
      </v-v-col>
      <v-v-col>
        <h1>{{ $t("helloWorld.welcomeMsg") }}</h1>
        <h2>{{ msg1 }}</h2>
        <h2>{{ msg() }}</h2>
      </v-v-col>
    </v-row>
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
