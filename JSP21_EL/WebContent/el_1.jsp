<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>EL</title>
</head>
<body>
	<h3>익스프레션 language</h3>
	${10 }<br>  <!-- 원래대로면 ${10} 이 그대로 나와야하는데
	  						그냥 10만 나옴 -->
	 ${99.99 }<br>
	 ${"ABC" }<BR>
	 ${TRUE }<BR>

<h3>EL 의 연산자</h3>
${1+2 }<br>
${1-2 }<br>
${1*2 }<br>
${1/2 }<br>
${1>2 }<br>
${1<2 }<br>
${1<2? 33:100}<br>
${(1<2) || (1<2)}<br>
<hr>
<%
	int num = 10;
%>
num : ${num }<br>   <!-- 이걸로 EL은 자바 언어가 아닌 것을 알 수 있다. -->
<!-- 자바 언어가 아니라서 java 변수 그대로 표현은 안돼지만~~ ''에러도 아니다'' -->
num : <%= num %><br>



</body>
</html>