<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/> <%-- DAO bean 생성 --%>

<% // parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	// ※ 이 단계에서 parameter 검증 필요
%>

<% // DAO 사용한 트랜잭션
	int cnt = dao.deleteByUid(uid);
%>   

<% if(cnt == 0){ %>
	<script>
		alert('삭제 실패');
		history.back();
	</script>
<% } else { %>
	<script>
		alert('삭제 성공');
		location.href = "list.jsp";  <%-- 삭제후에는 list 로 가자 --%>
	</script>
<% } %>
















