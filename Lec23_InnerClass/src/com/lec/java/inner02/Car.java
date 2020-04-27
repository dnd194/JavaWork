package com.lec.java.inner02;

public class Car {
	// 멤버 변수( outer )
	private String color;
	
	// 생성자
	public Car(String color) {
		this.color = color;
	}
	
	// 메소드
	public void displayCarInfo() {
		System.out.println("color: " + color);
	}
	
	
	// 멤버 내부 클래스 
	public class Tire{
		
		private int r;  //반지름
		
		public Tire() {
		}
		public Tire(int r ) {
			this.r= r;
		}
		public void displayInfo() {
			System.out.println("---자동차 정보---");
			System.out.println("차의 color : "+color);
			System.out.println("tire 의 반지름:"+r);
		}
	}
	
} // end class Car











