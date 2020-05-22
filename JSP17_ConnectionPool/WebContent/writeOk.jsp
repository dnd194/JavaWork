<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="dao" class="com.lec.beans.WriteDAO"/> <%-- DAO bean 생성 --%>

<%
	request.setCharacterEncoding("utf-8");  // 한글 인코딩 꼭!
%>
<jsp:useBean id="dto" class="com.lec.beans.WriteDTO"/>
<jsp:setProperty property="*" name="dto"/>

<%--
<%
	request.setCharacterEncoding("utf-8");  // 한글 인코딩 꼭!
	// 입력한 값 받아오기			
	String name = request.getParameter("name");
	String subject = request.getParameter("subject");
	String content = request.getParameter("content");
	
	// 유효성 체크, 
	// name, subject 는 비어있으면 안된다. NN
	// null 이거나 빈 문자열이면 이전화면으로 돌아가기
	if(name == null || subject == null ||
		name.trim().equals("") || subject.trim().equals("")){
%>
		<script>
			alert("작성자 이름, 글제목은 필수 입니다!");
			history.back();   // history.go(-1);
		</script>
<%		
		return;    // ★ 더 이상 JSP 프로세싱 하지 않도록 종료 ★
	}
%>
 --%>

<%
	// DAO 사용한 트랜잭션
	//int cnt = dao.insert(subject, content, name);
	int cnt = dao.insert(dto);
%>

<% if(cnt == 0){ %>
		<script>
			alert("등록 실패!!!!!!");
			history.back();   // 브라우저가 기억하는 직전 페이지(입력중 페이지로)
		</script>
<% } else { %>
		<script>
			alert("등록 성공, 리스트를 출력합니다");
			location.href = "list.jsp";
		</script>

<% } %>













































