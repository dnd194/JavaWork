<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>쿠키 리스트</title>
</head>
<body>
<%
	//사용자 컴퓨터 안의 쿠기 정보는 request 시에 서버로 전달된다.
	//request 객체의 getCookies() 로 쿠키를 받아온다.
	// request.getCookies()  ==> 배열을 return 한다.
			// key , value 로 이루어져 있다.
	
	Cookie[] cookies = request.getCookies();  //Cookie[] 배열을 리턴
	
	if(cookies != null){    //만역 쿠키가 하나도 없다면... null을 리턴함
		for(int i = 0; i<cookies.length; i++){  
			//배열이니까 for 문을 돌림
			String cookieName = cookies[i].getName(); 	//쿠키 이름
			String cookieValue = cookies[i].getValue();  //쿠키 값
					
			//내장 객체 사용
			out.println((i+1)+"]"+cookieName + " : -->"+cookieValue + "<br>"); 
			//처음에는 없다가 다시 get 하면 tomcat의 쿠키가 찍힌다. JSESSIONID
		}//end for
	}else{
		out.println("쿠키가 없습니다~~<br>");
	}
%>
<hr>
<form action="cookieCreate.jsp">
	<input type="submit" value = "쿠키생성  & 갱신">
</form>
<br>
<form action="cookieDelete.jsp">
	<input type="submit" value = "쿠키 삭제 ">
</form>
</body>
</html>