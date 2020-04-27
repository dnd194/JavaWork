package com.lec.java.math01;

import java.util.Random;

public class Math01Main {

	public static void main(String[] args) {
		System.out.println("Math 클래스");
		// Math 클래스의 모든 메소드는 static으로 선언
		// 인스턴스 생성 없이(new 없이) 사용 가능.
		// Math.메소드이름() 사용
		
		
		System.out.println();
		System.out.println("[1] Math 의 상수들");
		System.out.println("Math.PI : " + Math.PI);
		System.out.println("Math.E : " + Math.E);    // 자연 로그 e
		
		
		System.out.println();
		System.out.println("[2] random(): 난수 발생");
		System.out.println(Math.random());
		// 0 이상 1 미만의 난수(임의의 숫자)를 만듬
		
		// 0 이상 10미만의 난수를 발생
		System.out.println(Math.random() * 10);
		
		// 주사위(1,2,3,4,5,6)
		System.out.println((int)(Math.random() * 6) + 1);
		
		System.out.println();
		System.out.println("[3] round(): 반올림");
		System.out.println(Math.round(1.2));
		System.out.println(Math.round(1.7));
		System.out.println(Math.round(-1.2));
		System.out.println(Math.round(-1.7));
		
		System.out.println();
		System.out.println("[4] floor(): 작거나 같은 가장 큰 정수");
		// floor: 바닥
		System.out.println(Math.floor(1.2));
		System.out.println(Math.floor(1.7));
		System.out.println(Math.floor(-1.2));
		System.out.println(Math.floor(-1.7));
		
		System.out.println();
		System.out.println("[5] ceil(): 같거나 큰 가장 작은 정수");
		// ceil: 천장
		System.out.println(Math.ceil(1.2));
		System.out.println(Math.ceil(1.7));
		System.out.println(Math.ceil(-1.2));
		System.out.println(Math.ceil(-1.7));
		
		System.out.println();
		System.out.println("[6] sqrt(): 제곱근"); // square root
		System.out.println(Math.sqrt(4));
		System.out.println(Math.sqrt(9));
		System.out.println(Math.sqrt(25));
		
		System.out.println();
		System.out.println("[7] toRadians() : degree → radian 변환");
		System.out.println(Math.toRadians(180));
		System.out.println(Math.toRadians(360));
		
		System.out.println();
		System.out.println("[8] toDegrees : radian → degree 변환");
		System.out.println(Math.toDegrees(Math.PI));
		System.out.println(Math.toDegrees(2 * Math.PI));
		
		
		System.out.println();
		System.out.println("[9] abs : 절대값");
		System.out.println(Math.abs(-2.4));
		System.out.println(Math.abs(2.4));
		
		
		System.out.println();
		System.out.println("[10] 삼각함수 ");
		System.out.println(Math.sin(Math.PI / 2));   // sin 함수
		System.out.println(Math.asin(Math.PI / 2));   // arc sin  : 역 삼각함수     asin(90도) --> 무한대  이경우 NaN 출력

		
		
		
		
		// ※ 정수 난수 발생시 Random() 객체 사용하자.
		System.out.println();
		System.out.println("Random 객체 ");
		Random r = new Random();
		for(int i = 0; i < 10; i++) {
			System.out.print(r.nextInt(4) + " ");
		}
		System.out.println();
		System.out.println(new Random().nextInt(2));
		

	} // end main()

} // end class Math01Main


















