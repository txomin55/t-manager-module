<template>
  <div class="notification-handler">
    <div
      v-for="(notification, index) in notifications"
      :key="index"
      :ref="`${notification.id}`"
    >
      <v-alert dismissible :type="notification.type" transition="scale-transition">
        {{ notification.title }} - {{ notification.message }}
      </v-alert>
    </div>
  </div>
</template>

<script>
import Moment from 'moment';
import { mapState } from "vuex";

export default {
  name: "NotificationHandler",
  data() {
    return {
      notifications: [],
      timeout : 5000
    };
  },
  methods: {
    addTimeout(){
      if(this.notifications.length != 0){

        const vm = this;
        const timeoutId = setTimeout(() => {
          delete vm.$refs[`${vm.notifications[0].id}`];
          vm.notifications.shift();

          clearTimeout(timeoutId);
        }, this.timeout);
      }
    }
  },
  watch: {
    statusApiCall() {
      if(this.statusApiCall == "success"){
        
        this.notifications.push({
            showSuccess: true,
            title: this.$i18n.t("module.success.action"), 
            message: this.$i18n.t("module.success.actionDescription"),
            id: new Date().getTime(),
            timeout: this.timeout,
            type: "success"
        });

        this.$store.dispatch("initSuccessApiAction");

        this.addTimeout();
      }
    },
    error(errorData) {
              
      if(errorData && errorData.response && errorData.response.data && errorData.response.data.id){
        const errorDTO = errorData.response.data;
          this.notifications.push({
            showError: true,
            title: `${this.$i18n.t("module.errorHandler.error")} ${Moment(errorDTO.date).format(this.$i18n.t("module.date.formatWithTime"))}`,
            message: `${errorDTO.id}: ${errorDTO.msg}`,
            id: new Date().getTime(),
            timeout: this.timeout,
            type: "error"
          });

          this.addTimeout();
      }else{
        if(errorData != "no_error"){
          this.notifications.push({
              showError: true,
              title: `ERROR`,
              message: `${this.$i18n.t("module.errorHandler.contactDeveloper")}`,
              id: new Date().getTime(),
              timeout: this.timeout,
              type: "error"
            });

            this.addTimeout();
        }
      }  
    }
  },
  computed: {
    ...mapState({
      error: state => state.error,
      statusApiCall: state => state.statusApiCall
    })
  }
};
</script>
<style>
.notification-handler {
  padding-top: 5em;
  padding-right: 1em;
  position: fixed;
  width: 100%;
  z-index: 1;
  display: flex;
  flex-direction: column;
  align-items: flex-end;
}
</style>
