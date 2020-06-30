package com.lec.spring;

public class MessageEng implements MessageBean {

	String msgEng = " ha wi ~~";
	
	public MessageEng() {
		System.out.println("MessageEng() 생성");
	}

	public void sayHello() {
		System.out.println(msgEng);
	}

}
