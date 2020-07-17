<template>
<div class="somethingelse">
 <canvas @mousedown="startPainting" @mouseup="finishedPainting" @mousemove="draw"  id="canvas"></canvas>
 <div class="tnc">
    <timer-count v-bind:timerCount=60 v-on:timesup="SendToServer" ></timer-count>
    <button v-on:click="Clear">Clear</button>
 </div>

</div>
</template>

<script>

import TimerCount from "./TimerCount45"

export default {

    data() {
        return {
        message: 'Hello Vue!',
        vueCanvas:null,
        painting:false,
        canvas:null,
        ctx:null,
        debug: false
        }
    },
    components: {
        TimerCount
    },
    methods: {
  
        Clear(){
            this.ctx.clearRect(0, 0, this.canvas.width, this.canvas.height);
        },
        startPainting(e) {
            this.painting = true;
            if (this.debug) {
                console.log(this.painting)
            }
            this.draw(e)
        },
        finishedPainting() {
            this.painting = false;
             if (this.debug) {
                 console.log(this.painting);
             }
            this.ctx.beginPath()
        },
        draw(e) {
            if(!this.painting) return

            this.ctx.lineWidth = 5;
            this.ctx.lineCap ="round"
             if (this.debug) {
                 console.log(e.clientX+" "+e.clientY);
             }
             //this.ctx.lineTo(e.clientX-20,e.clientY-90); if you are showing the h6 welcome
            this.ctx.lineTo(e.clientX-20,e.clientY-60); //so this offset has to be the total height of everything above it
            this.ctx.stroke()

            //this.ctx.beginPath()
            //this.ctx.moveTo(e.clientX,e.clientY)

        
        },
        SendToServer()
        {
            const dataURL = this.canvas.toDataURL();
            //dataURL.replace(/^data:image\/(png|jpg);base64,/, ""); try this if it doesn't work
            this.$emit("sendtoserver",dataURL);
        }
    },
    mounted() {
        this.canvas = document.getElementById("canvas");
        this.ctx = this.canvas.getContext("2d");  

        // Resize canvas
        this.canvas.height = 500; //window.innerHeight;
        this.canvas.width = 500; //window.innerWidth;
 
    }

}
</script>

<style>
html body {
    padding: 0px;
    margin: 0px;
}

#canvas {
    border: 3px solid black;
}
.somethingelse {
    display: flex; 
    justify-content: flex-start;
    margin: 0px;
}
.tnc {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: space-evenly;
}

</style>