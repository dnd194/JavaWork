package com.lec.java.db03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lec.java.db.Query;

// 공통적으로 사용하는 상수들 인터페이스에 담아서 처리.
public class DB03Main implements Query{

	public static void main(String[] args) {
		System.out.println("DB 3 - PreparedStatement");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			// OracleDriver 클래스를 메모리에 로딩
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
			
			pstmt = conn.prepareStatement(SQL_INSERT);               //SQL_INSERT에 커서올리면 물음표의 개수를 알 수 있음
			// "INSERT INTO test_member VALUES(?, ?, ?)"						//타입에 맞게 꽂아 넣는게 중요함
			pstmt.setInt(1, 10);   // 첫번째 ? 는  1부터 시작!
			pstmt.setString(2, "rion");
			pstmt.setString(3, "2000-10-10");
			int cnt = pstmt.executeUpdate();  // DML 은 정수형 반환
			System.out.println(cnt + "개 행(row) INSERT 성공");
			
			System.out.println();
			System.out.println("UPDATE문");
			pstmt.close();        //애는 닫고 다시 새로 만들어줘야한다.   그렇게 바람직한 방법은 아니지만 ~~~~~
			pstmt = conn.prepareStatement(SQL_UPDATE_BIRTHDATE);
			//"UPDATE test_member SET mb_birthdate = ? WHERE mb_no = ?"
			pstmt.setString(1, "2020-01-01");
			pstmt.setInt(2, 10);
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) UPDATE 성공");
			
			System.out.println();
			System.out.println("SELECT");
			pstmt.close();   
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String no = rs.getString(COL_LABEL_NO);
				String name = rs.getString(COL_LABEL_NAME);
				String birthdate = rs.getString(COL_LABEL_BIRTHDATE);
				System.out.println(no+ " | "+name+ " | " + birthdate);
			}
			
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		

	} // end main()

} // end class DB03Main






