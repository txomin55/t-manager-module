import axios from "axios";
import store from "../store";

const ADDRESS = "localhost:8080"; //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

export function getUserData(cb) {
  axios
    .get(`http://${ADDRESS}/${store.state.module}/auth/getUserData`)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}
