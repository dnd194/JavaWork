package practice.maxwords;



import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;


/* MaxWrod
	여러문장으로 구성된 문자열을 입력받은뒤 
	문자열에서 가장 단어의 개수가 많은 문장을 찾아서, 
	그 문장과 문장의 단어의 개수를 출력
	'문장'의 구분은  .(마침표) !(느낌표) ?(물음표) 로 한다.
	'단어'구분은 '공백' 으로 한다
	
	입력예]
	We test coders. Give us a try. Can you make it out? It's awesome.
	
	출력예]
	5개
	Can you make it out
 */
public class MaxWord {
	
	// TODO : 필요한 메소드 있으면 추가 작성
	
	public static void main(String[] args) {
		int count = 0;
		String text1 = "";   //text1 초기화
		Scanner sc = new Scanner(System.in);					// 스캐너
		
		String text = sc.nextLine();							// 문장을 받습니다
		
		StringTokenizer n1 = new StringTokenizer(text,"!?.");	// 문장을 !?. 으로 나눠줍니다
		
		while(n1.hasMoreTokens()) {								// 토큰값만큼 반복합니다
			
			String n2 = n1.nextToken().trim();					// 문장의 앞뒤 공백을 제거하고 첫번째 토큰값을 스트링타입 n2로 저장합니다
			
			String[] n3 = n2.split("\\s+");						// n2의 값을 여백을 기준으로 스트링타입배열 n3에 넣어줍니다
			System.out.println(Arrays.toString(n3));
			//n3에 n2가 쌓이는게 아니라 계속해서 덮어씌워짐
			
			if (count <= n3.length) {							// 카운트값보다 다음 오는값이 큰지 확인
				count = n3.length;								// 크다면 카운트값을 변경
				text1 = n2;										// 토큰의 문장값을 text1에 저장
			}
			
		
		}	//end while
		
		System.out.println(count+"개");							// 모든 반복이 종료된후 카운트값을 가져옴
		System.out.println(text1);								// 저장된 문장 토큰값을 가져옴
		
		// 문장 분리한다
		// 단어의 갯수를 확인한다
		// 제일 많은단어가 들어간 토큰값과 단어의갯수를 출력한다
		
		
		
		
		
		
		sc.close();
	} // end main
} // end class
