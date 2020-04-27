-- SELECT 결과물중 맨 위의 5개만 출력해보고 싶으면 어케 해야 하나?
--   ex) 게시판.. 페이징

-- DBMS 마다 구현 방법 다름
--	MYSQL : LIMIT
-- 	MS SQL server : TOP
-- 	ORACLE : ROWNUM 

SELECT empno, ename, sal 
FROM t_emp;


SELECT rownum, empno, ename, sal   --  rownum은 오라클의 내부 객체
FROM t_emp;


SELECT rownum, empno, ename, sal   --  rownum은 내림차순으로 해도 여전히 1부터 붙여진다.
FROM t_emp
ORDER BY EMPNO desc;


--   상위 5개만            
SELECT rownum, empno, ename, sal   --  rownum은 내림차순으로 해도 여전히 1부터 붙여진다.
FROM t_emp	
WHERE rownum <= 5				-- 그래서 rownum을 조건절로 이용하여 데이터를 뽑아낼 수 있다.
ORDER BY EMPNO desc;

SELECT  empno, ename, sal    
--  rownum은 오라클의 내부 객체                굳이 select 로 뽑아내지 않아도 눈에 보이지는 않지만 존재함
FROM t_emp	
WHERE rownum <= 5				
ORDER BY EMPNO desc;

--  rownum은 오라클의 내부 객체

SELECT rownum, empno, ename, sal   
FROM t_emp	
--WHERE rownum > 5	
-- 이 경우는 안됌  동작이 되지 않음  rownum 범위가 1을 포함하지 않으면 동작을 하지 않음	
ORDER BY EMPNO desc;


-- 상위 5개 출력
-- row 1 ~ row 5 까지 출력  (1page)

SELECT rownum, empno, ename, sal   
FROM t_emp	
WHERE ROWNUM >=1 AND ROWNUM < 1+5
ORDER BY EMPNO DESC;

--다음페이지
SELECT rownum, empno, ename, sal   
FROM t_emp	
WHERE ROWNUM >=6 AND ROWNUM < 6+5    --이런 개념으로 가주는 것  
ORDER BY EMPNO DESC;					--문제는 rownum이 1을 포함하지않음 그래서 범위를 고쳐잡아야함

--------------------------------------------------------------------------------
INSERT INTO PHONEBOOK (SELECT * FROM PHONEBOOK ); -- error 프라이머리 키 제한 조건이 걸려있기 때문

INSERT INTO PHONEBOOK     --데이터를 임의적으로 늘려줌  (많은 데이터가 필요해서)
		(SELECT phonebook_seq.nextval,PB_NAME , PB_PHONENUM , PB_MEMO , SYSDATE FROM PHONEBOOK );
	
SELECT * FROM PHONEBOOK ;

SELECT PB_UID "uid", pb_name name  , PB_PHONENUM phonenum FROM PHONEBOOK 
ORDER BY pb_uid DESC ;


--inline view
SELECT T.* from(SELECT PB_UID "uid", pb_name name  , PB_PHONENUM phonenum FROM PHONEBOOK 
ORDER BY pb_uid DESC ) T ;   --inline view 


SELECT ROWNUM AS RNUM , T.* from(SELECT PB_UID "uid", pb_name "name" , PB_PHONENUM phonenum FROM PHONEBOOK 
ORDER BY pb_uid DESC ) T ;  

SELECT * FROM (
	SELECT ROWNUM AS RNUM , T.* from(SELECT PB_UID "uid", pb_name "name" , PB_PHONENUM phonenum FROM PHONEBOOK 
	ORDER BY pb_uid DESC ) T
)
WHERE Rnum >=11 AND rnum < 11 +10 ;

SELECT * FROM (
	SELECT ROWNUM AS RNUM , T.* from(SELECT PB_UID "uid", pb_name "name" , PB_PHONENUM phonenum FROM PHONEBOOK 
	ORDER BY pb_uid DESC ) T
)
WHERE Rnum >=21 AND rnum < 21 +10 ;




















