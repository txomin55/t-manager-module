<template>

    <v-container>
      <v-row>
        <v-dialog 
          v-model="showModal"
          persistent
        >
          <template v-slot:activator="{ on }">
            <v-btn color="primary" dark v-on="on">Open Dialog</v-btn>
            <v-btn color="primary" dark v-on="on" @click="createFunction()">
              {{ $t("fooCrud.create") }}
            </v-btn>
          </template>
          <component :is="creationPanel" />
        </v-dialog>
      </v-row>

      <v-row>
        <v-col>
            
            <v-list-item v-for="(item, index) in data" :key="index">
              <v-list-item-content>
                <v-row>
                  <v-col>
                    <v-list-item-title>
                      {{showItemData(item)}}
                    </v-list-item-title>
                  </v-col>
                  <v-col>
                    <v-btn color="primary" dark v-on="on">
                      Open Dialog
                    </v-btn>
                    <v-btn @click="editFunction(item)">
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
    'data' : {
      type: Array,
      default: () => []
    },
    'columnData' : {
      type: Array,
      default: () => []
    },
    'createFunction' : {
      type: Function,
      default: () => function(){}
    },
    'editFunction' : {
      type: Function,
      default: () => function(){}
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
      showModal : false
    }
  },
  methods: {
    showItemData(item){
      item.toString().replace(/,/g, "-")
    }
  }
};
</script>
