-- SQL 에서 문자 와 숫자간에 산술연산에서는 문자가 number타입으로 자동형변환된다.

SELECT 
SYSDATE,TO_CHAR(SYSDATE,'YYYY'), TO_CHAR(SYSDATE,'RRRR') 연도4자리
FROM dual;

SELECT 
	TO_CHAR(SYSDATE, 'MON') 월3자리,  -- 7월
	TO_CHAR(SYSDATE, 'MONTH')  월전체,  -- 7월
	TO_CHAR(SYSDATE, 'MON', 'NLS_DATE_LANGUAGE=ENGLISH') 월영문3자리,  -- JUL
	TO_CHAR(SYSDATE, 'MONTH', 'NLS_DATE_LANGUAGE=FRENCH')  "월영문전체(대)", -- JULY
	TO_CHAR(SYSDATE, 'month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(소)",  -- july
	TO_CHAR(SYSDATE, 'Month', 'NLS_DATE_LANGUAGE=ENGLISH')  "월영문전체(첫글자대)" -- July
FROM DUAL ;

SELECT 
TO_CHAR(SYSDATE,'DD' ) "일 숫자 두자리" ,
TO_CHAR(SYSDATE,'DDTH' ) "몇번째날" ,
TO_CHAR(SYSDATE,'DAY' ) "요일" ,
TO_CHAR(SYSDATE,'Dy' ) "요일 앞자리" 
FROM DUAL ;

SELECT 
	TO_CHAR(SYSDATE, 'HH24') 시24hr,
	TO_CHAR(SYSDATE, 'HH')  시12hr,
	TO_CHAR(SYSDATE, 'MI') 분,
	TO_CHAR(SYSDATE, 'SS') 초
FROM dual;

SELECT 
TO_CHAR(SYSDATE, 'YY/MM/DD'), TO_CHAR(SYSDATE, 'YY-MM-DD HH:mm:ss' ) 날짜
FROM DUAL ;

--2017년 10월 25일 23시 25분 46초
SELECT 
TO_CHAR(sysdate,'YYYY"년"MM"월"DD"일"') 날짜  --쌍따옴표로 년 , 월 , 일 표시
FROM dual;
--#4392
SELECT 
NAME, TO_CHAR(BIRTHDAY ,'YYYY-MM-DD') 생일
FROM T_STUDENT 
WHERE TO_CHAR(BIRTHDAY ,'MM')=03 ;

-- TO_CHAR : 대소문자 지정예
SELECT
SYSDATE,
TO_CHAR(SYSDATE, 'Dy Month DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A1,
TO_CHAR(SYSDATE, 'dy month dd, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A2,
TO_CHAR(SYSDATE, 'DY MONTH DD, YYYY', 'NLS_DATE_LANGUAGE=ENGLISH') AS A3
FROM DUAL

--TO_CHAR : 숫자를 문자로
SELECT
	1234, TO_CHAR(1234,'99999') "변환" , -- 9 하나당 한자리 총 5자리를 의미
	TO_CHAR(1234,'099999') "빈자리는 0으로",
	TO_CHAR(1234,'$9999') "빈자리는 $",
	TO_CHAR(1234.1234,'9999.99')"소수점 이하 2자리",
	TO_CHAR(1234,'99,999')"숫자 5자리 천단위 구분"
FROM DUAL;

SELECT 
NAME, TO_CHAR(( PAY * 12 +NVL(BONUS ,0)),'99,999' )"연봉"
FROM T_PROFESSOR
WHERE DEPTNO = 101;

--TO_NUMBER()함수
SELECT TO_NUMBER('123.44')"TO_NUMBER" FROM dual;

--TO_DATE() 함수
SELECT TO_DATE('2012-01-01', 'YYYY-MM-DD') TO_DATE
FROM dual;


--#4303
SELECT NAME , TO_CHAR( HIREDATE,'RRRR-MM-DD') "입사일",
to_char((pay*12),'99,999') "연봉",
to_char(((pay*12)*(110/100)) ,'99,999')"인상후"
FROM T_PROFESSOR 
WHERE TO_CHAR (HIREDATE ,'RRRR')<'2000' ;








