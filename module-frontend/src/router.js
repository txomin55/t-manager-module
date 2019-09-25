import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";

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
      path: "/fooCrud",
      name: "fooCrud",
      // route level code-splitting
      // this generates a separate chunk (fooCrud.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "fooCrud" */ "./views/FooCrud.vue"),
        meta: { 
          requiresAuth: true 
        }
    }
  ]
});
