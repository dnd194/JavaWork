package com.lec.java.switch03;

/* switch (조건) {case1:  case2:}
 *   (조건)에 따라서 해당 case로 이동
 *   (조건)에 사용될 수 있는 자료 타입은
 *    1. int로 변환 가능한 타입들: byte, short, int, char
 *    2. enum 타입(enum 자료형은 Java 5 버전부터 소개)
 *    3. String 타입 (Java 7 버전부터 switch 문에서 사용 가능)
 */
public class Switch03Main {

	public static void main(String[] args) {
		System.out.println("switch 제약 조건");
		System.out.println("char를 switch문에서 사용");

		char ch = 'b';
		switch (ch) {                  //기본적으로 대소문자 구분 
									//아래 코드는 대소문자를 구분하지않도록 함
		case 'A':
		case 'a':
			System.out.println('A');
			break;
		case 'B':
		case 'b':
			System.out.println('B');
			break;
		case 'C':
		case 'c':
			System.out.println('C');
			break;
		default:
			System.out.println("몰라");
			break;
		}

		// switch(조건) 에 사용할수 없는 값들
		long num = 1;
		/*switch (num) {          //switch 안에 long, float 형 불가   cannot convert~~~~~~
		case value:
			
			break;

		default:
			break;
		}*/

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
