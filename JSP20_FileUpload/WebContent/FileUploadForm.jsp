<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>파일업로드 FORM</title>
</head>
<body>
<h2>파일업로드 FORM</h2>
<form action="FileUpload.jsp" method="post" 
	enctype="Multipart/form-data">
	<hr>
	이름: <input type="text" name="name"><br>   <%-- part: parameters --%>
	제목: <input type="text" name="title"><br>
	<hr>	
	파일1: <input type="file" name="file1"><br> <%-- part: file1 --%>
	<hr>
	파일2: <input type="file" name="file2"><br> <%-- part: file2 --%>
	<br>
	<input type="submit" value="전송"/>
</form>
</body>
</html>

