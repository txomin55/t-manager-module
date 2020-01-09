import axios from "axios";
import store from "../store";

const ADDRESS = process.env.VUE_APP_ADDRESS;

export function getFoos(cb) {
  axios
    .get(`${ADDRESS}/${store.state.module}/api/foo/list`)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}

export function createFoo(foo, cb) {
  axios
    .post(`${ADDRESS}/${store.state.module}/api/foo`, foo)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}

export function editFoo(foo, cb) {
  axios
    .put(`${ADDRESS}/${store.state.module}/api/foo`, foo)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}

export function deleteFoo(id, cb) {
  axios
    .delete(`${ADDRESS}/${store.state.module}/api/foo/${id}`)
    .then(() => {
      cb(id);
    })
    .catch(() => {});
}

export function launchException() {
  axios
    .get(`${ADDRESS}/${store.state.module}/api/foo/exception`)
    .then(() => {})
    .catch(() => {});
}

export function getFooMsg(cb) {
  axios
    .get(`${ADDRESS}/${store.state.module}/api/foo/api/fooI18nSample`)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}
