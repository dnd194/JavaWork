package com.lec.spring.lifecycle01;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.beans.Score;

public class LifeCycleMain01{

	public static void main(String[] args) {
		System.out.println("메인 시작");
		
		//여태까지는 설정과 컨테이너 생성을 한꺼번에 했다 
		//그러나 이번엔 따로 하겠음
		
		//1. 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("컨테이너 생성완료");
		
		//2. 설정로딩
		ctx.load("classpath:appCtx01_A.xml"); //설정 만 완료 안에있는 bean들은 로딩되지않음
		System.out.println("설정완료");  
		
		ctx.refresh();
		System.out.println("컨테이너 refresh 완료");
		
		Score score1 = ctx.getBean("score1",Score.class);
		System.out.println(score1);
		
		ctx.close();
		System.out.println("메인 종료");
	}

}
