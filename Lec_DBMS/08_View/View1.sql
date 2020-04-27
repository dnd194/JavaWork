
CREATE VIEW v_prof
AS
SELECT profno, name, email, hpage FROM T_PROFESSOR ;

SELECT tname FROM tab;


SELECT * FROM v_prof;

------------------------------------------------
--view 생성시 별도의 컬럼이름을 지정해줄 수 있다.
CREATE OR replace VIEW v_prof (pfno, nm, em, hp)
AS
SELECT profno, name, email, hpage FROM T_PROFESSOR;



SELECT tname FROM tab;


CREATE OR REPLACE VIEW v_prof_dept (교수번호, 교수명, 소속학과명 )
AS 
SELECT p.PROFNO , p.NAME , d.DNAME FROM T_DEPARTMENT d, T_PROFESSOR p
WHERE d.DEPTNO = p.DEPTNO ;

SELECT * FROM v_prof_dept;

--#8103
SELECT d.DNAME 학과명,  s.max_height"최대키", s.max_weight "최대몸무게"
FROM  (SELECT DEPTNO1 , MAX(HEIGHT ) max_height, MAX(weight) max_weight 
FROM T_STUDENT GROUP BY DEPTNO1 ) s , T_DEPARTMENT d
WHERE s.deptno1 = d.DEPTNO ;

--#8104) 연습
--t_student, t_department 테이블  학과별로 가장 키가 큰 학생들의 이름과 키, 
--학과이름을 인라인뷰 를 사용하여 다음과 같이 출력하세요
SELECT d.dname "학과명", a.max_height "최대키", s.name "학생이름", s.height "키"
FROM 
	(SELECT deptno1, MAX(height) max_height FROM t_student GROUP BY deptno1) a, t_student s, t_department d
WHERE 
	s.deptno1 = a.deptno1 AND s.height = a.max_height
	AND s.deptno1 =  d.deptno
;


--#8105) 연습
--t_student 테이블 : 
--학생의 키가 동일 학년의 평균 키보다 큰 학생들의 학년과 이름과 키, 해당 학년의 평균키를 출력하되, 
--inline view 를 사용해서 아래와 같이 출력하세요. 단 학년 칼럼은 오름 차순으로 정렬.

SELECT s.grade "학년", s.name "이름", s.height "키", a.avg_height "평균키"
FROM
	(SELECT grade, avg(height) avg_height FROM t_student GROUP BY grade) a,
	t_student s
WHERE a.grade = s.grade AND s.HEIGHT > a.avg_height 
ORDER BY 1;





























