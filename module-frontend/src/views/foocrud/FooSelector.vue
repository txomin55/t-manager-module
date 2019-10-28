<template>
  <v-container>
        
    <v-row>
      <v-col class="text-center">
        <h1>{{ $t("fooCrud.welcome") }}</h1>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="text-center">
        <h3>{{ $t("fooCrud.description") }}</h3>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="text-center">
        <v-btn @click="getException()">
          {{ $t("fooCrud.exception") }}
        </v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col class="text-center">
        <v-btn @click="openCrud()">
          CRUD
        </v-btn>
      </v-col>
    </v-row>

    <v-row>
      <v-col>
        <commons-card-title-selector 
          :items="foos"
          v-on:selected-card-title="openSelected"
        />
      </v-col>
    </v-row>

  </v-container>
</template>

<script>
import { mapState } from "vuex";
export default {
  name: "FooSelector",
  data() {
    return {
    }
  },
  methods: {
    getException() {
      this.$store.dispatch("fooModule/launchException");
    },
    openCrud(){
      this.$router.push("/fooCrud");
    },
    openSelected(id){
      alert("DESDE FOO SELECTOR " + id);
    }
  },
  computed: {
    ...mapState({
      foos: state => {
        if(state.fooModule.foos.length > 0){
          const mappedList = state.fooModule.foos.map(it => {
            return {
              id : it.id,
              title : it.name,
              subtitle : it.value
            }
          });

          return mappedList;
        }

        return [];
      }
    })
  }
};
</script>
