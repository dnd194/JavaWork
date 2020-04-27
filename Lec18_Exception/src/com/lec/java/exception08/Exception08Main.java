package com.lec.java.exception08;

import java.util.Scanner;

public class Exception08Main {

	static Scanner sc = new Scanner(System.in);

	// TODO : AgeInputException 을 throws 하는 메소드 정의
	public static int inputAge() throws AgeInputException {
		System.out.println("나이 입력:");
		int age = sc.nextInt();

		// TODO : AgeInputException 을 throw 하기
		if (age <= 0 || age > 120) {

			AgeInputException e = new AgeInputException("나이 오바야~");
			throw e;
		}

		return age;

	} // end inputAge()

	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기 2");

		// TODO
		for (int i = 0; i < 5; i++) {
			try {
				inputAge();
			} catch (AgeInputException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}
			sc.nextLine();
		}

		System.out.println("프로그램 종료...");

	} // end main()

} // end class Exception08Main
