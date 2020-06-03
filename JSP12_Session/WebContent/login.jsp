<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>로그인만들어보자</title>
</head>
<body>
<%!
	String sessionName, sessionValue;
%>
<%

	if(session.getAttribute("userid") == null){  %>
		<!-- 로그인 상태가 아닐때 -->
		<h2> 로그인 상태가 아닙니다.</h2>
		<form action="loginOk.jsp">
			id : <input type="text" name="userid"><br>
			pw : <input type="password" name ="pw"><br>
			<input type="submit" value="로그인"><br>
		</form>
		
	<% }else{ %>   <!-- 안에 html 코드를 넣어주기 위해서 다음과 같이 디렉티브 태그를 닫아줌 -->
		<!-- 로그인 상태일때  -->
		<h2> 로그인 상태입니다.</h2>
		<form action="logout.jsp">
			<input type="submit" value="로그아웃"><br>
		</form>
<% 	}  %>

</body>
</html>