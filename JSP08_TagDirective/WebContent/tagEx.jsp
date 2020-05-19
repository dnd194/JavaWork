<%@ page language="java" contentType="text/html; charset=UTF-8"   
	pageEncoding="UTF-8"%>   
	<!-- 지시자 (Directive)   태그  : 페이지에 대한 '''정보''' 나타내는 태그   -->
	<!-- import 속성 : 패키지를 불러옴.  자바의 '''import 와 동일'''하다고 봐도 됨.
 			 
  				
  ** JSP 가 기본으로 import 하는 패키지 : 서블릿 관련 패키지   javax.servlet    javax.servlet.jsp     javax.servlet.http
	 -->
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%   /* 스크립트릿 */
		int sum = 0;
		for (int cnt = 1; cnt <= 100; cnt++) {
			sum += cnt;
		}
		
	%>
	
	1부터 100까지의 합은 : <%= sum %>  	<!-- 저기 안에 자바값이 들어간다. (익스프레션식)-->
	<!-- 스크립팅 요소 태그 (스크립트릿, 익스프레션, 선언부) -->
	 <hr>
	 <h3>오늘의 식단</h3>
	 	 - 김치김밥<br>
	 	 - 참치김밥<br>
	 	 - 유부김밥<br>
	 	 <!-- include directive  -->
	<%@ include file = "test.jsp"%>
	 
</body>
</html>