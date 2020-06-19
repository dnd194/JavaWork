package com.lec.spring.aop03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.beans.Service;
import com.lec.spring.beans.ServiceEx;

public class AopMain03 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:aopCtx3.xml");
		System.out.println("ctx생성");

		// TODO
		
		ctx.close();
		System.out.println("Main 종료");
	} // end main

} // end class
