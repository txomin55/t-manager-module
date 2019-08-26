<template>
  <div class="foo">
    <h1>This is the FOO CRUD page</h1>
    <p>
      This provides GET, POST and DELETE requests from your modules FooController
    </p>
    <div>
      <ul>
        <li v-for="(foo, index) in foos" :key="index">
          <a @click="removeFoo(foo)">
            <label>{{foo}} (Click to remove)</label>
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
  props: {
    foos : []
  },
  methods: {
    removeFoo(id){
      this.foos.array.forEach((element, index) => {
        if(element == id) this.foos.splice(index, 1);
      });
    },
    getFoos(){
      this.foos = [1,2,3,4,5]
    },
    cretateFoo(){
      this.foos.push(Math.floor((Math.random() * 10) + 1))
    }
  },
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
