package com.lec.java.variable03;

//실수형 자료 타입: float(4바이트), double(8바이트)
//정수형 자료 타입의 기본형은 int
//실수형 자료 타입의 기본형은 double

public class Variable03Main {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
//		실수타입
		System.out.println("변수 - 실수 타입");
		
		double number1 = 3.141592; //초기화 = 값을 최초에 대입
//		float number2 = 3.14; 기본적으로 실수 리터럴은 double형으로 인식
//		float <- double 대입 불가 => 큰거에서 작은걸로는 안됌 
		//float 리터럴
		float number3 = 3.14f;  //그래서 뒤에 "f" 를 붙여줌
		
		// 실수 타입 최대, 최소값
		System.out.println("float : "+Float.MIN_VALUE +" ~ " +Float.MAX_VALUE);
		//1.4E-45 = 1.4 * 10^-45  
		System.out.println("double : "+Double.MIN_VALUE +" ~ " +Double.MAX_VALUE);
		//4.9E-324 = 4.9 * 10^-324 
//		실수타입에서 최솟값은 음수가 아닙니다~ 무조건 0보다 큼 / 비트로 표현하는 방식이 다르기 때문
		
		
//		실수타입은 정확한 값을 기대하면 안됨 => 정밀도의 문제
		float number4 = 1.23456789f;
		double number5= 1.23456789;
		//float 과 double 비교
		System.out.println("number4 : "+ number4); 
		System.out.println("number5 : "+ number5);
		//float 과 double은 저장할 수 있는 값의 크기뿐만 아니라 소숫점 이하 정밀도(precision)의 차이가 있다
		
		//실수표기법
		double number6 = 123; //자동형변환이 된다   "123.0" 으로
		double number7 = 1.23e2; // 지수 표기법(exponential notation) 'e'
		System.out.println("number6 : "+number6); //123.0
		System.out.println("number7 : "+number7); //123.0
		
		double number8 = 0.0001213;
		double number9 = 1.213e-4;
		System.out.println("number8 : "+number8);
		System.out.println("number9 : "+number9);
		
		
		
		
		
		
		
		
	}

}
