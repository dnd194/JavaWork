package com.lec.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import common.D;

public class FileDAO {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	public FileDAO() {
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

	public FileDTO[] createArray(ResultSet rs) throws SQLException{
		FileDTO[] arr =null;
		List<FileDTO> list =new ArrayList<FileDTO>();
		while(rs.next()) {
			int uid = rs.getInt("bf_uid");
			String source = rs.getString("bf_source");
			String file = rs.getString("bf_file");
			
			FileDTO dto = new FileDTO(uid, source, file);
			list.add(dto);
		}//end while
		
		arr = new FileDTO[list.size()];  //리스트의 사이즈만큼 생성
		list.toArray(arr);
		
		
		return arr;
		
	}//end createArray

	//특정 글(wr_uid) 의 첨부파일(들) select 
	public FileDTO[] selectFilesByWrUid(int wrUid) throws SQLException{
		
		FileDTO[] arr =null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT);
			pstmt.setInt(1, wrUid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
	}//end selectFilesByWrUid
	
	
	
	//특정 글(bf_uid) 의 첨부파일 하나를  select 
	public FileDTO[] selectByUid(int uid) throws SQLException{
		
		FileDTO[] arr =null;
		
		try {
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
	}//end selectByUid
	
	
}
