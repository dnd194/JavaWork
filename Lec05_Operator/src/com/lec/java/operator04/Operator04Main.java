package com.lec.java.operator04;

/* 증감 연산자(++, --) Increment / Decrement Operator
 *  	++변수: 변수의 값을 1 증가시켜서 저장
 *   	--변수: 변수의 값을 1 감소시켜서 저장
 *  
 *   증감연산자: prefix(접두사), postfix(접미사)
 *   	접두사(prefix)인 경우에는, 증감(++, --)이 먼저 된 후 다른 연산자가 동작
 *   	접미사(postfix)인 경우에는, 다른 연산자 먼저 실행된 후 증감(++, --)가 동작
 */
public class Operator04Main {

	public static void main(String[] args) {
		System.out.println("연산자 4 - 증감 연산자(++, --) Increment / Decrement Operator");
		
		int num1 = 100;
		System.out.println("num1 = "+num1);
		// ++ : 변수값 1 증가~
		++num1;
		// num+=1 과 동일한 결과
		System.out.println("num1 = "+num1);
		
		// -- : 변수값 1 감소
		int num2 = 100;
		--num2;
		// num -= 1; 과 동일한 결과
		System.out.println("num2 = "+num2);
		
		num2--;
		num2--;
		System.out.println("num2 = "+num2);
		
		System.out.println("\n\n======================");
		System.out.println("증감연산자: prefix(접두사), postfix(접미사)");
		
		int num4 = 100;
		
		int num5 = ++num4; //num5 = 101 ******prefix
		//만약에 int num5 = num4++; 였으면 num5 = 100;
		System.out.println("num4 = "+ num4);
		System.out.println("num5 = "+ num5);
		
		int num6 = 100;
		int num7 = num6++; // num7 = 100; ********postfix
		System.out.println("num6 = "+ num6);
		System.out.println("num7 = "+ num7);
		
		
		int num8 = 10;
		int num9 = --num8 + 5;
		System.out.println(num8 + ", "+num9);
		
		int num10 = 10;
		int num11 = num10-- + 5;
		System.out.println(num10+ ", "+num11);
		
		int number1 = 10;
		int number2 = number1-- + 5 + --number1;
		
		// (1) number1에 저장된 값(10) + 5 -> 15
				// (2) number1의 값이 1 감소 -> 9
				// (3) 15 + --number1: number1의 값을 먼저 감소 -> 8
				// (4) 15 + 8 -> 23
				// (5) number2에 23이 저장
				// ★ 그러나, 실무에서는 절대로 이런 코드는 작성하지 마십시오.


		System.out.println(number2);
		
		// number1 = 8;
		// number2 = 23;
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class












