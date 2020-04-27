--INITCAP() 함수
--#4101 첫 문자 ''''''''대문자'''''''''로 바꾸어 출력

SELECT INITCAP('great') FROM dual;

SELECT ID , INITCAP(ID) 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

SELECT NAME "이름" , ID , LOWER(ID ) "소문자", UPPER(ID ) "대문자" 
FROM T_STUDENT 
WHERE DEPTNO1 = 201;

SELECT NAME "이름", ID , LENGTH (ID ) "글자수"
FROM  T_STUDENT 
--WHERE LENGTH(id)=10 OR  LENGTH (ID )=9;
WHERE LENGTH(id)>=9;

SELECT NAME 이름, LENGTH (NAME ) 길이, LENGTHB(NAME ) 바이트
FROM T_STUDENT ;

--concat  
--SELECT CONCAT(name,"POSITION" ) "교수님명단"
SELECT name || "POSITION"  "교수님명단"
FROM T_PROFESSOR 
WHERE DEPTNO = 101;


--SUBSTR
SELECT SUBSTR('abcde',1,3) --디비쪽에서 인덱스는 1부터 시작
FROM dual;

--#4107
SELECT NAME , SUBSTR(JUMIN ,1,6) "생년월일"
FROM  T_STUDENT 
WHERE DEPTNO1 =101;

--#4108
SELECT NAME , SUBSTR(JUMIN ,1,6) "생년원일" 
FROM T_STUDENT 
WHERE SUBSTR(JUMIN ,3,2)='08';  -- 가급적 문자열로 표현해주세여
--where jumin like '__08%';  --앞에 두문자 무조건 와야하고 아무거나

--#4109
SELECT NAME , JUMIN 
FROM T_STUDENT 
WHERE GRADE =4 AND SUBSTR(JUMIN ,7,1)='2' ;


SELECT INSTR('a*b*c*','*',1,1) FROM dual;-- 매개변수 4개
SELECT INSTR('a*b*c*','*',3,2) FROM dual;--해당문자열안에서 찾을 문자를 정하고 몇번째 인덱스부터 시작하고 몇번째의 단어를 뽑는지
SELECT INSTR('a*b*c*','*',-4,1) FROM dual;--인덱스를 오른쪽으로 주면 검색도 오른쪽부터함
SELECT INSTR('a*b*c*','*',-4,2) FROM dual;--찾고자하는게 없으면 0을 리턴
SELECT INSTR('a*b*c*','*',-2,2) FROM dual;

--#4110
--SELECT NAME ,TEL ,INSTR(TEL ,')',1,1) AS 위치
SELECT NAME ,TEL ,INSTR(TEL ,')') AS 위치  --1은 default 값이라 생략해도 위와 같은 결과가 나옴
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--#4111
SELECT NAME, TEL  , SUBSTR(tel,1,INSTR(TEL ,')')-1 ) "지역번호" --함수 안에 매개변수로 함수가 들어가도됨
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--LTRIM , RTRIM    ppt 33page
SELECT LTRIM('슈퍼슈퍼슈가맨', '슈퍼') LTRIM FROM DUAL; --해당하는 문자가 있으면 지움 '슈' 까지
--좌우 공백 모두 제거는 trim 

SELECT DNAME , RTRIM(DNAME ,'부') "RTRIM 예제" 
FROM T_DEPT2 ;
--REPLACE( 대상 문자열 , 바꾸고싶은 문자, 바꿀문자)

--#4118
SELECT REPLACE (NAME,(SUBSTR(NAME ,1,1)), '#') 학생
FROM T_STUDENT 
WHERE DEPTNO1 =102;

--#4119
SELECT REPLACE (NAME, (SUBSTR(NAME ,2,1)), '#' ) 학생
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--#4120
SELECT NAME , REPLACE (JUMIN ,SUBSTR(JUMIN ,7,7) ,'*******') 주민번호
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

--#4121 
SELECT NAME,TEL, REPLACE (TEL , SUBSTR(TEL, INSTR(TEL,')')+1,3 ),'###') 전화번호 
FROM T_STUDENT 
WHERE DEPTNO1 =102;



