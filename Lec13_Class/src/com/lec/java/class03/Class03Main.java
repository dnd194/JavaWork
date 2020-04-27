package com.lec.java.class03;

/*
	캡슐화, 은닉, 추상화

	클래스 안에 필요한 '속성' 과 '행동' 을 멤버로 묶고
	외부에서의 '직접적인 접근을 제한'하여
	객체의 데이터 와 메소드를 은닉(hiding)하고, 
	사용자에게는 필요한 기능만 제공하여 추상화(abstraction) 하는   
	객체지향 기술을 '캡슐화(encapsulation)' 라고 한다
	
	
	클래스의 멤버변수를 접근하기 위한 기능을 제공하는 메소드를 
	getter , setter 라 한다
*/
public class Class03Main {

	public static void main(String[] args) {
		System.out.println("Getter & Setter");
		
		Number n1 = new Number(100,'A');
//		n1.num = 200;  ==> num 이 private 이기 때문에 에러가 남         not visible 에러가 남 (존재는 하지만 볼수없다)
		
		
		n1.setNum(200);
		System.out.println(n1.getNum());
		n1.setNum(-1);  //조건이 맞지 않아서 바뀌지 않는다.
		System.out.println(n1.getNum());
		System.out.println("프로그램 종료");
	} // end main()
} // end class Class03Main














