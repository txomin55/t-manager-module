<template>
  <div></div>
</template>

<script>
export default {
  name: "ErrorHandler",
  computed: {
    request() {
      return this.$store.state.configModule.error;
    }
  },
  watch: {
    request() {
      switch (this.request.status) {
        case 404:
          this.$notify.error({
            title: this.$i18n.t("errorHandler.error"),
            message: `${this.request.status}: ${this.request.statusText}`
          });
          break;
        case 401:
          break;
      }
    }
  }
};
</script>
