package com.lec.spring.di05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;
import com.lec.spring.Student;

public class DIMain05 {

	public static void main(String[] args) {
		System.out.println("main 시작");
		
		AbstractApplicationContext ctx = 
					new GenericXmlApplicationContext("classpath:studentCtx2.xml");
		System.out.println("컨테이너 생성");
		
		Score score = null;
		score = (Score)ctx.getBean("score1");
		System.out.println(score);
		
		score = (Score)ctx.getBean("score2");
		System.out.println(score);
		
		
		Student stu1 = (Student)ctx.getBean("stu1");
		System.out.println(stu1);
		
		Student stu2 = (Student)ctx.getBean("stu2");
		System.out.println(stu2);
		
		ctx.close();
		System.out.println("main 종료");
	}

}
