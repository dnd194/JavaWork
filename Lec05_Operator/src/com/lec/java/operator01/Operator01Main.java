package com.lec.java.operator01;

/*
 * 연산자 관련 일반사항
 * 
 * 연산 Operation
 * 연산자  Operator
 * 피연산자 Operand
 * 
 * ■ 피연산자의 개수에 따라
 * 이항연산자(binary operator) : 피연산자가 2개인 연산자 
 * 단항연산자(unary operator) : 피연산자가 1개인 연산자
 * 삼항연산자(ternary operator) : 피연산자가 3개인 연산자
 * 
 * ■ 연산자는 연산을 수행하기 전에 피연산자의 타입을 일치시키려 한다.
 * 
 * ■ 피연산자의 타입에 따라 수행하는 연산이 달라지는 연산자들도 있다  (ex: +  )
 * 
 * ■ 모든 연산은 연산의 결과값을 리턴한다 (어떠한 '값'인지?, 어떤 '타입'인지? 주목)**********************************
 * 
 * ■ 관례적으로 이항연산자는 피연산자와 연산자 간에 한칸씩(space) 띄어주는게 좋다
 *   단항연산자는 피연산자와 연산자를 붙여주는게 일반.
 */

/*
	대입 연산자 assignment operator : =
 		등호(=) 오른쪽의 값을 왼쪽에 대입(저장)
 		
 	산술 연산자 arithmetic operator : +, -, *, /, % 
 */
public class Operator01Main {

	public static void main(String[] args) {
		System.out.println("연산자(Operator) 01");
		
		System.out.println("\n====================");
		System.out.println("[1] 대입 연산자 : = (assignment operator)");
		// 등호(=) 오른쪽의 값을 왼쪽에 대입(저장)
		int num = 123;
		System.out.println("num = "+num);
		
		System.out.println("\n====================");
		System.out.println("[2] 산술 연산자: +, -, *, /, % (arithmetic operator)");
		int num1 = 7;
		int num2 = 3;
		int result;
		
		result = num1 + num2;
		System.out.println("num1 + num2 = "+result);
		result = num1 - num2;
		System.out.println("num1 - num2 = "+result);
		result = num1 * num2;
		System.out.println("num1 * num2 = "+result);
		result = num1 / num2;
		System.out.println("num1 / num2 = "+result);
		
		result = num1 % num2;   //나머지 연산자 '%' 
		System.out.println("num1 % num2 = "+result);
		
		// 나눗셈 연산자(/)가 실수에 사용됐을 경우에는
		// 계산 결과를 실수로 돌려 줌.
		// 실수 / 정수, 정수 / 실수, 실수 /실수 경우에는 결과가 항상 실수형이 됨

		double result2 = 12.0 / 3;
		System.out.println("실수 / 정수 결과 "+result2);
		
		// 나머지 연산자(%)
		// 정수 % 정수 = 정수로 값을 돌려 줌.
		// 실수 % 정수, 정수 % 실수, 실수 % 실수 = 몫을 제외한 실수형 나머지를 돌려줌.
		double result3 = 12.1 % 3;
		System.out.println("실수 % 정수 결과 "+result3);
		
		
		// 두 변수 값 바꾸는 방법
		int num3 = 100;
		int num4 = 200;
		int tmp;
		System.out.println("바꾸기전 num3 = "+num3 +"바꾸기 전 num4 "+num4);
		tmp = num3;
		num3 = num4;
		num4 = tmp;
		System.out.println("바꾼후 num3 = "+num3 +"바꾼후 num4 "+num4);
		
		
		// 대입연산자도 연산자다! 따라서
		// 연산의 결과값이 있다.  대입된 값을 결과값으로 리턴함
		int num5;
		int num6;
		System.out.println("num5 = "+ (num5 = 100));
		
		num5 = num6 = 300; // num6 = 300 -> num5 = num6 이런 순서 대로 연산된다.
		System.out.println("num5 = "+num5);
		System.out.println("num6 = "+num6);

		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class









