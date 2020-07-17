<template>
  <div class="home">

    <join-the-game v-if="!gameInProgress" v-on:gamejoined="GameJoined"></join-the-game>
    <start-the-game v-if="waitingForStart" v-on:gamestarted="GameStarted" v-bind:gameId="gameId"></start-the-game>

    <div v-if="playingInProgress">      
      <draw-the-word v-if="showDraw" v-on:senddrawingtoserver="SendDrawingToServer" v-bind:word="round.guess"></draw-the-word>
      <guess-the-drawing v-if="!showDraw" v-on:sendguesstoserver="SendGuessToServer" v-bind:imageurl="round.picture"></guess-the-drawing>
    </div>
    <game-over v-if="showGameOver" v-bind:gameId="gameId" />
  </div>

  
</template>

<script>
import JoinTheGame from '@/components/JoinTheGame'
import StartTheGame from '@/components/StartTheGame'
import DrawTheWord from '@/components/DrawTheWord'
import GuessTheDrawing from '@/components/GuessTheDrawing'
import GameOver from '@/components/GameOver'
import auth from '../auth';

export default {
  name: 'home',
  data() {
    return {
      gameInProgress: false,
      waitingForStart: false,
      gameId: '',
      playingInProgress: false,
      showDraw: false,
      showGameOver: false,
      round: {
        isDraw: false,
        guess: "",
        picture: "",
        doneBy: ""
      }
    }
  },
  components:{
    JoinTheGame,
    StartTheGame,
    DrawTheWord,
    GuessTheDrawing,
    GameOver
  },
  computed: {

  },
  methods: {
     GameJoined(id){
       this.gameId = id;
       this.gameInProgress = true;
       this.waitingForStart = true;
       this.WaitForNext();
     },
     GameStarted(){
       this.waitingForStart = false;
       this.gameInProgress = true;      
     },
     WaitForNext() {
        fetch(`${process.env.VUE_APP_GAME_REMOTE_API}/${this.gameId}`,{
          method: 'GET',
          headers: {
             Accept: 'application/json',
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + auth.getToken(),
          },
          credentials: 'same-origin'
          
        })
        .then((response) => {
          if (response.status==409){
            this.DisplayGameOver();
            return undefined;
          }
          if (response.ok) {
            return response.json();
          }     
        })
        .then( (round)=>{
          if (round) {
            this.round = round;
            this.playingInProgress = true;
            this.waitingForStart = false;
            if (round.isDraw == true){
              this.DisplayDraw(round.word);
            }
            else{
              this.DisplayGuess(round.image);
            }
          }
        })
        .catch((err) => console.error(err));
    },

    SendDrawingToServer(drawingURL)
    {
      this.round.picture = drawingURL;
   
      this.SendRoundToServer();
    },
    SendGuessToServer(guess)
    {
      this.round.guess = guess;      
      this.SendRoundToServer();
    },
    SendRoundToServer() {
        fetch(`${process.env.VUE_APP_GAME_REMOTE_API}/submitround/${this.gameId}`,{
          method: 'POST',
          headers: {
             Accept: 'application/json',
            'Content-Type': 'application/json',
            Authorization: 'Bearer ' + auth.getToken(),
          },
          credentials: 'same-origin',
          body: JSON.stringify(this.round)
        })
        .then((response) => {
          if (response.ok) {
            this.WaitForNext(); //wait for the next round after we submit
          }
        })
        .catch((err) => console.error(err));
    },
   
    DisplayDraw(){
      this.showDraw = true;
    },
    DisplayGuess(){
      this.showDraw = false;
    },
    DisplayGameOver(){
      this.showGameOver=true;
      this.playingInProgress=false;
    }
    
  }

}
</script>
