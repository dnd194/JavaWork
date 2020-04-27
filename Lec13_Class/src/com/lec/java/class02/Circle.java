package com.lec.java.class02;
// 생성자(Constructor)
// 생성자의 목적: 인스턴스 생성시 멤버변수들의 초기화
// 생성자의 이름은 반드시 클래스의 이름과 동일
// 생성자는 리턴 타입이 없다.
// 생성자도 매개변수(argument)를 가질 수 있습니다.
// 생성자도 오버로딩(overload) 가능****

// 클래스를 만들 때, 생성자를 따로 만들지 않으면
// '디폴트 생성자(default constructor)'를 자동으로 만들어줌.***
// 디폴트 생성자란 : 매개변수가 없는 생성자.  모든 멤버변수는 기본값으로 초기화
// (주의) 클래스에서 하나 이상의 생성자를 만들게 되면,
// 자동으로 디폴트 생성자를 만들어 주지 않습니다.
// (강력권장) 아무일도 안하더라도 디폴트 생성자는 반드시 만들어 주자. *****



public class Circle {
	//상태 (속성) - 멤버변수
	double radius; //반지름
	
	//생성자 (constructor)
	public Circle() {    //인스턴스 생성될 때 자동으로 생성
		//매개변수가 없는 생성자는 디폴트 생성자 (기본 생성자)
		//생성자의 목적: 멤버 변수의 초기화
		System.out.println("circle() 생성자 호출");
		System.out.println("반지름 값은 : " +radius); //숫자타입은 0 으로 초기화 됨
	}
	//생성자는 오버로딩 가능 ==> 매개변수리스트만 다르면 중복 정의 가능
	public Circle(double r) {
		System.out.println("Circle("+r+") 생성자 호출");
		radius = r;  //멤버 변수를 매개 변수 r로 초기화
		System.out.println("반지름 : "+radius);
	}
	
	//기능 (동작) - 멤버메소드
	//원의 둘레 계산  
	public double calcPerimeter() {
		return 2 * Math.PI * radius;
	}
	
	
	//원의 면적 계산
	public double calcArea() {
		return Math.PI * radius * radius;
	}
}
