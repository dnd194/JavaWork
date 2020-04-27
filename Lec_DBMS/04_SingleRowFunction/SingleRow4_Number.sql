--숫자 관련 단일행 함수들

--ROUND()
SELECT 'ROUND' ,ROUND(12.34) "(12.34)",
			ROUND(12.567) "(12.567)",
			ROUND(12.536,2) "3째자리 반올림한다",
			ROUND(16.345,-1)  "소수점기준 첫번째 왼쪽자리 반올림"  --20
FROM dual;

--TRUNC()
SELECT
	'TRUNC',
	TRUNC(12.345) "(12.345)",         -- 소수점 자름 (디폴트)
	TRUNC(12.345, 2) "(12.345, 2)",   -- 소수점 3자리부터 자름
	TRUNC(12.345, -1) "(12.345, -1)"  -- 1의 자리부터 자름
FROM
	dual;

-- ROUND() TRUNC()  CEIL()  FLOOR()
SELECT
	'12.5'  "12.5",
	ROUND(12.5)	"ROUND",
	TRUNC(12.5) "TRUNC",
	CEIL(12.5) "CEIL",
	FLOOR(12.5) "FLOOR"
FROM
	dual;

SELECT
	'-12.5'  "-12.5",
	ROUND(-12.5)	"ROUND",
	TRUNC(-12.5) "TRUNC",
	CEIL(-12.5) "CEIL",
	FLOOR(-12.5) "FLOOR"
FROM
	dual;

-- 오라클은 % 연산자가 없다  대신에 MOD() 를 씀
SELECT 
MOD(12,10) "MOD(12,10)",
MOD(12.6,4.1) "MOD(12.6 , 4.1)"
FROM DUAL;

SELECT 
POWER(3,2) "POWER(3,2)",-- N1^N2 의 형태
POWER(10,-2) "POWER(10,-2) ", 
POWER(27,1/3) "POWER(27,-3)"   --   
FROM DUAL;



