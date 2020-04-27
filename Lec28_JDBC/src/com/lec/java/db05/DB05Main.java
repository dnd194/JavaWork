package com.lec.java.db05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.lec.java.db.Query;

/* 트랜잭션 (Transaction)
 * 	데이터베이스의 '작업'의 단위,  
 *  '하나의 트랜잭션'은  '일련의 쿼리연산(들)' 로 구성
 *  
 *  가령 : A계좌 → B계좌  로의 ''''''''송금'''''''' 이라는 ''''''''트랜잭션''''''''은 아래 쿼리연산(들)로 구성 된 경우
 *  	① A계좌에서 인출 쿼리실행
 *  	② B계좌로 입금 쿼리실행
 *  	두 쿼리 연산은 '모두 반영' 되든지  아니면 '전혀 반영되지 않아야 한다'
 * 
 * 	트랜잭션 중간에 실패하면 직전까지 성공한 쿼리 결과도 다시 원상 복귀 해야 한다 ( rollback 이라 한다)
 * 
 *  트랜잭션의 4 특징 (줄여서 ACID 라고 한다) 
 * 		1. 원자성 (Atomicity) : 트랜잭션 연산은 '모두 반영' 되든지 아니면 '전혀 반영되지 않든지' 해야 한다.
 *		2. 일관성 (Consistency) : 트랜잭션이 성공적으로 완료되면 언제나 일관성 있는 데이터베이스 상태로 변환되어야 한다
 * 		3. 독립성 (Isolation) : 한 트랜잭션이 완료되기 전까지 트랜잭션이 다루는 데이터를 다른 트랜잭션이 데이터를 접근하지 못하도록 해야 한다  
 * 		4. 영속성 (Durability) : 트랜잭션 완료후에 변경된 내용은 계속 영구적으로 보존되어야 한다.
 * 
 *  트랜잭션의 상태
 *  
 *          시작
 *           ↓
 *         (활동)
 *        ↙        ↘
 *  (부분완료)  → (실패)
 *     ↓          ↓
 *(완료:commit)  (철회:rollback)
 * 
 * 
 * 	기본적으로 JDBC 의 모든 쿼리실행은 auto commit 이다. 
 * 
 * 	JDBC 에서 트랜잭션 구현하기
 * 		1. Connection 의 auto commit 을 해제  setAutoCommit(false);
 * 		2. 쿼리연산(들) 수행
 * 		3. 정상적으로 완료되면 commit() 실행
 * 		4. 예외 발생등으로 실패 하면 rollback() 실행
 */
public class DB05Main implements Query {

	public static void main(String[] args) {
		System.out.println("DB 5 - Transaction");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			// Statement 작성
			stmt = conn.createStatement();
			
			// 1. Connection 의 auto commit 을 해제
			conn.setAutoCommit(false);
			
			// 2. 쿼리연산(들) 수행   
			stmt.executeUpdate("INSERT INTO test_member VALUES (test_member_seq.nextval, '1번 째', sysdate)");
			stmt.executeUpdate("INSERT INTO test_member VALUES (test_member_seq.nextval, '2번 째', sysdate)");
			stmt.executeUpdate("INSERT INTO test_member VALUES (test_member_seq.nextval, '', sysdate)");    //고의에러  not null 자리에 null을 주면 rollback 되는지 확인
			stmt.executeUpdate("INSERT INTO test_member VALUES (test_member_seq.nextval, '4번 째', sysdate)");
			
			
			// 3. 정상적으로 완료되면 commit() 실행
			System.out.println("commit 실행 하겠슴니당"); 
			conn.commit();
			
			// 결과는 직접 콘솔에서 확인해보자
						
			rs = stmt.executeQuery(SQL_SELECT_ALL+ " ORDER BY "+COL_LABEL_NO+ " DESC");
			
			while (rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				System.out.println(no + " | " + name + " | " + birthdate);
			} // end while
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("SQL 에러: " + e.getMessage());
			e.printStackTrace();
			
			// 4. 예외 발생등으로 실패 rollback() 실행
			if( conn != null) {
				try {
					System.out.println("rollback 합니다~~");
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // end try-catch

	} // end main()

} // end class






















