<template>

  <v-app>

    <app-nav-bar />

    <v-main>
        <nuxt />
    </v-main>

    <app-footer/>

  </v-app>

</template>

<script>
    import AppNavBar from '@/components/AppNavBar'
    import AppFooter from '@/components/AppFooter'

export default {
  components: {
        AppFooter,
        AppNavBar
  }
}
</script>
