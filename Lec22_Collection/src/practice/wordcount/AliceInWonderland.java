package practice.wordcount;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* 1] 문서(문자열) 안의 단어의 빈도수를 계수해서 출력하기
 * 	- 대소문자 구분하지 않기 :   The 와 the 는 같은 단어
 *  - 2글자 이상만 계수하기
 *  - 구두점/기호 ",.\"\'`!?;:-()" 잘라내기
 *  - 공백 짤라내기
 * ex)
 * 	an : 234
 * 	the : 314
 * ...
 * 
 * hint]
 * 	split("\\s+")  --> String[]   
 * 	--> StringTokenizer  (혹은 정규표현식)
 *  	  --> HashMap<String, Integer>   <단어, 빈도수>  사용
 * ───────────────────────────────────────────────────────────    
 * 2] 빈도수 내림차순으로 정렬하여 출력하기
 * 	ex)
 *	1 the:113개
 *	2 she:95개
 *	3 to:85개
 *	...   
 *
 * hint]
 * 	Comparable<> 이나 Comparator<> 적용
 */

// TODO : 필요한 객체들 작성
// hint> 빈도수 담을 객체, Comparator<> ..

public class AliceInWonderland {

	public static void main(String[] args) {
		System.out.println("실습: 단어 발생 빈도");
//		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		String[] words = C.ALICE30.trim().toLowerCase().split("\\s+");

		String first;
		ArrayList<String> second = new ArrayList<String>();
		for (String e : words) {
//			System.out.println(e);
			StringTokenizer s1 = new StringTokenizer(e, ",.\"\'`!?;:-()");
			while (s1.hasMoreTokens()) {
//				System.out.println(s1.nextToken());  //기호가 제거된 채로 token이 나옴

//				

//				first = s1.nextToken();   //현재 글자 수 상관없이 문자열에 담는다
//				second.add(first);

				// TODO 근데 한글자 2글자 이상만 담을거야 done
				first = s1.nextToken();
				// ==> String first에는 토큰을 담는다.

				if (first.length() >= 2) { // => 문자열에 담은 토큰의 길이가 2이상만
					second.add(first); // => arraylist에 추가한다.
				}

				// first에는 뽑아낸 기호가 제거된 토큰들이 담김
				// first 는 문자열임
//				System.out.println(first.toString()); 
				// 이렇게하면 다음 토큰이 first 에 계속 덮어씌워져서 찍히는 거임
				// 그래서 지금 이 문자열들을 다시 배열로 담아야 함

			}
		}
		String[] third = second.toArray(new String[second.size()]);
		// 문자열 '배열' third 는 arraylist second 를 second 의 크기만큼의 새로운 배열로 만듬

		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < third.length; i++) {
			Integer v = map.get(third[i]); // v에 key 값이 담김 ===> third[i] = key 값
			if (v == null) { // 기존에 해당 키값이 없는 경우 == 처음 등장한 경우

				map.put(third[i], 1); // 등장 횟수 1

			} else { // 최소한 한번 등장했다 라는 것을 의미
				map.put(third[i], v + 1);
			}

		}
//		for(Map.Entry<String, Integer> e1 : map.entrySet()) {    ==> 내림차순 없이 분류만 되는 코드
//			
//			System.out.println(e1.getKey() + " : "+ e1.getValue()+"개");
//			
//		}

		// ------------------- 여기까지 분류 및 출력 된다
		// 이제 내림차순으로 만들차례 (기준이 value 값임) value의 타입은 integer key 값 타입은 String
		List<String> keySetList = new ArrayList<>(map.keySet());
		// collections.sort를 쓰기위해선 list가 필요함
		
		// value 값에 따라 내림차순 하는 람다식
		Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
		for (String key : keySetList) {
			System.out.println(key + " / " + map.get(key) + " 개 ");
		}

		// 발생빈도 작성
		// TODO

		// 결과 출력
		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class

