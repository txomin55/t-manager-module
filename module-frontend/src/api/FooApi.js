import Vue from "vue";
import VueResource from "vue-resource";
import store from "../store";

Vue.use(VueResource);
const RESOURCE = Vue;

const FooApi = {
  getFoo: function(cb) {
    RESOURCE.http
      .get(`http://${store.state.module}/foo`)
      .then(function(response) {
        return response.json();
      })
      .then(foos => {
        cb(foos);
      });
  },

  createFoo(foo, cb) {
    RESOURCE.http
      .post(`http://${store.state.module}/foo`, foo)
      .then(function(response) {
        return response.json();
      })
      .then(foo => {
        cb(foo);
      });
  },

  deleteFoo(id, cb) {
    RESOURCE.http.delete(`http://${store.state.module}/foo/${id}`).then(() => {
      cb(id);
    });
  }
};

Object.freeze(FooApi);

export default FooApi;
