package com.lec.java.regexp04;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 정규표현식 연습
 * 
 * 이번에 우리 쇼핑몰에서 할인 쿠폰을 발행하려 한다.
 * 발행되는 쿠폰의 일련번호 형식은 다음과 같다.
 * 
 *    															***** 알파벳두자리-숫자4자리-숫자3자리-알파벳3자리  ****** 
 * 
 * 						알파벳은 대소문자 구문 없슴
 * 						숫자는 0으로 시작하면 안됨.   ==> 조건
 * 						사용자는 발급받은 쿠폰번호를 입력해야 하는데, 
 * 						위와 같은 형식만 받아들일수 있도록 만들자
 * 
 * 허용예]
 * 	Ab-7890-786-zuy
 * 	ki-2010-893-Zip
 * 
 * 불가]
 * 	xX-1200-089-zuy
 * 	p9-324-089-zopl
 * 
 *  쿠폰번호를 계속해서 입력 받으면서 
 * "유효한 쿠폰입니다"  혹은 "유효한 쿠폰이 아닙니다" 판정결과를 출력
 * 
 * 'quit' 입력하면 프로그램 종료

 */

public class RegExp04Main {

	public static void main(String[] args) {
		System.out.println("쿠폰을 입력하세요 ");

		String input; // 허용예시
		String regex; // 정규표현식을 담을 문자열

		Pattern pat;
		Matcher mathcer;

		System.out.println();

		Scanner scan = new Scanner(System.in);
		while (true) {
			input = scan.nextLine();
			regex = "(^[a-zA-Z][a-z]+[-]?[1-9]\\d{3}[-]?[1-9]\\d{2}[-]?[a-zA-Z]{3})$";
//			pat = Pattern.compile(regex);
			regExpTest(regex, input);

			if (input.equals("quit")) {
				break;
			}
		}

//		input = "Ab-7890-786-zuy";  확인 예시

		System.out.println("프로그램 종료");
	} // end main

	public static void regExpTest(String regex, String input) {
		System.out.println("[쿠폰 매칭 테스트]------------------------");
		System.out.println();
//		System.out.println("정규 표현식 : "+regex);
		System.out.println("입력 문자열 : " + input);

		Matcher matcher = Pattern.compile(regex).matcher(input);
		

		if (matcher.find()) {

			System.out.println("유효한쿠폰입니다.");

			matcher = matcher.reset();
		}else {
			System.out.println("유효한 쿠폰이 아닙니다");
			matcher = matcher.reset();
			
		}

	}
} // end class
