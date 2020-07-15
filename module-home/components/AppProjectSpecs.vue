<template>
  <v-card
    outlined
    hover
  >
    <v-card-title>
      {{title}}
    </v-card-title>
    <v-card-text>
      <p v-html="$t(text)"></p>
    </v-card-text>
  </v-card>
</template>
<script>
    export default {
      name: 'AppProyectSpecs',
      props: {
        title: {
          type: String,
          default: null
        },
        text: {
          type: String,
          default: null
        }
      }
    }
</script>
