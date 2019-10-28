import * as FooApi from "../api/FooApi";

export default {
  namespaced: true,
  state() {
    return {
      foos: []
    };
  },
  mutations: {
    INIT_FOO_DATA(state, list) {
      state.foos = list;
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
      alert(JSON.stringify(data));
    },
  },
  actions: {
    initFooData(context) {
      FooApi.getFoo(foos => {
        context.commit("INIT_FOO_DATA", foos);
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
    }
  },
  getters: {
    getFooQuantity(state) {
      return state.foos.length;
    }
  }
};
