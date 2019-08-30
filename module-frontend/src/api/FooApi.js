import Vue from "vue";
import store from "../store";

const FooApi = {
  getFoo(cb) {
    Vue.$http
      .get(`http://${store.state.module}/foo`)
      .then(function(response) {
        return response.json();
      })
      .then(foos => {
        cb(foos);
      });
  },

  createFoo(foo, cb) {
    Vue.$http
      .post(`http://${store.state.module}/foo`, foo)
      .then(function(response) {
        return response.json();
      })
      .then(foo => {
        cb(foo);
      });
  },

  deleteFoo(id, cb) {
    Vue.$http.delete(`http://${store.state.module}/foo/${id}`).then(() => {
      cb(id);
    });
  }
};

Object.freeze(FooApi);

export default FooApi;
