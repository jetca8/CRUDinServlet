/* for CST8288 - Case Study 2*/
/* for MySQL*/
DROP DATABASE IF EXISTS tutoring;

CREATE DATABASE tutoring;

USE tutoring;

CREATE TABLE course (
	CourseCode VARCHAR(7) NOT NULL PRIMARY KEY,
        CourseName VARCHAR(45) NOT NULL,
	CourseDescription TEXT NOT NULL
)	;

CREATE TABLE experience (
	ExperienceID INT NOT NULL PRIMARY KEY,
	Description TEXT NOT NULL
)	;

CREATE TABLE student (
	StudentID INT NOT NULL PRIMARY KEY,
	FirstName VARCHAR(45) NOT NULL,
	LastName VARCHAR(45) NOT NULL,
	Email VARCHAR(45),
        PhoneNumber VARCHAR(45)
)	;

CREATE TABLE tutor (
	TutorID INT NOT NULL PRIMARY KEY,
	LastName VARCHAR(45) NOT NULL,
	FirstName VARCHAR(45) NOT NULL,
	Email VARCHAR(45),
	PhoneNumber VARCHAR(15),
	Status VARCHAR(45) NOT NULL,
	experience_ExperienceID INT NOT NULL,
  FOREIGN KEY (experience_ExperienceID) REFERENCES experience (ExperienceID)
)	;

CREATE TABLE session (
	DateKey DATE NOT NULL ,
	TimeKey TIME NOT NULL ,
	StudentLastName VARCHAR(45) NOT NULL,
	SessionStatus INT NOT NULL,
	SessionTopic TEXT NOT NULL,
        tutor_TutorID INT NOT NULL,
        course_CourseCode VARCHAR(7) NOT NULL,
        student_StudentID INT NOT NULL,
        PRIMARY KEY (DateKey, TimeKey, tutor_TutorID, course_CourseCode, student_StudentID),
    FOREIGN KEY (tutor_TutorID) REFERENCES tutor(TutorID),
    FOREIGN KEY (course_CourseCode) REFERENCES  course(CourseCode),
    FOREIGN KEY (student_StudentID) REFERENCES student(StudentID)
)	;

    CREATE TABLE tutorcourse (
    tutor_TutorID INT NOT NULL,
    course_CourseCode VARCHAR(7) NOT NULL,
    PRIMARY KEY (tutor_TutorID, course_CourseCode),
    FOREIGN KEY (tutor_TutorID) REFERENCES tutor (TutorID),
    FOREIGN KEY (course_CourseCode) REFERENCES course (CourseCode)
) ;

CREATE TABLE studentcourse (
   	student_StudentID INT NOT NULL,
	course_CourseCode VARCHAR(7) NOT NULL,
   PRIMARY KEY (student_StudentID,course_CourseCode),
   FOREIGN KEY (student_StudentID) REFERENCES student(StudentID),
   FOREIGN KEY (course_CourseCode) References course(CourseCode)
)	;

/* ------------------------------------ */

INSERT INTO COURSE
VALUES('CST8101','Computer Essentials','The essentials of computer software, hardware, and laptop management form the foundation for building further technical programming skills');
INSERT INTO COURSE
VALUES('CST8110','Introduction to Computer Programming','Introduction to algorithms and Object-Oriented software development. Use the Java programming language to develop programs which contain in');
INSERT INTO COURSE
VALUES('CST8215','Database','Students learn the fundamentals of Relational Databases design using Entity Relation diagrams, and use SQL to create, modify and query a dat...');
INSERT INTO COURSE
VALUES('CST8300','Achieving Success in Changing Environments','Rapid changes in technology have created personal and employment choices that challenge each of us to find our place as contributing citizen...');
INSERT INTO COURSE
VALUES('ENL1813','Communications I','Communication remains an essential skill sought by employers, regardless of discipline or field of study. Using a practical, vocation-orient... ');
INSERT INTO COURSE
VALUES('MAT8001','Technical Mathematics for Computer Science','The study of algebraic and transcendental functions is an essential prerequisite to Calculus. Students manipulate algebraic expressions, sol..');

INSERT INTO STUDENT
VALUES(9016001,'James','Gosling','gos123@livealgonquin.com','613-555-1212');
INSERT INTO STUDENT
VALUES(9016002,'Donald E.','Knuth','knu123@livealgonquin.com','613-555-1212');
INSERT INTO STUDENT
VALUES(9016003,'Robert C.','Martin','mar123@livealgonquin.com','613-555-1212');
INSERT INTO STUDENT
VALUES(9016004,'Edsger W.','Dijkstra','dij123@livealgonquin.com','613-555-1212');
INSERT INTO STUDENT
VALUES(9016005,'Alan','Turing','tur123@livealgonquin.com','613-555-1212');
INSERT INTO STUDENT
VALUES(9016006,'Claude','Shannon','sha123@livealgonquin.com','613-555-1212');
INSERT INTO STUDENT
VALUES(9016007,'Ken','Thompson','tho123@livealgonquin.com','613-555-1212');
INSERT INTO STUDENT
VALUES(9016008,'Dennis','Ritchie','rit123@livealgonquin.com','613-555-1212');
INSERT INTO STUDENT
VALUES(9016009,'Martin','Fowler','mar123@livealgonquin.com','613-555-1212');
