package com.lec.beans;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

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

	// 새글 작성 <-- DTO

	public int insert(WriteDTO dto) throws SQLException {
		
		String menu_name = dto.getMenu_name();
		int menu_price= dto.getMenu_price();

		int cnt = this.insert( menu_name, menu_price);
		return cnt;
	}//end insert

	// 메서드 오버로딩
	public int insert(String menu_name, int menu_price) throws SQLException {

		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_INSERT_MENU);
			
			pstmt.setString(1, menu_name);
			pstmt.setInt(2, menu_price);

			cnt = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return cnt;
	}//end insert

	// ResultSet --> DTO 배열로 return
	public WriteDTO[] createArray(ResultSet rs) throws SQLException {
		WriteDTO[] arr = null;   //DTO 배열 초기화
		
		ArrayList<WriteDTO> list = new ArrayList<WriteDTO>();
		
			
		while(rs.next()){
				
				//rs의 값 받아오기
			int uid = rs.getInt("menu_uid");
			String menu_name = rs.getString("menu_name");
			
			int menu_price = rs.getInt("menu_price");
	
			WriteDTO dto = new WriteDTO(uid, menu_name ,menu_price);
			
			list.add(dto);
		}//end while
		int size = list.size();
		if(size == 0 ) return null;
		arr = new WriteDTO[size];
		list.toArray(arr);
		
		return arr;
	
	}// end createArray
	
	public WriteDTO [] select() throws SQLException{
		
		WriteDTO[] arr =null;
		try {
			pstmt = conn.prepareStatement(D.SQL_SELECT);
			rs= pstmt.executeQuery();
			arr = createArray(rs);
		}finally {
			close();
		}
	
		return arr;
	}//end select
	
	//특정 uid의 글 내용 읽기, 조회수 증가
	//viewCnt 도 1증가, 읽어와야한다.
	
	
	//특정 uid 글 삭제하기
	public int deleteByUid(int uid) throws SQLException{
		int cnt = 0;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt = pstmt.executeUpdate();
		}finally {
			close();
		}
		
		return cnt;
	}//end deleteByUid
	
}
