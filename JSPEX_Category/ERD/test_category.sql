
/* Drop Tables */

DROP TABLE test_category CASCADE CONSTRAINTS;




/* Create Tables */

CREATE TABLE test_category
(
	ca_uid number NOT NULL,
	ca_name varchar2(30) NOT NULL,
	ca_depth number default 1,
	ca_parent number,
	ca_order number DEFAULT 1,
	PRIMARY KEY (ca_uid)
);

DROP SEQUENCE test_category_seq;
CREATE SEQUENCE test_category_seq;

-- 샘플 데이터                                                                                     name, depth, parent, order
INSERT INTO test_category VALUES(test_category_seq.nextval, '의류', 1, null, 1);
INSERT INTO test_category VALUES(test_category_seq.nextval, '식품', 1, null, 3);
INSERT INTO test_category VALUES(test_category_seq.nextval, '스포츠', 1, null, 2);

-- [1.의류][xxx]
INSERT INTO test_category VALUES(test_category_seq.nextval, '남성복', 2, 1, 3);
INSERT INTO test_category VALUES(test_category_seq.nextval, '여성복', 2, 1, 1);
INSERT INTO test_category VALUES(test_category_seq.nextval, '아동복', 2, 1, 2);

-- [1.의류][4.남성복][xxx]
INSERT INTO test_category VALUES(test_category_seq.nextval, '양복', 3, 4, 3);
INSERT INTO test_category VALUES(test_category_seq.nextval, '조끼', 3, 4, 1);
INSERT INTO test_category VALUES(test_category_seq.nextval, '점퍼', 3, 4, 2);

-- [1.의류][5.여성복][xxx]
INSERT INTO test_category VALUES(test_category_seq.nextval, '가디건', 3, 5, 3);
INSERT INTO test_category VALUES(test_category_seq.nextval, '블라우스', 3, 5, 2);
INSERT INTO test_category VALUES(test_category_seq.nextval, '원피스', 3, 5, 1);

-- [1.의류][6. 아동복][xxx]
INSERT INTO test_category VALUES(test_category_seq.nextval, '운동복', 3, 6, 3);
INSERT INTO test_category VALUES(test_category_seq.nextval, '교복', 3, 6, 2);
INSERT INTO test_category VALUES(test_category_seq.nextval, '저고리', 3, 6, 1);

-- [2.식품][xxx]
INSERT INTO test_category VALUES(test_category_seq.nextval, '반찬', 2, 2, 3);
INSERT INTO test_category VALUES(test_category_seq.nextval, '인스턴트', 2, 2, 1);

-- [2.식품][16.반찬][xxx]
INSERT INTO test_category VALUES(test_category_seq.nextval, '김치', 3, 16, 1);
INSERT INTO test_category VALUES(test_category_seq.nextval, '명란젓', 3, 16, 2);

-- [2.식품][17.인스턴트][xxx]
INSERT INTO test_category VALUES(test_category_seq.nextval, '라면', 3, 17, 1);
INSERT INTO test_category VALUES(test_category_seq.nextval, '과자', 3, 17, 4);
INSERT INTO test_category VALUES(test_category_seq.nextval, '빵', 3, 17, 3);
INSERT INTO test_category VALUES(test_category_seq.nextval, '피자', 3, 17, 2);


-- [3.스포츠][xxx]
INSERT INTO test_category VALUES(test_category_seq.nextval, '야구', 2, 3, 1);

-- [3.스포츠][24. 야구]
INSERT INTO test_category VALUES(test_category_seq.nextval, '야구배트', 3, 24, 1);
INSERT INTO test_category VALUES(test_category_seq.nextval, '글러브', 3, 24, 2);

SELECT * FROM TEST_CATEGORY ;

SELECT ca_uid "uid", ca_name name, ca_depth DEPTH, ca_parent parent, ca_order "order"
FROM TEST_CATEGORY 
WHERE CA_DEPTH = 2 AND CA_PARENT = 1
ORDER BY CA_ORDER ASC;






