<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>version</title>
</head>
<body>
<h3>버젼확인</h3>
 - 서버 : <%=application.getServerInfo() %> <br>
 - 서블릿 : <%= application.getMajorVersion() %>.<%= application.getMinorVersion() %><br>
 - JSP : <%= JspFactory.getDefaultFactory().getEngineInfo().getSpecificationVersion() %>
</body>
</html>

