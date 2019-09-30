<template>
  <v-container>
    <v-row>
      <v-col
        class="text-center"
      >
        <h1>{{ $t("fooCrud.welcome") }}</h1>
      </v-col>
    </v-row>

    <v-row>
      <v-col
        class="text-center"
      >
        <h3>{{ $t("fooCrud.description") }}</h3>
      </v-col>
    </v-row>

    <v-row>
      <v-col
        class="text-center"
      >
        <v-btn @click="getException()">
          {{ $t("fooCrud.exception") }}
        </v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col
        class="text-center"
      >
        <v-btn @click="cretateFoo()">
          {{ $t("fooCrud.create") }}
        </v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-subheader>{{ $t("fooCrud.total") }}-{{ nFoos }}</v-subheader>
        <v-list-item v-for="(foo, index) in foos" :key="index">
          <v-list-item-content>
            <v-row>
              <v-col>
                <v-list-item-title>
                  {{ foo.name }}-{{ foo.value }}
                </v-list-item-title>
              </v-col>
              <v-col>
                <v-btn @click="removeFoo(foo.value)">
                  {{ $t("fooCrud.remove") }}
                </v-btn>
              </v-col>
            </v-row>
          </v-list-item-content>
        </v-list-item>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <v-data-table
          :headers="headers"
          :items="foos"
          sort-by="calories"
          class="elevation-1"
        >
          <template v-slot:top>
            <v-toolbar flat color="white">
              <v-toolbar-title>FOO CRUD</v-toolbar-title>
              <v-divider class="mx-4" inset vertical></v-divider>
              <div class="flex-grow-1"></div>
              <v-btn color="primary" dark class="mb-2">
                New Item
              </v-btn>
            </v-toolbar>
          </template>

          <template v-slot:item.action="{ item }">
            <v-icon small class="mr-2" @click="editItem(item)">
              edit
            </v-icon>
            <v-icon small @click="deleteItem(item)">
              delete
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
  name: "FooCrud",
  data: () => ({
    headers: [
      { text: "Name", value: "name" },
      { text: "Value", value: "value" }
    ]
  }),
  computed: {
    foos() {
      return this.$store.getters["fooModule/getMappedFoo"];
    },
    nFoos() {
      return this.$store.getters["fooModule/getFooQuantity"];
    }
  },
  methods: {
    removeFoo(foo) {
      this.$store.dispatch("fooModule/deleteFooData", foo.id);
    },
    cretateFoo() {
      const fooDto = {
        name: `Soy ${new Date().getTime()}`
      };
      this.$store.dispatch("fooModule/createFoo", fooDto);
    },
    getException() {
      this.$store.dispatch("fooModule/launchException");
    }
  }
};
</script>
