package com.lec.java.lambda02;

/*	람다 표현식 (lambda - expression): 
	 	() -> 수행코드
	 	() -> 리턴값
	 	(매개변수..) -> 수행코드
	 	(매개변수..) -> 리턴값
	 	
	 매개변수의 타입은 생략해서 표현이 가능
	 매개변수가 여러개 있을 경우,
		 모든 매개변수의 타입을 생략해서 표현하거나,
		 모든 매개변수의 타입을 모두 다 표현해야 함. 
*/
public class Lambda02Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");

		// 매개변수 없고, 리턴값도 없는 경우
		Test01 lamda01 = () -> System.out.println("안녕하세영");
		lamda01.testPrint(); // testprint 는 test01에 추상메서드로 정의되어있음

		// 매개변수 한개, 리턴값은 없는 경우
		Test02 lamda02 = (x) -> System.out.println("num 값은 " + x);
		lamda02.testPrint(527); // testprint 는 test02에 추상메서드로 정의되어있음

		// 매개변수 여러개, 리턴값이 있슴.
		Test03 lamda03 = (x, y) -> (x > y) ? x : y;
		System.out.println("result = "+lamda03.max(20,555));

		// 매개변수 한개, 내부 수행코드 여러줄.., 리턴값.
		//여러 줄 일때는 블록을 잡으면 된다.
		Test04 lamda04 = (x) -> {
			System.out.println(x);
			
			return x.length();
		};
		System.out.println("result = "+ lamda04.myStrLen("java")); 

		// Test05 인터페이스 만들기
		// void printMax(double x, double y)
		// [출력양식 예제]
		// x = 3.14
		// y = 1.2
		// 3.14 > 1.2
		Test05 lamda05 = (x,y) -> {
			System.out.println(x);
			System.out.println(y);
			if(x>y) {
				System.out.println( x +" > " +y);
			}else {
				System.out.println(x + " < " +y);
			}
			
		};
		lamda05.printMax(3.14, 1.2);  //추상메서드 재정의
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
