<template>
  <div >
    <p style="margin: 0">
      <span class="bold">Original Owner:</span>
      {{pad.original_Owner}}
      <span class="bold">Original Word:</span>
      {{pad.original_Word}}
    </p>
    <div class="roundDisplay">
      <div v-if="pad.rounds[index].isDraw">
        <b-card no-body class="resultsCard">
          <b-card-body>
            <h3>
              <em>{{doneBy}}</em> saw word
              <em>{{guess}}</em> and drew
            </h3>
            <b-button v-on:click="index--" v-if="index>0" variant="primary">Previous</b-button>
            <img v-bind:src="pad.rounds[index].picture" />

            <b-button v-on:click="index++" v-if="index < pad.rounds.length-1" variant="primary">Next</b-button>
          </b-card-body>
        </b-card>
      </div>

      <div v-if="!pad.rounds[index].isDraw">
        <b-card no-body class="resultsCard">
          <b-card-body>
            <h3>
              <em>{{doneBy}}</em> guessed
              <em>{{guess}}</em> when they saw
            </h3>
            <div class="flexContainer">
              <b-button
                class="shorter"
                v-on:click="index--"
                v-if="index>0"
                variant="primary"
              >Previous</b-button>
              <img v-bind:src="pad.rounds[index].picture" />
              <!--<p class="guess"> {{guess}}</p>-->
              <b-button
                class="shorter"
                v-on:click="index++"
                v-if="index<pad.rounds.length-1"
                variant="primary"
              >Next</b-button>
            </div>
          </b-card-body>
        </b-card>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    pad: Object,
    index: Number
  },
  data() {
    return {
      round: Object
    };
  },

  computed: {
    doneBy() {
      return this.pad.rounds[this.index].doneBy;
    },
    drawTitle() {
      return (
        "<em>" +
        this.pad.rounds[this.index].doneBy +
        "</em> saw word <em>" +
        this.pad.rounds[this.index].guess +
        "</em> and drew:"
      );
    },
    guessTitle() {
      return (
        "<em>" +
        this.pad.rounds[this.index].doneBy +
        "</em> guessed <em>" +
        this.pad.rounds[this.index].guess +
        "</em> from image"
      );
    },
    guess() {
      return this.pad.rounds[this.index].guess;
    }
  }
};
</script>

<style>
.resultsCard {
  min-width: 500px;
  padding: 0;
  margin: 0;
}
.resultsCard > h4.card-title {
  margin: 0;
}

.guess {
  font-size: 50px;
  border: 5px solid black;
}
.flexContainer {
  display: flex;
  align-items: center;
}
.shorter {
  height: 30px;
  align-content: center;
}

.bold {
  font-weight: bold;
}
</style>