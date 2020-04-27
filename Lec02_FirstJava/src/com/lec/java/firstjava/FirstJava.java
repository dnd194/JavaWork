package com.lec.java.firstjava;


/*
모든 자바 프로그램은 main() 메소드로부터 '시작'한다
프로그램 실행순서는 '시작' 부터 한 문장(Statement) 씩 실행되는 것이 원칙
문장의 끝은 반드시 세미콜론 ';' 으로 마무리 해야 한다
*/

//블럭주석 /* ~ */

public class FirstJava {
	
	public static void main(String[] args) {
		System.out.println("My First Java App");
		System.out.println(123);
		System.out.println(); //줄바꿈만 함
		System.out.println(10+20); //숫자로 인식하여 연산한다
		System.out.println("10 + 20"); //문자열로 인식한다  ex) " ~ " 
		
		//문자열 출력은 반드시 " " 로 감싸야한다. !!!
		
//		System.out.println(안녕하세요);  =>> 에러  한줄 주석처리 방법: ctrl + / 
		
		System.out.println(3.141592 * 10 * 10 );
		System.out.println(10 * 10 / 2 );
		
//		+ 연산자의 여러가지 동작
//		좌 우 측 중에 한개라도 "문자열" 일 경우 "문자열 연결" 을 한다
//		위에 줄 복사 ctrl + alt + 방향키 아래
//		줄 삭제 ctrl + d 
//		단축키는 프로그래밍을 경쾌하게함 
		System.out.println("안녕하세요" + " 여러분"); //문자열끼리 연결해주는 연산
		System.out.println("결과 : "+ 10);
		System.out.println("결과 : "+ 10 + 20 );
		System.out.println("결과 : "+ (10 + 20) );
		
//		사칙연산 보여주기 (+, -, *, /)
		System.out.println("10 + 20 = " + (10+20));
		System.out.println("10 - 20 = " + (10-20));
		System.out.println("10 * 20 = " + (10*20));
		System.out.println("10 / 20 = " + (10.0/20.0)); //정수 / 정수 = 정수가 나옴 (소숫점이하는 절삭)
		System.out.println("10 / 20 = " + ((double)10/20)); //정수 / 정수 = 정수가 나옴 (소숫점이하는 절삭)
		System.out.println("10 % 20 = " + (10%20));
		
//		이스케이프 문자 (escape character)
//		example : she says "hi"
//		"~" 문자열 안에서 특수한 문자 출력
//		역슬래시(\) 와의 조합문자로 구성
		/*
		 * \"  => 쌍따옴표 
		 * \n  => 개행
		 * \t  => 탭문자
		 * \\  => 역스래시
		 */
		System.out.println("she says \"HI\"");
		System.out.println("1 \t23\t 456");
		System.out.println("10\n \\4");
		System.out.println("avengers \n\\Endgame\\");
		
		
		
		
		
		
		

		
	}

}	 
//여러줄 블록처리하고 탭 누르면 전체띄우기됨