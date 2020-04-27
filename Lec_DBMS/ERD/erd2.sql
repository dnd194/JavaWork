
/* Drop Tables */

DROP TABLE sugang CASCADE CONSTRAINTS;
DROP TABLE course CASCADE CONSTRAINTS;
DROP TABLE professor CASCADE CONSTRAINTS;
DROP TABLE student CASCADE CONSTRAINTS;
DROP TABLE department CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE course
(
	lecnum number NOT NULL,
	lecname varchar2(10) NOT NULL,
	isu number NOT NULL,
	lecyear number,
	lecmax number,
	lecloc number UNIQUE,
	profno number NOT NULL,
	PRIMARY KEY (lecnum)
);


CREATE TABLE department
(
	deptno number NOT NULL,
	depttel number,
	office number NOT NULL UNIQUE,
	deptname varchar2(10) NOT NULL UNIQUE,
	PRIMARY KEY (deptno)
);


CREATE TABLE professor
(
	profno number NOT NULL,
	addr varchar2(20),
	jumin number UNIQUE,
	name varchar2(10) NOT NULL,
	post varchar2(10),
	hiredate number UNIQUE,
	phonenum number,
	deptno number NOT NULL,
	PRIMARY KEY (profno)
);


CREATE TABLE student
(
	studno number NOT NULL,
	jumin number NOT NULL UNIQUE,
	name varchar2(10) NOT NULL,
	grade number,
	addr varchar2(20),
	phonenum number,
	deptno number NOT NULL,
	PRIMARY KEY (studno)
);


CREATE TABLE sugang
(
	studno number NOT NULL,
	lecnum number NOT NULL
);



/* Create Foreign Keys */

ALTER TABLE sugang
	ADD FOREIGN KEY (lecnum)
	REFERENCES course (lecnum)
;


ALTER TABLE professor
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE student
	ADD FOREIGN KEY (deptno)
	REFERENCES department (deptno)
;


ALTER TABLE course
	ADD FOREIGN KEY (profno)
	REFERENCES professor (profno)
;


ALTER TABLE sugang
	ADD FOREIGN KEY (studno)
	REFERENCES student (studno)
;



