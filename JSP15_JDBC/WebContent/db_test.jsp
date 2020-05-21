<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.sql.*"  
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
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	final String USERID="scott0316";		//유저 아이디
	final String USERPW="tiger0316";		//유저 비밀번호
%>

<%!
	//쿼리문 준비
	
	
%>

<%
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" +"<br>");
		conn = DriverManager.getConnection(URL, USERID, USERPW );
		out.println("conn 성공 "+ "<br>");
		
		//트랜잭션 실행
		
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









