<template>
  <v-container>
    <v-row>
      <v-col class="text-center">
        <h1>{{ $t("module.fooCrud.welcome") }}</h1>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="text-center">
        <h3>{{ $t("module.fooCrud.description") }}</h3>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="text-center">
        <v-btn @click="getException()">
          {{ $t("module.fooCrud.exception") }}
        </v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="text-center">
        <v-btn @click="getExceptionTimeout()">
          {{ $t("module.fooCrud.exceptionTimeout") }}
        </v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="text-center">
        <v-btn @click="getServerMsg()">
          {{ $t("module.fooCrud.messageFromServer") }}
        </v-btn>
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
    },
    getException() {
      this.$store.dispatch("fooModule/launchException");
    },
    getServerMsg() {
      alert(this.serverMsg);
    },    
    getExceptionTimeout() {
      this.$store.dispatch("fooModule/launchExceptionTimeout");
    }
  },
  computed: {
    ...mapState({
      foos: state => state.fooModule.foos,
      serverMsg: state => state.fooModule.msg
    })
  },
  mounted() {
    this.$store.dispatch("fooModule/initFooData");
  }
};
</script>
