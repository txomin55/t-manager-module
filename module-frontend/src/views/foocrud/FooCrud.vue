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
      <app-tmanager-table
        :headers="headers"
        :data="data"
        :deleteFunction="removeFoo"
        :columnData="columnData"
        :creationPanel="fooCreatePanel"
      />
    </v-row>
  </v-container>
</template>

<script>
import TManagerTable from "@/views/foocrud/table/TManagerTable";
import FooCreatePanel from "@/views/foocrud/create/FooCreatePanel";

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
      ],
      columnData: [
        "id",
        "name",
        "value"
      ],
      fooCreatePanel : FooCreatePanel
    }
  },
  components: {
    "app-tmanager-table": TManagerTable
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
    getException() {
      this.$store.dispatch("fooModule/launchException");
    }
  }
};
</script>
