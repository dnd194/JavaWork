package com.lec.java.exception01;

import java.util.Scanner;

/* 예외(Exception)
	
	컴파일 에러 : 문법상 오류
	예외(Exception) : 문법상의 오류 가 아닌 '실행중' 에 발생되는 오류상황
	  
	(기본적으로) 예외 가 발생되면, 예외 관련 메세지 출력하고 프로그램이 종료 됩니다.  
 */
public class Exception01Main {

	public static void main(String[] args) {
		System.out.println("예외(Exception)");
		
		System.out.println("[1] ArithmeticException");
		int num1 = 123;
//		int num2 = 0;   ==>  java.lang.ArithmeticException: / by zero       by zero  ==>  이유
		int num2 = 10;

		System.out.println("num1 / num2 = "+(num1/num2));
		
		System.out.println("[2] ArrayIndexOutOfBoundsException");
		int[] numbers = new int[10];
		
//		numbers[10]= 100; ==> ArrayIndexOutOfBoundsException   /  10      10 == > 이유
		
		System.out.println("[3] NegativeArraySizeException");

		int size = -1;
//		int[] number2 = new int[size];            배열의 사이즈에 음수를 넣을 경우 발생
		
		
		System.out.println("[4] NullPointerException");
		String str = null;
		
//		System.out.println("문자열 길이 : "+str.length());          // 주여서 NPE 라고도 함 
		//                        NULL 값 다음에는    ' . ' 가 붙을 수가 없다.
		
		
		System.out.println("[5] InputMismatchException");  
		Scanner sc = new Scanner(System.in);
	
		sc.nextInt();  //이럴때 문자열을 넣어주면 inputmismatch error 가 발생함
		
		sc.close();
		
		System.out.println("프로그램 종료");

	} // end main()

} // enc class Exception01Main











