<template>
  <div class="foo">
    <h1>{{ $t("fooCrud.welcome") }}</h1>
    <p>
      {{ $t("fooCrud.description") }}
    </p>
    <div>
      <button type="button" @click="getException()">
        {{ $t("fooCrud.exception") }}
      </button>
    </div>
    <div>
      {{ $t("fooCrud.total") }}-{{ nFoos }}
      <ul>
        <li v-for="(foo, index) in foos" :key="index">
          <label>{{ foo.name }}-{{ foo.value }}</label>
          <button type="button" @click="removeFoo(foo.value)">
            {{ $t("fooCrud.remove") }}
          </button>
        </li>
      </ul>

      <div>
        <button type="button" @click="cretateFoo()">
          {{ $t("fooCrud.create") }}
        </button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "FooCrud",
  computed: {
    foos() {
      return this.$store.getters["fooModule/getMappedFoo"];
    },
    nFoos() {
      return this.$store.getters["fooModule/getFooQuantity"];
    }
  },
  methods: {
    removeFoo(foo) {
      this.$store.dispatch("fooModule/deleteFooData", foo.id);
    },
    cretateFoo() {
      const rValue = Math.floor(Math.random() * 10 + 1);
      const fooDto = {
        id: rValue
      };
      this.$store.dispatch("fooModule/createFoo", fooDto);
    },
    getException() {
      this.$store.dispatch("fooModule/launchException");
    }
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped></style>
