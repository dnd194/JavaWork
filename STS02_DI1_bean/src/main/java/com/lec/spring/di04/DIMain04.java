package com.lec.spring.di04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Student;

public class DIMain04 {

	public static void main(String[] args) {
		System.out.println("main 시작");
		
		//컨테이너 생성
		AbstractApplicationContext ctx = 
					new GenericXmlApplicationContext("classpath:studentCtx.xml");
		System.out.println("--컨테이너 생성--");
		
		Student stu1 = (Student)ctx.getBean("bini");
		System.out.println(stu1);
		
		Student stu2 = (Student)ctx.getBean("bbin");
		System.out.println(stu2);
		System.out.println();
		
		stu2.getScore().setMath(100);
		System.out.println(stu2);
		System.out.println(stu1);
		
		
		
		System.out.println("main 종료");
	}

}
