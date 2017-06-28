import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource'
import VueRouter from 'vue-router'

Vue.use(VueResource)
Vue.use(VueRouter)

// Set up routing and match routes to components
export var router = new VueRouter({
  routes:[
    {path: '/home', component: App}
  ]
})

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
