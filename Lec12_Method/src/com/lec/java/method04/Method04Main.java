package com.lec.java.method04;

import java.util.Scanner;

/* 메소드 연습
 * 
 * 두개의 숫자를 받아서 아래와 같이 4칙연산을 수행한다.
 * 
 * 
 * [입력예]
 * 100 40
 * 
 * [출력예]
 * 100.0 + 40.0 = 140.0
 * 100.0 - 40.0 = 60.0
 * 100.0 x 40.0 = 4000.0
 * 100.0 / 40.0 = 2.5
 */

/*
 * 
 * public static double inputNumber(Scanner sc)
 * public static void calcSub(double x, double y)
 * public static void calcSub(double x, double y)
 * public static void calcMul(double x, double y)
 * public static void calcDiv(double x, double y)
 * 
 * Scanner 객체를 매개변수로 받을수 있다.
 * (메소드 안에서 Scanner 객체를 생성할수는 있으나... 제대로 close() 되지 않은채 생성하면 문제 발생) 
 * 
 * 이클립스에서 함수 호출 위에서 F3 누르면 정의 로 넘어감
 */
public class Method04Main {

	public static void main(String[] args) {
		System.out.println("메소드 연습 : 초간단 계산기");

		Scanner scan = new Scanner(System.in);

		double num1 = inputNumber(scan);

		scan.close();

		System.out.println("num1 : " + num1);
		System.out.println("\n프로그램 종료");
	} // end main()

	// method name: inputNumber
	// return: double
	// arguments: Scanner scan - 키보드 입력을 위한 객체
	// 기능: 키보드로 입력받은 double형 데이터를 리턴
	public static double inputNumber(Scanner scan) {
		double result;
		while (true) {
			System.out.print("0~100 사이 숫자 입력 : ");

			result = scan.nextDouble();
			if (result < 0.0 || result > 100.0) {
				System.out.println("다시 입력해주세요");
				continue;   //가장 가까운 블록으로 돌아감
			}
			break;
		}

		return result;

	}

	// method name: calcSum
	// return: void
	// arguments:
	// 1) double x
	// 2) double y
	// 기능: 두 수 x, y의 합을 출력(print)
	// TODO

	// method name: calcSub
	// return: void
	// arguments:
	// 1) double x
	// 2) double y
	// 기능: 두 수 x, y의 차(x - y)를 출력(print)
	// TODO

	// method name: calcMul
	// return: void
	// arguments:
	// 1) double x
	// 2) double y
	// 기능: 두 수 x, y의 곱(x * y)를 출력(print)
	// TODO

	// method name: calcDiv
	// return: void
	// arguments:
	// 1) double x
	// 2) double y
	// 기능: 두 수의 나눗셈(x / y) 결과 를 출력(print)
	// TODO

} // end class
