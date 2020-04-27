package com.lec.java.exception03;

/*  예외 처리: try ~ catch
  	연습 01패키지에서 발생하던 예외들을 try~catch로 잡아보자 
  	
 	 주의! : try 블럭 안에서 선언된 변수는 try 블럭안에서만 사용되는 지역변수가 된다.
	     catch 블럭등 다른 블럭에서도 사용 가능하게 하려면 try 바깥에서 선언해야 한다
 */
public class Exception03Main {

	public static void main(String[] args) {
		System.out.println("예외 처리: try ~ catch");
		
		System.out.println();
		System.out.println("[1] ArithmeticException");
		int num1 = 123;
		int num2 = 0;
		
		try {
			System.out.println("num1 / num2 = " + (num1 / num2));
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(num1+"은 "+num2+" 로 나눌수없습니다.");
		}
		
		
		
		System.out.println();
		System.out.println("[2] ArrayIndexOutOfBoundsException");

		try {
			
			int[] numbers = new int[10];
			numbers[100] = 111;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("index 범위를 초과했습니다");
		}
		
		System.out.println();
		System.out.println("[4] NullPointerException");

		try {
			String str = null;
			System.out.println("스트링 길이: " + str.length());
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("null 값에는 ' . ' 참조연산자를 붙일 수 없습니다");
		}

		
		System.out.println();
		System.out.println("[5] ClassCastException");

		try {
			Object obj = new int[10];
			String str2 = (String)obj;
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("int타입의 배열은 String 타입의 배열로 넘어 갈 수 없습니다");
			
		}
		
		

	} // end main

} // end class Exception03Main












