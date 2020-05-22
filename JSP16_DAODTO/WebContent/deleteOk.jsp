<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.sql.*"  
    import = "java.text.*"
    %>  
    <jsp:useBean id="dao" class="com.lec.beans.WriteDAO"></jsp:useBean>  
    <%  //parameter 받아오기
    
//     	request.setCharacterEncoding("utf-8");  //한글인코딩 get방식이라서 지금은 필요없음
    	int uid = Integer.parseInt(request.getParameter("uid"));
    %>
<%
	int cnt = dao.deleteByUid(uid);
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





