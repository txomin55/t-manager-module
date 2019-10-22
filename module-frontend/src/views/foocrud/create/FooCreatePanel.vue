<template>
  <v-container>
    <v-row>
      <v-col>
        <v-card>
          <v-toolbar flat dark color="primary">
            <v-btn icon dark @click="toggleModal()">
              <v-icon>mdi-close</v-icon>
            </v-btn>
          </v-toolbar>

          <v-card-title class="headline">CREATE/EDIT PANEL FOO</v-card-title>

          <div v-if="isEdit">{{ stringData }}</div>

          <v-card-actions>
            <v-btn
              v-if="!isEdit"
              color="primary"
              dark
              @click="createFunction()"
            >
              {{ $t("fooCrud.create") }}
            </v-btn>
            <v-btn
              v-if="isEdit"
              color="primary"
              dark
              @click="editFunction(data)"
            >
              {{ $t("fooCrud.edit") }}
            </v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
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
    },
    toggleModal: {
      type: Function,
      default: () => {}
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
      //TODO:
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
