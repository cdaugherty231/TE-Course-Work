import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    blogPosts: [
      {
        author: "katie",
        summary: "i can't believe there was no concert this year",
        post: "lot of text can go here",
        id: 1
      },
      {
        author: "cameron",
        summary: "cool people like JB",
        post: "lot of text can go here",
        id: 2
      },
      {
        author: "benjamin",
        summary: "wwjbd",
        post: "lot of text can go here",
        id: 3
      }
    ],
    selectedId: -1
  },
  mutations: {
    ADD_NEW_POST(state,post) {
      state.blogPosts.unshift(post);
    },
    UPDATE_SELECTED_ID(state,id) {
      state.selectedId = id;
    },
    DELETE_POST(state,id){
      state.blogPosts = state.blogPosts.filter(post=>post.id != id);
    }
  },
  actions: {
  },
  modules: {
  },
  strict: true
})
