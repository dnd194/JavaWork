package com.lec.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
	
	
	
	//웹어플리케이션(context) 시작할 때 호출  ==> 서버가 가동될 때 호출이 됩니다
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		System.out.println("서버가 start할때 시작이 되는거야");
		System.out.println("JSP07 Application 시작");
		System.out.println();
	}
	
	
	
	//웹어플리케이션(context) 종료될 때 호출
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		ServletContextListener.super.contextDestroyed(sce);
		System.out.println("서버가 Stop되면 종료되는거야");
		System.out.println("JSP07 Application 종료");
		System.out.println();
	}
	
	
}
