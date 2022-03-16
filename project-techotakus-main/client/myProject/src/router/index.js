import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import SignupPage from '../components/pages/SignupPage'
import SigninPage from '../components/pages/SigninPage'
import ExecuteCodePage from '../components/pages/ExecuteCodePage'
import PythonTutorialPage from "../components/pages/PythonTutorialPage"

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'IndexPage',
      component: SigninPage
    },
    {
      path: '/signup',
      name: 'SignupPage',
      component: SignupPage
    },
    {
      path: '/signin',
      name: 'SigninPage',
      component: SigninPage
    },
    {
      path: '/executecode',
      name: 'ExecuteCode',
      component: ExecuteCodePage
    },
    {
      path: '/pythontutorial',
      name: 'PythonTutorial',
      component: PythonTutorialPage
    }
  ]
})
