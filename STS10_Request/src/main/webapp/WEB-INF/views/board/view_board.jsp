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
<a href="<%= request.getContextPath()%>/board/list">list</a>
<a href="<%= request.getContextPath()%>/board/delete">delete</a>
<a href="<%= request.getContextPath()%>/board/update">update</a>
</body>
</html>