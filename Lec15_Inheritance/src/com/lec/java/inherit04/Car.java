package com.lec.java.inherit04;

public class Car extends Vehicle {

	int oil;
	//1
	public Car() {
		//부모클래스의 기본생성자 호출 --> Vehicle()
		//명시적으로 super() 생성자가 없으면 부모의 기본생성자를 호출하게됨.
		System.out.println("Car() 생성");
	}
	//2
	public Car(int oil) {
		//super()는 반드시 첫번째 문장 이여야함  아니면 에러가 난다.
		super();  //부모의 기본생성자 호출    super : 부모를 의미
		this.oil=oil;
		System.out.println("Car(int) 생성 => oil : "+oil);
	}
	//3
	public Car(int speed, int oil) {
		super(speed); //부모 생성자 중에서 signature가 int 인 것 을 호출
		this.oil=oil;
		
		System.out.println("Car(int, int) 생성 => speed : "+speed+ " oil : "+oil);
	}
	
	public Car(double value) {
		
		//생성자 위임 (delegation)
		this(555,(int)value);   //  ==> 자기 생성자를 호출   this랑 super는 서로 같이 있을 수 없다.
		System.out.println("Car(double) 생성 => value : "+value);
	}
	
	
	
}
