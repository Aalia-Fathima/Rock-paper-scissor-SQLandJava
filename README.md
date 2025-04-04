# Rock-paper-scissor-SQLandJava
## Introduction
The core game logic is implemented in Java.Player data and game statistics are stored in a MySQL database. The database connection is managed using JDBC.The front-end interface is built using Java Swing components, providing an interactive user experience. The GUI includes images, buttons for player choices (rock, paper, scissors) and displays game results.
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

## License
This project is licensed under the MIT License.
