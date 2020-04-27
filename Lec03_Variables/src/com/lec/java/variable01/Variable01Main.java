package com.lec.java.variable01;

/*
	변수 (Variables) :
		값을 담는 공간.  변수이름(variable name)을 부여해서 관리
		
	변수는 사용하기 전에 먼저 '선언(declaration)' 해야 한다
	변수 선언:
		변수타입 변수이름;
	
	변수의 초기화 (initialization)
	변수에 최초로 값(value) 을 대입 (assignment) 하는 것.
	변수(지역변수)를 사용/참조하려면 그전에 반드시 초기화가 되어야 함.

*/
public class Variable01Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("변수(variable)");
		//변수 선언   변수타입 + 변수이름 ;
		
		
		//int = integer 정수타입 
		int num1; //int타입의 변수 num1 생성
		int num2; //int타입의 변수 num2 생성
		
		//변수의 초기화 발생  초기화는 값을 대입하는  것
		num1 = 10; // =  => 대입연산자  (assignment operator)---- 오른쪽 값을 왼쪽에 대입
		
//		System.out.println(num2); 초기화를 하기전에 사용하면 에러
		num2 = 20; 
//		num3 = 30; 선언이 안된 변수는 사용할수없다 ~ cannot be resolved 
		System.out.println("num1 = "+ num1);
		System.out.println("num2 = "+ num2);
		
		num1 = 123; //변수의 값은 변경가능 
		System.out.println("num1 = "+ num1);
		System.out.println("num1 + num2 = "+ (num1+num2));
		// num1 - num2 결과를 화면출력
		System.out.println("num1 - num2 = "+ (num1-num2));
		// num1 * num2 결과를 화면출력
		System.out.println("num1 * num2 = "+ (num1*num2));
		// num1 / num2 결과를 화면출력
		System.out.println("num1 / num2 = "+ (num1/num2));

	} //end main()

} //end class  좋은습관~
