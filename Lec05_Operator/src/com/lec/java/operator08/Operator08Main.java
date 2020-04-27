package com.lec.java.operator08;

/* 비트 연산자 (bit-wise operator)
 *   a & b: (and) a,b가 모두 1 이면 결과도 1, 그 외에는 0
 *   a | b: (or) a가 1이거나 또는 b가 1이면 결과는 1, a,b 모두 0일 때만 0
 *   a ^ b: (xor) a와 b 둘 중 하나만 1이 있는 경우는 1, 그 외에는 0
 *          결국 둘이 같으면 0, 다르면 1
 *    ~a  : (not) a가 1이면 0, a가 0이면 1로 바꿔줌
*/
public class Operator08Main {

	public static void main(String[] args) {
		System.out.println("연산자 8 - 비트 연산자");
		System.out.println("[1] &(and), |(or), ^(exclusive or), ~(not)");
		
		byte n1 = 10;   // 2진수  -------- 0000 1010
		byte n2 = 7;	// 2진수  -------- 0000 0111
						// &    -------- 0000 0010  ==> 10진수 2~ 
						// |    -------- 0000 1111  ==> 10진수 15
						// ^    -------- 0000 1101  ==> 10진수 13
		int result = n1 & n2;  //비트연산자입니다~
		System.out.println(" & 결과 = "+result);
		System.out.println(" & 결과 = "+ Integer.toBinaryString(result)); //2진수로
		
		result = n1 | n2; //or
		System.out.println(" | 결과 = "+result);
		System.out.println(" | 결과 = "+ Integer.toBinaryString(result)); //2진수로
		
		result = n1 ^ n2; //xor 
		System.out.println(" ^ 결과 = "+result);
		System.out.println(" ^ 결과 = "+ Integer.toBinaryString(result)); //2진수로
		
		
		result = ~n1; //  n1 =  0000 1010
		              // ~n1 =  1111 0101  상위비트가 음수 이면 음수  ex) 1000 0000  
		
		System.out.println(result);
		System.out.println(Integer.toBinaryString(result));  //32비트 기준
		
		
		
		// 음수 정수 표현 참조 : http://tcpschool.com/c/c_refer_negativeNumber
		
		System.out.println("\n\n================");
		System.out.println("비트 이동(shift) 연산자: >>, <<");
		
		int n3 = 10;  // 0000 1010
		int result2 = n3 >> 1; //비트를 오른쪽으로 1bit 이동   ==>>> 0000 0101 맨 왼쪽은 그냥 0으로 채워짐
		
		System.out.println(result2);
		System.out.println(Integer.toBinaryString(result2));
		System.out.println();
		
		int result3 = n3 << 1; //비트를 왼쪽으로 1bit 이동 ==>>> 0001 0100
		System.out.println(result3);
		System.out.println(Integer.toBinaryString(result3));
		System.out.println("\n 프로그램 종료");
		
		//비트연산자 오른쪽 이동--> /2  
		//비트연산자 왼쪽 이동 --> *2   
		
		
	} // end main ()

} // end class







