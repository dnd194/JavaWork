package com.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.beans.WriteDTO;

import common.D;

public class WriteDAO {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public WriteDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("WriteDAO생성, 데이터베이스 연결!!");
		} catch (Exception e) {
			e.printStackTrace();
		} // end try
	}// 생성자

	public void close() throws SQLException {
		if (rs != null)
			rs.close();
		if (stmt != null)
			stmt.close();
		if (pstmt != null)
			pstmt.close();
		if (conn != null)
			conn.close();
	}// end close()
	
//	public String userID;
//	public String userPassword;
//	public String userEmail;
//	public String userEmailHash;
	public int insert(WriteDTO dto) throws SQLException {
//		String subject = dto.getSubject();
//		String content = dto.getContent();
//		String name = dto.getName();
		
		String userID = dto.getUserID();
		String userPassword = dto.getUserPassword();
		String userEmail = dto.getUserEmail();
		String userEmailHash = dto.getUserEmailHash();
		

		int cnt = this.insert(userID, userPassword, userEmail, userEmailHash);
		return cnt;
	}//end insert

	// 메서드 오버로딩
	public int insert(String userID, String userPassword, String userEmail, String userEmailHash) throws SQLException {

		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_INSERT);
			pstmt.setString(1, userID);
			pstmt.setString(2, userPassword);
			pstmt.setString(3, userEmail);
			pstmt.setString(4, userEmailHash);

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}//end insert
	public String getUserEmail(String userID) {
		try {
			pstmt = conn.prepareStatement(D.SQL_GET_EMAIL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getString(1); // 이메일 주소 반환
			}

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return null; // 데이터베이스 오류
	}
	
	public String getUserEmailChecked(String userID) {

		try {
			pstmt = conn.prepareStatement(D.SQL_EMAIL_CHECK);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				return rs.getString("e_echeck"); // 이메일 등록 여부 반환
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "0"; // 데이터베이스 오류

	}
	
	public String setUserEmailChecked(String userID) {

		try {

			pstmt = conn.prepareStatement(D.SQL_SET_EMAIL_CHECK);

			pstmt.setString(1, userID);

			pstmt.executeUpdate();

			return "1"; // 이메일 등록 설정 성공

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return "0"; // 이메일 등록 설정 실패

	}

}






	

