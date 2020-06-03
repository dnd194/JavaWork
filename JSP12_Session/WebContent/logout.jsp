<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String sessionName ="userid";
	session.removeAttribute(sessionName);
%>
<script>
	alert("로그아웃~~");
	location.href("login.jsp")
</script>