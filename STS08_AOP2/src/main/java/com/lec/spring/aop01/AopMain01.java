package com.lec.spring.aop01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.Service;

public class AopMain01 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopCtx1.xml");
		System.out.println("ctx생성");

		Service service1 = ctx.getBean("service1", Service.class);
		Service service2 = ctx.getBean("service2", Service.class);
		
		service1.doAction();   // 핵심코드
		System.out.println();
		service2.doAction();   // 핵심코드
		System.out.println();
		
		ctx.close();
		System.out.println("Main 종료");
	} // end main()

} // end class







