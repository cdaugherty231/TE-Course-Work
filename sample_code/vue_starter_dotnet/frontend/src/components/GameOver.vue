<template>
  <div id="mainGO">
    <b-card title="Game Over" sub-title="View Finished Pads" >        
        <ul>
            <li v-for="gamepad in finishedGamePads" :key="gamepad.original_Owner" v-on:click="showDetails(gamepad.original_Owner,$event)"><span>{{gamepad.original_Owner}}</span></li>   
        </ul>
    </b-card>  
    <div class="padDisplay" v-if="showPadDetails">        
        <show-pad-details v-bind:pad="showPad" v-bind:index="0" /> 
    </div>
    <div id="instructions" v-if="showInstructions">
    <b-card title="Instructions" >
        <b-card-text>
            If screen sharing is available, one player should be the designated reader. (Otherwise each player will be the reader for their own card and everyone will click next themselves.) The reader should select one card at a time and read the drawing and the guess for each round.
        </b-card-text>
    </b-card>
    </div>
    <b-button class="shorter" v-on:click="PlayAgain" v-if="!showInstructions">Let's do that again!</b-button>
  </div>  
</template>

<script>
import auth from '../auth';
import showPadDetails from './ShowPadDetails'

export default {
    name:'game-over',
    props: {
        gameId: String
    },
    data(){
        return {
            finishedGamePads: [],
            showPadDetails: false,
            showPad: [],
            showInstructions: true
        }
    },
    components:{
        showPadDetails
    },
    methods: {
        PlayAgain() {
            this.$router.go(0);
        },
        showDetails(owner,event) {
            this.showInstructions=false;
            //make the link grey
            event.target.classList.add('visited');
            this.showPadDetails=true;
            this.showPad = this.finishedGamePads.find(pad=>pad.original_Owner==owner);
        },
        GetFinishedPads() {
            fetch(`${process.env.VUE_APP_GAME_REMOTE_API}/finishedPads/${this.gameId}`,{
                method: 'POST',
                headers: {
                    Accept: 'application/json',
                    'Content-Type': 'application/json',
                    Authorization: 'Bearer ' + auth.getToken(),
                },
                credentials: 'same-origin',
            
            })
            .then((response) => {
                if (response.ok) {
                    return response.json();
                }
            })
            .then( (data)=> this.finishedGamePads=data) 
            .catch((err) => console.error(err));
        },
    },
    created () {
        this.GetFinishedPads();
    }

}
</script>

<style>
#mainGO{
    display:flex;
    justify-content: space-evenly;
}
li span {
  color: blue;
  text-decoration: none;
  cursor: pointer;
}

.visited {
  color:grey;
  text-decoration: none;
  cursor: pointer;
}
li span:hover {
  color: #00f;
  text-decoration: underline;
}

ul {
    list-style-type: none;
}
#instructions {
    max-width: 25%;
}


</style>