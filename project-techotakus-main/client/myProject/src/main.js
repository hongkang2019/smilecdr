// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
/*----------GraphQL----------*/
import ApolloClient from 'apollo-boost'
import VueApollo from 'vue-apollo'
/*--------Components---------*/
import Signup from './components/reusable/Signup'
import Signin from './components/reusable/Signin'
import CodeEditor from './components/reusable/CodeEditor'
import HeaderBar from './components/reusable/HeaderBar'
/*-------CodeMirror--------*/
import VueCodemirror from 'vue-codemirror'
/*--------Style-------------*/
import './style/Main.css'
import './style/Authen.css'
import 'codemirror/lib/codemirror.css'
import './style/HeaderBar.css'


Vue.use(VueCodemirror)

Vue.config.productionTip = false

//Initialize graphql client
const apolloClient = new ApolloClient({ 
  uri: 'http://194.113.64.41:8081/graphql',
});
Vue.use(VueApollo);
const apolloProvider = new VueApollo({
  defaultClient: apolloClient,
})

Vue.component("signup", Signup)
Vue.component("signin", Signin)
Vue.component("editor", CodeEditor)
Vue.component("headerbar", HeaderBar)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>',
  apolloProvider
})
