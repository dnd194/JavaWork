package com.lec.java.switch02;

public class Switch02Main {

	public static void main(String[] args) {
		System.out.println("switch 연습");

		// 도전
		// switch ~ case 조건문을 사용해서
		// 짝수 이면 --> "짝수입니다" 출력
		// 홀수 이면 --> "홀수입니다" 출력

		int num = 99;
		switch (num % 2) {    //switch 안의 조건이 중요 , 안에는 int 형과 int로 자동형변환되는 친구들만가능 long은 안됌 
		case 0:
			System.out.println("짝수 입니다");
			break;

		default:
			System.out.println("홀수입니다");
			break;
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
