<template>
  <div class="box">
      <div>{{pet.name}}</div>
      <div class="emoji">{{petEmoji}}</div>
  </div>
</template>

<script>
export default {
  props: {
    pet: Object
  },
  computed: {
    petEmoji() {
      const allEmojis = {cat: '🐈', dog: '🐕‍🦺', chicken: '🐔', fish: '🐟'};
      return allEmojis[this.pet.species];
    }
  }
}
</script>

<style>
.emoji {
    font-size: 3em;
}

.box {
  border: 1px solid black;
  width: 100px;
}
</style>