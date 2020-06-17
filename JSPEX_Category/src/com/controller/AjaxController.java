package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.command.AjaxListCommand;
import com.command.CateListCommand;
import com.command.Command;


/**
 * Servlet implementation class AjaxController
 */
@WebServlet("*.ajax")
public class AjaxController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AjaxController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			//cate_list.ajax 처리해주세염
		request.setCharacterEncoding("utf-8");  
		Command command = null;		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());  
		System.out.println("uri : "+uri);
		System.out.println("conPath"+conPath);
		System.out.println("com : "+com);    
		
		switch(com) {
		case "/cate_list.ajax":		//글 목록 (메뉴목록)
			new CateListCommand().execute(request, response);	//한줄 처리 
			new AjaxListCommand().execute(request, response);  //위에서 받아온 REQUEST를 쓰는거
			break;
		}
			
	}
	
}
