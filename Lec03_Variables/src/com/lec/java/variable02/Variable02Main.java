package com.lec.java.variable02;

//자바의 기본 자료형(primitive data type)
//정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
//실수 타입: float(4바이트), double(8바이트)
//문자 타입: char(2바이트)
//논리 타입: boolean

public class Variable02Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("정수타입 변수들");
		
//		정수는 음수도 포함하기 때문에 1byte = -128 ~ 127 까지 표현
		System.out.println("byte : " + Byte.MIN_VALUE + " ~ "+ Byte.MAX_VALUE);
		System.out.println("Short : " + Short.MIN_VALUE + " ~ "+ Short.MAX_VALUE);
		System.out.println("Int : " + Integer.MIN_VALUE + " ~ "+ Integer.MAX_VALUE);
		System.out.println("Long : " + Long.MIN_VALUE + " ~ "+ Long.MAX_VALUE);
		
		
		byte num1 = -128;
		byte num2 = 0;
		byte num3 = 123;
//		byte num4 = 1234; byte에 저장할 수 있는 크기보다 초과했기때문에 에러
		
		short num5 = -12345;
		short num6 = 12345;
//		short num7 = 32768; short에 저장할 수 있는 크기보다 초과
		
		int num8=999922211;
//		long num10 = 9123333334455; literal error
//		코드상에 직접 입력한 값들  = literal error 
		
//		정수리터럴 ==> int로 형변환 하려한다.
		
//		실수리터럴 ==> double로 형변환 하려한다.
//		"~" ==> 문자열(String) 으로 형변환 하려한다.
//		정수는 기본적으로 int형으로 인식 
		
		long num11 = 9876543210L; //뒤에  L(long) 을 붙여주면 long형으로 인식 
		long num12 = 12;
		
//		int num15 = 12L; 이거는 안됨  long타입은 int에 저장할 수 없기 때문
//		큰사이즈는 작은사이즈에 대입불가
		
		//값의 경계선
		byte num15 = Byte.MAX_VALUE; //127
		byte num16 = (byte)(num15 + 1 );
		System.out.println("num15 : "+num15);
		System.out.println("num16 : "+num16); //-128
//		127에서 + 1 을 하면 -128이 됨 순환의개념?? 마찬가지로 -128 -1 을 하면 127
		
//		정수표기법 진법별로 가능
		int number1 =11; 		//10진수 decimal
		int number2 = 0xb;  	//11의 16 진수 (hex) -> 0x로 시작
		int number3 = 013;  	//11의 8진수 -> 0으로시작
		int number4 = 0b1011;	//11의 2진수 -> 0b로 시작
		System.out.println("number1 : "+number1);
		System.out.println("number2 : "+number2);
		System.out.println("number3 : "+number3);
		System.out.println("number4 : "+number4);
		
		//String.fotmat() 을 사용하여 원하는 포맷(진법)으로 출력가능		
		System.out.println("number1 : "+String.format("%x", number1));
		//number1을 16진수로표현 "%x" <-- 때문
		System.out.println("number1 : "+String.format("%o", number1));
		//number1을 8진수로표현 "%o" <-- 때문
		
		//Integer.toXxx(n)을 사용하여 원하는 포맷의 문자열로 변환 가능
		System.out.println("number1 : "+Integer.toHexString(number1)); //16진수
		System.out.println("number1 : "+Integer.toOctalString(number1)); //8진수
		System.out.println("number1 : "+Integer.toBinaryString(number1)); //2진수
		
		
		
		
		
		
		
		
	}

}
