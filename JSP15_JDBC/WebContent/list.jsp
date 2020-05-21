<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.sql.*"  
    import ="java.text.*"
    %>  
    <!-- JDBC 관련 IMPORT -->
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
	final String SQL_WRITE_SELECT = "SELECT * FROM test_write ORDER BY wr_uid ASC";
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 목록</title>
<style>
	table{width:100%;}
	table, th, td{
		border : 2px solid lightpink;
		border-collapse:collapse;	
	}
</style>
</head>
<body>
<%
	try{
		Class.forName(driver);
		out.println("드라이버 로딩 성공" +"<br>");
		conn = DriverManager.getConnection(url, userid, userpw);
		out.println("conn 성공 "+ "<br>");
		
		//트랜잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_SELECT);
		
		rs = pstmt.executeQuery();  //select 문든 executeQuery()
		
		out.println("쿼리 성공 <br>");
		// 이 rs(resultset) 를 html table에 넣어줄거임
%>
	<hr>
	<h2>리스트</h2>
	<table>
		<tr>
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
<%
		while(rs.next()){
			out.println("<tr>");
			//rs의 값 받아오기
			int uid = rs.getInt("wr_uid");
			String subject = rs.getString("wr_subject");
			String name = rs.getString("wr_name");
			int viewcnt = rs.getInt("wr_viewcnt");
			Date d = rs.getDate("wr_regdate");
			Time t =rs.getTime("wr_regdate");
			//위에 Date, Time 은  java.sql 걸로 돌아감
			String regdate="";
			if(d != null){
				regdate = new SimpleDateFormat("yyyyMMdd").format(d)+" "+
							new SimpleDateFormat("hhmmss").format(t);
			}
			
			out.println("<td>"+uid +"</td>");
			out.println("<td><a href='view.jsp?uid="+uid+"'>"+subject +"</a></td>");
			out.println("<td>"+name+"</td>");
			out.println("<td>"+ viewcnt+"</td>");
			out.println("<td>"+ regdate+"</td>");
			
			
			out.println("</tr>");
		}//end while
%>
	</table>
	<br>
	<button onclick="location.href('write.jsp')"> 신규 등록 </button>
<%
		
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



</body>
</html>