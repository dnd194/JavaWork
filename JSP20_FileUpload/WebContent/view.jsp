<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:choose>
	<c:when test="${empty view || fn:length(view) == 0 }">
		<script>
				alert("해당정보가 삭제되었거나 없다리");
				history.back();
			</script>
	</c:when>
	<c:otherwise>




		<!DOCTYPE html>
		<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>게시글 읽기 (${view[0].subject })</title>
<!-- title에 글 제목 넣기 -->
</head>
<script>
	function chkDelete(uid){
		//삭제 여부, 다시 확인하고 진행하기
		var r = confirm("삭제하시겠습니까??");
		if(r){  //삭제하기버튼을 눌렀을때 동작
				location.href="deleteOk.do?uid="+uid;
		}
		
	}
</script>
<body>
	<h2>
		읽기
		${view[0].subject }</h2>
	<br> UID :
	${view[0].uid }<br> 작성자 :
	${view[0].name }<br> 제목 :
	${view[0].subject }<br> 등록일 :
	${view[0].regDate }<br> 조회수 :
	${view[0].viewCnt }<br>
	<hr>
	내용 :
	<br>
	<div>
		${view[0].content }
	</div>
	<hr>
	<!-- 첨부파일 및 다운로드 링크 -->
	<c:if test="${fn:length(file) > 0 }">
		<h4>첨부파일</h4>
		<ul>
			<c:forEach var = "element" items="${file }">
				<li><a href="download.do?uid=${element.uid}">${element.source }</a></li>
			</c:forEach>
			
			<!-- 이미지인 경우 보여주기 -->
			<c:forEach var = "element" items="${file }">
				<c:if test="${element.image == true }">
					<div style="width : 300px">
						<img style="width:100%; height:auto;"
						src="upload/${element.file }"/>
					</div>
				</c:if>
			
			</c:forEach>
			
			
		</ul>
	</c:if>
	
	
	
	<br>
	<button onclick="location.href='update.do?uid=${view[0].uid }'">수정하기</button>
	<button onclick="location.href='list.do'">목록보기</button>
	<button onclick="chkDelete(${view[0].uid })">삭제하기</button>
	<button onclick="location.href='write.do'">신규등록</button>
</body>
		</html>
		
	</c:otherwise>
</c:choose>
