package com.lec.spring.aop02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.Service;

public class AopMain02 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopCtx2.xml");
		System.out.println("--ctx 생성--");

		Service service21 = ctx.getBean("service21", Service.class);
		Service service22 = ctx.getBean("service22", Service.class);
		
		service21.doAction();
		System.out.println();
		service22.doAction();
		System.out.println();
		
		((MyService21)service21).hahaha();
		ctx.close();
		System.out.println("Main 종료");
	} // end main

} // end class











