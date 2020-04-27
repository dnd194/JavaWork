-- dual 은 ROW 1개 짜리 dummy TABLE;
SELECT 'abcde' FROM dual;
SELECT 100 FROM dual;
SELECT '안녕하세여' FROM dual;
SELECT 100+10 FROM dual;

--
SELECT * FROM T_EMP ;
--원하는 컬럼만 조회
SELECT EMPNO ,ENAME
FROM T_EMP ;

--교수님
SELECT * FROM T_PROFESSOR ;
SELECT name FROM  T_PROFESSOR ; --하단에 초록색 새로고침쪽에 결과개수 나옴

SELECT bonus FROM  T_PROFESSOR ;

SELECT name , '겨수님 사랑해여' FROM  T_PROFESSOR ;

--별명 alias 
SELECT STUDNO 학번, NAME 이름 
FROM  T_STUDENT ;

SELECT STUDNO ,name AS 이름   --위에랑 똑같은 쿼리 문
FROM  T_STUDENT; 

SELECT STUDNO "학번", name AS 이름   --여러가지 방법이 있음
FROM T_STUDENT ;

SELECT STUDNO "학번이름", name AS 이름
FROM  T_STUDENT ;

SELECT EMPNO "사원번호", ENAME "사원명",JOB "직업"
FROM T_EMP ;

SELECT DEPTNO "부서#" , DNAME "부서명", LOC "위치"
FROM T_DEPT ;

--distinct 중복값을 제거하고 출력
SELECT *
FROM T_EMP ;

SELECT DISTINCT DEPTNO 
FROM T_EMP ;

SELECT DISTINCT DEPTNO1 
FROM T_STUDENT ;

SELECT  DISTINCT JOB 
FROM T_EMP ;

SELECT NAME || '-' ||"POSITION"  AS 직책
FROM T_PROFESSOR ;


SELECT NAME || '의 키는 '||HEIGHT ||'몸무게는 '||WEIGHT||'입니다'   "학생의 키와 몸무게"
FROM T_STUDENT ;
