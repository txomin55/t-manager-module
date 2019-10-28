<template>
  <v-container>

    <v-row>
      <v-col>
        <v-subheader>{{ $t("fooCrud.total") }}-{{ nFoos }}</v-subheader>
      </v-col>
    </v-row>

    <v-row>
      <commons-crud-table
        :data="foos"
        :headers="headers"
        :columnData="columnData"
        :creationPanel="fooCreatePanel"
        :createFunction="createAction"
        :deleteFunction="removeAction"
        :editFunction="editAction"
        :tableTitle="title"
      />
    </v-row>

    <v-row>
      <v-col>
        <v-btn @click="goBack()">
          BACK
        </v-btn>
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
import FooCreatePanel from "@/views/foocrud/create/FooCreatePanel";

import { mapState } from "vuex";
export default {
  name: "FooCrud",
  data() {
    return {
      headers: [
        { text: "Id", value: "id" },
        { text: "Name", value: "name" },
        { text: "Value", value: "value" },
        { text: "Actions", value: "action", sortable: false }
      ],
      columnData: ["id", "name", "value"],
      fooCreatePanel: FooCreatePanel,
      title: "FOO CRUD"
    };
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
    },
    removeAction(id) {
      this.$store.dispatch("fooModule/deleteFooData", id);
    },
    createAction(fooDto){
      this.$store.dispatch("fooModule/createFooData", fooDto);
    },
    editAction(fooDto){
      this.$store.dispatch("fooModule/editFooData", fooDto);
    },
    goBack(){
      this.$router.push("/fooSelector");
    }
  }
};
</script>
