<template>
  <v-container>
    <v-row>
      <v-col class="text-center">
        <h2>{{ module }}</h2>
      </v-col>
    </v-row>
    <v-row>
      <v-col class="text-center">
        <h3>txomin.sirera@gmail.com</h3>
      </v-col>
    </v-row>
    <v-row>
      <v-col>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum
          maiores modi quidem veniam, expedita quis laboriosam, ullam facere
          adipisci, iusto, voluptate sapiente corrupti asperiores rem nemo
          numquam fuga ab at.
        </p>
        <p>
          Lorem ipsum dolor sit amet, consectetur adipisicing elit. Harum
          maiores modi quidem veniam, expedita quis laboriosam, ullam facere
          adipisci, iusto, voluptate sapiente corrupti asperiores rem nemo
          numquam fuga ab at.
        </p>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "About",
  data() {
    return {
      module: this.$store.state.module
    };
  }
};
</script>
