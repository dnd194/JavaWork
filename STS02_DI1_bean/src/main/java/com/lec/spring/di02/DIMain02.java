package com.lec.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.MessageBean;

/*
Dependency Injection (DI, 의존주입)
필요한 객체는 누가 만들어 사용하나?

방법2 : 외부에서 만들어 주입 (injection)
	스프링 특징 의존주입 (Dependenty Injection) 사용
	즉 '외부' 에서 만들어 놓은 것을 가져옴.
*/

public class DIMain02 {

	public static void main(String[] args) {
		System.out.println("메인이 시작하는걸");
		
		//Spring 설정파일 resource 명시
		String configLocation = "classpath:appCtx.xml";
		
		//ApplicationContext 객체를 만드는 시점에서 bean 객체가 생성됩니다
		AbstractApplicationContext ctx =
			new GenericXmlApplicationContext(configLocation);
		System.out.println("ApplicationContext 컨테이너 생성했는걸");
		
		//외부에서 만들어진 객체 주입 (injection)
		MessageBean msg = ctx.getBean("messageBean", MessageBean.class);
		//                          appCtx.xml 에서 만들어준 id값 messageBean
		
		msg.sayHello();
		
		ctx.close();  //이친구도 메모리를 잡아목는걸
		System.out.println("메인이 종료됬는걸");
		
		
		
	}

}
