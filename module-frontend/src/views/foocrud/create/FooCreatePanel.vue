<template>
  
  <v-container>
    <v-row>
      CREATE/EDIT PANEL FOO
      <v-btn color="primary" dark @click="createFunction()">
        {{ $t("fooCrud.create") }}
      </v-btn>
      <v-btn @click="editFunction(data)">
        {{ $t("fooCrud.edit") }}
      </v-btn>
    </v-row>
  </v-container>

</template>

<script>

export default {
  name: "FooCreatePanel",
  props: {
    'data' : {
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
    }
  }
};
</script>
