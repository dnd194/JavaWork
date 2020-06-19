package com.lec.spring.environment;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class EnvMain {

	public static void main(String[] args) {

		System.out.println("메인 시작");
		
		//Context -> Environment -> PropertySources
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext(); //컨테이너 생성
		ConfigurableEnvironment env =  ctx.getEnvironment();  //<- ConfigurableApplicationContext 소속 메서드
		MutablePropertySources propertySources = env.getPropertySources(); 
		
		//PropertySources 에 PropertySource 추가
		try {
			// PropertySource ''하나''를 생성하여  propertySources 에 추가
			propertySources.addLast(
					new ResourcePropertySource("classpath:admin.auth"));
			
			//이제 environment에서 특정 property에 접근이 가능
//			굳이 어느 propertySource 의 어느 property를 지정할 필요가 없다.
			//propertySources 에 소속된 모propertySource들을 스캔해서 찾아낸다.
			
			System.out.println("admin.id = "+env.getProperty("admin.id"));
			System.out.println("admin.pw = "+env.getProperty("admin.pw"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}//end try
		
		//바로 ctx.load 하면 되지않음 왜냐 지금 ctx 는 ConfigurableApplicationContext 타입이기 때문
		//때문에 아래와 같은 작업을 해줘야한다.
		
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;   //다운캐스팅이 필요한 부분
		gCtx.load("classpath:appCtx1.xml");		//설정 로딩
		gCtx.refresh();  // 빈 생성
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : "+ adminConnection.getAdminId());
		System.out.println("admin PW : "+ adminConnection.getAdminPw());
		gCtx.close();
		
		System.out.println("메인 종료");
		
		
		
		
	}

}
