<template>
    <div id="Page" class = "editor">
      <h2>Starts Here</h2>
      <div class = "paragraph">
          <p>Python is one of the most popular programming languages.</p>
          <p>Start learning python with our site.</p>
          <p>Use the following code segment to print "Hello World!"</p>
          <textarea class="code_demo" >print("Hello World")</textarea>
          <input type = "submit" v-on:click="display_editor" class = "display_btn" id = "displaybtn" value = "Try it yourself!">
      </div>
      <editor id = "editor_demo" hidden>testtest</editor>
    </div>
</template>

<script>
import 'codemirror/mode/python/python.js'

export default {
  name: 'PythonTutorialPage',
  methods:{
      display_editor(e){
        document.getElementById("editor_demo").removeAttribute("hidden");
        let btn = document.getElementById("displaybtn");
        btn.removeEventListener("click", this.display_editor);
        btn.addEventListener("click", this.hide_editor);
        btn.setAttribute("value", "Hide execute form");
      },
      hide_editor(e){
        document.getElementById("editor_demo").setAttribute("hidden", true);
        let btn = document.getElementById("displaybtn");
        btn.removeEventListener("click", this.hide_editor);
        btn.addEventListener("click", this.display_editor);
        btn.setAttribute("value", "Try it yourself!");
      }
  },
}



</script>

<style>
.page{
    width: 60%;
}
div.paragraph{
    width: auto;
    align-content: center;
}

.display_btn{
    margin-left: 0px;
}
.code_demo{
    height: auto;
    overflow: hidden;
    width: inherit;
    display: flex;
    margin-top: 5px;
    margin-bottom: 5px;
    resize: none;
    background-color: transparent;
}
</style>