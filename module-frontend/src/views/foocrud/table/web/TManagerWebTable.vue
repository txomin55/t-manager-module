<template>
  <v-container>
    <v-row>
      <v-btn color="primary" dark @click="selectItem(null)">
        {{ $t("fooCrud.create") }}
      </v-btn>
      <v-dialog v-model="showModal" persistent>
        <component
          :is="creationPanel"
          :data="selectedItem"
          :toggleModal="toggleModal"
        />
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
            <v-icon small class="mr-2" @click="selectItem(item)">
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
    headers: {
      type: Array,
      default: () => []
    },
    data: {
      type: Array,
      default: () => []
    },
    deleteFunction: {
      type: Function,
      default: () => {}
    },
    creationPanel: {
      type: Object
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
  data() {
    return {
      selectedItem: null
    };
  },
  methods: {
    selectItem(item) {
      this.toggleModal();
      this.selectedItem = item;
    }
  },
  computed: {
    showModal(){
      return this.showModalValue;
    }
  }
};
</script>
