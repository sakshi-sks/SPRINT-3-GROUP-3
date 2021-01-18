# SPRINT-3-GROUP-3
Training and Placement Cell

Instructions of using Training and Placement Cell

Training and placement cell is a single page application which can be used by the students, recruiters and placement officer of the college and check their recruitment proceedings.

Modules in project
•	Student Module- Consisting of functionalities such as student registration, student login, change password, update detils etc.
•	Administrator Module- Consists of functionalities such as view students, delete student, view recruiter, delete recruiter, view college details, update college details, change password etc.
•	Recruiter Module- consists functionalities such as recruiter registration, recruiter login, change password, view student details,update detils etc.

Technology used
•	React Application- modern JavaScript- ES6
•	RESTFUL API- Spring Boot on Java
•	Database- PostgreSql

Tools You Need to Build This Project
•	Maven 3.0+ for building Spring Boot API Project.
•	npm, webpack for building frontend.
•	IDE- STS4 for Java and Visual Studio Code for Frontend – JavaScript, React, CSS, Bootstrap, HTML.
•	JDK 1.8+.
•	Node v8+.
•	Embedded Tomcat, built into Spring Boot Starter Web.

Installing Node Js (npm) and Visual Studio Code
•	Steps-
  o	Step 1 - Installing NodeJs and NPM - Node Package Manager
  o	Step 2 - Installing Visual Studio Code - Front End JavaScript Editor

Installing Java, STS4, and Embedded Maven
•	Steps-
  o	Step 0 - Installation Java, STS4 and Maven.
  o	Step 1 - Installing Java JDK.
  o	Step 2 - Installing STS4 IDE.
  o	Step 3 - Using Embedded Maven in STS4.
  o	Step 4 - Troubleshooting Java, STS4 and Maven.
Creating a Full Stack CRUD Application With React and Spring Boot — Step-by-Step Approach
•	Create a Spring Boot Application.
•	Create a React application using Create React App.
o	Open cmd, go to the folder in which you have to create the react application and then type-
  npx create-react-app name-of-project
o	Command for bootstrap, axios, react-router-dom installation-
  npm i axios --save
  npm i bootstrap --save
  npm i react-router-dom –save
o	After installing everything, run a command to initialize the server-
  npm start
•	Create the Retrieve Courses REST API and Enhance the React Front end to retrieve the courses using the axios framework.
•	Add a feature to delete a course in React front end and Spring Boot REST API.
•	Add functionality to update course details in React front end and Spring Boot REST API.
•	Add feature to create a course in React front end and Spring Boot REST API.

The Backend Spring Boot REST API is running on http://localhost:8080, and it does not allow requests from other servers - http://localhost:3000, in our project.
Hence it has to be configure Rest Resource to allow access from specific servers-
•	@CrossOrigin(origins =  “http://localhost:3000”) — Allows requests from specific origins.



