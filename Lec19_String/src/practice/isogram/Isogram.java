package practice.isogram;

import java.util.Arrays;
import java.util.Scanner;

/*	Isogram
	 문자열을 입력받으면 isogram 여부를 판단하여 true/false 를 출력하다가, quit 가 입력되면 종료
	isogram 이란?  : 중복된 알파벳이 없는 단어
	
	 isogram 예) Machine, isogram, Alphabet, quit
 */
public class Isogram {

	public static boolean is_isogram2(String str) {

		str = str.toLowerCase(); // 먼저 소문자 모는 것이 좋음

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.substring(i + 1).indexOf(str.charAt(i)) != -1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input;
		while(true) {
			input= sc.next();
			if(input.equalsIgnoreCase("quit")) {
				break;
			}
			System.out.println(is_isogram2(input));
		}
		sc.close();

	} // end main()
} // end class
