<template>
  <div class="home">
    <h1>Home</h1>
    <p>You must be authenticated to see this. Your username is: {{ $store.state.user.username }}</p>
  </div>
</template>

<script>

export default {
  name: 'home'
};
</script>
