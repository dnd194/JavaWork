package com.lec.java.inner02;

/*
 	언제 내부 클래스로 설계?  
 	
	 상속 관계로 묶을 수는 없지만,
	 A라는 객체가 생성된 이후에야 존재할 수 있는 B라는 객체가 있다고 한다면,
	 B를 A의 멤버 '내부 클래스'로 선언한다.
	 (예) 컴퓨터-CPU/메모리, 자동차-타이어
	
	 반면
	 '햄버거 세트 메뉴' 객체의 경우
	 햄버거 객체와 콜라 객체는 별개의 객체로도 존재 가능하니까
 	'햄버거' 와 '콜라' 는 '세트메뉴' 객체의 '멤버변수'로 붙도록 하는게 낳다
 	
 	is-a  : 상속관계
 	has-a (종속) : 멤버내부클래스
 	has-a (독립) : 멤버변수
 	
 */
public class Inner02Main {

	public static void main(String[] args) {
		System.out.println("멤버 내부 클래스 활용");
		
		Car myCar = new Car("red");
		Car.Tire myTire = myCar.new Tire(16);
		
		myTire.displayInfo();			// red / 16
		System.out.println();
		Car.Tire myTire2 = myCar.new Tire(20);
		Car.Tire myTire3 = myCar.new Tire(30);
		myTire2.displayInfo();          // red / 20
		System.out.println();
		myTire3.displayInfo();			// red / 30
		
		
	} // end main()

} // end class Inner02Main













