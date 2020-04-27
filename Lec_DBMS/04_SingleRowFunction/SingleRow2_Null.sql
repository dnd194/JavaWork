SELECT * FROM T_PROFESSOR ;

SELECT name, pay, pay+BONUS 
FROM T_PROFESSOR ;


-- 그룹함수에서는 동작,     null은 그룹함수에서 제외되어 동작한다.  여기서는 null + x = null 이 아니다
SELECT sum(pay), sum(bonus) FROM T_PROFESSOR ;


SELECT name, pay, pay+BONUS 총지급액,pay+NVL(BONUS ,0) 총지급액 
FROM T_PROFESSOR ;

--#4201 + #4202
SELECT NAME ,PAY ,NVL(BONUS ,0) BONUS ,(PAY * 12 +NVL2(BONUS,BONUS ,0)) 연봉 
FROM T_PROFESSOR 
WHERE DEPTNO =101;