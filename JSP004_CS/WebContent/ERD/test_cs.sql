
/* Drop Tables */

DROP TABLE cs_board CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE cs_board
(
	cs_uid number NOT NULL,
	cs_name number NOT NULL,
	cs_subject varchar2(20) NOT NULL,
	cs_content clob NOT NULL,
	cs_regdate date DEFAULT sysdate,
	PRIMARY KEY (cs_uid)
);
CREATE sequence cs_seq;
DROP SEQUENCE cs_seq;
SELECT * FROM CS_BOARD;

CREATE SEQUENCE cs_name_seq;
INSERT INTO CS_BOARD values(cs_seq.nextval,cs_name_seq.nextval,'월요일...','제발요', '2019-05-21');

