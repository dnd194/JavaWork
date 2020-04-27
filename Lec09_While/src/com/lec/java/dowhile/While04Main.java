package com.lec.java.dowhile;

/*
do {
	...
	...
}while(조건식) 문인 경우에는,

{...} 안에 있는 실행문들을 한번은 실행을 하고 나서
조건식을 검사하게 된다.

*/

public class While04Main {

	public static void main(String[] args) {
		System.out.println("do - while문 연습");
		
		int n = 0;
		while ( n > 0) {                   //==> 조건이 처음부터 false 이므로 아예 한번도 실행되지 안음
			System.out.println("카운트 다운 : "+n);
			n--;
		}
		System.out.println();
		
		do {
			System.out.println("카운트 다운 : "+n);
			n--;
		}while ( n > 0);                
			
		//99단 9단 do~while로 출력
		int i = 1;
		do {
			System.out.println(" 9 x "+i+" = "+(9*i));
			i++;
		}while(i<=9);
		
	} // end main()

} // end class While04Main









