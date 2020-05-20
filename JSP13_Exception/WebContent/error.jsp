<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
    <!-- 에러핸들링을 위한 페이지라고 명시를 해줘야한다. -->
    
    <!-- response 코드 정상화하기 -->
    <% response.setStatus(200);%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>에러 났을때 오는곳</title>
</head>
<body>
에러가 발생했다리....<br>
예외 타입은 : <%= exception.getClass().getName() %><br>
예외 메세지 : <%= exception.getMessage() %>
</body>
</html>