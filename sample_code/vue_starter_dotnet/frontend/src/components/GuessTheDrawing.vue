<template>
  <div>
      <h1>Guess The Drawing</h1>
       <input type=text placeholder="type guess here" v-model="guess">
      <div class="somethingelse">
       
       <img v-bind:src="imageurl">
       <timer-count v-on:timesup="SendToServer" ></timer-count>     
    </div>
  </div>
</template>

<script>
import TimerCount from "./TimerCount15"


export default {
  name: "guess-the-drawing",
  components: {
    TimerCount,
  },
  props: {
    imageurl: String
  },
  data() {
    return {
      guess: ''
    }
  },
  methods: {
    SendToServer() {       
      this.$emit('sendguesstoserver',this.guess);
    }
  }

}
</script>

<style>
.somethingelse {
    display: flex; 
    justify-content: flex-start;
    margin: 0px;
}
</style>