--산술 연산자

SELECT ENAME , sal , SAL *1.1    -- SAL * 1.1 하면 COLUMN이 추가된다.
FROM T_EMP ;

SELECT ENAME , sal , COMM --COMM은 NULL 을 허용하는 컬럼  
FROM T_EMP ;

SELECT ENAME, SAL, COMM , SAL + COMM --NULL 값과의 산술연산은 무 조 건 NULL
FROM T_EMP;

SELECT * FROM T_EMP WHERE JOB ='SALESMAN';  --직업이 SALESMAN 인 직원만 나옴   대소문자구분하니 조심할 것

SELECT ENAME , SAL ,DEPTNO 
FROM T_EMP 
WHERE DEPTNO =10;

SELECT ENAME ,SAL 
FROM T_EMP 
WHERE SAL > 2000;

SELECT ENAME , EMPNO , SAL 
FROM T_EMP 
WHERE ENAME ='SCOTT';

SELECT NAME ,GRADE 
FROM T_STUDENT 
WHERE GRADE BETWEEN 2 AND 3;

SELECT NAME ,GRADE 
FROM T_STUDENT 
WHERE GRADE IN (2,3);

SELECT NAME ,GRADE 
FROM T_STUDENT 
WHERE GRADE =2 OR GRADE =3;

SELECT NAME , PAY , "POSITION" 
FROM T_PROFESSOR 
WHERE "POSITION" ='정교수' AND PAY >300;

SELECT NAME ,"POSITION" 
FROM T_PROFESSOR 
WHERE BONUS IS NULL ;

SELECT NAME 
FROM T_PROFESSOR WHERE NAME LIKE '김%';

SELECT ENAME 
FROM T_EMP WHERE ENAME LIKE '%NE%';

SELECT ENAME 
FROM T_EMP WHERE ENAME LIKE '_A%';  -- 언더바 위치에 아무글자나 와도되고 뒤에는 아무거나 와도된다.


--오름차순 ASC , 내림차순 DESC   
SELECT ENAME 
FROM T_EMP WHERE ENAME LIKE '%L%'
ORDER BY ENAME DESC ;


--직책은 내림차순으로 급여는 오름차순으로  오름차순이 기본이라 안써줘도됨 그냥 SAL 이런식으로 
SELECT ENAME ,JOB ,SAL 
FROM T_EMP 
ORDER BY JOB DESC,SAL ;


SELECT NAME , GRADE , HEIGHT 
FROM T_STUDENT 
ORDER BY GRADE ASC , HEIGHT DESC ;



