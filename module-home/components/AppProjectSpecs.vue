<template>
  <div>
    <h2>{{$t(title)}}</h2>
    <p v-html="$t(text)"></p>
  </div>
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
