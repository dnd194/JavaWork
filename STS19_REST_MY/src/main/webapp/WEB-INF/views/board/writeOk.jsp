<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" 
    import = "java.sql.*"  
%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${result == 0 }">
		<script>
			alert("등록실패~~");
			history.back();  //브라우저가 기억하는 직전 페이지
		</script>
	
	</c:when>
	
	<c:otherwise>
		<script>
			alert("등록 성공, 리스트를 출력합니다~~");
			location.href("list.do");  //브라우저가 기억하는 직전 페이지
		</script>
	
	</c:otherwise>
</c:choose>
 
	




