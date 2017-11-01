<template>
  <section class="tites">
    <div class="hero-body">
      <div id="app" class="container">
        <h1 class="title">Blog Vuejs</h1>
        <h2 class="subtitle">This is a mini blog using vuejs and bulma</h2>

        <div class="columns" >

          <div class="column is-6 ">
            <div class="field">
              <input type="text" class="input" v-model="title" placeholder="Title"></input>
            </div>
            <div class="field">
              <textarea class= "textarea" name="name" rows="8" cols="80" v-model="description" placeholder="Post content"></textarea>
            </div>
            <v-multiselect v-model="hashtags"></v-multiselect>
            <button class= "button is-success" type="button" name="button" v-on:click="addNewPost()" >Post it</button>
          </div>
          <div class="column is-6">
            
            <h2 class="subtitle has-text-centered ">
              <span class="icon">
                <i class="fa fa-home"></i>
              </span>
              Posts
            </h2>
            <div v-for="post in posts">
              <div class="">
                <div class=" ">
                  <p class="title is-4">
                    {{ post.title}}
                  </p>
                </div>
                <div class="content">
                  <p>{{ post.description }}</p>
                </div>
                <footer >
                  <i class="is-small content">
                    <div v-if="post.updateDateFormat == '' ">
                      Posted at <time>{{post.creationDateFormat}}</time> 
                    </div>
                    <div v-else>
                      Update at <time>{{post.updateDateFormat}}</time>
                    </div>
                    
                    by <b>{{post.author.name}}</b>
                  </i>
                </footer>
                <a class="button is-warning is-outlined" @click="isComponentModalActive = true">
                  <span>Edit</span>
                  <span class="icon is-small">
                    <i class="fa fa-edit"></i>
                  </span>
                </a>
                <b-modal :active.sync="isComponentModalActive" has-modal-card>
                  <v-update-post v-bind="post"></v-update-post>
                </b-modal>
                <a class="button is-danger is-outlined" @click="deletePost(post)">
                  <span>Delete</span>
                  <span class="icon is-small">
                    <i class="fa fa-times"></i>
                  </span>
                </a>
              </div>
              </br>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>

import axios from 'axios';
import UpdatePost from './components/UpdatePost.vue';
import Multiselect from './components/Multiselect.vue';

export default {
  data(){
    return {
      isComponentModalActive: false,
      description: '',
      title: '',
      creationDateFormat: '',
      posts:[ 
      ],
      errors:[

      ],
      hashtags:[

      ]
    }
  },
  components:{
    'v-update-post': UpdatePost,
    'v-multiselect': Multiselect
  },
  mounted(){
    this.getAllPosts()
  },
  methods:{ 
    addNewPost: function(){

      self = this;
      axios.post('http://localhost:8081/api/v1/post',{
        description : this.description,
        title: this.title,
        hashtags: this.hashtags
      }).then(function(response){
        self.posts.push(response.data)
        console.log(response);
        self.title = '';
        self.description = '';
        self.hashtags = [];
      }).catch(function(error){
        console.log(error);
      });
    },
    getAllPosts : function(){
      axios.get('http://localhost:8081/api/v1/post')
        .then(response => {
          this.posts = response.data
        })
        .catch(e =>{
          this.errors.push(e)
        });
    },
    deletePost: function(post){
      self = this;
      // this.$dialog is from Buefy
      this.$dialog.confirm({
        title: 'Deleting post',
        message: 'Are you sure you want to <b>delete</b> this post? This cannot be done.',
        confirmText: 'Delete Post',
        type: 'is-danger',
        hasIcon: true,
        onConfirm: () => axios.delete("http://localhost:8081/api/v1/post/"+post.id)
          .then(response =>{
            self.posts.pop(post)
            // TODO make a better remove item list
            this.$toast.open('Post deleted!');
          })
          .catch(e =>{
            console.log(e);
          })
      }) 
    }
  },
  created(){
    // get value from child component and add to hashtags from parent component
    this.$root.$on('hashtags', (hashtags) => {
    	this.hashtags = hashtags;
    })
  }
}
</script>

<style>

</style>
