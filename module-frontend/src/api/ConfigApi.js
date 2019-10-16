import axios from "axios";
import store from "../store";

const ADDRESS = "localhost:8080"; //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

export function getUserData(cb) {
  axios
    .get(`http://${ADDRESS}/${store.state.module}/user`)
    .then(result => {
      cb(result.data);
    })
    .catch(() => {});
}
