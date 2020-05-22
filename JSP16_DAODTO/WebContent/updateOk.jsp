<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>  
    <jsp:useBean id="dao" class="com.lec.beans.WriteDAO"></jsp:useBean>  
    
    <%  //parameter 받아오기
    	request.setCharacterEncoding("utf-8");  //한글인코딩
    	int uid = Integer.parseInt(request.getParameter("uid"));
    	String subject = request.getParameter("subject");
    	String content = request.getParameter("content");
    %>
<%
	//DAO 사용한 트랙잭션
	int cnt = dao.update(uid, subject, content);

%>
<%-- 위 트랙잭션이 마무리되면 페이지 보여주기 --%>
<% 
	if(cnt == 0 ){ %>
		<script>
			alert("수정실패~~");
			history.back();  //브라우저가 기억하는 직전 페이지
		</script>
<% }else{ %>
		<script>
			alert("수정 성공, 수정된 리스트를 '다시' 출력합니다~~");
			location.href("view.jsp?uid=<%= uid %>");  
		</script>
		
<% } %>





