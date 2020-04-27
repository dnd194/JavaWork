package com.lec.java.variable04;

public class Variable04Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("변수 - char , boolean, String");
		
//		char : 문자 하나를 저장하기 위한 데이터 타입 (2바이트)
		char ch1 = 'A';   
//		char 리터럴은  홀따옴표 ('')로 묶어준다.
//		문자열 String 리터럴은 쌍따옴표 (" ~ ");
		System.out.println("ch1 : "+ch1);
		
		char ch2 = '한'; //ch2에는 '한'의 코드 값이 담겨져있다
		char ch3 = '글';
		System.out.println("ch2 : "+ch2);
		System.out.println("ch3 : "+ch3);
		char ch4 =0xae01; 
		System.out.println("ch4 : "+ch4); //긁의 16진수 값은 0xae01
		char ch5 =1234;
		System.out.println("ch5 : "+ch5);
		
//		println()은 char를 문자로 출력 그러나 다른 정수형으로 변환되면 해당 코드 값을 정수로 출력
		char ch6 = '!';
		System.out.println("ch6 : "+ch6);
		char ch7 = 33;
		System.out.println("ch7 : "+ch7); //! 의 코드 값은 33
		System.out.println("ch7 + 1 : "+(ch7+1));  //정수형으로 변환되면 해당 코드 값을 정수로 출력
		System.out.println("ch7 + 1 : "+(char)(ch7+1)); 
		
		char ch8 = 'A';
		char ch9 = 'a';
		System.out.println(" 'A' : "+ch8);
		System.out.println(" 'a' : "+ch9);
		
//		소문자의 코드 값이 더 크다
	
		System.out.println(" 'A' : "+ch8+" - "+(int)ch8);
		System.out.println(" 'a' : "+ch9+" - "+(int)ch9);
				// 1. 까마귀
				// 2. 가마우지
				// 3. 직박구리
				//   2 - 1 - 3
				
				// 1. cable
				// 2. bible
				// 3. able
				//  3 - 2  - 1
				
				// 1. aaAA
				// 2. AaAa
				// 3. AAaa
				// 4. aAaA
				//  3 - 2 - 4 - 1
		
		
		
		
//		boolean(논리형) : 참 (true) , 거짓(false)
		
		boolean b1 = true;
		boolean b2 = false;
		System.out.println("b1 : "+b1);
		System.out.println("b2 : "+b2);
		
		System.out.println(10<20);
		System.out.println(10>20);
		
		boolean b3 = 10<20;
		System.out.println("b3 : "+b3);
		
//		String(문자열) 은 기본자료형(primitive) 이 아니다 
		String name = "Im"; //String 리터럴은 쌍따옴표
		String nickname = "thunder";
		System.out.println("이름은 : "+name +" \n별명은 : "+nickname);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
