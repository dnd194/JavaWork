package com.lec.java.switch04;

public class Switch04Main {

	public static void main(String[] args) {
		System.out.println("String 타입을 switch에서 사용하기");
		
		String lang = "C++";
		switch (lang) {
		case "Java":
			System.out.println("hello java");
			break;
		case "Python":
			System.out.println("hello python");
			break;
		case "C++":
			System.out.println("hello C++");
			break;
		case "Swift":
			System.out.println("hello Swift");
			break;
		default:
			break;
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









