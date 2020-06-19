package com.lec.spring.aop02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.beans.Service;

public class AopMain02 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopCtx2.xml");
		System.out.println("ctx 생성");

		// TODO
		
		ctx.close();
		System.out.println("Main 종료");
	} // end main

} // end class
