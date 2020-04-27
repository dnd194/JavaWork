package com.lec.java.class02;

public class Rectangle {
	//속성
	// 가로 , 세로
	double width, height;
	
	
	
	
	//생성자
	public Rectangle() {
		//매개변수가 없는 생성자  ==> 디폴트 (기본) 생성자 
		System.out.println("Rectangle() 생성");
		width = 100;	//디폴트 값 지정가능
		height=100;		//디폴트 값 지정가능
		System.out.println("가로 : "+width);        //0
		System.out.println("세로 : "+height);			//0
	}
	public Rectangle(double width, double height) {
		this.width = width;              //멤버 변수 초기화
		this.height = height;				//멤버 변수 초기화
		System.out.println("Rectangle(w,h) 생성");
		System.out.println("가로 : "+width);
		System.out.println("세로 : "+height);
		
	}
	
	
	//동작
	//사각형의 둘레, 사각형의 넓이 만들고 메인에서 호출
	public double recPerimeter() {
		return (width+height)*2;
	}
	
	public double recArea() {
		return width*height;
	}
}


