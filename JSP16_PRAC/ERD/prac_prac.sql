
/* Drop Tables */

DROP TABLE prac_board CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE prac_board
(
	p_uid number NOT NULL,
	p_name varchar2(10) NOT NULL,
	p_age number NOT NULL,
	p_region varchar2(10) NOT NULL DEFAULT 0,
	p_foot number NOT NULL DEFAULT 0,
	p_intro varchar2(100) NOT NULL,
	PRIMARY KEY (p_uid)
);

CREATE SEQUENCE PRAC_SEQ;
SELECT * FROM PRAC_BOARD ;
INSERT INTO prac_board VALUES 
(PRAC_SEQ.nextval, '임상빈', 27, '서초', 255, '하위^^');

--INSERT INTO TEST_WRITE VALUES
--(TEST_WRITE_SEQ.nextval, '첫째글:하위^^', '안녕하세요', '김희철', 0, '2019-05-21');
