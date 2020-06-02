<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<script>
	function chkSubmit(){
		frm = document.forms["frm"];	//form 객체 가져오기
		
		var name = frm.name.value.trim();  			//작성자
		var subject = frm.subject.value.trim();		//제목
		
		if(name == ""){
			alert("작성자 란은 반드시 입력해야 합니다.");
			frm.name.focus();
			return false;
		}
		
		if(subject == ""){
			alert("제목은 반드시 작성해야합니다");
			frm.subject.focus();
			return false;
		}
		
	}
</script>

<body>
<h2>글작성</h2>
<%-- 글 내용이 많을수 있기 때문에 POST 방식 사용 --%>
<form name="frm" action="writeOk.do" method="post" onsubmit="return chkSubmit()"
enctype="Multipart/form-data">
<!-- content 의 사이즈가 얼마나 커질지 모르기 때문에 form 의 method 방식은 post 방식으로 한다. -->
작성자:
<input type="text" name="name"/><br>
제목:
<input type="text" name="subject"/><br>
내용:<br>
<textarea name="content"></textarea>
<br><br>
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
<input type="submit" value="등록"/>
</form>
<br>
<button type="button" onclick="location.href='list.do'">목록으로</button>
</body>
</html>