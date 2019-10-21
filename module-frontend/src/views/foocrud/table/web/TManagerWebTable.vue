<template>

  <v-container>
    <v-row>
      <v-dialog 
        v-model="showModal"
        persistent
      >
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on" @click="selectItem(null)">
            {{ $t("fooCrud.create") }}
          </v-btn>
            
        </template>
        <component 
          :is="creationPanel"
          :data="selectedItem" />
      </v-dialog>
    </v-row>

    <v-row>
      <v-col>
        <v-data-table
          :headers="headers"
          :items="data"
          sort-by="name"
          class="elevation-1"
        >
          <template v-slot:top>
            <v-toolbar flat color="white">
              <v-toolbar-title>FOO CRUD</v-toolbar-title>
              <v-divider class="mx-4" inset vertical></v-divider>
              <div class="flex-grow-1"></div>
            </v-toolbar>
          </template>

          <template v-slot:item.action="{ item }">
            <v-icon small class="mr-2" v-on="on" @click="selectItem(item)">
              mdi-pencil
            </v-icon>
            <v-icon small @click="deleteFunction(item.id)">
              mdi-delete
            </v-icon>
          </template>

          <template v-slot:no-data>
            NO DATA
          </template>
        </v-data-table>
      </v-col>
    </v-row>
  </v-container>

</template>

<script>

export default {
  name: "TManagerWebTable",
  props: {
    'headers' : {
      type: Array,
      default: () => []
    },
    'data' : {
      type: Array,
      default: () => []
    },
    'deleteFunction' : {
      type: Function,
      default: () => function(){}
    },
    'creationPanel' : {
      type: Object,
      default : {}
    }
  },
  data(){
    return {
      showModal : false,
      selectedItem : null
    }
  },
  methods: {
    selectItem(item){
      this.selectedItem = item;
    }
  }
};
</script>
