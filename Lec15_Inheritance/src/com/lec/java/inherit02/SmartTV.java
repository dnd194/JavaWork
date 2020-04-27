package com.lec.java.inherit02;

//BasicTV
//   ㄴ SmartTV


public class SmartTV extends BasicTV{
	
	String ip;   //추가된 내용 
	
	public void displayInfo() {
		super.displayInfo();     //부모의 메서드 활용
		System.out.println("ip 주소 : "+ip);  //추가된 기능
	}
}
