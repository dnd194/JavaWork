package com.lec.java.operator09;
/* 산술 연산의 결과 타입
 * 
 * 일단 피연산자가 reference type 이면, unbox 후 형변환 수행됨. 그리고 나서
 * 피연산자중 하나라도 double 이면 다른쪽이 double 이 된다.  
 * 그렇지 않으면 피연산자중 하나라도 float 이면 다른 쪽이 float 가 된다.  
 * 그도 아니면 피연산자중 하나라도 long 이면 다른 쪽을 long 으로 바꾼다.  
 * 그도 아니면 양쪽 피연산자 모~ 두 int 로 바꾼다.
 * 
 * https://docs.oracle.com/javase/specs/#5.6.2
 * 	When an operator applies binary numeric promotion to a pair of operands, each of which must denote a value that is convertible to a numeric type, the following rules apply, in order, using widening conversion (§5.1.2) to convert operands as necessary: 
 * 	If any of the operands is of a reference type, unboxing conversion (§5.1.8) is performed. Then: 
 * 	If either operand is of type double, the other is converted to double. 
 * 	Otherwise, if either operand is of type float, the other is converted to float. 
 * 	Otherwise, if either operand is of type long, the other is converted to long. 
 * 	Otherwise, both operands are converted to type int.
 */
public class Operator09Main {

	public static void main(String[] args) {
		System.out.println("산술연산의 결과 타입");

		int n1 = 10, n2 =20;
		int n3 = n1 + n2;
		System.out.println("n3 = "+n3);
		
		byte b1 = 10, b2 =20;
		
		short s1 = 10, s2= 20;
//		short s3 = s1+s2; 에러 // short + short = int
		
//		int형 보다 같거나 작은 타입의 변수 합은 무조건 int형이 된다
		
		char ch1 = 10, ch2 = 20;
//		char ch3 = ch1 + ch2; 당연히 에러 // char + char = int
		
		char ch3 =(char)(ch1 +ch2);  //명시적 형변환이 필요하다 *******************************************************

//		byte b3 = b1+b2; 에러       //byte 타입 끼리 더하면 결과는 int형이 된다
		long l1 = 10l;
//		int n4 = n1 + l1; 에러  // int + long = long
		
		float f1 = 1.0f , f2= 2.0f;
		float f3 = f1 + f2; // float 끼리의 연산은 가능
		f3 = f1 + n1; //float 타입 이하의 연산에서는 float가 나온다~
		f3 = f1 + b1; 
		
		double d1 = 1.0 , d2 = 2.0;
		double d3 = d1 + d2;
		d3 = d1 + f1;  // double의 연산에서는 무조건 double이 나옴
		
//		f3 = f1 + d1;  에러  ==>> float 은 double을 담을 수 없음
		
		//********************** int 이하 끼리 연산결과는 무조건 int이기 때문에 주의할 것
		
		long l2 = 27000000000L;
		System.out.println("l2 = "+l2);
		
		l2 = 3000 * 3000 * 3000; //인트끼리의 곱으로 long 타입이 나올 수가 없다.
		System.out.println("l2 = "+l2);
		
		//자바의 연산결과 타입규칙과 
		//기본 데이터 타입의 한계값을 인지하고 있어야한다.
		
		//복합대입연산자
		int sum = 0;
		double d4 = 1.2;
		
		//sum = sum + d4 ==> 에러
		sum += d4; // 이거는 된다...
		System.out.println(sum); 
		
		//sum += d4 복합대입연산자는 sum = sum + d4 가 아니라 
//		sum = (int)(sum + d4)으로 동작한다.
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("\n 프로그램 종료");
	} // end main ()

} // end class