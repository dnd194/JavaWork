package com.lec.java.exception02;
/* 예외처리 : try~catch를 사용하는 이유
	 1. if 문은 예외 처리 이외의 용도로 사용되기 때문에 프로그램 코드상에서 
	    예외처리 부분을 구분하기가 쉽지 않다
	 2. try {}  블럭은 '일반적인 흐름'을   ,catch {} 블럭을 '예외처리' 
	    블럭으로 만듦으로 코드 분석이 훨씬 용이.
*/
public class Exception02Main {

	public static void main(String[] args) {
		System.out.println("예외(Exception) 처리");
		
		int num1 = 123;
		int num2 = 0;
		int result = 0;
		
		// if 문을 사용한 처리
		if (num2 != 0) {
			result = num1 / num2;
		} else {
			System.out.println("0으로 나눌 수 없습니다... ");
		} // end if
		
		System.out.println("결과: " + result);
		
		// 위의 코드를 try~catch 로 만들어 처리

		System.out.println("\n try - catch 구문 사용");
		
		try {           
			//수행 블록
			result = num1 / num2;
			System.out.println("결과 : "+result);
		} catch (ArithmeticException e) {
							//위 와 같은 에러일경우
			//예외처리 블록  
			System.out.println("0 으로 나누는 exception 발생");
			System.out.println(e.getMessage());
			e.printStackTrace();
			//예외가 처리되면 (handling) 프로그램은 종료되지 않고 계속 진행된다.
			
			
		}
		
		
		System.out.println();
		System.out.println("프로그램 종료...");

	} // end main()

	/* 
		특히 시스템 자원(resource), HW (파일, DB..) 등을 사용하는 프로그래밍에선
		'예외' 가 언제든지 발생할수 있으므로 try ~ catch 가 필수적이다.
		 
		try {
			// 1. DB connect
			// 2. DB 테이블 접속/쿼리
			// 3. SQL 문장 실행
			// 4. 결과 출력
		} catch (Exception e) {
			// Exception 처리
		}
		
		if (DB connect 성공) {
			if (DB table 쿼리 성공) {
				if (SQL 문장 실행) {
					System.out.println("결과"));
				} else {
					// SQL 문장 실패 처리
				}
			} else {
				// DB 테이블 쿼리 실패 처리
			}
		} else {
			// DB connect 실패 처리
		}
	 */
	
	
} // end class Exception02Main












