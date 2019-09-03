import FooApi from "../api/FooApi";

export default {
  namespaced: true,
  state() {
    return {
      foos: []
    };
  },
  mutations: {
    INIT_FOO_DATA(state, list){
      state.foos = list;
    },
    CREATE_FOO(state, data){
      state.foos.push(data);
    },
    DELETE_FOO_DATA(state, id){
      state.foos.array.forEach((element, index) => {
        if (element == id) state.foos.splice(index, 1);
      });
    }
  },
  actions: {
    initFooData(context){
      FooApi.getFoo(foos => {
        context.commit("INIT_FOO_DATA", foos);
      });
    },
    createFoo(context, fooData){
      FooApi.createFoo(fooData, foo => {
        context.commit("CREATE_FOO", foo);
      });
    },
    deleteFooData(context, id){
      FooApi.deleteFoo(id, id => {
        context.commit("DELETE_FOO_DATA", id);
      });
    }
  },
  getters: {
    getMappedFoo(state){
      return state.foos.map(foo => {
        return { name: new Date().getTime(), value: foo };
      });
    },
    getFooQuantity(state){
      return state.foos.length;
    }
  }
};
