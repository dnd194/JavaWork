package com.lec.java.regexp03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 정규표현식 에 사용하는 각종 표현식들
 * 	정규표현식		설명
 * 	^			문자열 시작
 * 	$			문자열 종료
 * 	.			임의의 문자 [단 ‘'는 넣을 수 없습니다.]
 * 	*			앞 문자가 0개 이상의 개수가 존재할 수 있습니다.
 * 	+			앞 문자가 1개 이상의 개수가 존재할 수 있습니다.
 * 	?			앞 문자가 없거나 하나 있을 수 있습니다.
 * []			문자의 집합이나 범위를 표현합니다. -기호를 통해 범위를 나타낼 수 있습니다. ^가 존재하면 not을 나타냅니다.
 * {}			횟수 또는 범위를 나타냅니다.
 * ()			괄호안의 문자를 하나의 문자로 인식합니다. (그룹)
 * |			패턴을 OR 연산을 수행할 때 사용합니다.
 * \s			공백 문자
 * \S			공백 문자가 아닌 나머지 문자
 * \w			알파벳이나 숫자
 * \W			알파벳이나 숫자를 제외한 문자
 * \d			[0-9] 숫자
 * \D			숫자를 제외한 모든 문자
 * (?i)			대소문자를 구분하지 않습니다.
 * 
 * 
 * 자바 정규표현식에 사용되는 escaped character 들
 *    \.[]{}()<>*+-=!?^$|
 */
public class RegExp03Main {

	public static void main(String[] args) {
		System.out.println("정규표현식\n");

		String regex, intput, title;
		String[] arrInput;

		// ─────────────────────────────────────────
		title = "^ : 바로 문자뒤의 문자열로 시작됨";
		regex = "^The"; // The 로 시작하는 문자열 패턴
		arrInput = new String[] { "The Things", "On The Things", // 이거는 안됌
				" The The The", // 매칭없음 앞에 공백이 있기때문에
				"The The The The" // 1개만 매칭된다.

		};

		// ─────────────────────────────────────────
		title = "$ : 문자열의 마지막이 이 문자열로 마무리 됨";
		regex = "Man$"; // Man으로 끝나는 문자열 패턴을 의미
		arrInput = new String[] { "SuperMan", "AquaMan", "WonderWoman", // man 으로 끝나서 안됌
				"WonderWoMan", "PostMan " // 매칭 안됨 끝이 an+공백 이기 때문에
		};

		// ─────────────────────────────────────────
		title = "^표현식$ : 정확하게 전체패턴매칭되는 문자열"; // *******
		regex = "^Su...Man$"; // 'Su' 로 시작하고 '...' 아무글자 3글자 끝은 'Man' 으로 끝나는 문자열
		arrInput = new String[] { "SuperMan", "SugarMan", "Super Man", // 중간에 공백이있어서 안뎀
				" SuperMan", // 앞에 공백이있어서 안뎀
				"SuperMan " // 뒤에 공백이 있어서 안뎀
		};
		// ─────────────────────────────────────────
		title = " . : 어떤 문자든지 임의의 '한문자'를 말한다.꼭 하나의 문자와 매칭";
		regex = "x.y"; // x로 시작 + 임의의 문자 한개 + y로 종료
		arrInput = new String[] { "xyz", // x
				"xxzdfdk", // x
				"aa10x9zbxbz", // x
				"xz", // x
				"90x zxx_zdf", // 공백도 하나의 문자다! 매칭된다 //x
				"xbz", // x
				"xyyz x1y xx2yy xxyyxyxyyyxy" // o

		};

		// ─────────────────────────────────────────
		title = " * : 바로 앞의 문자가 없거나 한개 이상의 경우를 매칭";
		regex = "ab*"; // a로 시작하고 b는 없어도되고 1개 이상 이여도됨
		arrInput = new String[] { "a", // o
				"abc", // o
				"ab", // o
				"abbbaaaabababbab", // o 8개
				"bbba", // o 1개 마지막 a 한개
				"cdef" // x

		};

		// ─────────────────────────────────────────
		title = " + : 바로 앞의 문자를 나타내면 꼭 한개 혹은 그 이상을 매칭";
		regex = "ab+"; // a가 있고 b는 한개 이상 뒤따라와야한다
		arrInput = new String[] { "a", // x
				"abc", // o
				"ab", // o
				"abbbaaaabababbab", // o 5개
				"bbba", // x
				"cdef" // x
		};

		// ─────────────────────────────────────────
		title = " ? : 바로 앞의 문자가 한개 있거나 없는것을 매칭";
		regex = "ab?"; // a로 시작하고 b가 한개 있거나 없는 것을 매칭 여러개는 안됨
		arrInput = new String[] { "a", // o 1
				"abc", // o 1
				"kkabcc", // o 1
				"abbbaaaabababbab", // o 8
				"bbba" // o 1

		};

		// ─────────────────────────────────────────
		title = " [] : 안에 존재하는 문자들중 한 문자만을 매칭";
		regex = "[abc]"; // a 또는 b 또는 c 중에 한 문자에 매칭

		arrInput = new String[] { "able", // 2개 매칭
				"bible", // 2개 b2개
				"cable", // 3개 abc
				"xenosys", // x

		};
		regex = "[abc]+"; // abc 중 한 문자 한 개 이상
		arrInput = new String[] { "able", // 1개 매칭
				"bible", // 2개
				"cable", // 1개
				"xenosys", // x

		};
		regex = "[a-z]+"; // 알파벳 a 부터 z 까지 문자 한개 이상
		arrInput = new String[] { "abc100", "abcDefGHIUJ-KLM123opQrstuz" // 숫자 빼고 매치욈

		};

		regex = "[a-zA-z]+"; // 알파벳 a~z 까지 하나, 대문자 A~Z 까지 하나
		regex = "[a-zA-Z0-9]+"; // 알파벳 a~z 까지 하나, 대문자 A~Z 까지 하나 , 숫자 0~9 까지하나
		regex = "[a-zA-Z0-9-]+"; // 알파벳 a~z 까지 하나, 대문자 A~Z 까지 하나 , 숫자 0~9 까지하나, - 까지 하나 ==>한덩어리로 나옴
		arrInput = new String[] { "23", // 자연수
				"0", // 0은 자연수가 아님
				"-10", // 음수
				"023" // 0으로 시자가기 ㅐ문에 안됌

		};
		regex = "^[1-9][0-9]*"; // ==> 자연수 패턴을 구하는 정규표현식
		// 1~9 숫자하나로 시작하고 0~9까지의 숫자가 있거나 없거나
		// ─────────────────────────────────────────
		title = " {} : 앞에 있는 문자나 문자열의 등장개수를 정함";
		regex = "ab{2}"; // a가 있고 b의 등장 개수 2개
		arrInput = new String[] { "abb", "abbb", "abbbabbbbbbbbabaabab", };
		regex = "ab{2,}"; // a 가 있고 b의 등장개수가 2개 이상
		regex = "ab{3,5}"; // b의 개수가 3개부터 5까지

		// ─────────────────────────────────────────
		title = " () : ()안에 있는 글자들을 그룹화 ";
		regex = "a(bc)*"; // a가 있고 (bc)그룹이 1개 이상있거나 없거나
		arrInput = new String[] { "abc", // 1개
				"abcbcbbc", // 1개
				"abcabcabc", // 3개

		};
		// ─────────────────────────────────────────
		title = " | : OR 연산자  역할"; // 버티컬
		regex = "a|b"; // a또는 b 둘중 하나
		arrInput = new String[] { "a", // o
				"b", // o
				"ab", // o 2o
				"xyz", // x
				"abcbabababcbabcbcbabcbabcbababc", };
		regex = "(a|b)+";

		// ─────────────────────────────────────────
		title = "(?i)  : 대소문자 구분안하고 매칭 "; // 타 언어 정규표현식과 다름 ex)js
		regex = "(?i)abc"; // 대소문자 구분안하고 abc매칭

		arrInput = new String[] { "abc", "Abc", "aBC", "ABC", };

		// ─────────────────────────────────────────
		title = "\\s : 공백,  \\S : 공백아닌 문자";
		regex = "\\s+"; // 공백(spacebar, 줄바꿈, \t 전부 포함)이 한개 이상
		arrInput = new String[] { "Hello My World", // 2
				"He \tllo My World", // 3
				"\n\t Hello My World\n\n", // 4

		};

		regex = "\\S+";

		// ─────────────────────────────────────────
		title = "\\w : 알파벳이나 숫자                 ,          \\W 알파벳이나 숫자를 제외한 문자";
		regex = "\\w+"; // 알파벳이나 숫자 한개 이상

		arrInput = new String[] { "This is 2020-03-23 !!", // this is 2020 03 23

		};
		regex = "\\W+"; // 공백 공백 - - !!

		// ─────────────────────────────────────────
		title = "\\d : [0-9] 숫자, \\D 숫자를 제외한 모든 문자";
		regex = "\\d+"; // 0~9숫자 한개 이상

		arrInput = new String[] {

				"This is 2020-03-23 !!", // 2020 03 23
		};
		regex = "\\D+"; // 숫자를 제외한 문자 한개 이상 //this is
		
		// ─────────────────────────────────────────
		title = "escaped character 매칭 시키기";
		//regex = ".+";     // . => 정규표현식에서 의미하는 것이 있으므로 진짜 . 을 나타내고 싶으면 아래와같이 [.]로 표현해줘야한다
		regex="[.]+";   //진짜 . 을 나타내고 싶으면 [.]로 표현해줘야한다
		arrInput = new String[] {
				"My name is ..."
		};
		// *****************************************
		// 패턴매칭 수행
		System.out.println(title);
		regExpTest(regex, arrInput);

		System.out.println("프로그램 종료");
	} // end main()

	// 도우미 함수
	public static void regExpTest(String regex, String[] arrInput) {
		for (String input : arrInput)
			regExpTest(regex, input);
	}

	public static void regExpTest(String regex, String input) {
		System.out.println("[정규표현식 매칭 테스트]-----------------");
		System.out.println("정규표현식: " + regex);
		System.out.println("입력문자열: " + input);

		Matcher matcher = Pattern.compile(regex).matcher(input);
		int groupCount = matcher.groupCount(); // 그룹 개수

		int matchCount = 0;
		while (matcher.find()) {
			matchCount++;
			System.out.println("    매치" + matchCount + ": " + matcher.group() + " {" + matcher.start() + "~"
					+ matcher.end() + "}");

			// 그룹이 있으면 group별 출력
			if (groupCount > 0) {
				for (int i = 0; i <= groupCount; i++) { // i 범위 주목!
					System.out.printf("\t group(%d): %s {%d~%d}\n", i, matcher.group(i), matcher.start(i),
							matcher.end(i));
				}
			}

		} // end while
		if (matchCount == 0)
			System.out.println("   Ⅹ매치 없슴Ⅹ");
		System.out.println();
	} // end regExpTest()

} // end class
