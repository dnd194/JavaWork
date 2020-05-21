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
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID="scott0316";		//유저 아이디
	final String USERPW="tiger0316";		//유저 비밀번호
%>

<%!
	//쿼리문 준비
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
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" +"<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW );
		out.println("conn 성공 "+ "<br><br>");
		
		//트랜잭션 실행
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
		
		
		
	}catch(Exception e){
		e.printStackTrace();
		//예외처리
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
<title>수정 <%= subject %></title>
</head>
<script>
function chkSubmit(){
	frm = document.forms['frm'];
	var subject = frm.subject.value.trim();
	
	if(subject == ""){
		alert("제목은 반드시 작성해야합니다");
		frm.subject.focus();
		return false;
	}
	return true;
}


</script>
<body>
<form name ="frm" action="updateOk.jsp" method="post" onsubmit="return chkSubmit()">
<input type="hidden" name="uid" value="<%= uid %>"/>
작성자 : <%= name %><br>  <!-- 작성자 이름 변경 불가 -->
제목 : 
<input type="text" name="subject" value="<%= subject %>"/><br>
내용 : <br>
<textarea name="content">
	<%=content %>
</textarea>
<br>
<input type="submit" value="수정"/>

</form>
<button onclick="history.back()">이전으로</button>
<button onclick="location.href('list.jsp')">목록보기</button>

</body>
</html>