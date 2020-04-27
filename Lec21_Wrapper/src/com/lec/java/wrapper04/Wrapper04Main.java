package com.lec.java.wrapper04;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* BigInteger, BigDecimal
 * 
 * BigInteger
 * 		정수타입 기본자료형으로 담을수 없는 한계 범위 밖의 값들을 다룰때 사용하는 객체
 * 
 * BigDecimal
 *  	실수타입 기본자료형에서 발생하는 정밀도의 문제는 극복하기 위해 사용하는 객체
 *  
 * 이들은 반드시, 인스턴스를 생성해서 사용해야 한다
 */
public class Wrapper04Main {

	public static void main(String[] args) {
		System.out.println("[1] BigInter 클래스");
		System.out.println("Integer 최소값: " + Integer.MIN_VALUE);
		System.out.println("Integer 최대값: " + Integer.MAX_VALUE);
		System.out.println("Long 최소값: " + Long.MIN_VALUE);
		System.out.println("Long 최대값: " + Long.MAX_VALUE);
		
		//long num = 10000000000000000000L;
		// 컴파일 에러: long 타입의 최대값이 넘는 수는 사용할 수 없다.
		// 사용할 수 있는 정수의 한계를 없앤 클래스가 BigInteger
		
		// 1. 큰 수(BigInteger) 인스턴스 생성
		// long의 크기를 넘어가는 숫자를 표기할 수 없기 때문에
		// 생성자에 매개변수로 스트링을 넘겨준다.

		// TODO
		
		
		// 2. 사칙연산과 같은 계산을 위해서는 메소드를 사용

		// TODO
		
		System.out.println();
		System.out.println("[2] BigDecimal 클래스");

		// TODO
		
		
		// float, double 등은 오차가 발생하는 것을 피할 수 없다.
		// 오차를 없애기 위해서 만들어지 클래스가 BigDecimal
		
		// 1. BigDecimal 클래스의 인스턴스 생성

		// TODO
		
		// 2. 계산은 메소드를 사용

		// TODO
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















