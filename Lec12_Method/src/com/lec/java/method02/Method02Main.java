package com.lec.java.method02;

/* return 의 믜미
 * 
 *   1. 메소드를 호출한 곳으로 '하나의 값' 을 리턴할 수 있다.
 *   2. 메소드 종료
 *   3. 메소드 정의시 명시한 리턴타입의 값이 '반드시' 리턴되어야 한다
 *          (혹은 리턴타입으로 형변환 가능한 값이)
 */

public class Method02Main {

	public static void main(String[] args) {
		System.out.println("메소드의 리턴 타입");

		int sum = add(110, 220); // 330이 대체된다고 생각하면됨. 330 = add 함수의 결과 값
		System.out.println("sum : " + sum);

		sum = add(10, 20) + add(30, 40); // 연산자는 = , + 2개
		System.out.println("sum : " + sum);

		sum = add(50, add(10, 20));
		System.out.println("sum : " + sum);

		System.out.println("sum = " + (add(10, -40) + add(add(20, 30) + 10, 10))); // 40 그냥 괄호 벗기기
		
		
		System.out.println(divide2(1944, 9)); //아래 2줄이랑 똑같음
		String str = divide2(123, 14);
		System.out.println(str);

		System.out.println("\n프로그램 종료");
	} // end main()

	// 메소드 이름: add
	// 매개변수:
	// 1) int x
	// 2) int y
	// 리턴타입: int
	public static int add(int x, int y) { // 무조건 'int' 값을 ' 리턴 ' 시켜줘야한다
		int result = x + y;

		return result; // int 값 반환 (메소드(함수) 종료) 리턴과 함께 자기를 호출한 위치로 되돌아 간다.
	}

	// 메소드 이름: sub
	// 매개변수:
	// 1) int x
	// 2) int y
	// 리턴타입: int
	public static int sub(int x, int y) {
		int result = x - y;

		return result;
	}

	// 메소드 이름: multiply
	// 매개변수:
	// 1) int x
	// 2) int y
	// 리턴타입: int
	public static int multiply(int x, int y) {
		int result = x * y;

		return result;
	}

	// 메소드 이름: divide
	// 매개변수:
	// 1) int x
	// 2) int y
	// 기능: x를 y로 나눈 몫을 리턴하는 메소드
	// 리턴타입: int
	public static int divide(int x, int y) {
		int result = x / y;
		return result;
		
		//그냥 return x/y; 때려도 됨 근데 y가 0이 나오면 프로그램이 죽음  exception 발생 (arithmetic)
	}

	// 메소드 이름: divide2
	// 매개변수:
	// 1) int x
	// 2) int y
	// 만약에 y 가 0 이면 --> "0으로 나눌수 없습니다"
	// y 가 0 이 아니면 --> "몫은 ~~이고 , 나머지는 ~~ 입니다"
	// 리턴타입: String ★
	public static String divide2(int x, int y) {
		String str;
		if ( y == 0) {
			 str = "0으로 나눌수 없습니다.";
		}else {
			 str = "몫은"+ x/y+" 이고 나머지는"+ x%y+" 입니다";
		}
		return str;
	}

} // end class
