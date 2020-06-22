package com.lec.spring.aop01;

import com.lec.beans.Logger;
import com.lec.beans.Service;

public class MyService12 extends Service {

	// 관심사(공통기능) 코드가 함께 섞여 있는 경우.
	
	@Override
	public void doAction() {
		new Logger().logIn();  // 공통기능
		
		// 핵심기능
		//System.out.println("MyService12 의 doAction()");
		printInfo();
		
		new Logger().logOut();  // 공통기능
	}

}

















