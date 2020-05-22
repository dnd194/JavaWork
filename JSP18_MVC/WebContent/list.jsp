<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="java.text.*"
	import="com.lec.beans.*"%>

<%
	//controller 로 부터 결과 데이터를 받는다.
	WriteDTO[] arr = (WriteDTO[])request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 목록</title>
<style>
table {
	width: 100%;
}

table, th, td {
	border: 2px solid lightpink;
	border-collapse: collapse;
}
</style>
</head>
<body>

	<hr>
	<h2>리스트</h2>
	<table>
		<tr>
			<th>UID</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<%
			if(arr != null){
				for (int i =0; i<arr.length; i++){
		%>
				<tr>
				<td><%= arr[i].getUid() %></td>
				<td><a href="view.do?uid=<%= arr[i].getUid()%>"><%=arr[i].getSubject() %></a></td>
				<td><%= arr[i].getName() %></td>
				<td><%= arr[i].getViewCnt() %></td>
				<td><%= arr[i].getRegDate() %></td>
				</tr>
		
		<% 
				}//end for
			}
		%>

	</table>
	<br>
	<button onclick="location.href('write.do')">신규 등록</button>

</body>
</html>