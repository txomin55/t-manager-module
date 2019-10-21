<template>
  
  <v-container>
    <v-row>
      <v-col
        v-if="$vuetify.breakpoint.smAndUp"
      >
        <app-foo-crud-web-table 
          :headers="headers"
          :data="data"
          :deleteFunction="removeFoo"
          :creationPanel="creationPanel"
        />
      </v-col>
      <v-col
        v-else
      >
        <app-tmanager-mobile-list 
          :data="data" 
          :deleteFunction="removeFoo"
          :columnData="columnData"
          :creationPanel="creationPanel"
        />
      </v-col>
    </v-row>
  </v-container>

</template>

<script>
import FooCrudWebTable from "table/web/TManagerWebTable";
import TManagerMobileList from "table/mobile/TManagerMobileList";

export default {
  name: "TManagerTable",
  props: {
    'data' : {
      type: Array,
      default: () => []
    },
    'headers' : {
      type: Array,
      default: () => []
    },
    'columnData' : {
      type: Array,
      default: () => []
    },
    'deleteFunction' : {
      type: Function,
      default: () => {}
    },
    'creationPanel' : {
        type: Object,
        default : {}
    }
  },
  components: {
    "app-tmanager-web-table": TManagerWebTable,
    "app-tmanager-mobile-list": TManagerMobileList
  }
};
</script>
