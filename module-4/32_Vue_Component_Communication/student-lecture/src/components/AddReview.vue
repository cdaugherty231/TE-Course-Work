<template>
  <div>
    <a
      id="show-form-button"
      href="#"
      v-on:click.prevent="showForm = true"
      v-if="!showForm"
    >Show Form</a>
    <form v-if="showForm === true" v-on:submit.prevent="addNewReview">
      <div class="form-element">
        <label for="reviewer">Name:</label>
        <input id="reviewer" type="text" v-model="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="title">Title:</label>
        <input id="title" type="text" v-model="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating:</label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review</label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>
      <button>Submit</button>
      <button v-on:click.prevent="resetForm" type="cancel">Cancel</button>
    </form>
  </div>
</template>

<script>
export default {
  name: "add-review",
  data() {
    return {
      showForm: false,
      newReview: {}
    };
  },
  methods: {
    addNewReview() {
      this.$store.commit("ADD_REVIEW", this.newReview);
      this.resetForm();
    },
    resetForm() {
      this.showForm = false;
      this.newReview = {};
    }
  }
};
</script>

<style>
</style>
