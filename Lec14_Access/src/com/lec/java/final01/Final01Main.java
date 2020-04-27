package com.lec.java.final01;

public class Final01Main {
	//final 멤버 변수는 반드시 선언과 동시에 초기화 해야한다.
//	final int num; 초기화 안해서 error 발생
	
	final int NUM = 1;
	
	//ctrl shift x => 대문자 변환
	//ctrl shift y => 소문자 변환
	
	
	
	public static void main(String[] args) {
		System.out.println("final: 변경할 수 없는 상수");
		
		int num1 = 1;
		num1 = 10;
		
		final int num2 = 1;
//		num2 = 10;          final 상수는 변경 불가
		
		final int num3;
		num3 = 1;  // 지역변수 fianl은 초기화는 나중에 가능
		
		
		

	} // end main()

} // end class Final01Main










