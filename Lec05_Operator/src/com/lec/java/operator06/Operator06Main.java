package com.lec.java.operator06;

/* 논리 연산자: &&, ||, !, ^
 *	A && B: (AND 연산) A와 B가 모두 참일 때만 결과가 true, 나머지는 결과가 false
 *	A || B: (OR 연산) A나 B 둘 중 하나가 참이면 결과가 true, 둘 다 거짓이면 결과가 false
 *	!A	: (NOT 연산) A가 참이면 결과가 false, 거짓이면 결과가 true
 *	A ^ B : ( XOR 연산, 배타적 논리 합 )A, B 둘의 논리값이 같으면 false, 다르면 true
 */
public class Operator06Main {

	public static void main(String[] args) {
		System.out.println("연산자 6 - 논리 연산자: &&, ||, !, ^");

		int num1 = 10;
		boolean result;
		result = num1 > 0 && num1 < 100;   //논리연산자는 우선순위가 낮다.
		System.out.println(result);
		
		result = num1 > 0 && num1 < 10;   
		System.out.println(result);
		
		result = num1 > 0 || num1 < 10;   
		System.out.println(result);
		
		result = num1 < 0 || num1 < 10;  
		System.out.println(result);
		
		result = !(num1 > 0);
		System.out.println(result);
		
		result = num1 < 0 ^ num1 > 100;  //배타적 논리 합  서로 논리 값이 같으면 false, 다르면 true
		System.out.println(result);
		
		
		System.out.println("\n 프로그램 종료");
	} // end main ()

} // end class











