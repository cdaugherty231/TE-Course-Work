<template>
  <div>
      <h1>Welcome the {{musicianName}} fan blog page</h1>
      <blog-listing />
      <add-blog-post />
      <blog-post v-if="$store.state.selectedId!=-1" v-bind:post="selectedPost"/> 
  </div>
</template>

<script>
import BlogListing from './BlogListing.vue'
import AddBlogPost from './AddBlogPost.vue'
import BlogPost from './BlogPost.vue'

export default {
    name: 'musician-fan-blog-page',
    props: {
      musicianName: String
    },
    components: {
      BlogListing,
      AddBlogPost,
      BlogPost
    },
    computed: {
      selectedPost(){
        //get the post that has the same id as selectedId
        return this.$store.state.blogPosts.find(post=>post.id == this.$store.state.selectedId )
      }
    }
};
</script>

<style>
</style>