<template>
  <div id="main">
      <b-card :title="title">  
      <vue-canvas v-on:sendtoserver="SendToServer"/>
      </b-card>
     
  </div>
</template>

<script>

import VueCanvas from './VueCanvas'


export default {

  name: "draw-the-word",
  props: {
    word: String
  },
  data() {
    return {
      title: "Draw the word: " + this.word
    }
  },
  components: {
    VueCanvas
  },
  computed: {

  },
  methods: {
    SendToServer(dataURL)
    {            
      this.$emit("senddrawingtoserver",dataURL);      
    }
  }
 

}
</script>

<style>
h1 {
  margin: 0;
  height: 50px;
}

#main {
    padding: 0px;
    margin: 0px;
    background-color: white;
}
#canvas {
    border: 3px solid black;
    height: 500px;
    width: 500px;
}
</style>