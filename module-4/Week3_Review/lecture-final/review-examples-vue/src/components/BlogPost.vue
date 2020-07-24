<template>
  <div class="post">
      <h3>{{post.summary}} {{post.author}}</h3>
      <p> {{post.post}} </p>
  </div>
</template>

<script>
export default {
    name: 'blog-post',
    props: {
        post: {}
    }

}
</script>

<style>
div.post {
    border: 2px solid purple;
    border-radius: 5px;
    margin: 5px;
}

</style>