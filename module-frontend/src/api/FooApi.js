import axios from "axios";
import store from "../store";

const ADDRESS = "localhost:8080"; //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

export function getFoo(cb) {
  axios
    .get(`http://${ADDRESS}/${store.state.module}/foo`)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}

export function createFoo(foo, cb) {
  axios
    .post(`http://${ADDRESS}/${store.state.module}/foo`, foo)
    .then(() => {
      cb(foo);
    })
    .catch(() => {});
}

export function deleteFoo(id, cb) {
  axios
    .delete(`http://${ADDRESS}/${store.state.module}/foo/${id}`)
    .then(() => {
      cb(id);
    })
    .catch(() => {});
}

export function launchException() {
  axios
    .get(`http://${ADDRESS}/${store.state.module}/foo/exception`)
    .then(() => {})
    .catch(() => {});
}
