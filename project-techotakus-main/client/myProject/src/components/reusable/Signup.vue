<template>
    <div id='Signup'>
        <div id="signInfo"></div>
        <form id="signupForm" @submit.prevent="SignupAction">
            <input type="text" class="form_element" v-model="username" placeholder="Enter your username" required/>
            <input type="text" class="form_element" v-model="password" placeholder="Enter your password" required/>
            <input type="submit" class = "signup_button" value="Sign up!">
            <router-link to="/signin">Already Have An Account? Sign in Now!</router-link>
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
    name: 'Signup',
    data(){
        return{
            username:"",
            password:"",
        }
    },
    methods:{
        SignupAction(e){
            const thiscp = this;
            var SignupGql = gql`{
                Signup(user_name:\"${this.username}\", user_password:\"${this.password}\")
            }`;
            ApoCli.query({query: SignupGql}).then(
                function(res){
                    if(res.data.Signup == 1){
                        document.getElementById("signInfo").innerHTML = "Signup Succeed!";
                        thiscp.$router.push('/signin');  
                    }else if (res.data.Signup == 0){
                        document.getElementById("signInfo").innerHTML = "Username Already Exists!";
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
