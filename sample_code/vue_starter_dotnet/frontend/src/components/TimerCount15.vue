<template>
    <div id="timerCountDiv" class="timerCountClass">
     {{timerCount}}
    </div>
    
</template>

<script>

    export default {

        data() {
            return {
              timerCount: 20
            }
        },


        watch: {

            timerCount: {
                handler(value) {

                    if (value <10) {
                        document.getElementById("timerCountDiv").classList.add("warning");                
                    }
                    if (value > 0) {
                        setTimeout(() => {
                            this.timerCount--;
                        }, 1000);
                    }
                    else {
                        this.$emit("timesup");
                    }

                },
                immediate: true // This ensures the watcher is triggered upon creation
            }

        }
    }

</script>

<style scoped>
.timerCountClass {
    border: 5px solid black; 
    font-size: 50px;
    width: 100px;
    height: 100px;
    text-align: center;
    vertical-align: center;
}

.warning {
    color:red;
    font-size: 100px;
    font-weight: bold;    
    width: 150px;
    height: 150px;
}
</style>