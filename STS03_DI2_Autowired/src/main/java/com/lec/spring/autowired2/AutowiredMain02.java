package com.lec.spring.autowired2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AutowiredMain02 {

	public static void main(String[] args) {
		System.out.println("Autowired 자동주입2");

		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:autowiredCtx2.xml");
		System.out.println("-- 컨테이너 생성 --");
		
		System.out.println(ctx.getBean("listService"));
		System.out.println(ctx.getBean("viewService"));
		
		ctx.close();
		System.out.println("종료");
	}

}














