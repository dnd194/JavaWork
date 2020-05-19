<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Aut</title>
</head>
<body>
	<!-- 이렇게 태그를 끊고 할 수 도 있다. -->
	<%-- 
<%
	int i = 0;
	while(true){
		i++;
		out.println("1 * "+i+" = "+1*i+"<br>");
%>
--------------------- <br>
<%
		if(i >= 9 ) break;
	}
%>
--%>
	<%!/* 자바 세상 ^^ 변수선언, 메소드 정의 */
		int i = 100;
		String str = "test";

		public int summ(int a, int b) {
			return a + b;
		}
	%>

<%
	//스크립트릿  
	out.println("i = " + i+"<br>");
	out.println("str = "+str+"<br>");
	out.println("summ(i,10) = "+summ(i,10));

%>
<hr>   <!-- 익스프레션식으로 표현 -->
	i = <%= i %><br>
	str = <%= str %><br>
	summm =<%= summ(i,10) %><br>
</body>
</html>