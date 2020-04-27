package com.lec.java.method11;

/* 재귀 호출 (recursive call)
 * 메소드(혹은 함수) 내부에서 메소드가 자기 자신을 또다시 호출하는 것.
 * 
 * 장점:
 * 	복잡한 문제를 간단하고 논리적으로 기술 가능.
 * 
 * 단점 & 주의 :
 *  메모리 부담 발생 
 * 	무한히 재귀호출 할수 없다. --> Stack Overflow 발생
 *  따라서 재귀호출이 종료되는 조건이 반드시 필요하다. **********************************
 *  
 *  재기호출은 주로 '팩토리알'연산에 사용한다.
 * 
 * 
 */
public class Method11Main {

	public static void main(String[] args) {
		System.out.println("재귀 호출 (recursive call)");
		System.out.println("재귀 메소드(recursive method)");
		
		showNumber(1);   //==> 재귀 호출은 무한히 돌 지 않는다.  불가 함 ' stackoverflow ' 에러  exception이 아니라 그냥 에러임 // stack 메모리 초과
		
//		int n = Integer.MAX_VALUE;
//		double [] arr = new double[n];   // ==> out of memory //heap 메모리 영역 초과
		
		for(int n = 0 ; n<=10; n++) {
			System.out.println(n+"! = "+calcFactorial(n));
		}
		
		//팩토리얼은 호출 호출 호출 호출 호출 하다가 리턴 찍고 리턴 리턴 리턴 리턴 하는 개념
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
	public static void showNumber(int n) {
		
		System.out.println(n);
//		showNumber(n+1);
		
		
	}
	
	// method name: calcFactorial
	// return: long (num의 팩토리얼을 계산해서 리턴)
	// arguments: long num
	// 기능:
	//   if n == 0,  ** 0! = 1 **
	//   if n > 0, n! = n * (n - 1)!
	//   if n < 0, 계산 불가
	public static long calcFactorial(long num) {
		
		long result = 0l;  //long 형 타입으로
		if(num == 0) {     // 0!  ==> 재귀호출 종료 조건
			result = 1l;
		}else if(num > 0){
			result = num*calcFactorial(num-1);
		}else {
			System.out.println("음수 팩토리얼은 계산 불가 ");
		}
		
		return result;
		
		
	}
	
	// 대부분의 recursive call 은 for/while 등의 순환문으로 전환 가능하다
	// 실습: calcFactorial 오버로딩 하여, for/while 문으로 구현해보기
	// TODO
	
	// method name: pow
	// return: double (n의 e승을 계산해서 리턴)
	// arguments: int n, int e
	// 기능:
	//   if e == 0, n^0 = 1
	//   if e > 0, n^e = n x n^(e-1)
	// TODO
	
	
	// method name: powerOfTwo
	// return: double (2의 n승을 계산해서 리턴)
	// arguments: int n
	// 기능:
	//   if n == 0, 2^0 = 1
	//   if n > 0, 2^n = 2 x 2^(n-1)
	//   if n < 0, 2^n = 1 / 2^(-n)
	// TODO
	
	
	
	
} // end class













