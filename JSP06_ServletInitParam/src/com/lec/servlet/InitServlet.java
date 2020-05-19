package com.lec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(urlPatterns = {"/InitS"},
				initParams = {
						@WebInitParam(name = "id", value = "test11"),
						@WebInitParam(name = "pw", value = "1234"),
						@WebInitParam(name = "local", value = "kkkkorea")
				})
// 이거랑 web.xml 에서 초기화한 값이랑 동시에 사용할 수 없기때문에 둘중하나는 주석처리해줘야한다.
public class InitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
    }

	//초기화 된 parameter 가져오는 함수 ServletConfig
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletConfig 의 메소드를 사용한다.
		String id = getInitParameter("id"); // ==> xml init-param 에서 id 값을 가져옴
		String pw = getInitParameter("pw");
		String local = getInitParameter("local");
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		//html , head, body 다 생략한 상태에서도 됨
		// web.xml에서 초기화한 값들이 찍힌다.
		out.println("id : " + id+ "<br>");
		out.println("pw : " + pw+ "<br>");
		out.println("local : " + local+ "<br>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
