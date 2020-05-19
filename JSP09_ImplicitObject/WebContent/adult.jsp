<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>19세 이상입니다~</title>
</head>
<body>
<%! int age ; %>
<%
	String str = request.getParameter("age");
	age = Integer.parseInt(str);
%>

당신은 <%= age %> 세 입니다.<br>
성인이네요 이용가능합니다~<br>
<a href="input_age.html">처음으로</a>

</body>
</html>