package com.lec.java.inherit05;

//private: 자기 클래스에서만
//default: 자기 클래스 + 같은 패키지 안에서
//protected: 자기 클래스 + 같은 패키지안 + 상속 관계에 있을 때
//public: 어디서나
//직접 사용 가능

public class Test01 {
	private int privateNum;
	int defaultNum;
	protected int protectedNum;
	public int publicNum;
	
	public void showInfo() {
		System.out.println("private = " + privateNum);
		System.out.println("default = " + defaultNum);
		System.out.println("protected = " + protectedNum);
		System.out.println("public = " + publicNum);
	}
	
} // end class Test01









