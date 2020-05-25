<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--     아래 의 것을 필 수 적으로 해줘야한다-->
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>jstl2_core</title>
</head>
<body>

<h2>set, remove, out</h2>
<!-- 일반 적으로 접두어를  c 로 많이한다 -->
<c:set var = "name" value="갬자"></c:set>
이름 : <c:out value="kelvin"></c:out><br>
이름 : <c:out value='${name }'></c:out><br>

${name }<br>
<c:remove var ="name"/>
이름 : <c:out value = "${name }"/><br>

<hr>

<% int age =10; %>
나이 : ${age }<br>   <!-- el 에는 자바변수 안되요~~ 잊지마세여 -->
<!-- 그러나 아래는 가능하다 -->
<c:set var = "age" value="<%=age %>"/>
나이 : ${age }<br>
<hr>

<h2> catch</h2>

<c:catch var ="error">
<!-- 이안에서 예외가 발생하면 예외객체를 error 변수에 담는다 -->
<%= 2/0 %>
<br>
</c:catch>

<c:out value = "${error }"/><br>   <!--exception 이름이랑 메세지가 담겨져있다  -->
<br>

<c:catch var = "ex">
	name parameter 값은  = <%= request.getParameter("name") %><br>
	
	
<!-- 	아래는 에러 유도 코드  그러나 에러는 뜨지않는다 왜냐하면 catch 로 감싸져있기때문 -->
	<% if(request.getParameter("name").equals("test")){ %>
	${param.name }은 test 입니다.
	<%} %>
	
</c:catch>
<br>

<c:if test="${ex != null }">    <!-- if 안에 저렇게 조건을 넣음  EL식으로 들어감 -->
	예외 발생<br>
	${ex }<br>

</c:if>






</body>
</html>