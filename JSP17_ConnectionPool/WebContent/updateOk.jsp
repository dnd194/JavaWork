<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/>

<% // parameter 받아오기
	request.setCharacterEncoding("utf-8");  // 한글 인코딩 꼭!
	int uid = Integer.parseInt(request.getParameter("uid"));
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	// ※ 이 단계에서 parameter 검증 필요
%>
<% // DAO 사용한 트랜잭션
	int cnt = dao.update(uid, subject, content);
%>    

<% if(cnt == 0){ %>
	<script>
		alert('수정 실패');
		history.back();
	</script>
<% } else { %>
	<script>
		alert('수정 성공');
		location.href = "view.jsp?uid=<%= uid%>";
	</script>
<% } %>
















