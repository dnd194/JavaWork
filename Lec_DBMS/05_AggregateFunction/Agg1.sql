
SELECT * 
FROM T_PROFESSOR ;

SELECT COUNT(*) , COUNT(HPAGE ) FROM T_PROFESSOR ;   -- 그룹함수는 null값을 계산할 때 배제함

SELECT count(bonus) , sum (bonus) FROM T_PROFESSOR ;
SELECT  max(HIREDATE )   FROM T_EMP ;


--null 허용 컬럼의 크룹함수 적용시
SELECT avg(BONUS ),avg(NVL(BONUS ,0) )
FROM  T_PROFESSOR ;

SELECT DEPTNO , avg(BONUS)     -- 셀렉트 절에는 그룹함수와 그룹함수가 아닌것은 함께 올 수 없다.  avg = 그룹함수    deptno 는  xxxxx
FROM T_PROFESSOR 

SELECT DEPTNO , round(avg(nvl(BONUS,0)),1) 보너스평균 
FROM T_PROFESSOR 
GROUP BY DEPTNO 

--#5101
SELECT DEPTNO , "POSITION" ,avg(pay)
FROM T_PROFESSOR 
GROUP BY DEPTNO , "POSITION" 
ORDER BY DEPTNO ASC ,"POSITION" ASC 

--부서별 평균급여
SELECT DEPTNO , round(avg(pay) , 1) "평균급여"
FROM T_PROFESSOR 
--그룹함수는 where 절에서 사용할 수 가 없다.
GROUP BY DEPTNO ;

SELECT DEPTNO , round(avg(pay) , 1)"평균급여"
FROM T_PROFESSOR 
GROUP BY DEPTNO 
HAVING avg(pay) > 300 
ORDER BY DEPTNO ASC ;


--<Select query 문 순서 
--1.select   2. from   3. where   4. group by   5.having    6.order by  이 순서대로 구성하면된다.     gruop 과 having set 메뉴  서로 같이 붙어있음

SELECT * FROM T_EMP;
--#5102    COUNT( MGR = EMPNO )  ,
SELECT MGR 매니저, ROUND( AVG(NVL(SAL ,0)),1) "급여평균" , COUNT(EMPNO ) "직원수" , AVG(NVL(COMM,0) )"교통비평균" ,SUM(SAL )"급여총액" 
FROM t_emp
--WHERE JOB ='MANAGER'
WHERE MGR IS NOT NULL
GROUP BY MGR ;


SELECT * 
FROM T_PROFESSOR ;
--#5103 
SELECT DEPTNO , COUNT(PROFNO ) "총인원", AVG(PAY )"급여평균", AVG(nvl(BONUS ,0))"보너스평균" , AVG(SYSDATE -HIREDATE) "근속일평균" 
FROM T_PROFESSOR 
WHERE "POSITION" ='정교수' OR "POSITION" ='조교수'
--WHERE POSITION LIKE '%교수'
GROUP BY DEPTNO;

--#5104
SELECT DEPTNO1 , MAX(WEIGHT ) - MIN(WEIGHT ) "최대최소몸무게차"
FROM T_STUDENT 
GROUP BY DEPTNO1 ;
--HAVING MAX(WEIGHT) - MIN(WEIGHT) >= 30;






















