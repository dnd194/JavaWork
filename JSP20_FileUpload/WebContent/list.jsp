<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.sql.*" import="java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- JSTL 버전으로 바뀌니, import 번잡함도 사라진다 . java 변수 선언도 사라진다. -->

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

		<c:choose>
			<c:when test="${empty list || fn:length(list) == 0 }">
				<!-- 			배열이 비어있거나 있긴있지만 길이가 0개 짜리 배열일때를 체크 -->
			</c:when>
			<c:otherwise>
				<c:forEach var ="dto" items="${list }">
					<tr>
					<td>${dto.uid }</td>
					<td><a href="view.do?uid=${dto.uid }">${dto.subject }</a></td>
					<td>${dto.name }</td>
					<td>${dto.viewCnt }</td>
					<td>${dto.regDate }</td>
				</tr>
				</c:forEach>
			</c:otherwise>

		</c:choose>


	</table>
	<br>
	<button onclick="location.href('write.do')">신규 등록</button>

</body>
</html>