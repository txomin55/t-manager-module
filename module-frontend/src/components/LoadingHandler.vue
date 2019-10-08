<template>
  <div class="loading-handler">
	<v-overlay :value="loading">
		<v-progress-linear
			indeterminate
			background-color="secondary"
			color="primary"
		></v-progress-linear>
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
<style>
</style>
