<template>
  <div id="app">
    <textarea name="name" rows="8" cols="80" v-model="post"></textarea>
    <button type="button" name="button" v-on:click="addNewPost()" >Post it</button>
      <div v-for="post in posts" >
        <blockquote cite="http://">
          {{ post.message }}
        </blockquote>
      </div>
    </ul>
  </div>
</template>

<script>
export default {
  data(){
    return {
      post: '',
      posts:[
        { message: 'First static cool message' },
        { message: 'Second message'}
      ]
    }
  },
  methods:{
    addNewPost: function(){
      this.posts.push({'message': this.post})
      this.post = ''
    }
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

h1, h2 {
  font-weight: normal;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
