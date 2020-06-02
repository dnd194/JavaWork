
/* Drop Tables */

DROP TABLE e_user CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE e_user
(
	e_uid number NOT NULL,
	e_id varchar2(30) NOT NULL UNIQUE,
	e_pw varchar2(30) NOT NULL,
	e_email varchar2(100) NOT NULL UNIQUE,
	e_ehash varchar2(100) NOT NULL UNIQUE,
	e_echeck varchar2(1) NOT NULL,
	PRIMARY KEY (e_uid)
);


DROP sequence e_seq;
CREATE SEQUENCE e_seq;
SELECT * FROM e_user;

DELETE FROM E_USER WHERE E_UID = 1;

INSERT INTO e_user VALUES (e_seq.nextval, 'dnd194','aaaaaaaa','dnd194@naver.com','dnd194@naver.com','1');





