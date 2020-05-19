<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta name = "viewport" content="width=device-width, initial-scale=1.0">
<title>forward</title>
</head>
<body>
<h1>URL 과 페이지의 내용을 주의깊게 봐주세요^^</h1>
<!-- Action Tag -->
<h3>지금의 페이지는 forward 페이지 랍니다~~~</h3>


<jsp:forward page="sub.jsp"/> <!-- 단독태그로 만들어줌 -->
<p>위 라인의 내용은 sub 페이지의 내용입니다.</p>



</body>
</html>