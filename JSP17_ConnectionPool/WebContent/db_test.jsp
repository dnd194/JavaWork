<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*"%> <%-- JDBC 관련 import --%>    
<%!
	// JDBC 관련 기본 객체 객체변수 선언
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
	// ex) String sql_xxxx = "INSERT INTO .....";  
%>

<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" + "<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>");
		
		// 트랜잭션 실행
		//
		
	} catch(Exception e){
		e.printStackTrace();
		// ※ 여기서 예외처리를 하든지, 예외 페이지를 설정해주어야 한다.
		// throw e;   // JSP 예외 페이지에 보여주기
	} finally {
		// DB 리소스 해제
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