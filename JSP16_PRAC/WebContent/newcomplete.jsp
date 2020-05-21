<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.sql.*"  
    %>  
    <!-- JDBC 관련 IMPORT -->
    <%
    	request.setCharacterEncoding("utf-8");  //한글 인코딩
    	
    	//입력한 값 받아오기
    	String name =request.getParameter("name");
    	int age = Integer.parseInt(request.getParameter("age"));
    	String intro = request.getParameter("intro");
    	String region = request.getParameter("region");
    	
    	//유효성 체크
    	//name, subject 는 비어있으면 안된다 NN
    	//null 이거나 빈 문자열이면 이전화면으로 돌아가기
    	if(name == null || age ==0 || intro==null||
    	name.trim().equals("")|| age == 0||intro.trim().equals("")){
    	%>
    		<script>
    			alert("이름, 나이, 소개는 필수 입니다!");
    			history.back();  //histoty.go(-1);
    		</script>
    		
<% 
			//				가장 중요한 부분
			// JSP 코드에서 return 의 의미는 더이상 프로세싱하지 않는 다는 의미
			return;   // '''''''더이상 JSP 프로세싱 하지 않도록 종료'''''''''''
    	}
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
	String sql_insert = "INSERT INTO prac_board (p_uid, p_name, p_age, p_foot, p_intro) "+
	"VALUES(prac_seq.nextval, ?, ?, ?, ?)";
	
%>

<%
	try{
		Class.forName(driver);
		out.println("드라이버 로딩 성공" +"<br>");
		conn = DriverManager.getConnection(url, userid, userpw);
		out.println("conn 성공 "+ "<br>");
		
		//받은 parameter 값으로 트랜잭션 실행
		pstmt = conn.prepareStatement(sql_insert);
		
		pstmt.setString(1, name);
		pstmt.setInt(2, age);
		pstmt.setInt(3, foot);
		pstmt.setString(4, intro);
		
		cnt= pstmt.executeUpdate();
		//정상적으로 된다면 cnt는 1이 되야함
		
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
<!-- 위 트랜잭션이 마무리되면 페이지 보여주기 -->
<% 
	if(cnt == 0 ){ %>
		<script>
			alert("등록실패~~");
			history.back();  //브라우저가 기억하는 직전 페이지
		</script>
<% }else{ %>
		<script>
			alert("등록 성공, 리스트를 출력합니다~~");
			location.href("list.jsp");  //브라우저가 기억하는 직전 페이지
		</script>
		
<% } %>
	








