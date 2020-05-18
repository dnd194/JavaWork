package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
//@WebServlet("/He") //이걸 바꾸거나 주석처리하면  서버에서 context 리로딩이 됨 
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("하위^^ 첫번째라구~"); //단순히 확인용 doGet이 동작을 하는지 안하는지
		
//		서블릿으로 HTML 문서 response
//		1. content type 설정     --> 타입을 알려줘야지 동작을 한
//		2. PrintWriter 객체 생성 <-- response 객체로부터
//		3. PrintWriter 객체로 HTML 스트림에 쓰기
		
		response.setContentType("text/html; charset=utf-8"); 
//		text/html 로 해줘야지  아래의 html 코드가 document 형식으로 나옴
//		text/plain 으로 할시에 그냥 텍스트 그대로 나옴 
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html lang='ko'>");
		out.println("<head>");
		out.println("<meta charset='utf-8'>");
		out.println("<title>서블릿타이핑이라구</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>HTML 문서 RESPONSE</h2>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
