package com.lec.spring.aop01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.beans.Service;

public class AopMain01 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopCtx1.xml");
		System.out.println("ctx생성");

		// TODO
		
		ctx.close();
		System.out.println("Main 종료");
	} // end main()

} // end class
