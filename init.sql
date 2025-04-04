CREATE DATABASE IF NOT EXISTS GameProject;
USE GameProject;
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
