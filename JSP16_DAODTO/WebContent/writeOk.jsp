<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.sql.*"  
    %>  
    <jsp:useBean id="dao" class="com.lec.beans.WriteDAO"></jsp:useBean>
    <%-- DAO Bean 생성 --%>
    
<%--     
    <%
    	request.setCharacterEncoding("utf-8");  //한글 인코딩
    	
    	//입력한 값 받아오기
    	String name =request.getParameter("name");
    	String subject = request.getParameter("subject");
    	String content = request.getParameter("content");
    	
    	//유효성 체크
    	//name, subject 는 비어있으면 안된다 NN
    	//null 이거나 빈 문자열이면 이전화면으로 돌아가기
    	if(name == null || subject ==null || 
    	name.trim().equals("")||subject.trim().equals("")){
    	%>
    		<script>
    			alert("작성자 이름, 글 제목은 필수 입니다!");
    			history.back();  //histoty.go(-1);
    		</script>
    		
<% 
			//				가장 중요한 부분
			// JSP 코드에서 return 의 의미는 더이상 프로세싱하지 않는 다는 의미
			return;   // '''''''더이상 JSP 프로세싱 하지 않도록 종료'''''''''''
    	}
%> --%>

<%
	request.setCharacterEncoding("utf-8");  //한글 인코딩  post로 받아오기때문에 꼭해줘야함
%>
<jsp:useBean id="dto" class="com.lec.beans.WriteDTO"></jsp:useBean>
<jsp:setProperty property="*" name="dto"/>
    <%
//     	int cnt = dao.insert(subject, content, name);
    /* 위에 구문이 끝나고 자원을 닫아줌 */
    
    	int cnt = dao.insert(dto);
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
	




