<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.net.*" %> <%-- URLEncoder 외 --%>

<%-- JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  

<% request.setCharacterEncoding("utf-8"); %>

<%-- parameter 받기 : Java --%>
<%
	String [] originalFileNames = request.getParameterValues("originalFileName");
	String [] fileSystemNames = request.getParameterValues("fileSystemName");
	int cnt = originalFileNames.length;
%>

<%-- parameter 받기 : JSTL --%>
<c:set var="originalFileNames" value="${paramValues.originalFileName }"/>
<c:set var="fileSystemNames" value="${paramValues.fileSystemName }"/>
<c:set var="cnt" value="${fn:length(paramValues.originalFileName) }"/>

    
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>파일 확인 & 다운로드 링크</title>
<style>
form p {text-decoration: underline;}
form p:hover {cursor: pointer; color:blue;}
</style>
</head>
<body>
<%-- Java 방식 --%>
<h3><%= cnt %>개의 파일 확인</h3>
<ul>
<%
	for(int i = 0; i < cnt; i++){
		out.println("<li>파일: " + (i + 1) + "</li>");
		out.println("<ul>");
		out.println("<li>원본이름: " + originalFileNames[i] + "</li>");
		out.println("<li>파일시스템: " + fileSystemNames[i] + "</li>");
		out.println("</ul>");
	}
%>
</ul>

<%-- JSTL 방식 --%>
<h3>${cnt } 개의 파일 확인</h3>
<ul>
<c:forEach var="i" begin="0" end="${cnt - 1 }" varStatus="status">
	<li>파일: ${i + 1 }</li>
	<ul>
		<li>원본이름: ${originalFileNames[status.index] }</li>
		<li>파일시스템: ${fileSystemNames[status.index] }</li>
	</ul>
</c:forEach>
</ul>

<hr>

<%-- GET방식 request시 url 에  한글이나 띄어쓰기 등이 들어가선 안되기 때문에 반드시 URLEncoder 로 처리 해야 한다
X ] /FileDownload.jsp?fileSystemName=8퍼센트.ipynb
O ] /FileDownload.jsp?fileSystemName=8%ED%8D%BC%EC%84%BC%ED%8A%B8.ipynb
java.net.URLEncoder  임포트!
--%>
<h3>다운로드링크1: get + Java</h3>
<% for(int i = 0; i < originalFileNames.length; i++){ %>
	<%-- 화면에는 원본이름으로, 실제 링크는 업로드 저장된 이름으로 --%>
	<%
		String fname = URLEncoder.encode(fileSystemNames[i], "utf-8");
		String oname = URLEncoder.encode(originalFileNames[i], "utf-8");
	%>
	<a href="FileDownload.jsp?fileSystemName=<%= fname%>&originalFileName=<%= oname%>">
		<%= originalFileNames[i] %>
	</a>
	<br>
<% } %>

<h3>다운로드링크2: post + Java</h3>
<% for(int i = 0; i < originalFileNames.length; i++){ %>
<form name="frm<%=i %>" action="FileDownload.jsp" method="post">
	<input type="hidden" name="fileSystemName"
		value="<%= fileSystemNames[i] %>"/>
	<input type="hidden" name="originalFileName"
		value="<%= originalFileNames[i] %>"/>
	<p onclick="document.forms['frm<%=i%>'].submit()">
	<%= originalFileNames[i] %>
	</p>
</form>
<% } %>

<h3>다운로드링크3: post + JSTL</h3>
<c:forEach var="i" begin="0" end="${cnt -1 }">
<form name="ifrm${i }" action="FileDownload.jsp" method="post">
	<input type="hidden" name="fileSystemName"
		value="${fileSystemNames[i] }"/>
	<input type="hidden" name="originalFileName"
		value="${originalFileNames[i] }"/>
	<p onclick="document.forms['ifrm${i }'].submit()">
	${originalFileNames[i] }
	</p>
</form>
</c:forEach>

<hr>
<%--
	웹 경로에 이미지 저장한 경우
 --%>
<h3>이미지 보기</h3>
<% for(int i =0; i<originalFileNames.length; i++) {%>
<div style="width:300px">
	<img style="width:100%"; heigth="auto" src="upload/<%=fileSystemNames[i] %>"/>
</div>

<%} %>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>

