package com.lec.java.wrapper02;

/* Java 5부터 wrapper 클래스의 auto-boxing/unboxing 기능 제공
 * 	boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
 * 	unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
 */
public class Wrapper02Main {

	public static void main(String[] args) {
		System.out.println("auto-boxing, auto-unboxing");

		Integer num1 = 10 ; //    == Integer num1 = Integer.valueOf(10) 과 동일한 코드라는 점을 기억  (auto-boxing)
		Integer num2 = 20;
		System.out.println(num1+num2);    // ==> auto unboxing 안에있는 것을 꺼내서 연산
		System.out.println(num1.intValue() + num2.intValue());  //<-- 와 똑같이 연산  ==  num1+num2
		
		//굳이 명시를 안해줘도 똑같이 작동함
		
		Integer num3 = num1+num2;
	
		Integer num30 = Integer.valueOf(num1.intValue()+num2.intValue());  // 위에 코드랑 같은 코드      wrapper 클래스의 특징중 하나임  
		
		
		System.out.println();
		System.out.println("boxing/unboxing");
		// boxing(포장): 기본자료형의 값을 wrapper 클래스에 저장하는 것
		// unboxing(개봉): wrapper 클래스에 저장된 기본자료형 값을 꺼내는 것
		
		Integer num4 = 100;    //  == integer.valueof(100);   ==    int num4 = 100;
		int n4 = num4;
		System.out.println("n4 = "+n4);
		
		System.out.println();
		System.out.println("auto-boxing/auto-unboxing");

		// TODO
		
		System.out.println();
		System.out.println("wrapper 클래스들");
		
		Long num100 = Long.valueOf(10000000000l);
		Long num101 = Long.valueOf(11111111111111111l);
		Double num200 = 3.14; //double.valueof(3.14)
		
		
		// unboxing 할때는 자기가 원하는 형태로 꺼내어 쓸 수 있다
		System.out.println(num1.doubleValue());           // num1 은 Integer wrapper 인데 double 로 받음   가능
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class















