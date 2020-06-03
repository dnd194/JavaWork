<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 처리만 하는 페이지임 -->

<%!
	public static final String ADMIN_ID ="admin";
	public static final String ADMIN_PW ="1234";
%>
<%
	String userid = request.getParameter("userid");
	String pw = request.getParameter("pw");
	
	String cookieName = "userid";
	String cookieValue = userid;  //로그인 성공시 admin이 담겨져있음
	
	//userid 와 pw 가 일치하면 로그인성공 + 쿠키생성
	//id 는 대소문자 관계없이   ,,,,  pw 는 대소문자 구분
	if(ADMIN_ID.equalsIgnoreCase(userid) && (ADMIN_PW.equals(pw))){
		 out.println("<script>");
		 out.println("alert('로그인 성공')");
		 out.println("</script>");
		 
		 Cookie cookie = new Cookie(cookieName, cookieValue);
		 cookie.setMaxAge(2*30);  //1분으로 세팅
		 response.addCookie(cookie);
	}else{
		 out.println("<script>");
		 out.println("alert('로그인 실패')");
		 out.println("</script>");
		 
		 Cookie cookie = new Cookie(cookieName, cookieValue);
		 cookie.setMaxAge(0);  //쿠키 삭제 , 기존에 있었더라도 삭제.
		 response.addCookie(cookie);  //만료시간이 0초인 쿠키를 추가 
	}//end if
%>
<script>
	location.href("login.jsp")
</script>