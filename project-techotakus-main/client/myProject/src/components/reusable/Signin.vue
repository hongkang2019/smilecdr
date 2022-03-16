<template>
    <div id='Signin'>
        <div id="signinInfo"></div>
        <form id="signinForm" @submit.prevent="SigninAction">
            <input type="text" class="form_element" v-model="username" placeholder="Enter your username" required/>
            <input type="text" class="form_element" v-model="password" placeholder="Enter your password" required/>
            <input type="submit" class = "signin_button" value="Sign in!">
            <router-link to="/signup">Don't have an account? Sign up now!</router-link>
        </form>            
    </div>
</template>

<script>
import gql from 'graphql-tag';
import ApolloClient from 'apollo-boost'
var ApoCli = new ApolloClient({ 
  uri: 'http://194.113.64.41:8081/graphql',
});

export default {
    name: 'Signin',
    data(){
        return{
            username:"",
            password:"",
        }
    },
    methods:{
        SigninAction(e){
            const thiscp = this;
            var SigninGql = gql`{
                Signin(user_name:\"${this.username}\", user_password:\"${this.password}\")
            }`;
            ApoCli.query({query: SigninGql}).then(
                function(res){
                    if(res.data.Signin != null){
                        thiscp.$router.push('/executecode');
                        localStorage.setItem("tph_token", res.data.Signin);                                          
                    }else if (res.data.Signin == null){
                        document.getElementById("signinInfo").innerHTML = "Sign In Failed!";
                    }                  
                }
            ).catch(
                function(err){
                    console.log(err);
                }
            )
        } 
    }
}
</script>
