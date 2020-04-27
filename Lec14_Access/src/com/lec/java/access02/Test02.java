package com.lec.java.access02;

public class Test02 {
	private int privateNum;				//자기자신
	int defaultNum;                  	//자기 자신 + 같은 패키지
	protected int protectedNum;			//자기자신+ 같은패키지 + 상속받은클래스
	public int publicNum;				//어디서든 사용가능
	
	private void privateMethod() {
		
	}
	void defaultMethoid() {
		
	}
	protected void protectedMethod() {
		
	}
	public void publicMethod() {
		
	}
}
