<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"%>
    <!--     아래 의 것을 필 수 적으로 해줘야한다-->
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
   <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>jstl core3</title>
<style>
	table,th,td{
		border : 1px solid lightpink;
		border-collapse: collapse;
	}
</style>
</head>
<body>
<h2>if</h2>
<!-- 스크립트릿만 사용하는 경우 1 -->
<% if(1+2 ==3){ %>
	1 + 2 = 3 <br>     <!-- 이 줄을 html 영역 -->
	<%} %>


<!-- 스크립트릿만 사용하는 경우 2 -->
<%
	if ( 1 + 2 ==3){
		out.println("1 + 2 = 3<br>");
	}
%>

<!-- jstl 사용 -->
<c:if test="${1 + 2 == 3 }">     <!-- if 안에 저렇게 조건을 넣음  EL식으로 들어감 -->
	1 + 2 = 3 : EL 식 사용 가능 <br>

</c:if>

<c:if test = "true">  <!-- 항상 참 -->
true <br>
</c:if>

<c:if test = "<%= 1 + 2 ==3 %>">  <%--표현식 사용 이것도 가능?? --%>
	1 + 2 = 3 : JSP EXPRESSION 식 가능<BR>
</c:if>

<c:if test = " ${1 + 2 !=3 }">

1+ 2 != 3<br>
</c:if>

<hr>
<!-- jstl 에선 c:else 는 따로 없다 대신에 choose, when 을 조합하여 사용한다. -->


<h2> choose , when, otherwise</h2>

<!-- 스크립트릿만 사용하는 경우 너무 드럽고 쓰기 힘들고 보기 힘듬 -->
<% 
	switch(10%2){
	case 0:
	
%>
	짝수입니다<br>
	<%
	break;
	case 1:
	%>
	홀 수 입니다 <br>
	<%
	break;
	default :
	%>
	아무고토 아닙니다<br>
	<%
	}
	%>

<!-- jstl을 사용하는 경우 -->
<c:choose>
	<c:when test = "${10 % 2 ==0 }">
		짝수 입니다.<br>
	</c:when>
	<c:when test = "${10 % 2 ==1 }">
		홀 수 입니다.<br>
	</c:when>
	<c:otherwise>
		아무고토 아닙니다<br>
	</c:otherwise>
</c:choose>
<br><hr>
<h2>for each</h2>

<!-- 스크립트립만 사용하는 경우 -->
<%
	for (int i =0; i<=30; i+=3){
%>
<span> <%= i  %></span>
<% } %>
<br>

<!-- jstl을 사용하는경우 -->
<c:forEach var ="i" begin="0" end="30" step="3">
			<!-- 변수 i , 시작 값 , 끝값 ,  증감식 -->
	${i }

</c:forEach>

<br> <hr>
<c:forEach var ="a" begin="3" end="9" step="1">
	<c:forEach var = "b" begin="1" end="9" step="1">
		${a }*${b}= ${  b * a }
	</c:forEach>
</c:forEach>

<c:set var="intArray" value ="<%= new int[] {1,2,3,4,5} %>"/>
<!-- 직접적으로 1,2,3,4,5 를 배열에 넣어줌 -->

<br><hr>
<c:forEach var="element" items="${intArray }">
<!-- enhance for문 과 비슷하다고 생각하면 편할듯 
		intArray 배열에서 하나식 뽑는것
-->
	${element },  
</c:forEach>
<br><hr>


<!-- intArray 배일 인덱스 2~4 번쨰 값 출력 -->
<c:forEach var="element" items="${intArray }" begin="2" end="4">
	${element },  
</c:forEach>
<br>

<c:forEach var="element" items="${intArray }" begin="2" end="4" varStatus="status">
<!-- intArray 배일 인덱스 2~4 번쨰 loop 정보가 status 변수에 담김 -->

	${status.count} : intArray[${status.index }] = ${element } <br>
	
<!-- 	count 는 몇번째 돌고있는지를 표시해줌    index는 그냥 원래 알던 index -->
</c:forEach>
<br>
<hr>
<!-- '''복수''' 개의 배열 / collection 도 다룰수 있다.  -->
<%
	List<String> myList = new ArrayList<String>();
	myList.add("월");
	myList.add("화");
	myList.add("수");

%>
<!-- arraylist도 배열로 돌려버릴 수 있다 -->

<c:set var = "arr1" value='<%= new String[]{"sun","mon","thu"}%>'/>
<c:set var = "arr2" value='<%= Arrays.asList("월","화","수") %>'/>
<ul>
<c:forEach var="element" items="${arr1 }" varStatus="status">
	<li>${status.index} : ${element } - ${arr2[status.index] }</li>
</c:forEach>
</ul>

<br><hr>

<%
	HashMap<String, Object> hMap = new HashMap<>();
	hMap.put("name", "kelvin");
	hMap.put("age", 27);
	hMap.put("today", new Date());    //오늘 날짜
	
%>
<c:set var="map1" value="<%=  hMap %>"/>
<table>
	<tr><th>key</th><th>value</th></tr>
	<c:forEach var="item" items="${map1 }">
	<tr>
		<td>${item.key }</td>
		<td>${item.value }</td>
		</tr>
	</c:forEach>
</table>



</body>
</html>