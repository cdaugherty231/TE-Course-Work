<template>
  <div id="app">  
    <musician-fan-blog-page musicianName="Jimmy Buffett" />
  </div>
</template>

<script>
import MusicianFanBlogPage from './components/MusicianFanBlogPage.vue'

export default {
  name: 'App',
  components: {
    MusicianFanBlogPage
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
