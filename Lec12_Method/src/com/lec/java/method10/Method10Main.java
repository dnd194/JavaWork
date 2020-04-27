package com.lec.java.method10;

import java.util.Arrays;
import java.util.Scanner;

/* 메소드와 배열
 * 매개변수가 배열,  리턴타입이 배열
 */
public class Method10Main {

	public static void main(String[] args) {
		System.out.println("메소드와 배열");
		Scanner sc = new Scanner(System.in);

		int[] score = new int[10]; //10명의 점수를 저장할 배열
		
		//점수를 입력 받아서 score 배열에 저장
		inputScore(sc, score);
		
		//저장된 점수 확인
		displayScore(score);
		
		//총 점 계 산
		int total = calcTotal(score);
 
		System.out.println("총점 : "+total);
		
		sc.close();
		
		System.out.println("랜덤 숫자 배열 생성");
		double[] randArr = genRandom(10);
		System.out.println(Arrays.toString(randArr));
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	// method name: inputScore
	// return: void
	// arguments: 
	//   1) Scanner sc - 입력장치
	//   2) int[] score: 점수를 입력받아서 저장할 배열
	public static void inputScore(Scanner sc, int[] score) {
		
		for(int i = 0; i<score.length; i++) {
			System.out.print(i+ " 번째 점수를 입력받겠습니다");
			score[i] = sc.nextInt();
			
		}
		
	}
	
	// method name: displayScore
	// return: void
	// arguments: int[] score - 출력할 점수가 저장된 배열
	public static void displayScore(int[] score) {
		
		System.out.println("점수 출력");
		System.out.println("-----------------------------");
		for(int x : score) {
			System.out.print(x+", ");
		}
		System.out.println();
		System.out.println("-----------------------------");
	}
	
	
	// method name: calcTotal
	// return: int (계산된 총점을 리턴)
	// arguments: int[] score (점수들을 저장한 배열)
	public static int calcTotal(int[] score) {
		
		int total = 0;
		for (int x : score) {
			total += x;
		}
		
		return total;
	}

	
	// method name: findMax
	// return: int (최대값)
	// arguments: int[] score (점수들 저장된 배열)
	// TODO
	
	
	// method name: findMin()
	// return: int (최소값)
	// arguments: int[] score
	// TODO
	
	// method name: genRandom()
	// return: double[]  (생성된 난수 배열)
	// arguments: n  생성할 난수 개수     
	public static double[] genRandom(int n) {           //배열도 리턴값으로 넘기는 것이 가능하다
		
		double[] arr = new double[n];   //난수의 개수만큼의 배열 생성 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Math.random();
			
		}
		return arr;
		
	}
	
} // end class Method09Main












