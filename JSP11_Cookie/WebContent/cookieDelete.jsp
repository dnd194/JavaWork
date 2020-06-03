<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String cookieName = "num1";
	
	if(cookies != null){
		for(int i = 0 ; i<cookies.length; i++){
			
			//num1 이라는 쿠키가 있으면 쿠키를 삭제 
			if(cookieName.equals(cookies[i].getName())){
				cookies[i].setMaxAge(0); 
				//클라이언트 쪽에서 죽여야함
				//만료시간을 0으로 해주면 바로 죽음
				response.addCookie(cookies[i]);
				//response 직후 곧바로 삭제됨 (만료시간이 0초 라서)
			}
		}
	}
%>
<script>
	alert("<%= cookieName%> 삭제");
	location.href("cookieList.jsp");
</script>