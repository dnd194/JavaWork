<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>JSP start</title>
</head>
<body>
하위<br>
<!-- request  -->
<a href="page1.jsp">page1</a><br>
<a href="./page2.jsp">page2</a><br>


<!-- 33번 같은 짓 하면 안돼요~~~ 
					이거는 도메인명 바로 뒤에 href가 붙는다. -->
<a href="/page3.jsp">page3</a>
</body>
</html>