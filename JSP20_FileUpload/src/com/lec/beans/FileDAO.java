package com.lec.beans;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

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

	public FileDTO[] createArray(ResultSet rs) throws SQLException {
		FileDTO[] arr = null;
		List<FileDTO> list = new ArrayList<FileDTO>();
		while (rs.next()) {
			int uid = rs.getInt("bf_uid");
			String source = rs.getString("bf_source");
			String file = rs.getString("bf_file");

			FileDTO dto = new FileDTO(uid, source, file);
			list.add(dto);
		} // end while

		arr = new FileDTO[list.size()]; // 리스트의 사이즈만큼 생성
		list.toArray(arr);

		return arr;

	}// end createArray

	// 특정 글(wr_uid) 의 첨부파일(들) select
	public FileDTO[] selectFilesByWrUid(int wrUid) throws SQLException {

		FileDTO[] arr = null;

		try {
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT);
			pstmt.setInt(1, wrUid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
	}// end selectFilesByWrUid

	// 특정 글(bf_uid) 의 첨부파일 하나를 select
	public FileDTO[] selectByUid(int uid) throws SQLException {

		FileDTO[] arr = null;

		try {
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		} finally {
			close();
		}
		return arr;
	}// end selectByUid

	// 특정 글 ( wr_uid )의 첨부파일 (들) 삭제
	// '''db삭제'''도 해야하고, ''''파일 삭제도'''' 해야함
	public int deleteByWrUid(int wrUid, HttpServletRequest request) throws SQLException {
		int cnt = 0;
		FileDTO[] arr = null;
		try {
			// 1. 물리적인 파일 삭제 (경로 필요)
			pstmt = conn.prepareStatement(D.SQL_FILE_SELECT);
			pstmt.setInt(1, wrUid);
			rs = pstmt.executeQuery();

			arr = createArray(rs);
			// 물리적인 경로 획득해야함 그래서 servletContext 가 필요함
			ServletContext context = request.getServletContext();
			String saveDirectory = context.getRealPath("upload");

			for (FileDTO dto : arr) {
				File f = new File(saveDirectory, dto.getFile());
				System.out.println("삭제 시도 ==>> " + f.getAbsolutePath());

				// 파일이 존재하면 지워야하기 때문에 검증이 필요
				if (f.exists()) {
					if (f.delete()) {
						// 위에 조건이 true 이면 delete를 써서 삭제 그리고 삭제가 성공하면 다음과같은 console을 띄움
						System.out.println("삭제성공");
					} else {
						System.out.println("삭제 실패");
					}
				} else {
					System.out.println("파일이 없어연");
				} // end if
			} // end for

			// 2. test_file 테이블 내용 삭제
			pstmt.close();
			rs.close();

			pstmt = conn.prepareStatement(D.SQL_FILE_DELETE_BY_WRUID);
			pstmt.setInt(1, wrUid);
			cnt = pstmt.executeUpdate();
			System.out.println("첨부파일 " + cnt + "개 삭제");

		} finally {
			close();
		}

		return cnt;
	}// end deleteByWrUid()

	// 여러개의 bf_uid 의 파일(들)을 제거
	// 매개변수로 배열을 받음
	public int deleteByUid(int[] uids, HttpServletRequest request) throws SQLException {
		int cnt = 0;
		if (uids == null || uids.length == 0)
			return 0;
		// ex 101,204,319 번파일을 지우려면??
		// 조건으로 where bf_uid in (101,204,319) 이런식으로 가능

		try {
			// 물리적인 파일 삭제
			StringBuffer sql = new StringBuffer("select bf_file from test_file where bf_uid in (");
			for (int uid : uids) {
				sql.append(uid + ",");
			}
			sql.deleteCharAt(sql.lastIndexOf(",")); // sql의 마지막 문자 , 를 삭제
			sql.append(")"); // 마지막에 괄호 닫아줘야함

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql.toString());

			// 물리적인 경로 획득
			ServletContext context = request.getServletContext();
			String saveDirectory = context.getRealPath("upload");

			while (rs.next()) {
				String fileName = rs.getString("bf_file"); // 삭제할 파일명
				File f = new File(saveDirectory, fileName);

				System.out.println("삭제 시도 ==>> " + f.getAbsolutePath());

				// 파일이 존재하면 지워야하기 때문에 검증이 필요
				if (f.exists()) {
					if (f.delete()) {
						// 위에 조건이 true 이면 delete를 써서 삭제 그리고 삭제가 성공하면 다음과같은 console을 띄움
						System.out.println("삭제성공");
					} else {
						System.out.println("삭제 실패");
					}
				} else {
					System.out.println("파일이 없어연");
				} // end if

			}

			sql = new StringBuffer("delete from test_file where bf_uid in(");
			for (int uid : uids) {
				sql.append(uid + ",");
			}
			sql.deleteCharAt(sql.lastIndexOf(",")); // sql의 마지막 문자 , 를 삭제
			sql.append(")"); // 마지막에 괄호 닫아줘야함

			System.out.println("파일 삭제 : " + sql);// sql 문 확인용

			cnt = stmt.executeUpdate(sql.toString());

		} finally {
			close();
		}

		return cnt;
	}//end deleteByUid
	
	//특정 글(wr_uid)에 첨부파일들 추가
	public int insert(int wrUid,
							List<String> originalFileNames,
									List<String> fileSystemNames) throws SQLException{
		
		int cnt = 0;
		//첨부파일  정보 추가(저장)하기
		pstmt = conn.prepareStatement(D.SQL_FILE_INSERT);
		for(int i= 0; i<originalFileNames.size(); i++) {
			
			pstmt.setString(1, originalFileNames.get(i));
			pstmt.setString(2, fileSystemNames.get(i));
			pstmt.setInt(3, wrUid);
			cnt+=pstmt.executeUpdate();
		}//end for
		
		
		return cnt;
	}
	
	
	
	
	
	
	
	

}
