<template>
  <div>
    <h1>All the Blog Posts</h1>
    <div
      class="blogPostSummary"
      v-for="blog in blogPosts"
      v-bind:key="blog.id"
      v-on:click="updatedSelectedId(blog.id)"
      v-on:dblclick="deletePostByid(blog.id)"
    >
      <h4>{{blog.author}} {{blog.summary}}</h4>
    </div>
  </div>
</template>

<script>
export default {
  name: "blog-listing",
  computed: {
    blogPosts() {
      return this.$store.state.blogPosts;
    }
  },
  methods: {
    updatedSelectedId(id) {
      this.$store.commit("UPDATE_SELECTED_ID", id);
    },
    deletePostByid(id) {
      this.$store.commit("DELETE_POST", id);
    }
  }
};
</script>

<style>
div.blogPostSummary {
  border: 2px solid black;
  border-radius: 5px;
  margin: 5px;
}
</style>