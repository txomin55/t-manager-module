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
        <v-list-item v-for="(item, index) in data" :key="index">
          <v-list-item-content>
            <v-row>
              <v-col>
                <v-list-item-title>
                  {{ showItemData(item) }}
                </v-list-item-title>
              </v-col>
              <v-col>
                <v-btn color="primary" @click="selectItem(item)">
                  {{ $t("fooCrud.edit") }}
                </v-btn>
              </v-col>
              <v-col>
                <v-btn @click="deleteFunction(item.id)">
                  {{ $t("fooCrud.remove") }}
                </v-btn>
              </v-col>
            </v-row>
          </v-list-item-content>
        </v-list-item>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "TManagerMobileList",
  props: {
    data: {
      type: Array,
      default: () => []
    },
    columnData: {
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
    showItemData(item) {
      return Object.values(item).toString().replace(/,/g, "||");
    },
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
