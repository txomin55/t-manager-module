<template>

    <v-row>
      <v-col>
          <v-btn color="primary" dark @click="createFunction()">
            {{ $t("fooCrud.create") }}
          </v-btn>
          <v-list-item v-for="(foo, index) in data" :key="index">
            <v-list-item-content>
              <v-row>
                <v-col>
                  <v-list-item-title>
                    {{ foo.id }}-{{ foo.name }}-{{ foo.value }}
                  </v-list-item-title>
                </v-col>
                <v-col>
                  <v-btn @click="editFunction(foo)">
                    {{ $t("fooCrud.edit") }}
                  </v-btn>
                </v-col>
                <v-col>
                  <v-btn @click="deleteFunction(foo.id)">
                    {{ $t("fooCrud.remove") }}
                  </v-btn>
                </v-col>
              </v-row>
            </v-list-item-content>
          </v-list-item>

      </v-col>
    </v-row>

</template>

<script>
export default {
  name: "FooCrudMobileList",
  props: {
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
