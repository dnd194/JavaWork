<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="cnt" class="com.lec.beans.CountBean" scope="page"/>
<b>cnt 의 getCount 호출</b><br>
<jsp:getProperty name="cnt" property="count"/>

<a href="scope1_page1.jsp">page1 로 갑니다..</a>