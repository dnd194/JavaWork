package com.lec.sts18_security.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	//request, response 를 매개변수로 받기 때문에, 서블릿 api 직접이용하여 handle 가능
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {

		System.out.println("AccessDeniedHandler()");
		System.out.println("redirect 합니다~");
		response.sendRedirect(request.getContextPath()+"/accessError");
		
	}

}
