<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ page import ="java.io.PrintWriter" 
    		import="com.utill.SHA256"
    		import="com.beans.WriteDAO"
    		import="com.beans.WriteDTO"%>
    
    
    <%

	request.setCharacterEncoding("UTF-8");

	String userID = null;

	String userPassword = null;

	String userEmail = null;

	if(request.getParameter("userID") != null) {

		userID = (String) request.getParameter("userID");

	}

	if(request.getParameter("userPassword") != null) {

		userPassword = (String) request.getParameter("userPassword");

	}

	if(request.getParameter("userEmail") != null) {

		userEmail = (String) request.getParameter("userEmail");

	}

	if (userID == null || userPassword == null || userEmail == null) {

		PrintWriter script = response.getWriter();

		script.println("<script>");

		script.println("alert('입력이 안 된 사항이 있습니다.');");

		script.println("history.back();");

		script.println("</script>");

		script.close();

	} else {

		WriteDAO writeDAO = new WriteDAO();

// 		int result = writeDAO.insert(new WriteDAO(userID, userPassword, userEmail, SHA256.getSHA256(userEmail), "0"));
		int result = writeDAO.insert(userID, userPassword, userEmail, SHA256.getSHA256(userEmail));
		if (result == 0) {

			PrintWriter script = response.getWriter();

			script.println("<script>");

			script.println("alert('이미 존재하는 아이디입니다.');");

			script.println("history.back();");

			script.println("</script>");

			script.close();

		} else {

			session.setAttribute("userID", userID);

			PrintWriter script = response.getWriter();

			script.println("<script>");

			script.println("location.href = 'emailSendAction.jsp';");

			script.println("</script>");

			script.close();

		}

	}

%>