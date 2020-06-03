<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	public static final String ADMIN_ID ="admin";
	public static final String ADMIN_PW ="1234";
%>
<%
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	String sessionName = "userid";
	String sessionValue = userid;  //로그인 성공시 admin이 담겨져있음
	
	//userid 와 pw 가 일치하면 로그인성공 + 쿠키생성
	//id 는 대소문자 관계없이   ,,,,  pw 는 대소문자 구분
	if(ADMIN_ID.equalsIgnoreCase(userid) && (ADMIN_PW.equals(pw))){
		 out.println("<script>");
		 out.println("alert('로그인 성공')");
		 out.println("</script>");
		 
		 session.setAttribute(sessionName, sessionValue);
		 
	}else{
		 out.println("<script>");
		 out.println("alert('로그인 실패')");
		 out.println("</script>");
		 
		 //혹시 있을지 모르는 세션 삭제
		 session.removeAttribute(sessionName);
		 
	}//end if
%>
<script>
	location.href("login.jsp")
</script>