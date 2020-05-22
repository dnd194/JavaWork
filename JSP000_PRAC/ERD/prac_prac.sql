
/* Drop Tables */

DROP TABLE prac_board CASCADE CONSTRAINTS;


/* Create Tables */

CREATE TABLE prac_board
(
	p_uid number NOT NULL,
	p_name varchar2(10) NOT NULL,
	p_age number NOT NULL,
	p_region varchar2(10) NOT NULL ,
	p_foot number NOT NULL ,
	p_intro varchar2(100) NOT NULL,
	PRIMARY KEY (p_uid)
);
DROP SEQUENCE PRAC_SEQ;
CREATE SEQUENCE PRAC_SEQ;
SELECT * FROM PRAC_BOARD ;
INSERT INTO prac_board VALUES 
(PRAC_SEQ.nextval, '임상빈', 27, '서초', 255, '하위^^');
INSERT INTO prac_board VALUES 
(PRAC_SEQ.nextval, '한수빈', 25, '화성', 235, '하위2^^');
INSERT INTO prac_board VALUES 
(PRAC_SEQ.nextval, '홍성룡', 28, '일산', 270, '하위3^^');
INSERT INTO prac_board VALUES 
(PRAC_SEQ.nextval, '이예지', 27, '신당', 235, '하위4^^');
INSERT INTO prac_board VALUES 
(PRAC_SEQ.nextval, '장윤성', 27, '용인', 280, '하위5^^');
INSERT INTO prac_board VALUES 
(PRAC_SEQ.nextval, '윤지우', 28, '평촌', 270, '하위6^^');

--INSERT INTO TEST_WRITE VALUES
--(TEST_WRITE_SEQ.nextval, '첫째글:하위^^', '안녕하세요', '김희철', 0, '2019-05-21');
