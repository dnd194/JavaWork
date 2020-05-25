<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.util.*"
    import = "com.lec.beans.*"  %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>JSTL & BEAN</title>
</head>
<body>
<%
Person im = new Person();
im.setName("kelvin");
im.setAge(27);
%>

<c:set var ="dto" value="<%= im %>"/>
이름 : ${dto.name }<br>   
<!-- 내부적으로 getName 을 호출함 -->	
나이 : ${dto.age }<br>   
dto : ${dto }<br>      <!-- dto의 주소가 출력이 된다. -->

<hr>
<!-- EL 은 BEAN 객체의 내용을 읽어올 수 있다. -->

<!-- id 가 p0 인 빈 객체를 생성 -->
<jsp:useBean id="p0" class="com.lec.beans.Person">
	<jsp:setProperty name="p0" property="name" value="홍성룡"/>
	<jsp:setProperty name="p0" property="age" value="28"/>
</jsp:useBean>
이름 : ${p0.name }<br>
나이 : ${p0.age }<br>
p0 : ${p0 }<br>

<!-- bean 배열의 경우 -->
<%
	Person p1 = new Person();
	p1.setName("고질라");
	p1.setAge(100);
	Person p2 = new Person();
	p2.setName("킹기도라");
	p2.setAge(200);
	Person p3 = new Person();
	p3.setName("모스라");
	p3.setAge(80);

	Person [] arr = {p1, p2, p3};
%>


<c:set var ="dtoArr" value = "<%= arr %>"/>
<c:forEach var ="p" items="${dtoArr }">
${p.name }<br>
${p.age }<br>
${p }<br>
</c:forEach>
<hr>
<%
	ArrayList<Person> list = new ArrayList<Person>();
	list.add(p1);
	list.add(p2);
	list.add(p3);
%>

<c:set var="dtoArr" value="<%= list %>"/>
<c:forEach var="p" items="${dtoArr }">
	${p.name }<br>
	${p.age }<br>
	${p }<br>
</c:forEach>

<hr>

${dtoArr[0].name }<br>
${dtoArr[1].name }<br>
${dtoArr[2].name }<br>
${dtoArr[3].name }<br>   <!-- exception 없이 넘어감 array outof exception 뜨지않음 --> 

<hr>
<!-- 특정 id의 bean이 있는지 체크 : empty  -->
<c:if test = "${empty dto }" > <!-- dto가 비어 있냐??  비어있으면 true 차있으면 false -->
	dto 는 없습니다<br>		<!-- 있으므로 출력되지않음 -->

</c:if>

<hr>
<c:if test = "${not empty dto }" > <!-- dto가 비어 있냐??  비어있으면 true 차있으면 false -->
	dto 는 있습니다.<br>

</c:if>
<Hr>
<c:if test="${dto == null }">
	dto 는 없습니다.    <!-- 있으므로 출력되지않음 -->
</c:if> 
<hr>
<c:if test="${dto !=null }">
	dto 는 있습니다.
</c:if>

<c:choose>
	<c:when test="${empty ghost }">
		ghost는 없습니다.<br>
	</c:when>
	<c:when test="${not empty ghost }">
		ghost는 있슴다.<br>
	</c:when>
</c:choose>
<br><hr>
<%  
	Person park = null;
%>

<c:set var="v1" value="<%= park %>"/>
park:${v1 }<br>

<c:if test ="${empty v1 }">    <!-- null 도 empty로 들어간다. -->
	v1은 empty 입니다
</c:if>

<c:if test ="${empty v2 }">		<!-- 존재하지 않는 값도 empty -->
	v2는 empty 입니다
</c:if>




</body>
</html>