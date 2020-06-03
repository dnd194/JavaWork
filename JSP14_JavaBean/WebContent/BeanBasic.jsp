<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<jsp:useBean id="person1" class="com.lec.beans.Person" scope="page"></jsp:useBean>
<!-- 기본 생성자 호출과 똑같은 기능을 함   자바클래스에 기본 생성자가 없을 경우 에러가 나요~
    		Person person1 = new com.lec.beans.Person()  (경로 때문에 풀네임 사용) 
    		정확히는 request.setAttribute("person1", person1) 이 코드도 적용됨		-->


<%-- 기본 생성자 생성후 useBean 안에서 setProperty 사용 --%>
<jsp:useBean id="person2" class="com.lec.beans.Person" scope="page">
	<jsp:setProperty name="person2" property="name" value="옥수수수염차" />
	<jsp:setProperty name="person2" property="id" value="2" />
	<jsp:setProperty name="person2" property="age" value="28" />
	<jsp:setProperty name="person2" property="gender" value="female" />
</jsp:useBean>

<%-- form 에서 넘어온 값을 bean 객체가 바로 받을 수 있다
					대신에 bean의 '''필드명'''과 
								'''순서'''가
								 모두 일치 해야한다. --%>
<jsp:useBean id="person3" class="com.lec.beans.Person" scope="page">
	<jsp:setProperty name="person3" property="name" />
	<jsp:setProperty name="person3" property="id" />
	<jsp:setProperty name="person3" property="age" />
	<jsp:setProperty name="person3" property="gender"/>
</jsp:useBean>							
<!-- person3.getGender(request.getParameter("gender") 와 동일한 역할 -->



<%-- parameter 들을 일괄로 받아오기  property="*" 을 사용 --%>
<jsp:useBean id="person4" class="com.lec.beans.Person" scope="page">
	<jsp:setProperty name="person4" property="*"/>
</jsp:useBean>
<!-- parameter를 일괄로 받아옴  ====>>>  ' * '을 사용함 -->



<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>자바빈</title>
</head>
<body>
	<jsp:setProperty property="name" value="마테차" name="person1" />
	<jsp:setProperty property="id" value="1" name="person1" />
	<jsp:setProperty property="gender" value="male" name="person1" />
	<jsp:setProperty property="age" value="27" name="person1" />
	<!-- 
	 				'''setProperty'''  
			person1.setName, setId, setGender ... 같은 역할을 수행함 -->
	<h3>person1</h3>
	이름 :<jsp:getProperty property="name" name="person1" /><br> 
	
	<!-- name 이나 property 의 값을 오타낼 경우 nullpointexception이 발생한다. -->
	
	
	나이 :<jsp:getProperty property="age" name="person1" /><br> 
	아이디 :<jsp:getProperty property="id" name="person1" /><br> 
	성별 :<jsp:getProperty property="gender" name="person1" /><br>
	<!-- 
					'''getProperty'''
			person1.getName, getId, getGender ... 같은 역할을 수행함 -->
	<h3>person2</h3>
	이름 :<jsp:getProperty property="name" name="person2" /><br> 
	나이 :<jsp:getProperty property="age" name="person2" /><br> 
	아이디 :<jsp:getProperty property="id" name="person2" /><br> 
	성별 :<jsp:getProperty property="gender" name="person2" /><br>
	
	<h3>person3</h3>
	이름 :<jsp:getProperty property="name" name="person3" /><br> 
	나이 :<jsp:getProperty property="age" name="person3" /><br> 
	아이디 :<jsp:getProperty property="id" name="person3" /><br> 
	성별 :<jsp:getProperty property="gender" name="person3" /><br>
	
	
	<h3>person4</h3>
	이름 :<jsp:getProperty property="name" name="person4" /><br> 
	나이 :<jsp:getProperty property="age" name="person4" /><br> 
	아이디 :<jsp:getProperty property="id" name="person4" /><br> 
	성별 :<jsp:getProperty property="gender" name="person4" /><br>
</body>
</html>