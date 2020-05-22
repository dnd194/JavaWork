<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="com.lec.beans.*" %>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/>

<%  // parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// ※ 이 단계에서 parameter 검증 필요
%>

<% // dao 사용한 트랜잭션
	WriteDTO [] arr = dao.readByUid(uid);
%>

<%
	if(arr == null || arr.length == 0){ 
%>
			<script>
				alert("해당 정보가 삭제되거나 없습니다");
				history.back();
			</script>
<%
		return;   // 더이상 JSP 프로세싱 하지 않고 종료
	} // end if
%>
<%
	String name = arr[0].getName();
	String subject = arr[0].getSubject();
	String content = arr[0].getContent();
	String regDate = arr[0].getRegDate();
	int viewCnt = arr[0].getViewCnt();
%>



<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>읽기 <%= subject %></title> <!-- title에 글제목 넣기 -->
</head>
<script>
function chkDelete(uid){
	// 삭제 여부, 다시 확인 하고 진행하기
	var r = confirm("삭제하시겠습니까?");
	if(r){
		location.href = 'deleteOk.jsp?uid=' + uid;
	}
}
</script>
<body>
<h2>읽기 <%= subject %></h2>
<br>
UID : <%= uid %><br>
작성자 : <%= name %><br>
제목 : <%= subject %><br>
등록일 : <%= regDate %><br>
조회수 : <%= viewCnt %><br>
내용: <br>
<hr>
<div>
<%= content %>
</div>
<hr>
<br>
<button onclick="location.href='update.jsp?uid=<%= uid%>'">수정하기</button>
<button onclick="location.href = 'list.jsp'">목록보기</button>
<button onclick="chkDelete(<%= uid %>)">삭제하기</button>
<button onclick="location.href = 'write.jsp'">신규등록</button>

<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
</body>
</html>















