package com.lec.beans;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import common.D;

public class CategoryDAO {

	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	public CategoryDAO() {
		try {
			Class.forName(D.DRIVER);
			conn = DriverManager.getConnection(D.URL, D.USERID, D.USERPW);
			System.out.println("CategoryDAO생성, 데이터베이스 연결!!");
		} catch (Exception e) {
			e.printStackTrace();
		} // end try
		
	}
	
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
	
	// ResultSet --> DTO 배열로 return
		public CategoryDTO[] createArray(ResultSet rs) throws SQLException {
			CategoryDTO[] arr = null;   //DTO 배열 초기화
			ArrayList<CategoryDTO> list = new ArrayList<CategoryDTO>();
			while(rs.next()){
				int uid = rs.getInt("ca_uid");
				String name = rs.getString("ca_name");
				int depth = rs.getInt("ca_depth");
				int parent = rs.getInt("ca_parent");
				int order = rs.getInt("ca_order");
				
				CategoryDTO dto = new CategoryDTO(uid, name ,depth, parent, order);
				
				list.add(dto);
			}//end while
			int size = list.size();
			if(size == 0 ) return null;
			arr = new CategoryDTO[size];
			list.toArray(arr);
			return arr;
		}// end createArray
		
		public CategoryDTO [] select() throws SQLException{  //전체 글 목록
			CategoryDTO[] arr =null;
			try {
				pstmt = conn.prepareStatement(D.SQL_SELECT_ALL);
				
				rs= pstmt.executeQuery();
				arr = createArray(rs);
			}finally {
				close();
			}
			return arr;
		}//end select
		
		public CategoryDTO[] select2(int depth, int parent) throws SQLException{
			CategoryDTO[] arr =null;
			try {
				pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_N_PARENT2);
				pstmt.setInt(1, depth);
				pstmt.setInt(2, parent);
				rs= pstmt.executeQuery();
				arr = createArray(rs);
			}finally {
				close();
			}
			return arr;
		}
		public CategoryDTO[] select2(int depth) throws SQLException{
			CategoryDTO[] arr =null;
			try {
				pstmt = conn.prepareStatement(D.SQL_CATEGORY_BY_DEPTH_N_PARENT3);
				pstmt.setInt(1, depth);
				rs= pstmt.executeQuery();
				arr = createArray(rs);
			}finally {
				close();
			}
			return arr;
		}
}
