<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.io.PrintWriter"%>

<%@page import="com.utill.SHA256"%>

<%@page import="com.beans.WriteDAO"%>

/* 변경사항 String은 equals로 비교할것. == .equals     import *로 바꿈 다른 */

<%

	 request.setCharacterEncoding("UTF-8");

	String code = request.getParameter("code");

	WriteDAO writeDAO = new WriteDAO();

	String userID = null;

	if(session.getAttribute("userID") != null) {

		userID = (String) session.getAttribute("userID");

	}

	if(userID == null) {

		PrintWriter script = response.getWriter();

		script.println("<script>");

		script.println("alert('로그인을 해주세요.');");

		script.println("location.href = 'userLogin.jsp'");

		script.println("</script>");

		script.close();


	}

	String userEmail = writeDAO.getUserEmail(userID);

// 	String rightCode = (new SHA256().getSHA256(userEmail).equals(code)) ? "1" : "0";
	String rightCode = (new SHA256().getSHA256(userEmail).equals(code)) ? "1" : "0";  
	
	
	if(rightCode.equals("1")) {

		writeDAO.setUserEmailChecked(userID);

		PrintWriter script = response.getWriter();

		script.println("<script>");

		script.println("alert('인증에 성공했습니다.');");

		script.println("location.href = 'index.jsp'");

		script.println("</script>");

		script.close();


	} else {

		PrintWriter script = response.getWriter();

		script.println("<script>");
		

		script.println("alert('유효하지 않은 코드입니다.');");

		script.println("location.href = 'userLogin.jsp'");

		script.println("</script>");

		script.close();		

	} 
%>