package com.lec.java.array01;

/* 배열(Array)
 		동일 타입의 여러개의 데이터를 담는 집합자료형
 	
 	배열 선언
 		자료타입[] 변수이름;
 		
 	배열 원소 (element)
 		배열에 담긴 각각의 데이터
 		
 	배열의 길이 (length)
 		배열 원소의 개수, 즉 배열에 담긴 데이터의 개수 
 		
 	배열 인덱스 (첨자, index)
 		배열의 인덱스는 0부터 시작해서, (배열의 길이 - 1)까지가 됨
 		배열인덱스를 사용하여 배열원소에 접근하여 사용
 	
 	배열을 new로 생성한뒤에는 자동초기화 가 됨.
		숫자타입들은 --> 0으로
		boolean타입은 --> false 로
		객체타입(Object) 타입은 --> null 로.
 	
 	★ 배열변수의 타입, 배열원소의 타입 확실히 구분하자
 	★ JVM 메모리 상에 생기는 구조 이해 필수 
 */
public class Array01Main {

	public static void main(String[] args) {
		System.out.println("배열(Array)");
		
		//다량의 데이터를 위해서 매번 변수를 작성하는 것은 사실상 불가
		
		//배열 선언, 초기화
		int[]korean = new int[3];
		//int타입 배열 선언
		//3개의 int 데이터를 담는 배열로 초기화
		
		korean[0]=90;
		korean[1]=80;
		korean[2]=70;
		System.out.println("국어 0번째 "+korean[0]);
		System.out.println("국어 1번째"+korean[1]);
		System.out.println("국어 2번째 "+korean[2]);
		
//		korean[3] ==>> 에러 indexoutof~~
		System.out.println("for 사용하여 배열 출력");
		for ( int i = 0 ; i<3; i++) {
			System.out.println("korean["+i+"] ="+korean[i]);
		}
		
		System.out.println();
		
		int [] english = new int[5];
		System.out.println(english[1]); //==> 0을 대입한 적이 없는데 결과로 0이 나온다.
		//하나의 규칙임 숫자타입의 배열은 초기화 하지 않으면 '0' 으로 자동 초기화 된다.
		
		for(int i =0; i<5; i++) {
			english[i]=i*10;
		}
		for(int i = 0; i < english.length; i++) {
			System.out.println("영어 " + i + " : " + english[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // end main()

} // end class Array01Main









