<template>
  <v-container>
    <v-row>
      <v-col v-if="$vuetify.breakpoint.smAndUp">
        <app-tmanager-web-table
          :headers="headers"
          :data="data"
          :deleteFunction="deleteFunction"
          :creationPanel="creationPanel"
          :toggleModal="toggleModal"
          :showModalValue="showModalValue"
        />
      </v-col>
      <v-col v-else>
        <app-tmanager-mobile-list
          :data="data"
          :deleteFunction="deleteFunction"
          :columnData="columnData"
          :creationPanel="creationPanel"
          :toggleModal="toggleModal"
          :showModalValue="showModalValue"
        />
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import TManagerWebTable from "@/views/foocrud/table/web/TManagerWebTable";
import TManagerMobileList from "@/views/foocrud/table/mobile/TManagerMobileList";

export default {
  name: "TManagerTable",
  props: {
    data: {
      type: Array,
      default: () => []
    },
    headers: {
      type: Array,
      default: () => []
    },
    columnData: {
      type: Array,
      default: () => []
    },
    creationPanel: {
      type: Object
    },
    deleteFunction: {
      type: Function,
      default: () => {}
    },
    toggleModal: {
      type: Function,
      default: () => {}
    },
    showModalValue: {
      type: Boolean,
      default: false
    }
  },
  components: {
    "app-tmanager-web-table": TManagerWebTable,
    "app-tmanager-mobile-list": TManagerMobileList
  }
};
</script>
