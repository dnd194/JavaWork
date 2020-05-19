<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>param</title>
</head>
<body>
<!-- Action Tag -->
<h2>현재 페이지는 param 페이지</h2>
<% 
	int num = 1024;
%>
<!-- 이 값이 subparam 으로 넘어감 -->
<!-- 수행하는 코드의 순서도 다름   
					 익스프레션식이 먼저 수행되고 값이 넘어간 것을 알 수 있음 -->
<jsp:forward page = "subParam.jsp">
	<jsp:param value="test123" name="id"/>
	<jsp:param value="<%=num %>" name="pw"/>
</jsp:forward>

<!-- include 도 같은 순서로 동작함 -->

<!-- action 태그는 각 각 컴파일 하고 실행한 후에 합쳐지고 -->
<!-- include 파일은 미리 합쳐진후 합쳐진 상태에서 컴파일 된다. -->
<p> 위 라인의 내용은 subParam 의 내용입니다.</p>
</body>
</html>