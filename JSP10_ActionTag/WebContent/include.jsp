<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.net.*"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>include</title>
</head>
<body>

<!-- Action Tag -->
<h3>지금의 페이지는 include 페이지 랍니다~~~</h3>

<%-- <jsp:include page="sub.jsp"/> <!-- 단독태그로 만들어줌 --> --%>
<!-- include directive 랑 똑같이 동작한다.    
		  jsp08의 tagEx 에 있음		그러나 과정은 다름 -->
<%@ include file ="sub.jsp" %>
<p>위 라인의 내용은 sub 페이지의 내용입니다.</p>

<hr>
<h3>지금의 페이지는 include 페이지 랍니다~~~</h3>

<jsp:include page="sub.jsp"/> <!-- 단독태그로 만들어줌 -->
<p>위 라인의 내용은 sub 페이지의 내용입니다.</p>

<hr>
<%!
	//변수 선언
	String name = "고길동";
	int age = 40;
%>
<%@ include file= "sub2.jsp" %>
<%-- <jsp:include page="sub2.jsp"></jsp:include> --%>

<jsp:include page="sub3.jsp">
	<jsp:param value='<%=URLEncoder.encode(name, "utf-8") %>' name="name"/>
	<jsp:param value="<%=age %>" name="age"/>
</jsp:include>
<!-- request도 url 형식이기 때문에 encoding 을 해줘야한다. -->



</body>
</html>