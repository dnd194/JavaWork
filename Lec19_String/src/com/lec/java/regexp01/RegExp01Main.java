package com.lec.java.regexp01;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 정규표현식 regular expression
 * 
 * 문자열 검색, 치환  등의 동작에 있어서
 * 단순한 '문자열 비교' 를 하는 것이 아니라 
 * 특정 '패턴'과 비교하고자 할때 이를 단 몇줄의 코드로 구현 가능!
 * 주어진 문자열에서 패턴을 찾아내는 것을 '패턴 매칭(pattern matching)' 이라 함
 * 
 * 사용자가 입력한 문자열 패턴 유효성 체크 등에 많이 사용
 * 		ex) 주민등록번호, URL, email, 비밀번호, 
 * 			날짜포맷(yyyy-mm-dd) 
 * 			전화번호(010-xxxx-xxxx) ... 
 * 
 * 자바는 java.util.regex 에서 관련 클래스들 제공
 * 		Pattern, Matcher ..
 * 
 * 일반적인 작성단계
 * 	 1) 주어진 정규표현식을 구현하는 Pattern 객체 생성
 *   2) 패턴 매칭 수행객체 Matcher 생성
 *   3) Matcher 객체로부터 패턴매칭을 수행하여  검색, 치환등의 동작
 * 
 * 장점: 코딩량 저감, 거의 대부분의 언어에서 공용으로 사용.
 * 단점: 처음에 배우기 어렵고, 코드 가독성 떨어뜨림.
 * 
 * 정규표현식을  사용하는 String 메소드들:
 * 	matches(), split(), replaceAll(), replaceFirst()
 * 
 * 정규표현식 연습 사이트 추천
 * : https://regexr.com/    (정규식 , 문자열 매칭 연습)
 * : https://regexone.com/  ( step by step 으로 연습 하기 좋음)
 * : https://regexper.com/  (특징: 시각화, 정규식을 이미지로 다운가능)
 * : https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html  (오라클 공식)
 * ─────────────────────────────────────────────────────────────
 * 	정규표현식		설명
 * 	^			문자열 시작
 * 	$			문자열 종료
 * 	.			임의의 문자 [단 ‘'는 넣을 수 없습니다.]
 * 	*			앞 문자가 0개 이상의 개수가 존재할 수 있습니다.
 * 	+			앞 문자가 1개 이상의 개수가 존재할 수 있습니다.
 * 	?			앞 문자가 없거나 하나 있을 수 있습니다.
 * []			문자의 집합이나 범위를 표현합니다. -기호를 통해 범위를 나타낼 수 있습니다. ^가 존재하면 not을 나타냅니다.
 * {}			횟수 또는 범위를 나타냅니다.
 * ()			괄호안의 문자를 하나의 문자로 인식합니다.
 * |			패턴을 OR 연산을 수행할 때 사용합니다.
 * \s			공백 문자
 * \S			공백 문자가 아닌 나머지 문자
 * \w			알파벳이나 문자
 * \W			알파벳이나 숫자를 제외한 문자
 * \d			[0-9] 숫자
 * \D			숫자를 제외한 모든 문자
 * (?i)			대소문자를 구분하지 않습니다.
 */
public class RegExp01Main {

	public static void main(String[] args) {
		System.out.println("정규표현식 regular expression");
		
		String input;
		String regex;  //정규표현식을 담을 문자열 
		
		Pattern pat;		//객체선언
		Matcher matcher;	//객체선언
		
		System.out.println();
		System.out.println("■ 정규표현식 객체, 메소드 연습");
		System.out.println("패턴] .  ← 임의의 문자 하나");
		
		// 1).주어진 정규표현식을 구현하는 Pattern 객체 생성
		// Pattern.compile(정규표현식 문자열) 사용  

		regex = "My....";  //My로 시작하고 뒤에 임의의 문자 4개가 따라오는 패턴   정규표현식 '.' 확인
		pat = Pattern.compile(regex);  //pattern 객체 생성  regex와 비교하는 pattern 객체
		
		input = "-My1234-";          //'My1234' My....(regex)과 같은 패턴존재
//				 01234567 ==> index
		// 2) 패턴 매칭 수행객체 Matcher 생성
		// Pattern 의 matcher() 사용
		// Pattern을 사용해서 주어진 문자열에서 패턴 매칭할 객체 생성 --> Matcher객체 리턴
		// (아직 패턴 매칭을 진행하진 않았다)
		
		matcher = pat.matcher(input);    	//patter 객체에 matcher 가 있음   ==> Matcher 객체를 return 함
		
		
		// 3) Matcher 객체로부터 패턴매칭을 수행하여  검색, 치환등의 동작  
		//  find() '다음' 패턴매칭 검색 , 패턴매칭 발견하면 true 아니면 false 리턴
		//  group() 바로 직전에 패턴매칭된 문자열 String 리턴
		//  reset() 다시 처음부터 패턴매칭하도록 reset 함.
		//  replaceFirst() : 첫번째 매칭을 치환
		//  replaceAll() : 모든 매칭을 치환
		//  matches() : 패턴매칭이 '문자열 전체영역' 이 패턴매칭 되는지 여부
		//  start() : 최근 매칭의 시작 index, 
		//  end() : 최근 매칭의 끝 index (마지막 매칭된 문자 '다음' 인덱스값)  ==> 그래서 7이 찍힘
		if(matcher.find()) {
			System.out.println("find() 성공");
			System.out.println(matcher.group()+"{"+matcher.start()+"~"+matcher.end()+"}");
			
		}else {
			System.out.println("find() 실패");
		}
		
		
		//위의 코드를 다시 실행하면? 그 매칭된 다음부터 수행한다
		if(matcher.find()) {             //==>실패가 나옴
			System.out.println("find() 성공");
			System.out.println(matcher.group()+"{"+matcher.start()+"~"+matcher.end()+"}");
			
		}else {
			System.out.println("find() 실패");     
		}
		
		// reset() 다시 처음부터 패턴매칭하도록 reset 함.
		matcher = matcher.reset();  
		if(matcher.find()) {
			System.out.println("find() 성공");
			System.out.println(matcher.group()+"{"+matcher.start()+"~"+matcher.end()+"}");
			
		}else {
			System.out.println("find() 실패");
		}
		
		// replaceFirst() : 첫번째 매칭 패턴을 치환하여 결과 리턴
		matcher.replaceFirst("XXXX");
		//==> 매칭된 첫번째 패턴 다음과 같은 문자열로 치환  My1234 => XXXX 로 바뀜
		System.out.println(matcher.replaceFirst("XXXX"));
		
		
		// matches()
		// 패턴매칭이 '문자열 전체영역' 이 패턴매칭 되는지 여부
		System.out.println();
		System.out.println("matches()");
		matcher = pat.matcher("-My1234-");
		
		if(matcher.matches()) {
			//matches()는 true , false 를 반환함
			System.out.println("matches()매칭 ok");
		}else {
			System.out.println("matches()매칭 fail");
		}
		matcher = pat.matcher("My1234");
		
		if(matcher.matches()) {
			//matches()는 true , false 를 반환함
			System.out.println("matches()매칭 ok");
		}else {
			System.out.println("matches()매칭 fail");
		}
		//위 코드를 아래와 같이 한번에 만들 수 있다
		if(Pattern.compile("My....").matcher("My1234").matches()) {
			//matches()는 true , false 를 반환함
			System.out.println("matches()매칭 ok");
		}else {
			System.out.println("matches()매칭 fail");
		}
		
		System.out.println();
		
		
		System.out.println("Pattern.matches(regex, input) 사용");
		// 단순히 '문자열 전체영역' 이 패턴에 맞는지 여부 만 확인하려면 간단하게 Pattern.matches() 사용하자.
		// Pattern.matches()는 내부적으로 정확히 아래와 같이 동작하게 된다.
		//     Pattern.compile(regex).matcher(input).matches()
		if(Pattern.matches("My....", "myabcd")) {    //왼쪽이 기준, 오른쪽이 비교할 문자열
			System.out.println("pattern.matches() ok");
		}else {
			System.out.println("pattern.matches() fail");
		}

		System.out.println();
		System.out.println("■ 여러개 패턴 검색");
		
		// 과연 "My...." 으로 몇개가 매칭되나?  : 예측해보자
		// 기본적으로 대소문자를 구분하여 매칭한다
		input = "-My98kk-myABCD--My1234567--MyZZ---My789";   //3개가 매칭이 된다
				// o      x         o        o      x
		
		matcher = pat.matcher(input);
		while(matcher.find()){                 //find() 함수의 특징을 볼 것
			System.out.println(matcher.group()+"{"+matcher.start()+"~"+(matcher.end()-1)+"}");
			//end()는 매칭된 다음 인덱스를 리턴해주어서 '-1' 해주면 매칭되는 인덱스 확인 가능
		}
		System.out.println();
		
		System.out.println(matcher.replaceFirst("***")); //처음에 매칭된 것만 치환 replaceFirst
		System.out.println(matcher.replaceAll("***")); // 매칭된 모든것 치환 replaceAll
		
		System.out.println();
		System.out.println("find(fromIndex)");  // fronIndex부터 검색

		matcher = pat.matcher(input);      //-My98kk-myABCD--My1234567--MyZZ---My789
		int fromIndex=16;
		
		while(matcher.find(fromIndex)){            
			System.out.println(matcher.group()+"{"+matcher.start()+"~"+(matcher.end()-1)+"}");
			//end()는 매칭된 다음 인덱스를 리턴해주어서 '-1' 해주면 매칭되는 인덱스 확인 가능
			fromIndex= matcher.end();  //이렇게 해주지 않으면 계속 조건값이 계속 true 이므로 무한루프됨
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

















