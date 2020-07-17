<template>
  <div>
      <h1>Ready to start game {{gameId}}</h1>
       <b-card title="Current Players" sub-title="Are you ready for fun?">
      
        <b-card-text>
        <ul>
            <li v-for="player in currentPlayers" :key="player">{{player}}</li>
        </ul>
         </b-card-text>
         <b-button v-on:click="RefreshPlayerList">Refresh Player List</b-button>
      </b-card>
      <b-card title="Don't hit the button until all players have joined!" sub-title="Or wait and someone else will eventually do it, right?">

      <b-button v-on:click="StartTheGame">Start the game!</b-button>
      </b-card>

      

      <p id="err"></p>
    </div>
</template>

<script>
import auth from '../auth';

export default {
    
    name: 'start-the-game',
    props: {
        gameId: String
    },
    data() {
        return {
            currentPlayers: []
        }
    },
    methods: {
         StartTheGame() { //this will make WaitForNext return 
            fetch(`${process.env.VUE_APP_GAME_REMOTE_API}/startthegame`, {
                method: 'POST',
                headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
                Authorization: 'Bearer ' + auth.getToken(),
                },
                credentials: 'same-origin',
                body: JSON.stringify(this.gameId),
            })
            .then( (response)=> {
                if (response.ok){
                    this.$emit("gamestarted");
                }
                else{
                    console.log(response.statusText);
                    document.getElementById("err").innerText = "ERROR:"+ response.status + " "+response.statusText;
                }
            })
            .catch((err) => console.error(err));
        },
         RefreshPlayerList() { //this will updatet eh list of players
            fetch(`${process.env.VUE_APP_GAME_REMOTE_API}/getPlayerList/${this.gameId}`, {
                method: 'GET',
                headers: {
                Accept: 'application/json',
                'Content-Type': 'application/json',
                Authorization: 'Bearer ' + auth.getToken(),
                },
                credentials: 'same-origin',
             
            })
            .then( (response)=> {
                if (response.ok){
                    return response.json();
                }
            })
            .then ((list)=>{
                this.currentPlayers = list;
            })
            .catch((err) => console.error(err));
        },
    },
    created () {
        this.RefreshPlayerList();

    }

}
</script>

<style>

</style>