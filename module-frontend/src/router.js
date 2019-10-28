import Vue from "vue";
import Router from "vue-router";
import Home from "./views/home/Home.vue";

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
      path: "/foo",
      name: "foo",
      component: () => import("./views/foocrud/Foo.vue"),
      meta: {
        requiresAuth: true
      }
    }
  ]
});
