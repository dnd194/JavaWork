<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="dto" class="com.lec.beans.WriteDTO" scope="page"/>
    <jsp:setProperty name ="dto" property="uid" value="123"/>
    <jsp:setProperty name ="dto" property="subject" value="제목이라구"/>
    <jsp:setProperty name ="dto" property="name" value="작성자라구"/>
    
    <!-- EL 은 빈 객체도 사용할 수 있다. -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>EL - ACTION TAG</title>
</head>
<body>

<!-- 먼저 배웠던 방식은 아래와 같다. -->

<!-- dto 객체를 사용 -->
	uid : <%= dto.getUid() %><br>
	subject : <%= dto.getSubject() %><br>
	name : <%= dto.getName() %><br>
	
	<hr>
	<!-- jsp getProperty 를 사용해서 가져오기  -->
	
	uid : <jsp:getProperty name="dto" property="uid"/><br>
	subject : <jsp:getProperty name="dto" property="subject"/><br>
	name : <jsp:getProperty name="dto" property="name"/><br>
	
	<hr>
	<!-- bean 객체를 사용한 EL -->
	uid : ${dto.uid }<br>
	subject : ${dto.subject }<br>
	name :${dto.name }<br>
	comment : ${ddd.comment }<br> <!-- 이거는 에러가 나지 않음  그러나 아래 와 같이 할 경우는 에러가남-->
<%-- 	name :${dto.comment }<br> <!-- 이때는 dto 객체에서 getComment를 찾지 못해서 에러가남  --> --%>
	
	<!-- EL을 사용하면 훨씬 간단해짐 -->
	<hr>
	
	
</body>
</html>