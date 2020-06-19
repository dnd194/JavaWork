package com.lec.spring.property2.xml;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class PropertyMain2 {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = 
					new GenericXmlApplicationContext("classpath:appCtx2.xml");
		System.out.println(" -- ctx 생성 -- ");
		
		DBConn conn = ctx.getBean("dbConnection",DBConn.class);
		System.out.println("admin.id : "+conn.getId());
		System.out.println("admin.pw : "+conn.getPw());
		System.out.println("admin.url : "+conn.getUrl());
		System.out.println("admin.port : "+conn.getPort());
		
		
		ctx.close();
		System.out.println("메인 종료");
	}

}
