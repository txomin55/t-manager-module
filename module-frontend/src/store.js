import Vue from "vue";
import Vuex from "vuex";
import FooModule from "./modules/FooModule";
import ConfigModule from "./modules/ConfigModule";

Vue.use(Vuex);

export default new Vuex.Store({
  state: ConfigModule.state,
  getters: ConfigModule.getters,
  actions: ConfigModule.actions,
  mutations: ConfigModule.mutations,
  modules: {
    fooModule: FooModule
  }
});
