package com.lec.spring.di01;

import com.lec.spring.MessageBean;
import com.lec.spring.MessageEng;
import com.lec.spring.MessageKor;

/*
 * Dependency Injection (DI , 의존 주입)
 * 필요한 객체를 '누가' 만들어 사용하나??
 * 
 * 방법1 : 직접 생성 (new) 하여 사용
 * 
 * 
 * */


public class DIMain01 {

	public static void main(String[] args) {
		System.out.println("main() 시작");
		MessageBean msg = null;
		msg = new MessageKor();   //직접 만들어 사용(new)
		msg.sayHello();
		
		
		//의존하고 있던 객체의 버전등이 업그레이드 되면(설계가 변경이 되면)
		//의존하고 있던 객체를 재컴파일 해야한다 ( 수정 해야 한다 )
		msg = new MessageEng();
		msg.sayHello();
		
		System.out.println("메인 종료");

	}

}
