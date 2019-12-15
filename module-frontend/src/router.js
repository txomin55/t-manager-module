import Vue from "vue";
import Router from "vue-router";
import Home from "./views/home/Home.vue";
import About from "./views/about/About.vue";
import Foo from "./views/foocrud/Foo.vue";
import store from "./store";

if (!Vue.prototype.getCurrentLocation) {
  Vue.use(Router);
}

const embebed =
  window.isModuleEnsambled && window.isModuleEnsambled[store.state.module]
    ? true
    : false;

export default new Router({
  mode: "history",
  base: embebed
    ? `/${window.launcherNamePath}/${process.env.BASE_URL}`
    : process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "init"
    },
    {
      path: "/home",
      name: "home",
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/about",
      name: "about",
      component: About,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/foo",
      name: "foo",
      component: Foo,
      meta: {
        requiresAuth: true
      }
    }
  ]
});
