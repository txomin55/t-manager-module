<template>
  <div>
    <v-snackbar
      v-model="showError"
      color="error"
      multi-line
      right
      :timeout="timeout"
      top
    >
      {{ title }} - {{ message }}

      <v-btn dark text @click="showError = false">
        {{ $t("error.close") }}
      </v-btn>
    </v-snackbar>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "ErrorHandler",
  data() {
    return {
      showError: false,
      title: null,
      message: null,
      timeout: 6000
    };
  },
  computed: {
    ...mapState({
      error(state) {
        console.log(state);
        this.showError = true;
        this.title = this.$i18n.t("errorHandler.error");
        this.message = `${this.request.status}: ${this.request.data.msg}`;
      }
    })
  }
};
</script>
