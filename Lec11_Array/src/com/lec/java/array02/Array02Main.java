package com.lec.java.array02;
/*  배열의 선언과 초기화
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");
		
		
		int[]korean = new int[3];
//						length : 데이터 개수 ====> 3
//						size   : 데이터 용량 ====> 12 byte
		
		korean[0]= 100;
		korean[1]= 90;
		korean[2]= 80;
		
		for (int i = 0; i < korean.length; i++) {  //어시스트 기능 쓰면 편함
			System.out.println(korean[i]);
		}
		
		//선언과 동시에 초기화
		int[] english = new int [] {30,20,30};
		for (int i = 0; i < english.length; i++) {
			System.out.println(english[i]);
		}
		
		int [] math = {99,88,77,66};   //축약형
		for (int i = 0; i < math.length; i++) {
			System.out.println(math[i]);
		}
		
		//수학 점수들의 총점과 평균 계산
		int total = 0;
		for (int i = 0; i < math.length; i++) {
			total += math[i]; //누적합산
			
		}
		double avg = (double)total / math.length;
		System.out.println("수학 총점 : "+total+"\n수학 평균 : "+avg);
		
		System.out.println();
		//배열변수를 출력하면??
		//  () 괄호
		//  {} brace 
		//  [] bracket
		
		System.out.println(math); // ==> math 배열의 주소 값이 나옴
		
		
		
		
		
		
		
		
		
		
		
		
	} // end main()

} // end class Array02Main











