package com.lec.java.wrapper01;

/* Wrapper 클래스: 기본 자료형(primitive type)의 데이터를 감싸는 클래스
 * 기본 자료형: boolean, char, byte, short, int, long, float, double
 * Wrapper: Boolean, Character, Byte, Short, Integer, Long, Float, Double
 * 
 * Wrapper 클래스는 immutable 하다.
 * 
 * 
 * 
 */

public class Wrapper01Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스");
		System.out.println("wrapper 클래스에 값을 저장하는 방법");
		System.out.println();

		Integer i1 = 100; // 레퍼런스 타입에 인트형(primitive) 를 대입
		i1 = i1 + 200; // 레퍼런스타입 산술연산
		System.out.println("i1 = " + i1); // 300

		// Wrapper 클래스는 primitive 인거처럼 동작한다.

		// 1. 생성자 이용
		Integer num1 = new Integer(123);
		System.out.println("num = " + num1); // 123

		// 2. wrapper 클래스의 static 메소드인 valueOf() 메소드를 사용
		Integer num2 = Integer.valueOf(123);
		System.out.println("num2 = " + num2);

		if (num1 == num2) { // =>> 다르다
			System.out.println("== 같다");
		} else {
			System.out.println(" == 다르다!");
		}

		System.out.println("***num1 과 num2 의 equals 연산***");
		// wrapper 클래스도 서로 비교할때는 equals 를 쓸것
		if (num1.equals(num2)) { // =>> 같다
			System.out.println("== 같다");
		} else {
			System.out.println(" == 다르다!");
		}

		// 3. new Integer() VS Integer.valueOf()
		Integer num3 = new Integer(123); // => new 는 새로운 instance 를생성

		Integer num4 = Integer.valueOf(123);
		
		// ==>     valueof()는 생성한 object를 cache(기억) 해둔다
		// ==>     동일 literal 로 valueof() 생성하면, 기존의 생성된 object 리턴
		// ==>     이유 = 메모리 절약

		// new 로 생성한 것들 끼리 비교
		if (num1 == num3) { // =>> 다르다 둘다 new 로 만들었기 때문
			System.out.println("생성자 : 같은참조");
		} else {
			System.out.println("생성자 : 다른참조");
		}

		// valueof() 로 생성한 것들 끼리 비교
		if (num2 == num4) { // =>> 같다
			System.out.println("== 같다");
		} else {
			System.out.println(" == 다르다!");
		}

		// 4. literal 상수로 생성
		System.out.println();
		Integer num5 = 123;           
		//integer.valueof(123) 과 동일한 코드가 동작됨   (auto - boxing)
		
		if(num4 == num5) {
			System.out.println("literal 같은참조");
		}else {
			System.out.println("literal 다른참조");
		}

		
		// 5. valueOf(문자열) 가능!
		Integer num6 = Integer.valueOf("123");    //  ==> 123이 문자열에서 숫자로 먼저 바뀌고 valueof를 실행
		System.out.println(num6);

		
		if(num6 == num5) {
			System.out.println("같은참조");
		}else {
			System.out.println("다른참조");
		}
		
		
		
		// 6. 산술 연산 가능
		num6 *= 2;     //=> wrapper 클래스의 연산결과는 새로운 wrapper 를 생성한다. (immutable 하기 때문)
		
		
		System.out.println(num6);
		if(num6 == num5) {                //=> wrapper 클래스는 immutable 이라 다른값을 참조하게 된다.
			System.out.println("같은참조");
		}else {
			System.out.println("다른참조");
		}
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // end class
