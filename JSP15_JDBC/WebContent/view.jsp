<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.sql.*"  
    import = "java.text.*"
    %>  
    <!-- JDBC 관련 IMPORT -->
<%
	//파라미터 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// 이 단계에서 parameter 검증이 필요 (validation)  하지만 생략~~ writeOk.jsp에 example 있음
%>
<%!
	//JDBC 관련 기본 객체변수
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt =null;
	ResultSet rs = null;			//Select 결과, executeQuery()
	int cnt = 0;					// DML 결과, executeUpdate()
	
	//Connection 에 필요한 값 세팅
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String userid="scott0316";		//유저 아이디
	String userpw="tiger0316";		//유저 비밀번호
%>
<%!
	//쿼리문 준비
	
	//조회수 증가
	final String SQL_WRITE_INC_VIEWCNT = 
		"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";

	// 게시글 읽어오기
	final String SQL_WRITE_SELECT_BY_UID = "SELECT * FROM test_write WHERE wr_uid = ?";
%>
<%
// 	변수를 담을 공간 준비
	String name = "";
	String subject = "";
	String content ="";
	String regdate = "";
	int viewcnt = 0;
%>
<%
	try{
		Class.forName(driver);
		out.println("드라이버 로딩 성공" +"<br>");
		conn = DriverManager.getConnection(url, userid, userpw);
		out.println("conn 성공 "+ "<br>");
		
		//트랜잭션 실행
		//Auto - commit 비 활성화
		conn.setAutoCommit(false);
		
		//쿼리들 수행
		pstmt = conn.prepareStatement(SQL_WRITE_INC_VIEWCNT);
		pstmt.setInt(1, uid);
		cnt =pstmt.executeUpdate();
		
		pstmt.close();
		
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT_BY_UID);
		pstmt.setInt(1, uid);
		rs = pstmt.executeQuery();
		
		//많아야 한개의 record 만 select 된다
		// 한개만 있기때문에 while 돌리지 않는다
		
		if(rs.next()){
			subject = rs.getString("wr_subject");
			content = rs.getString("wr_content");  //이친구는 null 을 허용함
			if(content == null) content ="";  //null 일때의 값을 처리
			name = rs.getString("wr_name");
			viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t =rs.getTime("wr_regdate");
			//위에 Date, Time 은  java.sql 걸로 돌아감
			regdate="";
			if(d != null){
				regdate = new SimpleDateFormat("yyyyMMdd").format(d)+" "+
							new SimpleDateFormat("hhmmss").format(t);
			}
		}else{
			//wr_uid 값의 레코드가 없는 뜻
%>
			<script>
				alert("해당정보가 삭제되었거나 없다리");
				history.back();
			</script>
<%
			return;   //더이상 jsp 가 프로세싱하지 않고 종료
		}//end if
		
		
		//모든 쿼리 성공하면 commit
		conn.commit();
	}catch(Exception e){
		e.printStackTrace();
		
		//예외처리
		conn.rollback();
	}finally{
		//리소트 해제
		try{
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 읽기 (<%= subject %>)</title>  <!-- title에 글 제목 넣기 -->
</head>
<script>
	function chkDelete(uid){
		//삭제 여부, 다시 확인하고 진행하기
		var r = confirm("삭제하시겠습니까??");
		if(r){  //삭제하기버튼을 눌렀을때 동작
				location.href("deleteOk.jsp?uid="+uid);
		}
		
	}
</script>
<body>
<h2>읽기 <%= subject %></h2><br>
UID : <%= uid %><br>
작성자 : <%= name %><br>
제목 : <%= subject %><br>
등록일 : <%= regdate %><br>
조회수 : <%= viewcnt %><br>
<hr>
내용 : <br>
<div>
	<%=content %>
</div>
<hr>
<br>
<button onclick="location.href('update.jsp?uid=<%= uid%>')">수정하기</button>
<button onclick="location.href('list.jsp')">목록보기</button>
<button onclick="chkDelete(<%= uid %>)">삭제하기</button>
<button onclick="location.href('wrtie.jsp')">신규등록</button>
</body>
</html>