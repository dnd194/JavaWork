package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextPath
 */
@WebServlet("/ConPath")
public class ContextPath extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextPath() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//전부다 request 에서 뽑아냄
		
		//URL : Uniform Resource Locator
		//getRequestURL() 이친구는 StringBuffer를 return 함
		StringBuffer url = request.getRequestURL();
		
		//URI : Uniform Resource Identifier
		String uri = request.getRequestURI();
		
		//ContextPath 추출하기  ==> 실질적인 식별자역할
		String conPath = request.getContextPath();
		
		//domain 추출하기
		String url_domain = request.getScheme() + "://"+request.getServerName()
								+":"+request.getServerPort();
		
		//물리적인 servletContextName는		 '''ContextPath 가 아니다'''
		ServletContext context = request.getServletContext();
		String ServletContextName = context.getServletContextName();
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		out.println("<hr>");
		out.println("URL: "+url +"<br>");
		out.println("URI: "+uri +"<br>");
		out.println("ContextPath: "+conPath +"<br>");
		out.println("url_domain: "+url_domain +"<br>");
		// 아래는  ' / ' (슬래시없이) 이름만 나온다.
		out.println("ServletContext Name: "+ ServletContextName+"<br>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
