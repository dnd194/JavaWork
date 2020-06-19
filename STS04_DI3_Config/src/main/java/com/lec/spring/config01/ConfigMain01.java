package com.lec.spring.config01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.Score;

public class ConfigMain01 {

	public static void main(String[] args) {

		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:appCtx01_A.xml");
		
		System.out.println("-- ctxA 생성 --");
		
		Score score1 = (Score)ctx.getBean("score1");
		System.out.println(score1);
		
		//		context 객체는 여러개 만들수 있다.
		AbstractApplicationContext ctx2 =
				new GenericXmlApplicationContext("classpath:appCtx01_B.xml");
		System.out.println("-- ctxB 생성 --");
		
		Score score2 = (Score)ctx2.getBean("score2");
		System.out.println(score2);
		
		
		//		++ 여러개의 설정파일로부터 context 생성 가능
		
		AbstractApplicationContext ctx12 = 
				new GenericXmlApplicationContext("classpath:appCtx01_B.xml","classpath:appCtx01_A.xml");
//		AbstractApplicationContext ctx12 = 
//				new GenericXmlApplicationContext("classpath:appCtx01_A.xml","classpath:appCtx01_B.xml");
		System.out.println("-- ctxAB 생성 --");
		
		Score score1_2 = ctx12.getBean("score1",Score.class);
		Score score2_2 = ctx12.getBean("score2",Score.class);
		System.out.println(score1_2);
		System.out.println(score2_2);
		
		if(score1 == score1_2) {
			System.out.println("같다");
		}else {
			System.out.println("다르다리");
		}

		//             결과는 다르다  ==> 다른 컨테이너에 생성도니 별개의 객체
		
		
		
		ctx.close();
		ctx2.close();
		ctx12.close();
	}

}
