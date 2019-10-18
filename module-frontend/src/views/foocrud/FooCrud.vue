<template>
  <v-container>
    <v-row>
      <v-col class="text-center">
        <h1>{{ $t("fooCrud.welcome") }}</h1>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="text-center">
        <h3>{{ $t("fooCrud.description") }}</h3>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="text-center">
        <v-btn @click="getException()">
          {{ $t("fooCrud.exception") }}
        </v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-subheader>{{ $t("fooCrud.total") }}-{{ nFoos }}</v-subheader>
      </v-col>
    </v-row>

    <v-row>
      <v-col
        v-if="$vuetify.breakpoint.smAndUp"
      >
        <app-foo-crud-web-table 
          :headers="headers"
          :data="foos"
          :createFunction="cretateFoo"
          :deleteFunction="removeFoo"
        />
      </v-col>
      <v-col
        v-else
      >
        <app-foo-crud-mobile-list 
          :data="foos" 
          :createFunction="cretateFoo"
          :deleteFunction="removeFoo"
        />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import FooCrudWebTable from "@/views/foocrud/table/web/FooCrudWebTable";
import FooCrudMobileList from "@/views/foocrud/table/mobile/FooCrudMobileList";

import { mapState } from "vuex";
export default {
  name: "FooCrud",
  data(){
    return{
      headers: [
        { text: "Id", value: "id" },
        { text: "Name", value: "name" },
        { text: "Value", value: "value" },
        { text: "Actions", value: "action", sortable: false }
      ]
    }
  },
  components: {
    "app-foo-crud-web-table": FooCrudWebTable,
    "app-foo-crud-mobile-list": FooCrudMobileList
  },
  computed: {
    ...mapState({
      foos: state => state.fooModule.foos
    }),
    nFoos() {
      return this.$store.getters["fooModule/getFooQuantity"];
    }
  },
  methods: {
    removeFoo(id) {
      this.$store.dispatch("fooModule/deleteFooData", id);
    },
    cretateFoo() {
      const fooDto = {
        name: `Soy ${new Date().getTime()}`,
        value: `Valor ${new Date().getTime()}`
      };
      this.$store.dispatch("fooModule/createFoo", fooDto);
    },
    getException() {
      this.$store.dispatch("fooModule/launchException");
    }
  }
};
</script>
