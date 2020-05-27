package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.write.AjaxListCommand;
import com.command.write.Command;
import com.command.write.ListCommand;

@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public AjaxController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}
	
	protected void ajaxAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajaxAction() 호출 ^^");
		
		request.setCharacterEncoding("utf-8");  //post 방식으로 올수도있어서 해주는 작업??
		
		//컨트롤러는 다음 2개를 선택해야한다.
		String viewPage = null;     //어떠한 뷰 인지
		Command command = null;		//어떠한 커맨드인지  

		//		이러한 정보는 URL에 담겨져있음 그래서 URL을 찢어내야함 ==> ContextPath, Command 분리
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());  //실질적인 식별자 무슨 행동을 할지
		
		//어떻게 찢어지는지 test 용 출력
		System.out.println("uri : "+uri);
		System.out.println("conPath"+conPath);
		System.out.println("com : "+com);    
		
		//컨트롤러는 커맨드 (=com)에 따라 , 로직을 수행하고
		//결과를 내보낼 view를 결정한다.
		
		switch (com) {
		case "/list.ajax":     //글 목록 ajax 요청
			
			// 글 목록읽기
			new ListCommand().execute(request, response);   //여기서 받아서
			new AjaxListCommand().execute(request, response);   //여기로 넘겨줌
			
			
			break;

		default:
			break;
		}//and switch
	}
	
	

}
