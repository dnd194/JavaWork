
SELECT * FROM  T_CUSTOMER ;
SELECT * FROM T_GIFT ;

--#6201
--oracle
SELECT c.C_NAME 고객명, c.C_POINT "포인트", g.G_NAME "상품명"
FROM T_CUSTOMER c, T_GIFT g
WHERE c.C_POINT BETWEEN g.G_START  AND g.G_END ;
--ansi

SELECT c.C_NAME 고객명, c.C_POINT "포인트", g.G_NAME "상품명"
FROM T_CUSTOMER c JOIN T_GIFT g
ON c.C_POINT BETWEEN g.G_START AND g.G_END ;

--#6202
SELECT  g.G_NAME "상품명", COUNT(g.G_NAME )"필요수량" 
FROM T_CUSTOMER c, T_GIFT g
WHERE c.C_POINT BETWEEN g.G_START  AND g.G_END 
GROUP BY g.G_NAME ;

SELECT  g.G_NAME "상품명", COUNT(g.G_NAME )"필요수량" 
FROM T_CUSTOMER c JOIN T_GIFT g
ON c.C_POINT BETWEEN g.G_START  AND g.G_END 
GROUP BY g.G_NAME ;

--#6203
SELECT * FROM t_student ;
SELECT * FROM T_EXAM01 ;
SELECT * FROM T_CREDIT ;

SELECT s.NAME "학생이름", e.TOTAL "점수", c.GRADE "학점"
FROM T_STUDENT s, T_EXAM01 e, T_CREDIT c
WHERE s.STUDNO = e.STUDNO AND  e.TOTAL BETWEEN c.MIN_POINT AND c.MAX_POINT 
ORDER BY e.TOTAL DESC ;

SELECT s.NAME "학생이름", e.TOTAL "점수", c.GRADE "학점"
FROM T_STUDENT s JOIN T_EXAM01 e ON s.STUDNO = e.STUDNO
					JOIN T_CREDIT c on e.TOTAL BETWEEN c.MIN_POINT AND c.MAX_POINT
				ORDER BY e.TOTAL DESC ;

--#6204
SELECT * FROM T_GIFT ;			
--oracle
SELECT c.C_NAME 고객명, c.C_POINT point, g.G_NAME 상품명 
FROM T_CUSTOMER c, T_GIFT g
WHERE c.C_POINT >= g.G_START  AND g.G_NAME ='산악용자전거';

--ansi
SELECT c.C_NAME 고객명, c.C_POINT point, g.G_NAME 상품명 
FROM T_CUSTOMER c JOIN T_GIFT g
ON c.C_POINT >= g.G_START  AND  g.G_NAME ='산악용자전거';

--#6205
SELECT * FROM t_emp2;
SELECT * FROM t_post;

SELECT e.NAME 이름, (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(e.BIRTHDAY,'YYYY'))+1 "현재나이" ,NVL( e.POST, ' ') 현재직급, p.POST 예상직급
FROM T_EMP2 e, T_POST p
WHERE  (TO_CHAR( SYSDATE,'YYYY') - TO_CHAR(e.BIRTHDAY,'YYYY'))+1 BETWEEN p.S_AGE AND p.E_AGE ;

--ansi
SELECT e.NAME 이름, (TO_CHAR(SYSDATE,'YYYY') - TO_CHAR(e.BIRTHDAY,'YYYY'))+1 "현재나이" ,NVL( e.POST, ' ') 현재직급, p.POST 예상직급
FROM T_EMP2 e JOIN T_POST p
ON (TO_CHAR( SYSDATE,'YYYY') - TO_CHAR(e.BIRTHDAY,'YYYY'))+1 BETWEEN p.S_AGE AND p.E_AGE ;


--outer join
--#6206 left
--#6207 right
--#6208 full outer                  left , right , full --> ansi 구문 밖에 안됨
SELECT s.name "학생이름", p.name"교슈이름"
FROM T_STUDENT s
full OUTER JOIN T_PROFESSOR p   
ON s.PROFNO  = p.PROFNO ;

--self join
SELECT d1.DNAME 부서명, d2.DNAME 상위부서명
FROM t_dept2 d1 , T_DEPT2 d2
WHERE d1.PDEPT = d2.DCODE ;

SELECT d1.DNAME 부서명, d2.DNAME 상위부서명
FROM t_dept2 d1 JOIN T_DEPT2  d2
ON d1.PDEPT  = d2.DCODE ;

SELECT * FROM T_PROFESSOR ;
--#6210

SELECT  p1.PROFNO 교수번호, p1.NAME 교수명, p1.HIREDATE 입사일 , count(p2.HIREDATE )"빠른사람"  -- 그룹함수가 아닌 친구들은 그룹by에 죄다 박아야함
FROM T_PROFESSOR p1 
LEFT OUTER JOIN  T_PROFESSOR p2
on p2.HIREDATE < p1.HIREDATE 
GROUP BY p1.PROFNO , p1.NAME , p1.HIREDATE 
ORDER BY 4;

CREATE TABLE menu_tb
(
	menu_uid number NOT NULL,
	menu_name varchar2(50) NOT NULL,
	menu_price number NOT NULL,
	store_uid number NOT NULL,
	PRIMARY KEY (menu_uid)
);
DROP TABLE menu_tb CASCADE CONSTRAINTS;
DROP TABLE menu_detail CASCADE CONSTRAINTS;
CREATE SEQUENCE menu_uid_seq;
CREATE SEQUENCE order_uid_seq;
CREATE SEQUENCE store_uid_seq;
CREATE SEQUENCE menu_uid2_seq;
CREATE TABLE menu_detail
(
	menu_uid2 number NOT NULL,
	menu_name varchar2(50) NOT NULL,
	order_uid NUMBER NOT NULL,
	menu_quantity NUMBER NOT null
);

INSERT INTO menu_tb VALUES (menu_uid_seq.nextval, '아아연',3000,store_uid_seq.nextval);
INSERT INTO menu_tb VALUES (menu_uid_seq.nextval, '라뗴연',3000,store_uid_seq.nextval);
INSERT INTO menu_tb VALUES (menu_uid_seq.nextval, '코코아연',3000,store_uid_seq.nextval);
INSERT INTO menu_tb VALUES (menu_uid_seq.nextval, '기모찌',3000,store_uid_seq.nextval);

INSERT INTO menu_detail VALUES (menu_uid2_seq.nextval, '아아연',order_uid_seq.nextval, 2);
INSERT INTO menu_detail VALUES (menu_uid2_seq.nextval, '라뗴연',order_uid_seq.nextval, 2);
INSERT INTO menu_detail VALUES (menu_uid2_seq.nextval, '코코아연',order_uid_seq.nextval, 1);
INSERT INTO menu_detail VALUES (menu_uid2_seq.nextval, '기모찌',order_uid_seq.nextval, 4);
INSERT INTO menu_detail VALUES (menu_uid2_seq.nextval, '제발요',6, 4);
INSERT INTO menu_detail VALUES (menu_uid2_seq.nextval, '오마에와',6, 4);

SELECT * FROM MENU_TB ;
SELECT * FROM menu_detail;
CREATE TABLE sbbb as
SELECT a.menu_price , a.menu_name, b.menu_quantity
FROM MENU_TB a , menu_detail b
WHERE a.menu_uid = b.menu_uid2;

SELECT * FROM sbbb;


