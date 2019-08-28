<template>
  <div class="foo">
    <h1>This is the FOO CRUD page</h1>
    <p>
      This provides GET, POST and DELETE requests from your modules FooController
    </p>
    <div>
      TOTAL foos {{nFoos}}
      <ul>
        <li v-for="(foo, index) in foos" :key="index">
          <a @click="removeFoo(foo.value)">
            <label>{{foo.name}}-{{foo.value}} (Click to remove)</label>
          </a>
        </li>
      </ul>

      <div>
        <a @click="cretateFoo">CREATE FOO</a>
      </div>
    </div>
  </div>
</template>

<script>

export default {
  name: "FooCrud",
  computed: {
    foos(){
      return this.$store.getters['fooModule/getMappedFoo']
    },
    nFoos(){
      return this.$store.getters['fooModule/getFooQuantity']
    }
  },
  methods: {
    removeFoo(id){
      this.$store.dispatch('fooModule/deleteFooData', id)
    },
    getFoos(){
      this.$store.dispatch('fooModule/initFooData')
    },
    cretateFoo(){
      const rValue = Math.floor((Math.random() * 10) + 1)
      this.$store.dispatch('fooModule/createFoo', rValue)
    }
  },
  mounted() {
    this.getFoos()
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
