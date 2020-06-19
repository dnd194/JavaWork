package com.lec.spring;

public class MessageKor implements MessageBean {

	String msgKor = "하위	";
	
	
	//생성자가 언제 생성되는지  주의 깊게 볼 것
	public MessageKor() {
		System.out.println("MessageKor() 생성");
	}


	@Override
	public void sayHello() {
		System.out.println(msgKor);

	}

}
