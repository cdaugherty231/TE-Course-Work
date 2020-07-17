<template>
  <div id="app">
      <div id="nav">      
    </div>
    <router-view v-on:loggedIn="getUsername"/>
  </div>
</template>

<script>
import auth from './auth.js'
export default {
  data ()
  {
    return {
      username:''
    }
  },
  methods: {
    getUsername() {
      let temp = auth.getUser();
      if (temp!=undefined){
        this.username = temp.sub;
      }
    }
  },
  created() {
    this.getUsername();
  }
}
</script>
<style >

.card-body{
  background-color: white
}

</style>