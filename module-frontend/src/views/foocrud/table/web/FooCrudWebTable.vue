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
              <v-btn color="primary" dark @click="cretateFoo()">
                {{ $t("fooCrud.create") }}
              </v-btn>
            </v-toolbar>
          </template>

          <template v-slot:item.action="{ item }">
            <v-icon small class="mr-2" @click="editItem(item)">
              mdi-pencil
            </v-icon>
            <v-icon small @click="removeFoo(item.id)">
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
  props(){
    data : []
  },
  data: () => ({
    headers: [
      { text: "Id", value: "id" },
      { text: "Name", value: "name" },
      { text: "Value", value: "value" },
      { text: "Actions", value: "action", sortable: false }
    ]
  })
};
</script>
