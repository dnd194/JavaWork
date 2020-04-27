package practice.capitalize;

import java.util.Scanner;
import java.util.StringTokenizer;

/* LetterCapitalize
 * 	문장을 입력하고,  단어의 앞 문자를 대문자로 만들어 출력하기를 반복하다가
 *  quit 을 입력 받으면 종료하기
 * 
 * 	[입력예]
 * 		hello my world
 *  [출력예]
 * 		Hello My World  
 */

public class LetterCapitalize {

	// TODO : 필요한 메소드 있으면 추가 작성

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String input = sc.nextLine();
	
		for (String space : input.split("\\s+")) {
			
			StringTokenizer token = new StringTokenizer(space);
			while (token.hasMoreElements()) {
				String newStr = token.nextToken();
				if (newStr.equals("quit")) {
					break;
				}
				String first = newStr.substring(0, 1).toUpperCase();
				String last = newStr.substring(1);
				String full = first.concat(last);
				System.out.print(full + " ");
			}
		}
		sc.close();

	} // end main()
} // end class
