import axios from "axios";
import store from "../store";

const ADDRESS = process.env.VUE_APP_ADDRESS;

export function getFoo(cb) {
  axios
    .get(`${ADDRESS}/${store.state.module}/foo`)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}

export function createFoo(foo, cb) {
  axios
    .post(`${ADDRESS}/${store.state.module}/foo`, foo)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}

export function editFoo(foo, cb) {
  axios
    .put(`${ADDRESS}/${store.state.module}/foo`, foo)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}

export function deleteFoo(id, cb) {
  axios
    .delete(`${ADDRESS}/${store.state.module}/foo/${id}`)
    .then(() => {
      cb(id);
    })
    .catch(() => {});
}

export function launchException() {
  axios
    .get(`${ADDRESS}/${store.state.module}/foo/exception`)
    .then(() => {})
    .catch(() => {});
}

export function getFooMsg(cb) {
  axios
    .get(`${ADDRESS}/${store.state.module}/foo/fooI18nSample`)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}
