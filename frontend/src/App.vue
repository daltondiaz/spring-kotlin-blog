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
                    Posted at <time>{{post.creationDateFormat}}</time> 
                    by <b>{{post.author.name}}</b>
                  </i>
                </footer>
                <a class="button is-warning is-outlined">
                  <span>Edit</span>
                  <span class="icon is-small">
                    <i class="fa fa-edit"></i>
                  </span>
                </a>
                <a class="button is-danger is-outlined" v-on:click="deletePost(post)">
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

export default {
  data(){
    return {
      description: '',
      title: '',
      creationDateFormat: '',
      posts:[ 
      ],
      errors:[

      ]
    }
  },
  mounted(){
    this.getAllPosts(),
    this.de
  },
  methods:{ 
    addNewPost: function(){

      self = this;
      axios.post('http://localhost:8081/api/v1/post',{
        description : this.description,
        title: this.title
      }).then(function(response){
        self.posts.push(response.data)
        console.log(response);
        self.title = '';
        self.description = '';
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
      axios.delete("http://localhost:8081/api/v1/post/"+post.id)
        .then(response =>{
          self.posts.pop(post)
        })
        .catch(e =>{
          console.log(e);
        });
    }
  }
}
</script>

<style>

</style>
