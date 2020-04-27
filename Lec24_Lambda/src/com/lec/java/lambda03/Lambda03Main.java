package com.lec.java.lambda03;

/*
	 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
	 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
	 방법 2) 익명클래스
	 방법 3) 람다 표현식 lambda expression
*/
public class Lambda03Main {

	public static void main(String[] args) {
		System.out.println("익명 클래스, 람다 표현식 연습");
		//2개의 매개변수를 받고 double 형 리턴
	
//		 세가지 방법으로 자유자재로 구현할수 있어야 합니다.
//		 방법 1) 클래스 implements 인터페이스 + 오버라이딩.
//		 //덧셈연산
		 Operable plus = new Plus();
		 System.out.println("결과 는 : "+plus.operate(2.3, 4.8));
	 
		 
//		 방법 2) 익명클래스
//		 //뺄셈연산
		 Operable minus = new Operable() {
			
			@Override
			public double operate(double x, double y) {
				// TODO Auto-generated method stub
				return x-y;
			}
		};
		 System.out.println(minus.operate(55.0, 32.7));
		 
//		 방법 3) 람다 표현식 lambda expression
		 
		//제곱연산
		Operable lamda = (x,y) -> Math.pow(x,y);
		
		System.out.println(lamda.operate(2.0, 3.0));
				
		
			
			 
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	
} // end class
interface Operable{
	public abstract double operate(double x , double y);
}

class Plus implements Operable{

	@Override
	public double operate(double x, double y) {
		// TODO Auto-generated method stub
		return x+y;
	}
	
	
}




