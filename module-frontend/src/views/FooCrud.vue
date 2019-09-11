<template>
  <v-container fluid>
      <v-layout text-center wrap>
        <v-flex xs12>
          <h1>{{ $t("fooCrud.welcome") }}</h1>
        </v-flex>
      </v-layout>

      <v-layout text-center wrap>
        <v-flex xs12>
          <v-subheader>{{ $t("fooCrud.description") }}</v-subheader>
        </v-flex>
      </v-layout>

      <v-layout text-center wrap>
        <v-flex xs12>
          <v-btn 
           text 
           @click="getException()"
          >
            {{ $t("fooCrud.exception") }}
          </v-btn >
        </v-flex>
      </v-layout>

      <v-layout text-center wrap>
        <v-flex xs12>
          <v-subheader>{{ $t("fooCrud.total") }}-{{ nFoos }}</v-subheader>
          <v-list-item
            v-for="(foo, index) in foos"
            :key="index"
          >
            <v-list-item-content>
              <v-list-item-title>
                {{ foo.name }}-{{ foo.value }}
              </v-list-item-title>

              <v-btn 
               text
               @click="removeFoo(foo.value)"
              >
                {{ $t("fooCrud.remove") }}
              </v-btn>

            </v-list-item-content>
          </v-list-item>
          
        </v-flex>
      </v-layout>

      <v-layout text-center wrap>
        <v-flex xs12>
          <v-btn 
            @click="cretateFoo()"
            text
          >
              {{ $t("fooCrud.create") }}
          </v-btn>
        </v-flex>
      </v-layout>

  </v-container>
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
