import Vue from "vue";
import Vuex from "vuex";
import FooModule from "./modules/FooModule";
import ConfigModule from "./modules/ConfigModule";

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    fooModule: FooModule,
    configModule: ConfigModule
  }
})
