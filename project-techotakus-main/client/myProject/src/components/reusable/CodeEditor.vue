<template>
  <div>
    <form id="codeForm" @submit.prevent="Execute">
      <div class = "executeForm">
      <codemirror class="code_editor" v-model="code" :options="cmOptions" />
      <input type = "submit" class = "submit_button" value = "Execute Code">
      </div>
      <textarea id = "output" class = "code_box" hidden readonly></textarea>
    </form>
  </div>
</template>

<script>
//This component is modified based on the document from https://github.com/surmon-china/vue-codemirror
import 'codemirror/mode/python/python.js'
import 'codemirror/theme/darcula.css'
import gql from 'graphql-tag';
import ApolloClient from 'apollo-boost'
var ApoCli = new ApolloClient({ 
  uri: 'http://194.113.64.41:8081/graphql',
});

export default {
  data () {
    return {
      code: 'print("Hello World")',
      cmOptions: {
        tabSize: 2,
        mode: {
            name: 'python'
        },
        theme: 'darcula',
        lineNumbers: true,
        line: true,
      }
    }
  },
  methods:{
      Execute(e){
          var code = this.code;
          code = code.replace(/"/g, "\\\"").replace(/\\n/g, "_str_new_line_").replace(/\n/g, "_symbol_new_line_");
          var executeCode = gql`{
              RunPythonCode(code:\"${code}\")
          }`;
          ApoCli.query({query: executeCode}).then(
              function(res){
                  document.getElementById("output").style.display = "flex"
                  document.getElementById("output").innerHTML = res.data.RunPythonCode;
              }
          ).catch(
              function(err){
                  console.log(err);
              }
          )
      } 
  },
  // mounted() {
  //   console.log('the current CodeMirror instance object:', this.codemirror)
  //   // you can use this.codemirror to do something...
  // }
}
</script>

<style>
.executeForm{
  border: 10px solid rgb(212, 212, 212);
  background: rgb(212, 212, 212);
  width: inherit;
  align-self: center;
}
.code_editor {
  width: 100%;
  height: auto;
  margin: auto;
  text-align: left;
  font-size: 16px;
  /* align-content: center; */
}
.submit_button{
    background-color: rgb(164, 164, 173);
    margin-top: 10px;
    height: 30px;
    content-visibility: 50%;
    border-radius: 80%;
    overflow: auto;
    resize: none;
}
.editor{
  background-color: rgb(245, 245, 245);
  border: 1px #dbdbdb;
  border-style: solid;
  width: 80%;
  margin-left: 15%;
}
/* CodeForm */
#codeForm {
    align-self: auto;
    display: flex;
    flex-direction: column;
    width: 80%;
    max-width: 80%;
    margin: auto;
}

.code_box {
    height: 300px;
    width: inherit;
    display: flex;
    margin-top: 5px;
    margin-bottom: 5px;
    margin-left: auto;
    margin-right: auto;
    resize: none;
    align-self: center;
}
</style>