<template>
  <v-card>
    <v-toolbar flat dark color="primary">
      <v-btn icon dark @click="closeModal()">
        <v-icon>mdi-close</v-icon>
      </v-btn>
    </v-toolbar>

    <v-card-title class="headline">{{ $t("fooCrud.title") }}</v-card-title>

    <v-form v-model="valid">
      <v-container>
        <v-row>
          <v-col sm="6" md="3">
            <v-text-field
              label="ID"
              v-model="id"
              :rules="requiredRule"
              required
              :disabled="disabled"
            ></v-text-field>
          </v-col>
          <v-col sm="6" md="3">
            <v-text-field
              label="NAME"
              v-model="name"
              :rules="requiredRule"
              required
              :disabled="disabled"
            ></v-text-field>
          </v-col>
          <v-col sm="6" md="3">
            <v-text-field
              label="VALUE"
              v-model="value"
              :disabled="disabled"
            ></v-text-field>
          </v-col>
        </v-row>
      </v-container>
    </v-form>

    <v-card-actions v-if="!disabled">
      <v-btn v-if="!isEdit" color="primary" dark @click="createFoo()">
        {{ $t("create") }}
      </v-btn>
      <v-btn v-if="isEdit" color="primary" dark @click="editFoo()">
        {{ $t("edit") }}
      </v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
export default {
  name: "FooCreationPanel",
  props: {
    data: {
      type: Object
    },
    disabled: {
      type: Boolean,
      default: false
    }
  },
  data() {
    return {
      id: null,
      name: null,
      value: null,
      valid: false,
      requiredRule: [v => !!v || "Value is required"],
      itemData: {}
    };
  },
  methods: {
    removeData() {
      this.id = null;
      this.name = null;
      this.value = null;
      this.valid = false;
    },
    initData(data) {
      if (data) {
        this.id = data.id;
        this.name = data.name;
        this.value = data.value;
      } else {
        this.removeData();
      }
    },
    createFoo() {
      if (this.valid) {
        this.setData();

        this.$emit("create-item", this.itemData);

        this.removeData();

        this.closeModal();
      }
    },
    editFoo() {
      if (this.valid) {
        this.setData();

        this.$emit("edit-item", this.itemData);

        this.closeModal();
      }
    },
    closeModal() {
      this.$emit("close-modal");
    },
    setData() {
      this.itemData.id = this.id;
      this.itemData.name = this.name;
      this.itemData.value = this.value;
    }
  },
  computed: {
    isEdit() {
      return this.data;
    }
  },
  watch: {
    data: {
      immediate: true,
      handler(val) {
        this.initData(val);
        Object.assign(this.itemData, this.data);
      }
    }
  }
};
</script>
