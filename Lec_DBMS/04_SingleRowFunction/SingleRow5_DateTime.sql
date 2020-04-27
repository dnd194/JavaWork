--날짜함수
SELECT sysdate FROM dual;  --현재 날짜

--기본적인 날짜 연산
SELECT 
	SYSDATE "오늘", 
	SYSDATE+1 "내일(24시간후)",          -- 1 은 하루
	SYSDATE-2 "그저께(48시간전)", 
	SYSDATE+ 1/24 "한시간 뒤"
FROM dual;

--일자 차이 계산
SELECT 
	SYSDATE "오늘",
	SYSDATE - TO_DATE('2020-03-16') 
	--SYSDATE - (TO_DATE('2020-03-16 09:00:00','YYYY-MM-DD hh:mi:ss')) "경과"
	
FROM dual;

--두 날짜 계산시에 큰 날짜를 먼저 써야 양수로 나옴
SELECT 
	-- 규칙1: 두 날짜중 큰 날짜를 먼저 써야  양수로 나옴
	MONTHS_BETWEEN('2020-03-01', '2012-01-01') "양수값", 
	
	-- 규칙2: 두 날짜가 같은 달에 속해 있으면 특정 규칙으로 계산된 값
	MONTHS_BETWEEN('2012-02-29', '2012-02-01') "2/29-2/01", 
	MONTHS_BETWEEN('2012-04-30', '2012-04-01') "4/30-4/01",
	MONTHS_BETWEEN('2012-01-31', '2012-01-01') "1/31-1/01"
FROM dual;

SELECT TO_CHAR( sysdate, 'YYYY-MM-DD') "오늘 ", 
		TO_CHAR(HIREDATE, 'YYYY-MM-DD')"입사일",
		TO_CHAR(SYSDATE, 'YYYY') - TO_CHAR(HIREDATE, 'YYYY')"근속연수"
FROM T_PROFESSOR ;

--ADD_MONTH 함수 - 달을 추가.
SELECT SYSDATE, ADD_MONTHS(SYSDATE, 3)
FROM dual;

SELECT
	SYSDATE "오늘",
	LAST_DAY(SYSDATE) "이번달 마지막날",
	NEXT_DAY(SYSDATE, '월') "다음 월요일"   -- 현재 언어 세팅에 따라.
FROM 
	dual

-- 날짜의 ROUND() 함수  ,  하루의 반은 정오 12:00:00 이다. 이를 넘어서면 다음 날짜
-- 날짜의 TRUNC() 함수,  무조건 당일 출력.
-- 원서 접수나 상품 주문 등에서 오전까지 접수된 건은 당일 접수 처리. 오후접수는 익일 처리 등에서 사용.
SELECT
	SYSDATE "오늘",
	ROUND(SYSDATE),
	TRUNC(SYSDATE)
FROM
	dual;




