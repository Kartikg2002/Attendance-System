CREATE DATABASE attendancesystem;
use attendancesystem;

CREATE TABLE stuinfo(
id int auto_increment PRIMARY KEY,
name VARCHAR(50),
fathername VARCHAR(50),
phoneno VARCHAR(50),
email VARCHAR(50)
);

CREATE TABLE teacherinfo(
id int auto_increment PRIMARY KEY,
name VARCHAR(50),
username VARCHAR(50),
password VARCHAR(50)
);

CREATE TABLE attendance(
id VARCHAR(50),
name VARCHAR(50),
date VARCHAR(50),
attendance VARCHAR(50)
);

SELECT * FROM attendancesystem.stuinfo;
SELECT * FROM attendancesystem.teacherinfo;
SELECT * FROM attendancesystem.attendance;
