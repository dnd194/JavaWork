package com.lec.spring.property3.java;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lec.spring.property2.xml.DBConn;

public class PropertyMain3 {

	public static void main(String[] args) {
		System.out.println("메인 시작");
		
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext(DBConfig.class);
		System.out.println("-- ctx 생성 --");

		DBConn conn = ctx.getBean("dbConfig",DBConn.class);
		System.out.println("id : "+conn.getId());
		System.out.println("Pw : "+conn.getPw());
		System.out.println("Url : "+conn.getUrl());
		System.out.println("Port : "+conn.getPort());

		ctx.close();
		System.out.println("메인종료");
	}

}
