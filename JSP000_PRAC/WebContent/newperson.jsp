<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>신규 등록^^</title>
</head>
<script type="text/javascript">
	function checking(){
		frm = document.forms["frm"];
		
		var name = frm.name.value.trim();
		var age = frm.age.value;
		var intro = frm.intro.value.trim();
		var region = frm.region.value.trim();
		var footsize = frm.footsize.value; 
		if(name ==""){
			alert("어이어이.. 이름은 적으라구");
			frm.name.focus();
			return false;
		}
		
		if(age ==""){
			alert("나이도 적으세요");
			frm.age.focus();
			return false;
		}
		
		if(intro == ""){
			alert("각오");
			frm.intro.focus();
			return false;
		}
		if(region ==""){
			alert("지역");
			frm.region.focus();
			return false;
		}
		if(footsize ==""){
			alert("발크기");
			frm.region.focus();
			return false;
		}
	}

</script>
<body>
<h2>join 하세요^^</h2>
<form method="post" name ="frm" action="newcomplete.jsp" onsubmit="return checking()">
이름 : <input type="text" name="name"><br>
나이 : <input type="number" name="age"><br>
지역 : <input type="text" name="region"><br>
발크기 : <input type="number" name="footsize"><br>
자기소개 : <br>
<textarea name="intro"></textarea><br>
<br>
<input type="submit" value="조인^^">
<br><br>
<input type="button" onclick="location.href('list.jsp')" value="회원목록">

</form>
</body>
</html>