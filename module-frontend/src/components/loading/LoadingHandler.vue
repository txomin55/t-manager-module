<template>
  <div class="loading-handler">
    <v-overlay :value="loading">
      <v-progress-circular
        :active="loading"
        indeterminate
        background-color="secondary"
        color="black"
      ></v-progress-circular>
    </v-overlay>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "LoadingHandler",
  computed: {
    ...mapState({
      loading: state => state.status === "loading"
    })
  }
};
</script>
<style></style>
