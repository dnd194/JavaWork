<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "java.util.*"
    import = "java.text.*"
    %>
<%
		/* 첫번째 세션  */
	String sessionName1 = "num1";
			/* 0~9 까지의 랜덤 변수  */
	String sessionValue1 = ""+(int)(Math.random()*10);
	
	//세션 생성
	session.setAttribute(sessionName1, sessionValue1);
	/* 			name 과 value 쌍으로 이루어져 있다.		 */
			
			
			
	/*  2번째 세션  */
	String sessionName2 = "datetime";
	String sessionValue2 = new SimpleDateFormat("yyyyMMddHHmmss")
									.format(new Date());
	
	session.setAttribute(sessionName2, sessionValue2);
	/* 			name 과 value 쌍으로 이루어져 있다.		 */
%>
<script>
alert("<%= sessionName1 %>, <%= sessionName2%> 세션 생성");
location.href="sessionList.jsp";
</script>