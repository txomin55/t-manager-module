import axios from "axios";
import store from "../store";

const ADDRESS = "localhost:3000"; //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

export function getUserData(cb) {
  axios
    .get(`http://${ADDRESS}/${store.state.module}/auth/getUserData`)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}