
/* Drop Tables */

DROP TABLE test_write CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_write
(
	wr_uid number NOT NULL,
	wr_subject varchar2(200) NOT NULL,
	wr_content clob,
	wr_name varchar2(40) NOT NULL,
	wr_viewcnt number DEFAULT 0,
	wr_regdate date DEFAULT SYSDATE,
	PRIMARY KEY (wr_uid)
);

--시퀀스
CREATE SEQUENCE TEST_WRITE_SEQ; 


SELECT * FROM TEST_WRITE ;

-- 기본데이터 작성
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '첫째글:하위^^', '안녕하세요', '김희철', 0, '2019-05-21');
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '둘째글:헤헤헤','1111', '김수길', 0, '2017-03-02');
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '세째글:힘내세요', '7394', '최진덕' , 0, '2017-08-12');
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '네째글: ... ', '9090', '이혜원', 0, '2018-02-09');
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '다섯째글: 게시판', '7531', '박수찬', 0, sysdate);
INSERT INTO TEST_WRITE VALUES
(TEST_WRITE_SEQ.nextval, '여섯째글: 게시판', 'HAWI', 'Kevlin', 0, sysdate);

-- 다량의 데이터 필요
SELECT * FROM test_write ORDER BY wr_uid DESC;
INSERT INTO test_write(wr_uid, wr_subject, wr_content, wr_name)
	SELECT test_write_seq.nextval, wr_subject, wr_content, wr_name FROM test_write;

DELETE FROM test_write WHERE wr_uid > 20;

