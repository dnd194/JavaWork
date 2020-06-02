<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:choose>
	<c:when test="${empty update || fn:length(update) == 0 }">
		<script>
			alert("해당정보가 삭제되었거나 없다리");
			history.back();
		</script>
	</c:when>
	<c:otherwise>
	</c:otherwise>
</c:choose>


<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>수정 ${update[0].subject }</title>
<script src="ckeditor/ckeditor.js"></script>
</head>
<script>
	function chkSubmit() {
		frm = document.forms['frm'];
		var subject = frm.subject.value.trim();

		if (subject == "") {
			alert("제목은 반드시 작성해야합니다");
			frm.subject.focus();
			return false;
		}
		return true;
	}
</script>
<body>
	<form name="frm" action="updateOk.do" method="post"
		onsubmit="return chkSubmit()">
		<input type="hidden" name="uid" value="${update[0].uid }" /> 작성자 :
		${update[0].name }<br>
		<!-- 작성자 이름 변경 불가 -->
		제목 : <input type="text" name="subject" value="${update[0].subject }" /><br>
		내용 : <br>
		<textarea name="content" id="editor1">
	${update[0].content }
</textarea>
<script>CKEDITOR.replace('editor1',{
	allowedContent : true,
	filebrowserUploadUrl:'${pageContext.request.contextPath}/fileUpload.do'
})
</script>
		<br> <input type="submit" value="수정" />

	</form>
	<button onclick="history.back()">이전으로</button>
	<button onclick="location.href('list.do')">목록보기</button>

</body>
</html>