<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    %>  
<%
	int cnt = (Integer)request.getAttribute("delete");
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
			location.href("list.do");  
		</script>
		
<% } %>





