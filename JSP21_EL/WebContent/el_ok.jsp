<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>EL 내장객체</title>
</head>
<body>

<% 

String id = request.getParameter("id");
String pw = request.getParameter("pw");
String[] hobby = request.getParameterValues("hobby");


%>
아이디 : <%= id %><br>
비밀번호 : <%= pw %><br>
취미 : 
<% 
	for ( int i = 0 ; i < hobby.length; i++){  %>
		<%= hobby[i] %>
		
	<% }%><br>
<hr>
아이디 : ${param.id }<br>
비밀번호 : ${param.pw }<br>
취미 : ${paramValues.hobby[0] }
		${paramValues.hobby[1] }
		${paramValues.hobby[2] }<br>
		
		<hr>
		
		<!-- 아래와 같은 방법도 가능하다.   -->
아이디 : ${param["id"] }<br>
비밀번호 : ${param["pw"] }<br>
취미 : ${paramValues["hobby"][0] }
		${paramValues["hobby"][1] }
		${paramValues["hobby"][2] }<br>
<hr>

applicationScope : ${applicationScope.application_name }<br>   
<!-- el_form 에 있는 application.setAttribute 들이 찍힘 -->
sessionScope : ${sessionScope.session_name }<br>
pageScope : ${pageScope.page_name }<br>        <!-- page 와 request 값은 나오지 않는게 정상이다. -->
requestScope : ${requestScope.request_name }<br>

<hr>

context 초기화 파라미터<br>
${initParam.con_name }<br>
${initParam.con_id }<br>
${initParam.con_pw }<br>

<hr>
ContextPath<br>
<%= request.getContextPath() %><br>
<!-- 이친구 많이 사용될거에요   frontend에서는 '/' 은 도메인바로뒤 라는 것을 까먹지 말것-->
${pageContext.request.contextPath }<br>   <!-- context가 바뀔 경우를 생각해서 아래와 같이 쓰는 것을 추천하는바?? -->

<!-- 그래서 contextPath 가 바뀔 것을 감안해서 생각을 해야해여 -->
 <a href="${pageContext.request.contextPath }/el_form.jsp "> 입력 폼</a><br>




</body>
</html>