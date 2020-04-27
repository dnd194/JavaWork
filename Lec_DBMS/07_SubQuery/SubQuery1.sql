
SELECT *FROM t_emp;


SELECT ename , SAL FROM t_emp WHERE sal > (SELECT sal FROM T_EMP WHERE ENAME = 'SCOTT');
--밑단 부터 한개 만들고 조건절에 넣어주는 형식으로하면 편해여
-- subquery는 반드시 괄호로 묶어야한다.



--#7102

SELECT MAX(height) FROM T_STUDENT ;  --조건 가장 큰 키 ==> subquery

SELECT NAME ,HEIGHT 
FROM T_STUDENT 
WHERE HEIGHT = (SELECT MAX(height) FROM T_STUDENT );

--subquery  단일행  =====>> 결과가 '''한개'''만 나옴 평상시 썻던 쿼리문이 subquery임

--#7103

SELECT DEPTNO1 
FROM T_STUDENT 
WHERE NAME = '이윤나';  -- subquery

SELECT s.NAME , d.DNAME 
FROM T_STUDENT s, T_DEPARTMENT d
WHERE s.DEPTNO1 = d.DEPTNO  
AND s.DEPTNO1 = (SELECT DEPTNO1 FROM T_STUDENT WHERE NAME = '이윤나');

--#7104
SELECT HIREDATE 
FROM T_PROFESSOR 
WHERE NAME ='송도권';

SELECT p.NAME , p.HIREDATE , d.DEPTNO 
FROM T_PROFESSOR p , T_DEPARTMENT d
WHERE p.DEPTNO =d.DEPTNO  AND 
p.HIREDATE > (SELECT HIREDATE 
FROM T_PROFESSOR 
WHERE NAME ='송도권');

--#7105
SELECT avg(WEIGHT) 
FROM T_STUDENT 
WHERE DEPTNO1 =101;

--SELECT * FROM T_STUDENT ;
SELECT NAME , WEIGHT  
FROM T_STUDENT 
WHERE  WEIGHT > (SELECT avg(WEIGHT) FROM T_STUDENT WHERE DEPTNO1 =101); 


--#7106
SELECT HIREDATE 
FROM T_PROFESSOR 
WHERE NAME = '심슨';

SELECT PAY 
FROM T_PROFESSOR 
WHERE NAME ='조인형';

SELECT name 이름, PAY 급여, TO_CHAR(HIREDATE, 'YY/MM/DD' )입사일 
FROM T_PROFESSOR 
WHERE HIREDATE = (SELECT HIREDATE FROM T_PROFESSOR WHERE NAME = '심슨')
AND pay < (SELECT PAY FROM T_PROFESSOR WHERE NAME ='조인형')  ;


-- IN 연산자 다음에 다중에 조건이 올수 있다.
-- EX )  80 IN (10,20,30,40,50)  FALSE return
--다중행 subquery 연산자
-- in, >any ,<any, <all , >all , exist  

--#7107
SELECT * FROM T_EMP2 ;
SELECT * FROM T_DEPT2 ;

SELECT DCODE FROM T_DEPT2 WHERE AREA ='서울지사';

--다중행 서브쿼리 사용  ''''in''''
SELECT EMPNO , NAME , DEPTNO 
FROM T_EMP2 
WHERE DEPTNO IN (SELECT DCODE FROM T_DEPT2 WHERE AREA ='서울지사');

--#7108
SELECT PAY 
FROM T_EMP2 
WHERE POST ='과장'  --subQ

SELECT NAME 이름, POST 직급, to_char(PAY,'999,999,999')||'원' 연봉 
FROM T_EMP2 
WHERE pay >any  (SELECT PAY FROM T_EMP2 WHERE POST ='과장');

--#7109
SELECT min(WEIGHT) 
FROM T_STUDENT 
WHERE GRADE = 4;  --- sq1 

SELECT WEIGHT 
FROM T_STUDENT 
WHERE GRADE =4 ;  --- sq2 



SELECT NAME 이름	, GRADE 학년, WEIGHT 몸무게 
FROM T_STUDENT 
WHERE WEIGHT < (SELECT min(WEIGHT) 
FROM T_STUDENT 
WHERE GRADE = 4);

























