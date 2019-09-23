<template>
  <v-container fluid>
    <v-layout text-center>
      <v-row>
        <v-col>
          <h1>{{ $t("fooCrud.welcome") }}</h1>
        </v-col>
      </v-row>
    </v-layout>

    <v-layout text-center>
      <v-row>
        <v-col>
          <v-card>
            <v-subheader>{{ $t("fooCrud.description") }}</v-subheader>
          </v-card>
        </v-col>
      </v-row>
    </v-layout>

    <v-layout text-center>
      <v-row>
        <v-col>
          <v-btn @click="getException()">
            {{ $t("fooCrud.exception") }}
          </v-btn>
        </v-col>
      </v-row>
    </v-layout>

    <v-layout text-center>
      <v-row>
        <v-col>
          <v-btn @click="cretateFoo()">
            {{ $t("fooCrud.create") }}
          </v-btn>
        </v-col>
      </v-row>
    </v-layout>

    <v-layout text-center>
      <v-row>
        <v-col>
          <v-subheader>{{ $t("fooCrud.total") }}-{{ nFoos }}</v-subheader>
          <v-list-item v-for="(foo, index) in foos" :key="index">
            <v-list-item-content>
              <v-row>
                <v-col>
                  <v-list-item-title>
                    {{ foo.name }}-{{ foo.value }}
                  </v-list-item-title>
                </v-col>
                <v-col>
                  <v-btn @click="removeFoo(foo.value)">
                    {{ $t("fooCrud.remove") }}
                  </v-btn>
                </v-col>
              </v-row>
            </v-list-item-content>
          </v-list-item>
        </v-col>
      </v-row>
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
      const fooDto = {
        name: `Soy ${new Date().getTime()}`
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
