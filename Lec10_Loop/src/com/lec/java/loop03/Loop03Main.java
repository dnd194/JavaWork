package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
		for (int i = 2; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.println(i + " x " + j + " = " + (i * j));
			}
			System.out.println();
		}

		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용
		int i = 2;
		int j = 1;
		while (i < 10) {
			while (j < 10) {
				System.out.println(i + " x " + j + " = " + (i * j));
				j++;
			}
			j = 1; // j 는 이미 2단에서 9까지 돌았기 때문에 조건문을 충족시키기위해서 초기화 시켜줘야한다.
			System.out.println();
			i++;

			
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
