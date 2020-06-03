
/* Drop Tables */

DROP TABLE test_file CASCADE CONSTRAINTS;
DROP TABLE test_write CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_file
(
	bf_uid number NOT NULL,
	bf_source varchar2(200) NOT NULL,
	bf_file varchar2(200) NOT NULL,
	wr_uid number NOT NULL,
	PRIMARY KEY (bf_uid)
);


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


/* Create Foreign Keys */

ALTER TABLE test_file
	ADD FOREIGN KEY (wr_uid)
	REFERENCES test_write (wr_uid)
;

--시쿼스 작성
CREATE SEQUENCE test_file_seq;
SELECT * FROM test_file ORDER BY bf_uid DESC ;
SELECT * FROM test_write ORDER BY wr_uid DESC;






