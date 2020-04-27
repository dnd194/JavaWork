package com.lec.java.class02;


public class Class02Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습");		
		
		Circle c1 = new Circle();
		Circle c2 = new Circle(3);
		
		double perimeter = c1.calcPerimeter();
		System.out.println("c1의 둘레 : "+perimeter);
		
		perimeter = c2.calcPerimeter();
		System.out.println("c2의 둘레 : "+perimeter);
		
		System.out.println("c1의 넓이 : "+c1.calcArea());
		System.out.println("c2의 넓이 : "+c2.calcArea());
		System.out.println();
		
		
		
		Rectangle r1 =  new Rectangle();
		Rectangle r2 =  new Rectangle(2,3);
		
		
		System.out.println("rec2의 둘레: "+r2.recPerimeter());
		System.out.println("rec2의 넙이: "+r2.recArea());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("프로그램 종료");
	} // end main()

} // end class Class02Main










