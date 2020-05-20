<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String cookieName ="userid";
	String cookieValue ="";
	Cookie cookie = new Cookie(cookieName, cookieValue);
	cookie.setMaxAge(0);
	response.addCookie(cookie);
%>
<script>
	alert("로그아웃~~");
	location.href("login.jsp")
</script>