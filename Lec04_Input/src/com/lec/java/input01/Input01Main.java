package com.lec.java.input01;

import java.util.Scanner;

/*
 * 표준 입력 (Standard Input) : 키보드로부터 입력
 * 			Scanner 객체 사용
 * 
 * 표준 출력 (Standard Output) : 모니터로 출력
 */
public class Input01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("표준입력 : Scanner 사용");
		Scanner scan = new Scanner(System.in); 
		//Scanner 사용한 입력 작업
		int num1,num2;
		System.out.print("숫자 1을 입력하세요 : ");
		//터미널에 빨간 정지버튼이 있다면 아직 실행중이라는 의미
		num1=scan.nextInt();
		
		System.out.print("숫자2를 입력하세요 : ");
		num2 = scan.nextInt();
		
		
		System.out.println("num1 : "+num1);
		System.out.println("num2 : "+num2);
		System.out.println("num1 + num2 = "+ (num1+num2));
		System.out.printf("%d + %d = %d",num1, num2, num1+num2); //서식문자열로 한 것
		
		//nextInt()에서 문자나 다른 것을 입력하면 에러발생 InputMismatchException~~~
		
		scan.close(); 	//객체를 사용한 뒤에는 반드시 close()~~
		
		// 각 primitive 타입에 대해 nextXXX() 메소드 제공
//		sc.nextByte();
//		sc.nextShort();
//		sc.nextLong();
//		sc.nextFloat();
//		sc.nextDouble();
//		sc.nextBoolean();
// 		sc.nextchar 는 존재하지 않음
		
		
		
		
		
		
		
		
		
	}

}
