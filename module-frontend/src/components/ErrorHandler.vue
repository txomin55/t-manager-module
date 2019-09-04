<template>
  <div></div>
</template>

<script>
export default {
  name: "ErrorHandler",
  computed: {
    request() {
      return this.$store.state.error;
    }
  },
  watch: {
    request() {
      this.$notify.error({
        title: this.$i18n.t("errorHandler.error"),
        message: `${this.request.status}: ${this.request.data.msg}`
      });
    }
  }
};
</script>
