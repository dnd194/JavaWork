package old;

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
		String subject = dto.getSubject();
		String content = dto.getContent();
		String name = dto.getName();

		int cnt = this.insert(subject, content, name);
		return cnt;
	}//end insert

	// 메서드 오버로딩
	public int insert(String subject, String content, String name) throws SQLException {

		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(D.SQL_WRITE_INSERT);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setString(3, name);

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
			int uid = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String name = rs.getString("wr_name");
			String content = rs.getString("wr_content");
			int viewCnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t =rs.getTime("wr_regdate");
			//위에 Date, Time 은  java.sql 걸로 돌아감
			String regDate="";
			if(d != null){
				regDate = new SimpleDateFormat("yyyyMMdd").format(d)+" "+
							new SimpleDateFormat("hhmmss").format(t);
			}
	
			WriteDTO dto = new WriteDTO(uid, subject ,content, name, viewCnt);
			dto.setRegDate(regDate);
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
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT);
			rs= pstmt.executeQuery();
			arr = createArray(rs);
		}finally {
			close();
		}
	
		return arr;
	}//end select
	
	//특정 uid의 글 내용 읽기, 조회수 증가
	//viewCnt 도 1증가, 읽어와야한다.
	public WriteDTO[] readByUid(int uid) throws SQLException{
		
		int cnt = 0;
		WriteDTO[] arr = null;
		
		try {
			//트랜잭션 처리
			//Auto - commit 비 활성화
			
			conn.setAutoCommit(false);
			
			//쿼리들 수행
			pstmt = conn.prepareStatement(D.SQL_WRITE_INC_VIEWCNT);
			pstmt.setInt(1, uid);
			cnt =pstmt.executeUpdate();
			
			pstmt.close();  //닫아주고 다시 실행
			
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs = pstmt.executeQuery();
			
			arr= createArray(rs);
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
			throw e;
		}finally {
			close();
		}
		return arr;
		
	}//end readByUid
	
	//특정 uid 의 글 만 select   ''''여기는 조회수 증가가 없음
	public WriteDTO[] selectByUid(int uid) throws SQLException{
		WriteDTO[] arr =null;
		try {
			pstmt=conn.prepareStatement(D.SQL_WRITE_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			rs=pstmt.executeQuery();
			arr=createArray(rs);
			
		}finally {
			close();
		}
		
		return arr;
		
	}//end selectByUid
	
	
	//특정 uid의 글 수정(제목 , 내용)
	public int update(int uid, String subject, String content) throws SQLException{
		
		int cnt = 0;
		try {
			//트랜잭션 실행
			pstmt = conn.prepareStatement(D.SQL_WRITE_UPDATE);
			pstmt.setString(1, subject);
			pstmt.setString(2, content);
			pstmt.setInt(3, uid);
			
			cnt = pstmt.executeUpdate();
		}finally {
			close();
		}
		
		return cnt;
		
	}//end update
	
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
	
	// 페이징 -------------------------------------
	public WriteDTO[] selectPaging() throws SQLException{
		WriteDTO[] arr =null;
		int cnt = 0;
		int curPage = 1;
		int writePages = 10;   // 한 [페이징] 에 몇개의 '페이지' 를 표현할 것인가?
		int pageRows = 8;    // 한 '페이지' 에 몇개의 글을 리스트업 할 것인가?
		int totalPage = 0;	 // 총 몇 '페이지' 분량인가?
		try {
			pstmt=conn.prepareStatement(D.SQL_WRITE_COUNT_ALL);
			
			rs=pstmt.executeQuery();
			if(rs.next())
				cnt = rs.getInt(1);   // count(*), 전체 글의 개수
				
			rs.close();
			pstmt.close();
			
			totalPage = (int)Math.ceil(cnt / (double)pageRows); // 총 몇페이지 분량
			
			int fromRow = (curPage - 1) * pageRows + 1;  // 몇번째 row 부터?
					
			pstmt = conn.prepareStatement(D.SQL_WRITE_SELECT_FROM_ROW);
			pstmt.setInt(1, fromRow);  
			pstmt.setInt(2, fromRow + pageRows);
			rs = pstmt.executeQuery();
			arr = createArray(rs);
		}finally {
			close();
		}
		
		return arr;
		
	}//end selectByUid
	
	
}
