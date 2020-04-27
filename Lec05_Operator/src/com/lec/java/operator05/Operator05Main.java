package com.lec.java.operator05;

/*
	관계(비교) 연산자   Equality and Relational Operators
	
	 비교 연산의 결과를 참(true) 또는 거짓(false)으로 리턴하는 연산자
	 A < B: A는 B보다 작다
	 A > B: A는 B보다 크다
	 A >= B: A는 B보다 크거나 같다  ( ' = '  는 부등호 다음에~~)
	 A <= B: A는 B보다 작거나 같다
	 A == B: A와 B가 같다.  (대입연산자와 헤깔려서는 안된다.) 
	 A != B: A와 B는 다르다.	
 */
public class Operator05Main {

	public static void main(String[] args) {
		System.out.println("연산자 5 - 관계(비교) 연산자   Equality and Relational Operators");
		System.out.println("<, >, <=, >=, ==, !=");

		System.out.println(10<20);
		System.out.println(10>20);
		System.out.println(10<=20);
		System.out.println(10>=20);
		System.out.println(10!=20);
		System.out.println(10==20);
		
		int n1 = 11;
		int n2 = 12;
		boolean b2 = n1 != n2;
		System.out.println("b2 = " +b2);
		
		//실수타입은 연산결과값을 비교연산자로 같은지 비교하면 안된다.
		double d1 = 3.2;
		double d2 = 12.3 / 4.1 + 0.2; 
		System.out.println("d1 과 d2는 같습니까?" + (d1==d2));
		System.out.println(d1);
		System.out.println(d2);
		
		
		
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class






