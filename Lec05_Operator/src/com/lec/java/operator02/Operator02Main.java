package com.lec.java.operator02;

/* 복합 대입 연산자 compound assignment operators
 * 
 * 		+=, -=, *=, /=, %=, ...
 */
public class Operator02Main {

	public static void main(String[] args) {
		System.out.println("연산자(Operator) 2 - 복합 대입 연산자 compound assignment operators");
		System.out.println("+=, -=, *=, /=, %=, ...");

		int num1 = 10;
		System.out.println("num1 = "+num1 );
		
		num1 = num1 + 1; //기존의 num1 값에 1증가
		
		
		System.out.println("num1 = "+num1 ); //11
		num1 += 1;
		
		System.out.println("num1 = "+num1 ); //12
		
		int num3 = 123;
		num3-=23;
		System.out.println("num3 = "+num3); //100
		
		double num4 = 3.14;
		num4 *=2;
		System.out.println("num4 = "+num4);
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class










