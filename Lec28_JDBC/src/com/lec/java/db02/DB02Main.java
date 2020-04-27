package com.lec.java.db02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DB02Main {

	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	// DB 사용자 계정 정보
	public static final String USER = "scott0316";
	public static final String PASSWD = "tiger0316";

	public static final String TBL_NAME = "test_member";
	public static final String COL_LABEL_NO = "mb_no";
	public static final String COL_LABEL_NAME = "mb_name";
	public static final String COL_LABEL_BIRTHDATE = "mb_birthdate";

	public static void main(String[] args) {
		System.out.println("DB 2 - Statement");
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 로딩 성공");
			
			conn = DriverManager.getConnection(URL,USER,PASSWD);
			System.out.println("connection 성공");
			
			stmt = conn.createStatement();
			System.out.println("statement 생성 성공");
			
			String sql  = "UPDATE "+TBL_NAME+" SET "+ COL_LABEL_NAME +" = '슈퍼맨', "
							+COL_LABEL_BIRTHDATE+ " = '1997-07-17' "+
							" WHERE "+COL_LABEL_NO + " = 200";
			
			System.out.println(sql);
			int cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "개 행 (row) update 성공");
			
			sql = "DELETE FROM "+ TBL_NAME+ " WHERE "+COL_LABEL_NAME + " = '태권부이'";
			System.out.println(sql);
			cnt = stmt.executeUpdate(sql);
			System.out.println(cnt + "개 행 (row) DELETE 성공");
			
			//JDBC DML 명령 실행 --> AUTO-COMMIT (default)
			sql = "SELECT * FROM "+TBL_NAME;
			System.out.println(sql);
			
			rs = stmt.executeQuery(sql);
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
		}finally {
				try {
					if(rs !=null)	rs.close();
					if(stmt != null) stmt.close();
					if(conn != null) conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
	} // end main()

} // end class DB02Main













