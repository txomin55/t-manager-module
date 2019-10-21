<template>
  <v-container>
    <v-row>
      CREATE/EDIT PANEL FOO
      <div v-if="isEdit">{{ stringData }}</div>
      <v-btn v-if="!isEdit" color="primary" dark @click="createFunction()">
        {{ $t("fooCrud.create") }}
      </v-btn>
      <v-btn v-if="isEdit" color="primary" dark @click="editFunction(data)">
        {{ $t("fooCrud.edit") }}
      </v-btn>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "FooCreatePanel",
  props: {
    data: {
      type: Array,
      default: () => []
    }
  },
  methods: {
    cretateFoo() {
      const fooDto = {
        name: `Soy ${new Date().getTime()}`,
        value: `Valor ${new Date().getTime()}`
      };
      this.$store.dispatch("fooModule/createFoo", fooDto);
    },
    editFunction(item) {
      alert(JSON.stringify(item));
    }
  },
  computed: {
    isEdit() {
      return this.data;
    },
    stringData() {
      return JSON.stringify(this.data);
    }
  }
};
</script>
