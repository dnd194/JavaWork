
--계층형 쿼리

SELECT * FROM T_DEPT2 ;     --서로의 계층관계에 주목 해야함

SELECT LPAD(dname, 10, '*') 부서명 FROM t_dept2;     -- 왼쪽부터 비어있는 공간은 *로 채워 넣음

--LEVEL 
SELECT dname, LEVEL 
FROM t_dept2                          -- level 은 connect by prior와 같이 ''세트''로 사용된다.
CONNECT BY PRIOR DCODE = PDEPT 
START WITH dcode = 0001;  -- 시작하는 점이 기준이 되는듯 함    0001 은 사장 level = 1  

/* 해설
 * LEVEL 은 오라클에서 계속 사용할 수 있는 것으로
 * 해당 데이터가 몇번째 단계 이냐를 의미하는 것.
 * 
 * CONNECT BY PRIOR  :  각 row 들이 어떻게 연결되어야 하는지 조건 지정
 * PRIOR를 어느쪽에 주느냐가 중요!
 */

SELECT dname, LEVEL 
FROM t_dept2                                    
CONNECT BY dcode = PRIOR PDEPT 
START WITH dcode = 0001;  --  사장실 위에는 없다 그래서 사장실만 나오고 끝이남 

SELECT dcode , dname, PDEPT ,LEVEL 
FROM t_dept2                                    
CONNECT BY dcode = PRIOR PDEPT 
--START WITH dcode = 1005;  --1005 는 sw 지원실 
START WITH dcode = 1011;


SELECT lpad(dname, LEVEL * 6, '*') FROM T_DEPT2 
CONNECT BY PRIOR dcode = pdept 
START WITH dcode = 0001;

------------------------------------------------------------
SELECT * FROM t_emp2;


SELECT lpad(e.NAME || ' '|| d.dname ||' '|| nvl(e.POST,'사원') , LEVEL * 22, '-')"이름과 직급"  --post는 null을 허용함 그래서 함수 적용 
FROM t_emp2 e, (SELECT dname, dcode, pdept FROM t_dept2) d
WHERE e.DEPTNO = d.dcode -- join 조건
CONNECT BY PRIOR e.EMPNO = e.PEMPNO 
START WITH e.EMPNO = 20000101     --20000101 이 사장임   
;


SELECT LEVEL - 1 hr
FROM dual
CONNECT BY LEVEL <= 24
;

SELECT LEVEL FROM dual CONNECT BY LEVEL < 5;





















