

--제약 조건
--테이블 생성시 동시에 설정하기

--t_dept2.dcode   참조 예정
SELECT * FROM T_DEPT2 ;    --decode  : 0001, 1000, 1001 ............ 1011

--#9001  제약조건에 이름을 부여하지 않았을 떄
DROP TABLE t_emp3 CASCADE CONSTRAINT;
CREATE TABLE t_emp3 (
	no NUMBER(4) PRIMARY key,
	name varchar2(10) NOT null,
	jumin varchar2(13) NOT NULL unique,
	area NUMBER(1) CHECK(area<5) ,--  이게 조건문 check
	deptno varchar2(6) REFERENCES t_dept2(dcode)
);


DROP TABLE t_emp4 CASCADE CONSTRAINT;

CREATE TABLE t_emp4 (
	no NUMBER(4) ,
	name varchar2(10) NOT null,
	jumin varchar2(13) NOT NULL ,
	area NUMBER(1)  ,
	deptno varchar2(6) ,
	PRIMARY key(no),
	unique(jumin),
	check(area<5),
	foreign KEY(deptno) REFERENCES t_dept2(dcode)
);

--#9002 '''''''''''제약조건명을 명시''''''''''''''하여 정의

DROP TABLE t_emp3 CASCADE CONSTRAINT;

CREATE TABLE t_emp3 (
	no NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY key,
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin varchar2(13) CONSTRAINT emp3_jumin_nn NOT NULL 
						CONSTRAINT emp3_jumin_uk unique,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK(area<5) ,--  이게 조건문 check
	deptno varchar2(6) CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
);



DROP TABLE t_emp3 CASCADE CONSTRAINT;

CREATE TABLE t_emp3 (
	no NUMBER(4) ,
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin varchar2(13) CONSTRAINT emp3_jumin_nn NOT NULL ,
	area NUMBER(1) ,
	deptno varchar2(6) ,
	CONSTRAINT emp3_no_pk PRIMARY KEY(no),
	CONSTRAINT emp3_jumin_uk unique(jumin),
	CONSTRAINT emp3_area_ck CHECK(area <5 ),
	CONSTRAINT emp3_deptno_fk FOREIGN KEY (deptno) REFERENCES t_dept2(dcode)
);

-- 제약조건을 조회하기 
SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'T_EMP4';

SELECT OWNER , CONSTRAINT_NAME, CONSTRAINT_TYPE, STATUS
FROM USER_CONSTRAINTS
WHERE TABLE_NAME = 'T_EMP3';     --테이블이름은대문자로 써줄것 

--#9005 제약조건에 맞는 OR 위배되는 DML시도해보기

INSERT INTO T_EMP3 VALUES(1,'파이썬','1234561234567',4 , 1000);
--두번 실행하면 unique constraint    (PRIMRAY ERROR  , violate) 

INSERT INTO T_EMP3 VALUES(2,'파이썬','1234561234567',4 , 1000);
--실행하면 unique constraint    (unique ERROR  , violate) 

INSERT INTO T_EMP3 VALUES(2,'파이썬','22222222222222222222',4 , 1000);
-- 실행하면 value too large 에러 뜸  주민자리에는 13자리까지 올 수 있는데 16자리가 오고있기때문

INSERT INTO T_EMP3 VALUES(2,'파이썬','1111111111111',10 , 1000);
-- area 자리 오류   area는 5보다 작아야하기때문

INSERT INTO T_EMP3 VALUES(2,'파이썬','1111111111111',4 , 2000);
--integrity constraint (SCOTT0316.EMP3_DEPTNO_FK) violated - parent key not found
-- 참조하고자 하는 값이 없음

INSERT INTO t_emp3 (NO, jumin, area, deptno )VALUES (2,'2222222222222',4,1001);
-- name 자리가 비어있어서 null이 들어감 ----> name 자리에는 not null 로 설정해놨기때문에 에러가 남
-- cannot insert NULL into

--insert 뿐만 아니라 update / delete 에서도 오류발생가능

