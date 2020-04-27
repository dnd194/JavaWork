package com.lec.java.db01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

/*
JDBC (Java DataBase Connectivity) 사용
 0. 라이브러리(jar) 추가:
  1) 이클립스 프로젝트 폴더에 libs 폴더를 생성
  2) C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6_g.jar
 파일을 libs 폴더로 복사
  3) 복사한 라이브러리를 빌드패스에 추가   
		BulidPath - Configure Build Path..
		Libraries 탭에서  [Add JARs..]   ->  위 libs 폴더의 ojdbc6_g.jar 파일 추가
		Order and Export 탭에서  우선순위 Up (권장)

 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
 2. JDBC 드라이버 클래스를 메모리에 로드
 3. DB와 connection(연결)을 맺음
 4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
 5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
 6. SQL 문장을 DB 서버로 전송
 7. 실행 결과 확인
*/

// er-diagram 만들기
// http://ermaster.sourceforge.net/update-site

public class DB01Main {

	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)

	// JDBC 드라이버 클래스 정보
	public static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; // 주소가 오류나면 classnotfound

	// DB 서버 접속 주소 (URL) 정보
	public static final String URL = "jdbc:oracle:thin:@localhost:1521:XE"; // 포트번호가 틀리면 NETWORK ADAPTER COULD NOT
																			// ESTABLISH 에러
																			// Oracle 서버가 가동되지 않아도 위와 같은 에러가 뜸
	// 접속사용자 계정 정보 scott0316/tiger0316
	public static final String USER = "scott0316"; // 아이디가 틀리면 oracle에서 error 를 날림 ORA-~~~~~ 이런식
	public static final String PASSWD = "tiger0316";

	public static void main(String[] args) {
		System.out.println("DB 1 : JDBC 프로그래밍");

		Connection conn = null; // java.sql.Connection 커넥션 변수 선언 / 커넥션은 자원이므로 finally로 닫아준다.
		Statement stmt = null; // java.sql.Statement 변수 선언
		ResultSet rs = null; // java.sql

		try {
//		2. JDBC 드라이버 클래스를 메모리에 로드
			Class.forName(DRIVER); // <-- 동적 클래스 로딩
			System.out.println("DRIVER CLASS 로딩 성공");

//			3. DB 와 connection(연결)을 맺음
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connect 연결");

//			4. Statement 인스턴스를 생성 (SQL을 사용하기 위한 인스턴스)
			stmt = conn.createStatement(); // connection 으로 create
			System.out.println("Statement 생성 성공");

//			5. SQL 문장 작성(SELECT, INSERT, UPDATE, DELETE)
			System.out.println();
			String sql_insert = "INSERT INTO test_member VALUES(100, '태권부이', sysdate)"; // sql 문법으로 작성을 해줘야함
			// 위에 명령어 틀리면 SQL SYNTAX 에러 발생

//			int no = 200;
//			String name = "펭수";
//			sql_insert = "INSERT INTO test_member VALUES(" + no + ",'"+name+"',sysdate)";

			System.out.println(sql_insert); // 테스트용
//			6. SQL 문장을 DB 서버로 전송
			int count = stmt.executeUpdate(sql_insert); // 'DML' 명령문은 ''''''''''''''EXECUTEUPDATE()'''''''''''''''''''
														// 명령문으로 실행
			System.out.println(count + "개 row(행)이 INSERT 됨"); // DML 의 수행 리턴 값은 정수 타입임

//			5. SQL 문장 작성(SELECT)
			String sql_select = "SELECT mb_no, mb_name, mb_birthdate FROM test_member";
			System.out.println(sql_select);

			rs = stmt.executeQuery(sql_select); // 'SELECT' 및 기타 쿼리의 경우 EXECUTE QUERY() 로 실행
												// RETURN 값은 ResultSet 객체
			// resultSet에 담겨져있는 결과 확인
//			7. 실행 결과 확인
			// 7 - 1 컬럼이름으로 받기
			System.out.println();
//			while (rs.next()) { // next() 레코드를 하나 추출하고 true return, 더이상 뽑아낼 것이 없으면 false return 토크나이저랑 비슷
//
//				String no = rs.getString("mb_no"); // getXXXX ==> 컬럼 이름 OR 별명 명시
//				String name = rs.getString("mb_name");
//				String birthdate = rs.getString("mb_birthdate");
//				String result = no + "\t | " + name + "\t | " + birthdate;
//				System.out.println(result);
//
//			} // end while

			// 7 - 2 컬럼 인덱스로 받기
			System.out.println();
//			while (rs.next()) { // next() 레코드를 하나 추출하고 true return, 더이상 뽑아낼 것이 없으면 false return 토크나이저랑 비슷
//
//				String no = rs.getString(1); // getXXXX ==> 컬럼 이름 OR 별명 명시
//				String name = rs.getString(2);
//				String birthdate = rs.getString(3);
//				String result = no + "\t | " + name + "\t | " + birthdate;
//				System.out.println(result);
//
//			} // end while

			// 7 - 3 null 처리하기
			//getXXX()로 가져온 데이터가 NULL 값이면 null을 리턴한다.
//			while (rs.next()) { // next() 레코드를 하나 추출하고 true return, 더이상 뽑아낼 것이 없으면 false return 토크나이저랑 비슷
//
//				String no = rs.getString("mb_no"); // getXXXX ==> 컬럼 이름 OR 별명 명시
//				if(no == null) no = "";
//				String name = rs.getString("mb_name");
//				// name 값은 null 값일 수 없다고 테이블에 명시해놨음
//				String birthdate = rs.getString("mb_birthdate");
//				if(birthdate == null) birthdate = "";
//				String result = no + "\t | " + name + "\t | " + birthdate;
//				System.out.println(result);
//
//			} // end while
			
			
			// 7 - 4 개별적인 type로 받기

			while (rs.next()) { // next() 레코드를 하나 추출하고 true return, 더이상 뽑아낼 것이 없으면 false return 토크나이저랑 비슷

				int no = rs.getInt("mb_no"); // getXXXX ==> 컬럼 이름 OR 별명 명시
				// 정수형으로 받을 때 mb_no 값이 null이면 0으로 리턴 =======> 이거는 처리할 수 가 없다.
				String name = rs.getString("mb_name");
				// name 값은 null 값일 수 없다고 테이블에 명시해놨음
				String birthdate = "";
				Date d= rs.getDate("mb_birthdate");  //  ==> 날짜만 가져옴              여기서 Date 객체는 java.sql 꺼로 해야함
				Time t = rs.getTime("mb_birthdate");  //  ==> 시간만 가져옴		   여기서 Time 객체는 마찬가지로 java.sql
				if(d != null) {
					birthdate = new SimpleDateFormat("yyyy년 MM월 dd일").format(d)+ " "
							+ new SimpleDateFormat("hh:mm:ss").format(t);
				}
				
				String result = no + "\t | " + name + "\t | " + birthdate;
				System.out.println(result);

			} // end while
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) { // 디비쪽 exception 중 최상위
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close(); // 닫을 때는 순서를 역순으로 닫아야함 --> 나중에 만들어진 인스턴스부터
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("프로그램 종료");
	} // end main()

} // end class DB01Main
