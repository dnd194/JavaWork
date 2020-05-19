package com.lec.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCycle
 */
@WebServlet("/Cycle")
public class ServletCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
//	서블릿 생성자   ==> request 될때 생성이 된다. *****단 한번 *****
    public ServletCycle() {
        super();
        System.out.println("서블릿 생성(단 한번 생성됩니다 ^^)");
        System.out.println();
    }

    
//    init() ==>  서블릿 객체 생성 이후(직후) ==>   최초에 단 한번 생성됨
    @Override
    public void init() throws ServletException {
    	System.out.println("init 호출 (이친구도 단 한번 생성됩니다^^");
    	System.out.println("서블릿 객체 생성직후에 생성이됩니다요");
    	System.out.println();
    }

    
//    서블릿 객체가 소멸시 호출됩니다~~  ==> 서버가 종료됬을때  
    @Override
    public void destroy() {
    	System.out.println("destroy 호출  ==> 서블릿 객체가 소멸됬습니다~~ ");
    	System.out.println("서버가 종료됬을때 호출됩니다^^");
    	System.out.println();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 호출");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 호출");
	}
	
	
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("service() 호출됬어요 \n==>(doGet대신에 호출되요~~)");
//	}

}
