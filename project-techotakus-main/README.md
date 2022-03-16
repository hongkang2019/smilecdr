# Project Proposal
This is the proposal for the CSCC09 project of group TechOTAKUS.

### Project Title
Python Online Trainning Platform

### Team Members
Hongkang Yu, UTORID: yuhongk1
Linjun Wang, UTORID: wangl129

### Project Description
The purpose of this project is to create a web application that provides basic
trainning in Python. Python is a strong data analyzing language. Many students
that are not in CS program also have the desire to learn Python skills. 
However, some of them are first-time learning a programming language and have 
great difficulty. We aim at making stepping into Python easier with services 
such as providing basic trainning material, compiling and running your code
online, online examination and discussing with other learners.

### Key Features by Beta Version
1. As a user, I want to control my authentication on the website.
2. As a user, I want to browse any trainning materials.
3. As a user, I want the materials to be classified.
4. As a user, I want to edit my code on the website.
5. As a user, I want to compile my code on the website.
6. As a user, I want to browse others' post.
7. As a user, I want to post on the discussion board.
8. As a user, I want to comment on others' post.
9. As a user, I want to delete anything I posted.
We are aiming at the authentication, trainning materials, online code editor,
online compiling and discussion board by Beta Version.

### Features by Final Version
1. As a user, I want to do multiple choice tests on the website.
2. As a user, I want to keep my test results history.
3. As a user, I want to rank my test results with others.
4. As a user, I want to delete any comments under my post.
5. As a user, I want to be suggested with syntax while editing the code on the 
website.
We are aiming at the online testing, test record and rank, additional features
for the discussion board and additional features for the code editor after Beta
Version.

### Technology Stack
Our primary decision on the technology stack of the project is Vue.js + 
Spring Boot + Mybatis + MySQL.

Vue.js is a popular and widely used frontend framework. Our group wants to make
an attempt on this framework and experiences the Two-lane Data-Binding feature
of Vue.

Spring Boot is a strong Java EE framework that assembles the functionalities of
Spring and SpringMVC while saving a lot of configurations. The support of IoC,
AOP and the MVC structure allows us writing good quality code easily in our
backend.

Mybatis is a persistance framework that helps us to access to the database
easier. We can encapsulate the query statements and not bother that in our
JavaBean.

MySQL is one of the most commonly used relational database. The combination
of Mybatis and MySQL makes the CRUD operations efficient and powerful.

Overall, the technology stack is close to the technology stacks used in
some enterprises. We try to build a web application that is mature enough for
entrepreneurial use.

### Technical Challenges
1. It is challenge for us to find a way to compile the user input in Python
on our server and return the output back to users.
2. How to intelligently suggest what should be entered while users' editing
their code.
3. How to implement a test system similar to Quercus.
4. How to deploy a Java application on server.
5. Vue.js is a new framework for us. It is challenge to implement good UI
as we are all new to it. 