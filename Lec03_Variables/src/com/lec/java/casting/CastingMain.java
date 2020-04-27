package com.lec.java.casting;

/*
 * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
 * 
 * 		primitive type 에서 implicit casting 방향
 * 
 * 		byte → short → int → long → float → long  
 *                 		↑
 *                    char
 * 
 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
 *      
 *      (변환하고자 하는 타입명)변수/값
 *      
 *      
 *            
 */
public class CastingMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("형변환(Type Casting/Type Converting)");
		
		byte num1 = 123;
		int num2 = 123;
//		byte num3 = num2; 자동 형 변환 불가 int가 byte보다 크기때문
		byte num3 = (byte)num2;
		System.out.println("num3 : "+num3);
		
		//명시적 형변환시 주의점 --> 데이터 손실 발생 주의!!
		byte num5 = (byte)513;
		System.out.println("num5 : "+num5);  // 1
		//btye는 최소 -128 ~ 최대 127 그래서 상위데이터를 날려버림
		
		double avg1 = (99+88+78) / 3 ;
//		                  	정수    / 정수  => 정수    
		System.out.println("avg1 : "+avg1);
		
		double avg2 =(double)(99+88+78) / 3 ;
//							실수 	/ 정수  => 실수
		System.out.println("avg2 : "+avg2);
		
		double avg3 = (99+88+78) / 3.0;  //3.0 실수
//							정수   /  실수 => 실수
		
		System.out.println("avg3 : "+avg3);
		
	}

}
