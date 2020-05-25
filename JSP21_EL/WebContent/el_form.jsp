<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL 내장객체</title>
</head>
<body>
	<form action="el_ok.jsp" method="get">
		아이디 : <input type="text" name="id"><br>
		비밀번호 : <input type="password" name="pw"><br>
		<input type="checkbox" name="hobby" value="music">음악<br>
		<input type="checkbox" name="hobby" value="sport">운동<br>
		<input type="checkbox" name="hobby" value="game">게임<br>
		<input type="submit" value="login">
	</form>
	
	<% 
		// 내장객체
		application.setAttribute("application_name", "application_value");
		session.setAttribute("session_name", "session_value");
		pageContext.setAttribute("page_name", "page_value");
		request.setAttribute("request_name", "request_value");
	%>

</body>
</html>

