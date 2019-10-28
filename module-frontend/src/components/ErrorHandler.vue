<template>
  <div class="error-handler">
    <div
      v-for="(error, index) in errors"
      :key="index"
      :ref="`error-${error.id}`"
    >
      <v-alert dismissible type="error" transition="scale-transition">
        {{ error.title }} - {{ error.message }}
      </v-alert>
    </div>
  </div>
</template>

<script>
import { mapState } from "vuex";

export default {
  name: "ErrorHandler",
  data() {
    return {
      errors: []
    };
  },
  watch: {
    error(errorData) {
      const timeout = 5000;
      if(errorData.response && errorData.response.data){
        const errorDTO = errorData.response.data;
        this.errors.push({
          showError: true,
          title: `${this.$i18n.t("errorHandler.error")} ${errorDTO.date}`,
          message: `${errorDTO.id}: ${errorDTO.msg}`,
          id: new Date().getTime(),
          timeout: timeout
        });
  
      }else{
        this.errors.push({
          showError: true,
          title: `ERROR`,
          message: `${errorData.message}`,
          id: new Date().getTime(),
          timeout: timeout
        });
      }

      const timeoutId = setTimeout(() => {
        delete this.$refs[`error-${this.errors[0].id}`];
        this.errors.shift();

        clearTimeout(timeoutId);
      }, timeout);
    }
  },
  computed: {
    ...mapState({
      error: state => state.error
    })
  }
};
</script>
<style>
.error-handler {
  position: absolute;
  width: 100%;
  z-index: 1;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}
</style>
