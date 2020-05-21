<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.sql.*"  
    import = "java.text.*"
    %>  
    <!-- JDBC 관련 IMPORT -->
    
    <%  //parameter 받아오기
    
//     	request.setCharacterEncoding("utf-8");  //한글인코딩 get방식이라서 지금은 필요없음
    	int uid = Integer.parseInt(request.getParameter("uid"));
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
	final String SQL_WRITE_DELETE_BY_UID =
					"DELETE FROM test_write WHERE wr_uid = ?";
	
%>

<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" +"<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW );
		out.println("conn 성공 "+ "<br>");
		
		//트랜잭션 실행
		pstmt = conn.prepareStatement(SQL_WRITE_DELETE_BY_UID);
		pstmt.setInt(1, uid);
		
		cnt = pstmt.executeUpdate();
		//정상적으로 수행될시 cnt = 1
		
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

<%-- 위 트랙잭션이 마무리되면 페이지 보여주기 --%>
<% 
	if(cnt == 0 ){ %>
		<script>
			alert("삭제 실패~~");
			history.back();  //브라우저가 기억하는 직전 페이지
		</script>
<% }else{ %>
		<script>
			alert("삭제 성공, 수정된 리스트를 '다시' 출력합니다~~");
			location.href("list.jsp");  
		</script>
		
<% } %>





