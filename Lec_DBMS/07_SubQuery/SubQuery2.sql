

------- 서브 쿼리의 칼럼이 다중일 때    ~~~~~~~~~~~~~~~~~~~~

--#7201

SELECT GRADE , MAX(HEIGHT ) 
FROM T_STUDENT 
GROUP BY GRADE ;  -- 서브 쿼리가 칼럼이 2개 임 -- 다중서브쿼리

-- 칼럼을 2개를 받아야함 그래서 인자를 2개 만들어줌 where (1 , 2)
SELECT grade 학년, NAME 이름,HEIGHT 키
FROM T_STUDENT 
WHERE (  grade  ,  HEIGHT  ) 
IN (SELECT GRADE , MAX(HEIGHT ) FROM T_STUDENT GROUP BY GRADE )
ORDER BY GRADE ASc ;       

-- order 는 순차적으로 맨마지막 부분이라서 '별명'의 정보를 알고 있어서 별명을 유일하게 사용할 수 있음

--#7202
SELECT DEPTNO , to_char (MIN(HIREDATE ),'YYYY-MM-DD') 
FROM T_PROFESSOR 
GROUP BY DEPTNO ;   --다중 서브 쿼리

SELECT p.PROFNO 교수번호, p.NAME 교수명 , to_char (p.HIREDATE,'YYYY-MM-DD')입사일, d.DNAME 학과명
FROM T_PROFESSOR p, T_DEPARTMENT d
WHERE (d.DEPTNO , p.HIREDATE ) IN (SELECT DEPTNO , to_char (MIN(HIREDATE ),'YYYY-MM-DD') 
FROM T_PROFESSOR 
GROUP BY DEPTNO);

--#7203
SELECT POST ,max(PAY )
FROM t_emp2
GROUP BY POST ;   -- 다중 쿼리뭉

SELECT name 이름, POST 직급,PAY 연봉 
FROM T_EMP2 
WHERE (POST , PAY ) IN (SELECT POST ,max(PAY )
FROM t_emp2
GROUP BY POST);

--#7204
--SELECT * FROM T_DEPT2 ;
--SELECT  * FROM t_emp2;
SELECT avg(PAY) 
FROM t_emp2
GROUP BY DEPTNO ;

SELECT d.DNAME , e.NAME , e.PAY 
FROM t_emp2 e, t_dept2 d
WHERE e.DEPTNO = d.DCODE AND e.pay <ALL (SELECT avg(PAY) 
FROM t_emp2
GROUP BY DEPTNO );
 
-- 상호 연관  sub query      
-- main query 값을 sub query에 주고 subquery 를 수행한 후 그 결과를 다시 main으로 반환
SELECT a.name "사원이름", NVL(a.post, ' ') "직급", a.pay "급여"
FROM t_emp2 a
-- WHERE a.pay >= (  a.post 직급의 평균연봉 )
WHERE a.pay >= (SELECT avg(b.pay) FROM t_emp2 b WHERE NVL(a.post, ' ') = NVL(b.post, ' '))     
;

SELECT avg(b.pay) FROM t_emp2 b WHERE '과장' = b.post;


--#7206
-- 스칼라 서브 쿼리     (join 과 동작방식은 똑같음  그냥 안해도될듯)
SELECT 
name "사원이름", 
(SELECT d.dname FROM t_dept2 d
	WHERE e.deptno = d.dcode ) "부서이름"
FROM t_emp2 e;














