package com.lec.java.array12;

/* main() 의 매개변수 String[] args
 */
public class Array12Main {

	// 윈도우 환경에서 path 설정이 되어 있으면 커맨드 창 에서 
	// bin>java com.lec.java.array12.Array12Main ~~ ~~  
	// 이클립스 환경에선 Run-Run configuration 에서 [Argument] 를 설정해주면 된다.
	
	public static void main(String[] args) {
		System.out.println("main 메소드 매개변수: String[] args");
		
		System.out.println("args.length = "+ args.length);
		
		for(String arg : args) {
			System.out.println("--> " +arg);
		}
	} // end main

} // end class Array12Main







