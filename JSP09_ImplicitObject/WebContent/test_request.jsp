<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>request 객체체체</title>
</head>
<body>
<%
 	out.println("서버 : " + request.getServerName() + "<br>");
 	out.println("포트 : " + request.getServerPort() + "<br>");
 	out.println("요청방식 :" + request.getMethod() + "<br>");
 	out.println("프로토콜 :" + request.getProtocol() + "<br>");
 	out.println("URL :" + request.getRequestURL() + "<br>");
 	out.println("URI :" + request.getRequestURI() + "<br>");
 	out.println("ContextPath :" + request.getContextPath() + "<br>");
 	out.println("쿼리문자열: " + request.getQueryString() + "<br>");
 %>


</body>
</html>