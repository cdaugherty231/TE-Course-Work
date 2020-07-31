<template>
  <div>
      <h1>{{ $store.state.user.username }}'s Pets</h1>
      <pet-display v-for="currentPet in allPets" v-bind:key="currentPet.name" v-bind:pet="currentPet"></pet-display>

  </div>
</template>

<script>
import PetDisplay from '@/components/PetDisplay';
import petService from '@/services/PetService';

export default {
    components: {
        PetDisplay
    },
    data() {
        return {
            allPets: []
        }
    },
    created() {
        petService.fetchPets().then(response => this.allPets = response.data);
    }
}
</script>

<style>

</style>