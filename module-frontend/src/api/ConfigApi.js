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
    .get(`${ADDRESS}/${store.state.module}/auth/logout`, {
      params : {
        refresh_token : localStorage.getItem('refreshToken')
      }
    })
    .then(loginUrl => {
      window.location.replace(loginUrl.data);
    })
    .catch(() => {});
}
