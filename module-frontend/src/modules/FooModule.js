const MODULE_NAME = "module"; //FIXME: ESTO LO TENDRIA QUE RECUPERAR DE ALGUN PROPERTIES

export default {
  namespaced: true,
  state() {
    return {
      foos: []
    };
  },
  mutations: {
    INIT_FOO_DATA: (state, list) => {
      state.foos = list;
    },
    CREATE_FOO: (state, data) => {
      state.foos.push(data);
    },
    DELETE_FOO_DATA: (state, id) => {
      state.foos.array.forEach((element, index) => {
        if (element == id) state.foos.splice(index, 1);
      });
    }
  },
  actions: {
    initFooData: context => {
      this.$http
        .get(`http://${MODULE_NAME}/foo`)
        .then(function(response) {
          return response.json();
        })
        .then(foos => {
          context.commit("INIT_FOO_DATA", foos);
        });
    },
    createFoo: (context, foo) => {
      this.$http
        .post(`http://${MODULE_NAME}/foo`, foo)
        .then(function(response) {
          return response.json();
        })
        .then(foo => {
          context.commit("CREATE_FOO", foo);
        });
    },
    deleteFooData: (context, id) => {
      this.$http.delete(`http://${MODULE_NAME}/foo/${id}`).then(() => {
        context.commit("DELETE_FOO_DATA", id);
      });
    }
  },
  getters: {
    getMappedFoo: state => {
      return state.foos.map(foo => {
        return { name: new Date().getTime(), value: foo };
      });
    },
    getFooQuantity: state => {
      return state.foos.length;
    }
  }
};
