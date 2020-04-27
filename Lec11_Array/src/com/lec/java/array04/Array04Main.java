package com.lec.java.array04;

import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		
		int [] a = new int[5];
		int sum=0;
		double avg=0;
		int max=0;
		int min=0;
		min++;
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < a.length; i++) {
			a[i] = scan.nextInt();
			
			sum += a[i];
			
			max = max > a[i] ? max : a[i];
			min = min < a[i] ? min : a[i];
			
		}
//		for(int i = 1; i<a.length; i++){                   //최대값  기준값이 배열의 첫번째 값이므로 i = '1' 부터시작
		/*
		 * if(a[i]>max) { max = a[i] }
		 */	
		/*
		 * for (int i = 1; i < a.length; i++) { if(a[i]< min) { min = a[i]; } }
		 */
		avg = (double)sum / a.length;
		System.out.println(sum);
		System.out.println(avg);
		System.out.println(max);
		System.out.println(min);
		
		
	} // end main()

} // end class Array04Main








