package com.lec.java.hello;
/*
 * Java 첫 프로그램.
 * [학습목표]
 * - 기본 출력 : println(), print() 
 * - 주석 (Comment)
 */
public class Hello {

	public static void main(String[] args) {
		System.out.println("Hello Java!!");
		//한줄 주석 : line comment
		
		System.out.println("안녕하세요");
		//println()은 화면 출력하고 줄바꿈
		//소스코드 = .java  - src =source 소스코드 = 클레스 파일
		//바이트코드 = .class - bin = binary 
		
		System.out.println();
		System.out.println(1+2);
		System.out.println("1"+"2");
		System.out.println('A'+'B');
		System.out.println('1'+ 2);
		System.out.println('J'+"ava");
		
		//print() 출력하고 줄바꿈하지않음
		System.out.print("자바");
		System.out.print("프레임워크");
		System.out.println("풀스텍과정");
		System.out.println("2020-03-16");
		
	}

}
