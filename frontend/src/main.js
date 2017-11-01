import Vue from 'vue'
import App from './App.vue'
import VueResource from 'vue-resource'
import VueRouter from 'vue-router'
import Buefy from 'buefy'
import 'buefy/lib/buefy.css'

// register globally
// import Mutliselect from 'vue-multiselect';

Vue.use(VueResource)
Vue.use(VueRouter)
Vue.use(Buefy)

// register globally
// Vue.component('multiselect',Mutliselect);

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
