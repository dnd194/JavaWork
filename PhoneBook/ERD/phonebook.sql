
/* Drop Tables */

DROP TABLE phonebook CASCADE CONSTRAINTS;

/* Create Tables */

CREATE TABLE phonebook
(
	pb_uid number NOT NULL,
	pb_name varchar2(40) NOT NULL,
	pb_phonenum varchar2(40),
	pb_memo clob,
	pb_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (pb_uid)
);

--시퀀스 객체 생성
DROP SEQUENCE phonebook_seq;    --혹시모를 시퀀스 삭제
CREATE SEQUENCE phonebook_seq;

SELECT * FROM PHONEBOOK ORDER BY PB_UID DESC ;

-----           맛보기 함수
SELECT count(*) AS cnt FROM TEST_MEMBER ; --현재 테이블에 있는 모든 레코드의 개수를 보여줌  ----->>>> count()
SELECT max(mb_no) AS max FROM TEST_MEMBER ;    --max(컬럼name) 하면 그 컬럼의 최대값이 나옴   min --> 최소값  
SELECT min(mb_no) AS min FROM TEST_MEMBER ;   

SELECT COUNT(*) AS CNT FROM PHONEBOOK ;

