<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>로그인 페이지 입니다~</title>
</head>
<body>
<%!
	int i = 0 ; 
%>
<%
	Cookie[] cookies = request.getCookies();  // 쿠키를 꺼내서 배열에 담는다.
	String cookieName = "userid";   //로그인성공하면 발급되는 쿠키이름
	if(cookies != null){
		for(i = 0; i<cookies.length; i++){
			//배열로 오기때문에 어쩔 수 없이 일단 다한번 돌여야함
			if(cookieName.equals(cookies[i].getName())){   // <==
				break; //발견하면 break;
			}//end if 
		}//end for
	}
%>
<%
	if(cookies == null || i==cookies.length){  %>
		<!-- 로그인 상태가 아닐때 -->
		<h2> 로그인 상태가 아닙니다.</h2>
		<form action="loginOk.jsp">
			id : <input type="text" name="userid"><br>
			pw : <input type="password" name ="pw"><br>
			<input type="submit" value="로그인"><br>
		</form>
	<% }else{ %>   <!-- 안에 html 코드를 넣어주기 위해서 다음과 같이 디렉티브 태그를 닫아줌 -->
		<!-- 로그인 상태일때  -->
		<h2> 로그인 상태입니다.</h2>
		<form action="logout.jsp">
			<input type="submit" value="로그인"><br>
		</form>
<% 	}  %>

</body>
</html>