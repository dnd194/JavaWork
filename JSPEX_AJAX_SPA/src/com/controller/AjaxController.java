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
		ajaxAction(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ajaxAction(request, response);
	}

	protected void ajaxAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ajaxAction() 호출 ~");
		request.setCharacterEncoding("utf-8");  
		Command command = null;		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());  
		System.out.println("uri : "+uri);
		System.out.println("conPath"+conPath);
		System.out.println("com : "+com);    
	
//------------------------------------------------------- 기본
		switch(com) {
		case "/list.ajax":		//글 목록 (메뉴목록)
			new ListCommand().execute(request, response);	//한줄 처리 
			new AjaxListCommand().execute(request, response);  //위에서 받아온 REQUEST를 쓰는거
			break;
		case "/view.ajax":		//글 읽기
			new ViewCommand().execute(request, response);
			new AjaxListCommand().execute(request, response);
			break;
		case "/writeOk.ajax":  //글 작성 (메뉴)
			new WriteCommand().execute(request, response);
			new AjaxResultCommand().execute(request, response);
			break;
		case "/updateOk.ajax":  //글 수정 (메뉴)
			new UpdateOkCommand().execute(request, response);
			new AjaxResultCommand().execute(request, response);
			break;
		case "/deleteOk.ajax":  //글 삭제 (메뉴)
			new DeleteCommand().execute(request, response);
			new AjaxResultCommand().execute(request, response);
			break;
		}//end switch 
		
		
	
	
	}

}
