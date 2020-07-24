<template>
  <div>
      <h2> Input fields should be added to the form </h2>
      <form v-on:submit.prevent="addNewReview">
          <!--author,summary, post, id add these inpyt fields with a v-model to connect
          to the field on newPost-->
          
          <input type="submit" value="Do it"/>
          
      </form>
  </div>
</template>

<script>
export default {
    name: 'add-blog-post',
    data() {
        return {
            newPost: {
                author: "deb",
                summary: "you should add this as a field to the form",
                post: "this too",
                id: "99" //to do make this the next number in the series
            }
        };
    },
    methods: {
        addNewReview() {
            //call ADD_NEW_POST mutation
            this.updateIdWithNextValue();
            this.$store.commit("ADD_NEW_POST",this.newPost);
        },
        updateIdWithNextValue(){
            //to do look at the list of blog posts, figure otu the biggest id and then set the id for 
            // newPost to one bigger than that 
            let biggestId = this.$store.state.blogPosts[0].id; //assume the first blog post has the biggest id
            //then look thru the rest for the biggest
            this.$store.state.blogPosts.forEach(post=>{
                if (post.id>biggestId) {
                    biggestId = post.id;
                }
            })
           
            this.newPost.id = biggestId+1;
        }
    }


}
</script>

<style>

</style>