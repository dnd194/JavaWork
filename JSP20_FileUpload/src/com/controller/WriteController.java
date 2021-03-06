package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.Command;
import com.command.DeleteCommand;
import com.command.DownloadCommand;
import com.command.ListCommand;
import com.command.UpdateCommand;
import com.command.UpdateOkCommand;
import com.command.ViewCommand;
import com.command.WriteCommand;


@WebServlet("*.do")
//* 자리에 아무거나 와도 .do 로 만 끝나면 actionDo() 가 실행이 됨
public class WriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public WriteController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
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
		
		//어떻게 찢어지는지 test 용 출력
		System.out.println("uri : "+uri);
		System.out.println("conPath"+conPath);
		System.out.println("com : "+com);    
		
		//컨트롤러는 커맨드 (=com)에 따라 , 로직을 수행하고
		//결과를 내보낼 view를 결정한다.
		
		switch(com) {
		case "/list.do":
			command = new ListCommand();
			command.execute(request, response);
			viewPage = "list.jsp"; 	//포워딩할 jsp 선택
			
			break;
			
		case "/write.do":
			viewPage = "write.jsp";
			break;
		
		case "/writeOk.do":
			command = new WriteCommand();
			command.execute(request, response);
			viewPage = "writeOk.jsp";   //포워딩할 jsp 선택
			break;
		case "/view.do":
			command = new ViewCommand();
			command.execute(request, response);
			viewPage = "view.jsp";
			break;
		case "/update.do":
			command = new UpdateCommand();
			command.execute(request, response);
			viewPage = "update.jsp";
			break;
		case "/updateOk.do":
			command = new UpdateOkCommand();
			command.execute(request, response);
			viewPage = "updateOk.jsp";
			break;
		case "/deleteOk.do":
			command = new DeleteCommand();
			command.execute(request, response);
			viewPage = "deleteOk.jsp";
			break;
			
		case "/download.do":
			command = new DownloadCommand();
			command.execute(request, response);
			//view가 필요치 않다.
			break;
		
		}//end switch
		
		if(viewPage != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
		
		
	}//end actiondo
}











