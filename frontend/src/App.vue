<template>
  <section class="hero">
    <div id="app" class="container">
      <h1 class="title">Blog Vuejs</h1>
      <h2 class="subtitle">This is a blog using vuejs and bulma</h2>

      <div class="columns" >

        <div class="column is-6 ">
          <div class="field">
            <input type="text" class="input" v-model="title" placeholder="Title"></input>
          </div>
          <div class="field">
            <textarea class= "textarea" name="name" rows="8" cols="80" v-model="description" placeholder="Post content"></textarea>
          </div>
          <button class= "button is-primary is-outlined" type="button" name="button" v-on:click="addNewPost()" >Post it</button>
        </div>
        <div class="column is-6">
          <h2 class="subtitle has-text-centered">Posts</h2>
          <div v-for="post in posts" class="card" >
            <header class="card-header">
              <p class="card-header-title">
                {{ post.title}}
              </p>
            </header>
            <div class="card-content">
              <div class="content">
                <p>{{ post.description }}</p>
                <time datetime="2016-1-1">11:09 PM - 1 Jan 2016</time>
              </div>
            </div>
            <footer class="card-footer">
              <a class="card-footer-item button is-success">Save</a>
              <a class="card-footer-item button is-warning">Edit</a>
              <a class="card-footer-item button is-danger">Delete</a>
            </footer>
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
      posts:[ 
      ],
      errors:[
        
      ]
    }
  },
  mounted(){
    this.getAllPosts()
  },
  methods:{
    addNewPost: function(){
      this.posts.push({'title':this.title,'description': this.description})
      this.title = ''
      this.description = ''
    },getAllPosts : function(){
      axios.get('http://localhost:8081/api/v1/post')
        .then(response => {
          this.posts = response.data
        })
        .catch(e =>{
          this.errors.push(e)
        });
     }
  }
}
</script>

<style>

</style>
