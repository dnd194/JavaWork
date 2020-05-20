<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.text.*" 
    import = "java.util.*"
 %>
    
<%
	String cookieName1 = "num1";
	//0~9 까지의 정수형을 담고 자동형변환 (String)으로
	String cookieValue1 = ""+(int)(Math.random()*10);
	
	//쿠기는 이름과 값으로 구성
	Cookie cookie1 = new Cookie(cookieName1, cookieValue1);  
	cookie1.setMaxAge(2*30);  //쿠키만료 시간설정 (생성시점으로부터 2*30 초후)
	
	//생성된 쿠키는 response 에 담겨져있음 정보추가
	response.addCookie(cookie1); 
%>
<%
		String cookieName2 ="datetime";
		String cookieValue2 = new SimpleDateFormat("yyyyMMddHHmmss")
				.format(new Date());
		Cookie cookie2 = new Cookie(cookieName2, cookieValue2);
		cookie2.setMaxAge(30);
		response.addCookie(cookie2);
		
%>
<script>
	alert("<%= cookieName1 %>, <%=cookieName2%> 쿠키 생성" );
	location.href="cookieList.jsp";
</script>