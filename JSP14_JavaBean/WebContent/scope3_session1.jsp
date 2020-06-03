<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="session"/>
<!-- page 는 scope 의 default 값 -->
<jsp:setProperty name="cnt" property="count"/>
<%-- cnt.setCount(Integer.parseInt(request.getParameter("count"))) 와 같은 동작 --%>

<h3>session1<br>
cnt의 getCount 호출</h3>

<jsp:getProperty name = "cnt" property="count"/><br>
<%-- cnt.getCount() 호출 --%>
<a href="scope3_session2.jsp"> session2로 이동</a>

<%-- <jsp:forward page="scope3_session2.jsp"></jsp:forward> --%>

