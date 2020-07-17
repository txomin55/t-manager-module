<template>
  <v-footer
    dark
    :color="appColors.black"
  >
    <v-col
      class="text-center green--text"
    >
      &copy; {{ new Date().getFullYear() }} - <b>{{$t('tManager')}}</b>
    </v-col>
  </v-footer>
</template>
<script>
    import colors from 'vuetify/es5/util/colors'

    export default {
      name: 'AppFooter',
      data () {
        return {
          appColors: colors
        }
      }
    }
</script>