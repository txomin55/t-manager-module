import Vue from "vue";
import Router from "vue-router";
import Home from "./views/home/Home.vue";
import About from "./views/about/About.vue";
import Foo from "./views/foocrud/Foo.vue";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/"
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
