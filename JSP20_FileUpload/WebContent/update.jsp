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
		onsubmit="return chkSubmit()" enctype = "Multipart/form-data">
		<!-- 수정단계에서 파일추가 가능 Multipart request  -->
		<input type="hidden" name="uid" value="${update[0].uid }" /> 작성자 :
		${update[0].name }<br>
		<!-- 작성자 이름 변경 불가 -->
		제목 : <input type="text" name="subject" value="${update[0].subject }" /><br>
		내용 : <br>
		<textarea name="content">${update[0].content }</textarea>
		<br> 
		<!-- 첨부파일 목록(삭제대상) -->
		<c:if test="${fn:length(file)>0  }">
			<div style="background:#dddddd; padding:2px 10px; margin-bottom:5px; border:1px solid black;">
				<h4>첨부파일 - 삭제할 것에 체크하세여</h4>
				<div id="delFiles"></div>
				<c:forEach var="element" items="${file }">
					<div>
						<button type="button" onclick="deleteFiles(${element.uid}); $(this).parent().remove();">삭제</button> ${element.source }
					</div>
				</c:forEach>
			</div>
		</c:if>
		<script>
			function deleteFiles(fileUid){
				//삭제할 file의 bf_uid 값 들을 delfile에 담아 submit한다.
				$("#delFiles").append("<input type='hidden' name ='delfile' value='"+fileUid+"'>");
			}
		</script>
		
		
		
		
		
		<!-- 첨부파일 (추가) -->
		<div style="background:#dddddd; padding:2px 10px; margin-bottom:5px; border:1px solid black;">
			<h4>첨부파일</h4>
			<button type="button" id="btnAdd">추가</button>
			<div id="files"></div>
		</div>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
		<script>
			var i = 0;
			$('#btnAdd').click(function(){
			$('#files').append("<div><input type='file' name='upfile"+i+"'/>&nbsp;<button type='button' onclick='$(this).parent().remove()'>삭제 </button> </div>");
			i++;
			});
		</script>
		
		<input type="submit" value="수정" />

	</form>
	<button onclick="history.back()">이전으로</button>
	<button onclick="location.href='list.do'">목록보기</button>

</body>
</html>