import Vue from "vue";
import Vuex from "vuex";
import FooModule from "./modules/FooModule";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    fooModule: FooModule
  }
})
