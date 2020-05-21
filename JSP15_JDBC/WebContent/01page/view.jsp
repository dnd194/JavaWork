<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <%-- JDBC 관련 import --%>  
<%@ page import = "java.text.SimpleDateFormat" %>  

<%  // parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// ※ 이 단계에서 parameter 검증 필요
	
	int curPage = 1;   // 현재 페이지 (디폴트 1 page)
	
	// 현재 몇 페이지인지 parameter 받아오기 + 검증
	String pageParam = request.getParameter("page");
	if(pageParam != null && !pageParam.trim().equals("")){
		try{ 
			// 1이상의 자연수 이어야 한다
			int p = Integer.parseInt(pageParam);
			if(p > 0) curPage = p;
		} catch(NumberFormatException e){
			// page parameter 오류는 별도의 exception 처리 안함 
		}
	} // end if
%>

<%!
	// JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;   // SELECT 결과, executeQuery() 
	int cnt = 0;   // DML 결과, executeUpdate()
	
	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";  // JDBC 드라이버 클래스
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";  // DB 접속 URL
	final String USERID = "scott0316";  // DB 접속 계정 정보
	final String USERPW = "tiger0316";
%>

<%!
	// 쿼리문 준비
	final String SQL_WRITE_INC_VIEWCNT =  // 조회수 증가
		"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";

	final String SQL_WRITE_SELECT_BY_UID =  // 글 읽어 오기
		"SELECT * FROM test_write WHERE wr_uid = ?";
%>

<%
	String name = "";
	String subject = "";
	String content = "";
	String regdate = "";
	int viewcnt = 0;
%>


<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>");
		
		// 트랜잭션 실행
		// Auto-commit 비활성화
		conn.setAutoCommit(false);
		
		// 쿼리들 수행
		pstmt = conn.prepareStatement(SQL_WRITE_INC_VIEWCNT);
		pstmt.setInt(1, uid);
		cnt = pstmt.executeUpdate();
		
		pstmt.close();
		
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		
		// 한개의 레코드만 select 된다.
		if(rs.next()){
			subject = rs.getString("wr_subject");
			content = rs.getString("wr_content");
			if(content == null) content = "";   // null 처리 
			name = rs.getString("wr_name");
			viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t = rs.getTime("wr_regdate");
			regdate = "";
			if(d != null){
			 	regdate = new SimpleDateFormat("yyyy-MM-dd").format(d) + " " 
						+ new SimpleDateFormat("hh:mm:ss").format(t);
			}
		} else {
			// wr_uid 값의 레코드가 없는 뜻
%>
			<script>
				alert("해당 정보가 삭제되거나 없습니다");
				history.back();
			</script>
<%			
			return;   // ★더이상 JSP 프로세싱 하지 않고 종료★
		} // end if
		
		// 모든 쿼리 성공하면 commit
		conn.commit();
	} catch(Exception e){
		e.printStackTrace();
		// 예외 처리
		conn.rollback();
	} finally {
		// 리소스 해제
		try {
			if(rs != null) rs.close();
			if(stmt != null) stmt.close();
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
%>
<%-- 위 트랜잭션이 마무리 되면 페이지 보여주기 --%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>읽기 <%= subject %></title> <!-- title에 글제목 넣기 -->
</head>
<script>
function chkDelete(uid){
	// 삭제 여부, 다시 확인 하고 진행하기
	var r = confirm("삭제하시겠습니까?");
	if(r){
		location.href = 'deleteOk.jsp?uid=' + uid;
	}
}
</script>
<body>
<h2>읽기 <%= subject %></h2>
<br>
UID : <%= uid %><br>
작성자 : <%= name %><br>
제목 : <%= subject %><br>
등록일 : <%= regdate %><br>
조회수 : <%= viewcnt %><br>
내용: <br>
<hr>
<div>
<%= content %>
</div>
<hr>
<br>
<button onclick="location.href='update.jsp?uid=<%= uid%>'">수정하기</button>
<button onclick="location.href = 'list.jsp?page=<%= curPage%>'">목록보기</button>
<button onclick="chkDelete(<%= uid %>)">삭제하기</button>
<button onclick="location.href = 'write.jsp'">신규등록</button>

</body>
</html>















