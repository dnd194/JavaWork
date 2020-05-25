<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<c:choose>
	<c:when test="${updateOk ==0 }">
		<script>
			alert("수정실패~~");
			history.back(); //브라우저가 기억하는 직전 페이지
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("수정 성공, 수정된 리스트를 '다시' 출력합니다~~");
			location.href="view.do?uid=${param.uid}";
		</script>
	</c:otherwise>
</c:choose>




