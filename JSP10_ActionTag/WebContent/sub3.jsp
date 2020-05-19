<%@page import="java.net.URLDecoder"%>
<%@page import="java.beans.Encoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
<%!
	String name;
	int age;
%>
<%
	request.setCharacterEncoding("utf-8");

	name = URLDecoder.decode(request.getParameter("name"),"utf-8");
	
	age = Integer.parseInt(request.getParameter("age"));
	
%>
나이 : <%=age %><br>
이름 : <%=name %><br>
</body>
</html>