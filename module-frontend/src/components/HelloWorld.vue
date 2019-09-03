<template>
  <div class="hello">
    <h1>{{ $t("helloWorld.welcomeMsg") }}</h1>
    <h2>{{ msg1 }}</h2>
    <h2>{{ msg() }}</h2>
  </div>
</template>

<script>
export default {
  name: "HelloWorld",
  data() {
    return {
      msg1: this.$i18n.t("helloWorld.welcomeMsgSub")
    };
  },
  methods: {
    msg() {
      return this.$i18n.t("helloWorld.welcomeMsgSub");
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
</style>
