package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.*;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AjaxController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("actionDo() 호출 ~");
		
		request.setCharacterEncoding("utf-8");  //post 방식으로 올수도있어서 해주는 작업??
		
		//컨트롤러는 다음 2개를 선택해야한다.
		String viewPage = null;     //어떠한 뷰 인지
		Command command = null;		//어떠한 커맨드인지  

		//		이러한 정보는 URL에 담겨져있음 그래서 URL을 찢어내야함 ==> ContextPath, Command 분리
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());  //실질적인 식별자 무슨 행동을 할지
		
		switch(com) {
		case "/list.ajax":
			new ListCommand().execute(request, response);
			new AjaxListCommand().execute(request, response);
			break;
		
		
		
		
		
		}
	
	
	
	}
	
}
