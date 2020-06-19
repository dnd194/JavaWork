package com.lec.spring.config03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ConfigMain03 {

	public static void main(String[] args) {

		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx03.xml");
		System.out.println(" -- ctx 생성 -- ");
		
		// java에서 설정
		System.out.println(ctx.getBean("score1"));
		
		// xml 에서 설정
		System.out.println(ctx.getBean("score2"));
		
		
		
		ctx.close();
	}

}
