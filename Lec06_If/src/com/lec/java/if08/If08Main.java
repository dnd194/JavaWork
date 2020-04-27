package com.lec.java.if08;

/* 실수값은 정밀도(precision) 의 문제가 있기 때문에
 * 산술계산 결과값 등의 '같은값 여부' 비교는 하지 말자 
 */
public class If08Main {

	public static void main(String[] args) {
		System.out.println("실수 비교 연산");
		float f1 = 0.01f;
		float f2 = 0.1f * 0.1f;
		// 실수는 산술연산값이 100% 정확하지 않다 f1 != f2

		System.out.println("f1 = " + f1 + "\nf2 = " + f2);
		if (f1 == f2) {
			System.out.println("같습니다");
		} else {
			System.out.println("다릅니다");
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
