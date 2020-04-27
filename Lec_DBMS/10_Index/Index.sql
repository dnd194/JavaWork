
-- 인덱스 (Index)
-- 데이터(레코드)를 빠르게 접근하기 위해 <키, 주소> 쌍으로 구성된 데이터 구조

--인덱스가 없으면 테이블에서 특정값을 찾기 위해 모든 데이터를 다 뒤지는 TABLE SCAN 발생
--기본키를 위한 인덱스를 기본 인덱스,   
-- 일반적으론 테이블에 기본키가 있으면 기본키에 대한 기본 인덱스가 자동으로 생성된다.

-- 인덱스 종류
--  m-원 검색트리,  B-트리, B*-트리,  B+-트리 등이 있다.

-- 인덱스를 잘 사용하면 데이터베이스 성능이 좋아지게 할수도 있지만,
-- 잘못 설정하면 오히려 역효과가 날수도 있다.

-- 오라클
-- 기본적으로 INSERT 되는 순서대로 이입력됨.  정렬없이 저장됨.


--사원의 인덱스
SELECT empno, rowID FROM t_emp;  -- empno 는 primary key,  
			--rowid 도 rownum과 마찬가지로 오라클에서 제공해주는 객체임  insert 될때마다 자동으로 부여됨

SELECT empno , rowid FROM t_emp ORDER BY EMPNO DESC;
--empno를 내림차순했지만  rowid로 내림차순하고 있음을 볼 수 있다.

SELECT ename , rowid 
FROM t_emp;   -- rowid 순서대로 나옴

-- 인덱스 <key, rowid> 에 입력
-----------------------------------------------------------
-- (1) B-tree 인덱스
--	① UNIQUE INDEX                --중복되는 값이 없어야함 

--  ② Non Unique INDEX
--  ③ Function Based Index
--  ④ Descending Index
--  ⑤ 결합 인덱스 (Composite Index)

-----------------------------------------
-- UNIQUE INDEX
--   key 값이 중복되는 데이터가 없다는 뜻
--   이경우 인덱스 성능이 매우 좋아진다.
--   당장은 중복된 값이 안들어오지만, 향후에 중복될 값이 입력될 가능성이 있는 칼럼에는 
--   절.대.로 인덱스 생성하면 안됨!!!!!!!!

-- 인덱스 생성 구문
--   CREATE UNIQUE INDEX 인덱스명
--  ON 테이블이름(컬럼명1  ASC | DESC,  컬럼명2 ... )       -- 이친구 시험에 나옴

-- 연습
-- t_dept2 테이블의  dname 컬럼에 UNIQUE INDEX 생성
--  인덱스의 이름은 idx_dept2_dname 으로 생성

SELECT * FROM t_dept2;
CREATE UNIQUE INDEX idx_dept2_dname ON t_dept2(dname);


INSERT INTO t_dept2 values(9101, '임시매장', 1006, '부산지사');

INSERT INTO t_dept2 VALUES (9100, '임시매장', 1006, '서울지사');
-- unique constraint (SCOTT0316.SYS_C007030) violated¶




-- Non Unique INDEX
--  UNIQUE 인덱스가 성능은 좋으나 모든 컬럼에 다 만들수 있는 것은 아니다.
--  중복된 데이터가 들어가야 하는 경우는 Non Unique INDEX 사용

-- 인덱스 생성 구문
--   CREATE INDEX 인덱스명
--   ON 테이블이름(컬럼명1  ASC | DESC,  컬럼명2 ... )

-- 예제
-- t_professor 테이블의 position 칼럼에 Non unique 인덱스를 ''''내림차순'''' 생성

CREATE INDEX idx_prof_position 
ON t_professor(POSITION desc);    -- t_professor 테이블의 position 칼럼을 내림차순으로 하는 index 생성

--DBeaver에서 확인해보기
-------------------------------------------
/*
 * 인덱스는 어느 칼럼에 만들어야 하나? 
 * 답은 WHERE절에 오는 조건 칼럼이나 조인 조건 칼럼에 만들어 두어야 함
 * 가령 WHERE sal = 100  <-- sal 컬럼에 인덱스 만들어야 함.
 * sal 칼럼에 인덱스가 있다면 오라클은 sal 칼럼의 인덱스를 활용할수 있다.
 * 
 * 그런데!
 * sal 컬럼에 인덱스 생성하고 나서..
 * 정작 sql 문장에서는 WHERE sal + 100 = 200 조건으로 조회하면..
 * 인덱스는 활용 못함.
 * 이런 현상을 INDEX Suppressing Error 라고 함
 * 인덱스는 잘 만들어 놓고.. SQL 를 잘 못 작성하여 인덱스 사용 못하는 경우.
 * 
 * 명심!  :  인덱스를 사용하려 했다면, WHERE 조건절에 절대로 다른 형태로 가공해서는 안됨.
 * 
 * 그런데, 꼭 그렇게 사용해야 한다면?
 * WHERE sal + 100 = 200.. ??
 * 
 * 그러면 인덱스를 생성할때 저 형태로 , 즉 sal + 100 인덱스를 생성하면 됨.
 * 이를 '함수 기반 인덱스 ('f'unction 'b'ased 'i'ndex) == fbi' 라 함.
 * 
 */

CREATE INDEX idx_prof_pay_fbi ON t_professor(pay + 100)     --pay컬럼 + 100 에 대한 컬럼에 대해 인덱스가 만들어진다.. ==> 함수 기반 인덱스

-- 위와 같이 하면 오라클은 인덱스를 만들때 저 연산을 수행해서 인덱스 저장 가능.

-- 함수기반인덱스(FBI) 는 근본 해결책은 아니다.
-- 조건이 변경되면 다시 만들어야 하고..
-- FBI 는 기존 인덱스를 활용할수 없는 단점도 있다.  
--  ※ dbeaber 에서 생성 형태 확인해보자

--------------------------------------------
-- DESCENDING INDEX
--   인덱스들을 생성할때 내림차순 (큰 값이 먼저 오게) 인덱스 생성
--    큰값을 (큰값부터) 많이 조회하는 SQL에서 유리.
--    ex) 계좌조회.  최근날짜 (큰 날짜) 부터..
--    ex) 매출상위 매장순 ..  매출 큰 매장부터..

-- 예제
CREATE INDEX idx_prof_pay 
ON t_professor(pay DESC);


























