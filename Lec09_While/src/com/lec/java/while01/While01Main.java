package com.lec.java.while01;

/*
 	*** 조건식이 true 인 동안 while 블럭 반복 ***
 	
 	while(조건식 true / false){
 		.. 
 		..
 	}
 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		int count = 1;   //for문의 초기식 과 비슷
		while(count <= 10) {   //for문의 조건식 
			System.out.print(count+" ");             //문장의 순서에 따라서 출력 값이 달라질수 있으니 주의
			count++;     //for문의 증감식
			
		}
		System.out.println();
		int count2 = 10;
		while(count2 > 0) {
			System.out.print(count2+" ");
			count2--;
		}

	} // end main()
	
} // end class While01Main









