<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sessionName = "num1";

	//세션 삭제  속성이 num1 인 session을 삭제
	session.removeAttribute(sessionName);
	
	//세션 삭제  속성이 datetime 인 session을 삭제
	session.removeAttribute("datetime");

%>
<script>
alert("세션 삭제 <%= sessionName%> , <%= "datetime"%>");
location.href="sessionList.jsp";
</script>