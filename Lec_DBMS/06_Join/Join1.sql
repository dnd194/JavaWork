--JOIN


--FROM 절에 테이블에도 별명을 줄 수 있다. 대신에       '''(별명 . 칼럼이름)''' 이렇게 사용해야한다.
SELECT s.STUDNO , s.NAME , s.DEPTNO1 
FROM T_STUDENT s;       --20 record

SELECT d.DEPTNO , d.DNAME 
FROM T_DEPARTMENT d;    --12 record

SELECT * 
FROM T_STUDENT s, T_DEPARTMENT d;    --240record    



-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면 
-- 모든 카티션곱이 출력된다. 

SELECT s.STUDNO , s.NAME , s.DEPTNO1 , d.DEPTNO ,d.DNAME 
FROM T_STUDENT s, T_DEPARTMENT d;  --오라클 방식

SELECT s.STUDNO , s.NAME , s.DEPTNO1 , d.DEPTNO ,d.DNAME 
FROM T_STUDENT s
CROSS JOIN T_DEPARTMENT d;       --ANSI (안시) 방식        위에랑 결과 똑같음

--#6101
SELECT s.NAME "학생이름", s.DEPTNO1 "1전공", d.DNAME "학과 이름"
FROM T_STUDENT s, T_DEPARTMENT d
WHERE s.DEPTNO1 = d.DEPTNO ;   --equi join 방식       	         -- Oracle 방식으로 할시 from 과 where 이 세트 


----------------------------------------- A			N			S			I
SELECT s.NAME "학생이름", s.DEPTNO1 "1전공", d.DNAME "학과 이름"
FROM T_STUDENT s JOIN T_DEPARTMENT d
ON s.DEPTNO1 = d.DEPTNO  ;									-- join 과 on 는 서로 세트


SELECT s.NAME "학생이름", s.DEPTNO2 "제2 학과" , d.DNAME "제 2학과이름"
FROM T_STUDENT s, T_DEPARTMENT d
WHERE s.DEPTNO2 = d.DEPTNO ;    --null 값은 조건에서 빠져버림    조건에서 맞는것들만 나오는 거임


--#6102
SELECT * FROM T_STUDENT ;
SELECT * FROM T_PROFESSOR ;
------ oracle
SELECT s.NAME "학생이름", s.PROFNO "지도교수코드",p.NAME "지도교수이름"
FROM T_STUDENT s, T_PROFESSOR p
WHERE s.PROFNO = p.PROFNO ;

-------ansi
SELECT s.NAME "학생이름", s.PROFNO "지도교수코드",p.NAME "지도교수이름"
FROM T_STUDENT s JOIN T_PROFESSOR p
ON s.PROFNO = p.PROFNO ;

--#6103   --oracle
SELECT s.NAME , d.DNAME  , p.NAME 
FROM T_STUDENT s, T_DEPARTMENT d, T_PROFESSOR p
WHERE s.DEPTNO1 = d.DEPTNO AND s.PROFNO = p.PROFNO ;

--#6103    --ansi
SELECT s.NAME , d.DNAME  , p.NAME 
FROM T_STUDENT s JOIN T_DEPARTMENT d ON s.DEPTNO1 =d.DEPTNO 
				JOIN T_PROFESSOR  p ON  s.PROFNO  = p.PROFNO ;
			
--#6104

SELECT * FROM T_EMP2;
SELECT * FROM T_POST ;
--oracle
SELECT e.NAME 사원이름 , e.POST 현재, e.PAY 현재연봉, p.E_PAY 상한금액, p.S_PAY 하한금액 
FROM T_EMP2 e, T_POST p 
WHERE e.POST = p.POST ;

--ansi
SELECT e.NAME 사원이름 , e.POST 현재, e.PAY 현재연봉, p.E_PAY 상한금액, p.S_PAY 하한금액 
FROM T_EMP2 e JOIN T_POST p
ON e.POST = p.POST ;

--#6105
SELECT s.NAME 학생이름, p.NAME 교수이름
FROM T_STUDENT s, T_PROFESSOR p
WHERE s.PROFNO = p.PROFNO AND  s.DEPTNO1 = 101;   

--ansi
SELECT s.NAME 학생이름, p.NAME 교수이름
FROM T_STUDENT s JOIN T_PROFESSOR p ON s.PROFNO = p.PROFNO 
WHERE s.DEPTNO1 =101;   --일반조건은 where 로 해도 되고 ON 쪽에다가 붙여도됨


















