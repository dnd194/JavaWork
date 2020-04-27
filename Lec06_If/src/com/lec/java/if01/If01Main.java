package com.lec.java.if01;

/* if, if ~ else 조건문
 * 
 * 구문1:
 * 	if (조건식) {                           조건식에는 반드시 'boolean'값이 들어와야합니다~
 *  	조건식이 true 일때 실행되는 문장(들) 
 *  	...
 * 	}
 * 
 * 구문2:
 *  if (조건식) {
 *		조건식이 true 일때 실행되는 문장(들)
 *		...
 *  } else {
 *		조건식이 false 일때 실행되는 문장(들)
 *		...
 *  }
 */
public class If01Main {

	public static void main(String[] args) {
		System.out.println("if 조건문");

		int num = -10;
		if (num < 0) { // 디버깅은 생각하면서 ^^
			System.out.println("음수 입니다~");
		}

		if (num > 0) {
			System.out.println(num + "은 양수 입니다~"); // 조건이 거짓이라서 안에 문장을수행하지않음
		} else {
			System.out.println(num + "은 양수가 아닙니다");
		}

		System.out.println();

//		수행하는 문장이 하나라면 블록   { .. }  을 쳐주지 않아도 된다
		if (num < 0)
			System.out.println(num + "-> 음수");
		else
			System.out.println(num + "-> 0 or 양수");

		// 코드는 가독성 좋게~
		// 주어준 숫자가 짝수인지 홀수인지 여부 판단
		int num3 = 124;

		if (num3 % 2 == 0) {
			System.out.println(num3 + "은 짝 수 입니다");
		} else {
			System.out.println(num3 + "은 홀 수 입니다");
		}
		int num4 = 123;

		if (num4 % 2 == 0) {
			System.out.println(num4 + "은 짝 수 입니다");
		} else {
			System.out.println(num4 + "은 홀 수 입니다");
		}
		
		//주어진 숫자가 0 ~ 100 점 까지의 범위인지 여부
		
		int num5 = 101;
		
//		if ( 0 <= num4 <= 100 ) <---- 이런 표현식은 없다 수학적표현 xxxxxxx 근데 파이썬은 됨
		
		if( num5 >= 0 && num5 <= 100) {                //조건식을 만드는 것이 중요한 포인트
			System.out.println(num5+"은 유효한 점수 입니다.");
		}else {
			System.out.println(num5+"은 유효하지 않습니다.");
		}
		
		
		
		
		
		
		
		
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
