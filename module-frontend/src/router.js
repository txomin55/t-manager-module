import Vue from "vue";
import Router from "vue-router";

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/"
    },
    {
      path: "/login",
      name: "login",
      component: () => import("./views/login/Login.vue"),
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/home",
      name: "home",
      component: () => import("./views/home/Home.vue"),
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/about",
      name: "about",
      component: () => import("./views/about/About.vue"),
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
