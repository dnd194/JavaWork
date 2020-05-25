<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "com.lec.beans.WriteDTO"
    
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>EL request</title>
</head>
<body>
<%
request.setAttribute("myage", 30);
request.setAttribute("mydto", new WriteDTO(100,"제목","내용","작성자",3));
pageContext.setAttribute("myage", "pageContext가 우선순위가 더 높아요");
%>
<!-- page -> request -> session -> application 순으로 간다 -->

${myage }<br>      <!-- 둘다 30이 나옴 -->
${requestScope.myage }<br>
${mydto }<br>   <!--  원래는 주소값이 나오는데 지금 toString을 override해놔서 그 메소드가 정의한대로 나옴 -->
${mydto.uid }<br>
${mydto.name }<br>
${mydto.subject }<br>
${mydto.content }<br>


</body>
</html>