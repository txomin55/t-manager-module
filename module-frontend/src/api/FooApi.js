import Vue from "vue";
import store from "../store";

const ADDRESS = "localhost:8080"; //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

export function getFoo(cb) {
  Vue.http
    .get(`http://${ADDRESS}/${store.state.module}/foo`)
    .then(result => {
      cb(result.data);
    });
}

export function createFoo(foo, cb) {
  Vue.http.post(`http://${ADDRESS}/${store.state.module}/foo`, foo)
    .then(() => {
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

export function launchException() {
  Vue.http
    .get(`http://${ADDRESS}/${store.state.module}/foo/exception`)
    .then(() => {});
}
