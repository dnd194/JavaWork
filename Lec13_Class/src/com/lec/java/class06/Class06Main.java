package com.lec.java.class06;



public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		Score s1 = new Score("임상빈",80,40,40);
		System.out.println(s1.calcTotal());
		System.out.println(s1.calcAvg());

		s1.displayInfo();
		System.out.println("프로그램 종료");
	} // end main()

} // end class Clas06Main










