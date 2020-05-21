<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.util.*"
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>SessionList</title>
</head>
<body>
<!-- 하나의 session sessionName 과 sessionValue 로 이루어져있어 그리고 고유한 Id도 있지-->
<%
	// 유효한 세션이 있는 확인하는 메서드
	if(request.isRequestedSessionIdValid()){
		out.println("유효한 세션이 있습니다<hr>");
	}else{
		out.println("유효한 세션이 없습니다<hr>");
	}

	String sessionName, sessionValue;
	// 현재 세션들의 모든 name들 뽑기 이거는 그냥 예시용 name들을 다 뽑아주려고하는거임
	Enumeration<String> enumeration = session.getAttributeNames();  //enumeration<String> 타입 return
	int i = 0;
	while(enumeration.hasMoreElements()){  //i 가 0이면 'name' 이 없었다 ~~
		sessionName = enumeration.nextElement();  //Returns: the next element of this enumeration.
		
		sessionValue = session.getAttribute(sessionName).toString();  
	//getAttribute(sessionName) 는 object를 return 해서 toString() 작업을 해줘야한다.  
		out.println((i+1)+"]" + sessionName + " : "+ sessionValue + "<br>");
		i++;
		
	}//end while
	if(i == 0 ){
		out.println("세션(name,value) 값이 없습니다.<br>");
	}
	
			
%>
<hr>
<form action="sessionCreate.jsp">
	<input type="submit" value="세션 생성">
</form>

<br>
<form action="sessionDelete.jsp">
	<input type="submit" value="세션  삭제">
</form>
<hr>
<%
	String sessionId = session.getId(); //세션도 일정시간이 지나면 사라짐
	
	int sessionInterval = session.getMaxInactiveInterval();
	
	out.println("세션 ID : " + sessionId +"<br>");
	out.println("세션 유효시간 : "+sessionInterval+"<br>");
%>
<%
	out.println("--- session.invalidate() 후 --- <br>");
	/* 
			세션테이블 무효화  invalidate
	     	기존의 세션 테이블 삭제 (session id 무효화)
	     		-- 그안의 모든 attribute(이름)도 삭제됨.
	     	새로운 세션 테이블 생성
	     	
	     	아무때나 쓰면 안돼여~~~   그냥 지금은 동작기능만 하려고 하는거
	*/
	session.invalidate();   //지워도 sessionId는 남아있음 테이블을 지운다는 개념인듯
	sessionId = session.getId();
	sessionInterval = session.getMaxInactiveInterval();
	out.println("세션 ID : " + sessionId +"<br>");
	out.println("세션 유효시간 : "+sessionInterval+"<br>");
%>


</body>
</html>