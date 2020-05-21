import axios from "axios";
import store from "../store";

const ADDRESS = process.env.VUE_APP_ADDRESS;

export function getUserData(cb) {
  axios
    .get(`${ADDRESS}/${store.state.module}/api/user`)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}

export function logout() {
  axios
  .get(`${ADDRESS}/${store.state.module}/api/exit`)
  .then(result => {
    window.location.href = result.data;
  })
  .catch(() => {});
}