UPDATE t_emp3 SET area = 10 WHERE NO=1;
--ORA-01438: value larger than specified precision allowed for this column 
--area 자리는 5미만의 값만 가능하기 때문

--#9005   테이블 생성 후에 ALTER 명령 사용하여 제약조건 추가 가능
--t_emp4 의 name 컬럼 unique 제약조건 추가
--ALTER ~ ANDD
--ALTER ~ MODIFY
--ALTER ~ DROP

ALTER TABLE t_emp4 ADD CONSTRAINT emp4_nm_uk UNIQUE(name);

--#9006
ALTER TABLE T_EMP4 ADD CONSTRAINT EMP4_AREA_NN NOT NULL;
-- 컬럼의 기본값은 널을 허용  그래서 ADD가 아닌 MODIFY 로 해야한다.

ALTER TABLE T_EMP4 MODIFY area CONSTRAINT emp4_area_nn  NOT NULL;
--modify 로 바꾼 후의 모습

--#9007
--t_emp4 가 t_emp2(name)를 참조하도록

ALTER TABLE T_EMP4 ADD CONSTRAINT emp4_name_fk FOREIGN KEY(name) REFERENCES t_emp2(name);
--									제약조건 이름       제약조건     (참조할 컬럼)
--참조되는 부모테이블의 칼럼은 primary key 이거나 unique 해야한다.

--일단 부모테이블의 name 을 unique 로 바꾼 뒤 위의 쿼리를 다시 실행해보세여
SELECT * FROM t_emp2;

ALTER TABLE t_emp2 ADD CONSTRAINT emp2_name_uk UNIQUE(name);


DROP TABLE t_emp3 CASCADE CONSTRAINT;

CREATE TABLE t_emp3 (
	no NUMBER(4) CONSTRAINT emp3_no_pk PRIMARY key,
	name varchar2(10) CONSTRAINT emp3_name_nn NOT null,
	jumin varchar2(13) CONSTRAINT emp3_jumin_nn NOT NULL 
						CONSTRAINT emp3_jumin_uk unique,
	area NUMBER(1) CONSTRAINT emp3_area_ck CHECK(area<5) ,--  이게 조건문 check
	deptno varchar2(6) CONSTRAINT emp3_deptno_fk REFERENCES t_dept2(dcode)
				ON DELETE CASCADE -- 부모삭제시 같이 자식도 삭제됨
				-- on delete set null 부모삭제시 null 값으로
				
				--oracle 은 on update 지원하지 않는다.
);

--#9009 
--t_emp4 테이블의 name 필드의 제약조건에
--부모테이블이 삭제되면 NULL이 되도록 설정하기 (alter 사용)
ALTER TABLE t_emp4 DROP CONSTRAINT emp4_name_fk;  --일단 기존 제약 조건 삭제 

ALTER TABLE t_emp4
ADD CONSTRAINT emp4_name_fk FOREIGN key(name)
		REFERENCES t_emp2(name)
			ON DELETE SET NULL;  --부모가 삭제되면 자식은 null로 변환

---------------------------------------------------------------------
--disable novalidate  
--#9010
SELECT * FROM t_NOVALIDATE ;
SELECT * FROM T_VALIDATE ;

SELECT owner , CONSTRAINT_name, CONSTRAINT_type, status 
FROM user_constraints
WHERE table_name = 'T_VALIDATE';


INSERT INTO T_VALIDATE VALUES (1,'ddd');  --처음에는 error pk 라서


SELECT owner , CONSTRAINT_name, CONSTRAINT_type, status 
FROM user_constraints
WHERE table_name = 'T_NOVALIDATE';

INSERT INTO T_NOVALIDATE VALUES (1,'ddd'); 

ALTER TABLE T_NOVALIDATE DISABLE NOVALIDATE CONSTRAINT SYS_C007033; 
--DISABLE 로 바꾸고 데이터를 삽입하면 다시 ENABLE로 수정할 수 없다. --> 데이터를 지우면 가능


ALTER TABLE T_NOVALIDATE ENABLE NOVALIDATE CONSTRAINT SYS_C007033;

DELETE FROM T_NOVALIDATE  WHERE NAME='ddd';

























































































