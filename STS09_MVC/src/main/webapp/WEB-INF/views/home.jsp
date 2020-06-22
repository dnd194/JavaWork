<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img src="<%= request.getContextPath() %>/myRes/img/offjo.png"/>
<hr>
<img src="/sts09_mvc/resources/img/offjo.png"/>
<img src="<%= request.getContextPath() %>/resources/img/offjo.png"/>
<img src="${pageContext.request.contextPath }/resources/img/offjo.png"/>
</body>
</html>
