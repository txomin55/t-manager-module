<template>
  <v-container>
    <v-row>
      <v-dialog v-model="showModal" persistent>
        <template v-slot:activator="{ on }">
          <v-btn color="primary" dark v-on="on" @click="selectItem(null)">
            {{ $t("fooCrud.create") }}
          </v-btn>
        </template>
        <component :is="creationPanel" :data="selectedItem" />
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
                <v-btn color="primary" dark v-on="on" @click="selectItem(item)">
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
      type: Object,
      default: {}
    }
  },
  data() {
    return {
      showModal: false,
      selectedItem: null
    };
  },
  methods: {
    showItemData(item) {
      item.toString().replace(/,/g, "-");
    },
    selectItem(item) {
      this.selectedItem = item;
    }
  }
};
</script>
