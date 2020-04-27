package com.lec.java.static02;

public class Test {

	int num;     //인스턴스 변수  ==> static이 안붙어서
	static int sNum;   //클래스 변수 ==> static이 붙어서
	
	public void show() {
		//인스턴스 메서드
		
		System.out.println("인스턴스 num = "+num);
		System.out.println("클래스 num = "+sNum);
	}
	public static void show2() {
		//클래스 메서드 (static 메서드)
//		System.out.println("인스턴스 num = "+num); static은 non-static 멤버 사용불가
		
		System.out.println("클래스 num = "+sNum);
		
	}
	
}
