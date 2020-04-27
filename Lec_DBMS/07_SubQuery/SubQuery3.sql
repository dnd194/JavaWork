
-- 테이블 생성
CREATE TABLE test_emp_a (
	emp_id NUMBER,
	emp_name VARCHAR2(100)
);

CREATE TABLE test_emp_b (
	emp_id NUMBER,
	emp_name VARCHAR2(100)
);

DELETE FROM test_emp_a;
DELETE FROM test_emp_b;

INSERT INTO test_emp_a VALUES(101,'쌈빈');
INSERT INTO test_emp_b VALUES(201,'쌍빈');

SELECT * FROM test_emp_a;
SELECT * FROM TEST_EMP_B;

--동시에 여러개 테이블에 INSERT 하기
--다중 테이블 INSERT 구문에 '''SUB QUERY''' 가 필요하다
INSERT ALL INTO TEST_EMP_A VALUES (102,'RAO')
			INTO TEST_EMP_B VALUES (202, 'BBIN')
SELECT * FROM DUAL;

--SUBQUERY 로 INSERT 가능
INSERT INTO TEST_EMP_A (SELECT 400,'PEOPLE' FROM DUAL);   --SUBQUERY의 결과가 INSERT 됨
INSERT INTO TEST_EMP_B (SELECT 500,'PERSON' FROM DUAL);

-- 테이블 뻥튀기 (여러개???)

INSERT INTO TEST_EMP_A (SELECT * FROM TEST_EMP_A );   --테이블을 조회한 내용을 다시 테이블에 추가하기
SELECT * FROM TEST_EMP_A ;

INSERT INTO TEST_EMP_B (EMP_NAME) (SELECT emp_name FROM TEST_EMP_A );

SELECT * FROM TEST_EMP_B ;



















