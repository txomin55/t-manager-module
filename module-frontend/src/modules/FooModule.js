import * as FooApi from "../api/FooApi";

export default {
  namespaced: true,
  state() {
    return {
      foos: [],
      msg: ""
    };
  },
  mutations: {
    INIT_FOO_DATA(state, list) {
      state.foos = list;
    },
    INIT_FOO_MSG_DATA(state, msg) {
      state.msg = msg;
    },
    CREATE_FOO(state, data) {
      state.foos.push(data);
    },
    DELETE_FOO_DATA(state, id) {
      state.foos.forEach((element, index) => {
        if (element.id == id) state.foos.splice(index, 1);
      });
    },
    EDIT_FOO_DATA(state, data) {
      const item = state.foos.filter(it => it.id == data.id)[0];
      item.name = data.name;
      item.value = data.value;
    }
  },
  actions: {
    initFooData(context) {
      FooApi.getFoos(foos => {
        context.commit("INIT_FOO_DATA", foos);
      });
      FooApi.getFooMsg(msg => {
        context.commit("INIT_FOO_MSG_DATA", msg);
      });
    },
    createFooData(context, fooData) {
      FooApi.createFoo(fooData, foo => {
        context.commit("CREATE_FOO", foo);
      });
    },
    deleteFooData(context, id) {
      FooApi.deleteFoo(id, id => {
        context.commit("DELETE_FOO_DATA", id);
      });
    },
    editFooData(context, fooData) {
      FooApi.editFoo(fooData, foo => {
        context.commit("EDIT_FOO_DATA", foo);
      });
    },
    launchException() {
      FooApi.launchException();
    },
    launchExceptionTimeout() {
      FooApi.launchExceptionTimeout();
    }
  }
};
