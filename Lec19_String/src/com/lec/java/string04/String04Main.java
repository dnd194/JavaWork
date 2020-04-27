package com.lec.java.string04;

import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer 클래스

	token ? : '규칙'에 의해 구분된 더 이상 나눌수 없는 문자요소(문자열)
				(문법적으로 더 이상 나눌 수 없는 기본적인 언어요소)
*/

public class String04Main {

	public static void main(String[] args) {
		System.out.println("StringTokenizer 클래스");

		// token <- '규칙'에 의해 구분된 문자덩어리(문자열)?
		String str1 = "13:46:12";

		StringTokenizer tokenizer = new StringTokenizer(str1, ":");
		// 1번째 매개변수는 쪼갤 문자열, 2번째 매개변수 쪼개는 기준
		System.out.println("토큰의 개수 : " + tokenizer.countTokens()); // 토큰의 개수를 뽑는 countTokens()

		while (tokenizer.hasMoreTokens()) {// hasMoreElements랑 비슷합니다
			// 아직도 뽑을 토큰이 있냐?? 라는 것과 같음 근데 WHILE 문안에 있으니 그냥 boolean 타입을 return 한다는 것만 알면될듯
			System.out.println(tokenizer.nextToken());
		}
//		tokenizer.nextToken(); ==> no such elements exception 이미 다 뽑았는데 한번 더 그럴경우

		System.out.println();
		String str2 = "abc:def:ghi:jkl:mno"; // : (구분자 or delimeter)로 토큰분리

		tokenizer = new StringTokenizer(str2, ":");
		while (tokenizer.hasMoreElements()) {
			System.out.print(tokenizer.nextElement() + " ");
		}

		System.out.println();
		String str3 = "2015/04/08"; // / 로 토큰분리

		tokenizer = new StringTokenizer(str3, "//");
		while (tokenizer.hasMoreElements()) {
			System.out.println(tokenizer.nextElement());
		}

		System.out.println();
		String str4 = "2015년-4월-8일"; // - 으로 토큰분리

		tokenizer = new StringTokenizer(str4, "-");
		while (tokenizer.hasMoreElements()) {
			System.out.print(tokenizer.nextElement() + " ");
		}

		System.out.println();

		String str5 = "2015-04-08 14:10:55";
//		String date = str5.split("\\s+")[0];
//		String time = str5.split("\\s+")[1];
//		System.out.println("date : "+Arrays.toString(date.split("-")));
//		System.out.println("time : "+Arrays.toString(time.split(":")));
		StringTokenizer token5 = new StringTokenizer(str5, "-:"); // tokenizer 는 딜리미터에 - : 두개다 넣으면 알아서 해준다
		// delimeter 자리에 여러개 가능
		while (token5.hasMoreElements()) {
			System.out.print(token5.nextElement() + " ");
		}

		System.out.println();
		// StringTokenizer 생성자의 세번째 매개변수를 true 로 주면
		// delimiter 도 token 으로 추출된다
		String str6 = "num += 1";

		StringTokenizer token6 = new StringTokenizer(str6, "+=");
		while (token6.hasMoreElements()) {
			System.out.print(token6.nextElement() + " ");
		}
		System.out.println();
		token6 = new StringTokenizer(str6, "+=", true);
		while (token6.hasMoreElements()) {
			System.out.print(token6.nextElement() + " ");
		}

		// 실습]
		// 다음과 같은 수식이 있을때 토큰들을 분리해네세요
		// 연산자 + - / * 괄호 ( )
		// 10 + (name * 2) / num8- (+3)
		// 힌트]
		// 일단 공백으로 분리 split()
		// 그리고 나서 각각을 StringTokenizer 함

		System.out.println();
		System.out.println("수식 분석기");
		String expr = "10  +  (name * 2) / num8- (+3)";

		
		
		for( String space2 : expr.split("\\s+")) {   //문자열을 공백을 기준으로 split
			
			StringTokenizer token7 = new StringTokenizer(space2,"+-*/()",true);
			while(token7.hasMoreElements()) {
				System.out.print(token7.nextToken()+", ");
			}
		}
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
