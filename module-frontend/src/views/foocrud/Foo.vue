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
      <v-col>
        <commons-crud-panel :crudConfig="getCrudConfig()" />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import FooCreatePanel from "@/components/foocreate/FooCreatePanel.vue";
import { mapState } from "vuex";
export default {
  name: "Foo",
  data() {
    return {
      title: "FOO CRUD",
      headers: [
        { text: "Id", value: "id" },
        { text: "Name", value: "name" },
        { text: "Value", value: "value" }
      ],
      columnData: ["id", "name", "value"],
      cardsInfo: {
        id: "id",
        title: "name",
        subtitle: "value"
      },
      fooCreatePanel: FooCreatePanel,
      showCrud: true
    };
  },
  methods: {
    openSelected(item) {
      alert(`${JSON.stringify(item)}`);
    },
    getCrudConfig() {
      const config = {};
      config.tableTitle = this.title;
      config.selector = {
        cardsInfo: this.cardsInfo,
        openSelected: this.openSelected,
        showCrud: this.showCrud
      };
      config.crud = {
        data: this.foos,
        headers: this.headers,
        columnData: this.columnData,
        creationPanel: this.fooCreatePanel,
        createFunction: this.createAction,
        deleteFunction: this.removeAction,
        editFunction: this.editAction
      };

      return config;
    },
    removeAction(id) {
      this.$store.dispatch("fooModule/deleteFooData", id);
    },
    createAction(fooDto) {
      this.$store.dispatch("fooModule/createFooData", fooDto);
    },
    editAction(fooDto) {
      this.$store.dispatch("fooModule/editFooData", fooDto);
    }
  },
  computed: {
    ...mapState({
      foos: state => state.fooModule.foos
    })
  },
  mounted() {
    this.$store.dispatch("fooModule/initFooData");
  }
};
</script>
