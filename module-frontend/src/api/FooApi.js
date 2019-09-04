import Vue from "vue";
import store from "../store";

const ADDRESS = "localhost:8080"; //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

export function getFoo(cb) {
  Vue.http
    .get(`http://${ADDRESS}/${store.state.module}/foo`)
    .then(function(response) {
      return response.json();
    })
    .then(foos => {
      cb(foos);
    });
}

export function createFoo(foo, cb) {
  Vue.http
    .post(`http://${ADDRESS}/${store.state.module}/foo`, foo)
    .then(function(response) {
      return response.json();
    })
    .then(foo => {
      cb(foo);
    });
}

export function deleteFoo(id, cb) {
  Vue.http
    .delete(`http://${ADDRESS}/${store.state.module}/foo/${id}`)
    .then(() => {
      cb(id);
    });
}
