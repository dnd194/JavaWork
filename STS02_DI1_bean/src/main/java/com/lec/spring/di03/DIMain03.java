package com.lec.spring.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;

public class DIMain03 {

	public static void main(String[] args) {
		
		//applicationContext (컨테이너)생성 (빈(bean) 도 자동 생성)
		
		AbstractApplicationContext ctx = 
				new GenericXmlApplicationContext("classpath:scoreCtx.xml");
		System.out.println("컨테이너 생성됬다구");
		Score score = null;
		score = ctx.getBean("myScore1",Score.class);
		System.out.println(score);
		
		score =(Score)ctx.getBean("myScore2");  //매개변수를 하나만 줄 경우 오브젝트타입으로 리턴
		System.out.println(score);
		
		score =(Score)ctx.getBean("myScore3");  
		System.out.println(score);
		
		score =(Score)ctx.getBean("myScore4");  
		System.out.println(score);
		
		score =(Score)ctx.getBean("myScore5"); 
		System.out.println(score);
		
		score =(Score)ctx.getBean("myScore6"); 
		System.out.println(score);
		
		score =(Score)ctx.getBean("myScore7"); 
		System.out.println(score);
		
		System.out.println("특정 컨테이너의 생성된 빈의 개수 : "+ctx.getBeanDefinitionCount());
		for(int i = 1; i<=ctx.getBeanDefinitionCount(); i++) {
			System.out.println(ctx.getBean("myScore"+i));
		}
		score =(Score)ctx.getBean("myScore8"); 
		System.out.println(score);
		
		ctx.close();
		System.out.println("메인 종요ㅛ요ㅛ");
		
	}

}
