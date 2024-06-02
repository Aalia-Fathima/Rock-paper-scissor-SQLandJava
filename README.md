# Rock-paper-scissor-SQLandJava
## Introduction
This application was created by using java swing library as frontend, programming langugae used is Java and for backend used SQL database connected using JDBC
## Components
- **Game Logic:** 
The Java code handles the game rules and outcomes.
- **Database Integration:** 
MySQL Workbench 8.0 CE is used to create and manage the database. JDBC is used for database connectivity.
- **User Interface:** 
Java Swing components are utilized to create a user-friendly interface, with graphical elements like images, buttons to enhance the gameplay experience.
## Setup Instructions
**Option 1: Download the ZIP File**
- Go to the GitHub repository.
- Click on the "Code" button.
- Select "Download ZIP" and extract the files to your local machine.<br>
#### Option 2: Clone the Repository
```
   git clone https://github.com/Aalia-Fathima/Rock-paper-scissor-SQLandJava.git

```
**Database Setup**
- Ensure MySQL Workbench 8.0 CE is installed and running on your PC.
- Create the database and tables using the provided SQL scripts.
```
   create database <database-name>
   create table signup(
      username varchar(50) primary key,
      password varchar(50)
   );
   create table score(
      user varchar(50),
      foreign key(user) references signup(username),
      user_score int,
      system_score int
   );

```
- Update the JDBC connection details in the project to match your MySQL configuration.<br>
#### Run the Application:
- Open the project in your preferred Java IDE.
- Compile and run the Main class to start the game.
