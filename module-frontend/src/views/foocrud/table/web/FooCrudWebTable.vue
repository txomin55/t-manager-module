<template>

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
              <v-btn color="primary" dark @click="createFunction()">
                {{ $t("fooCrud.create") }}
              </v-btn>
            </v-toolbar>
          </template>

          <template v-slot:item.action="{ item }">
            <v-icon small class="mr-2" @click="editFunction(item)">
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

</template>

<script>

export default {
  name: "FooCrudWebTable",
  props: {
    'headers' : {
          type: Array,
          default: () => []
    },
    'data' : {
          type: Array,
          default: () => []
    },
    'createFunction' : {
      type: Function,
      default: () => {}
    },
    'editFunction' : {
      type: Function,
      default: () => {}
    },
    'deleteFunction' : {
      type: Function,
      default: () => {}
    }
  }
};
</script>
