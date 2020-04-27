package com.lec.java.inherit02;

/* 상속 (Inheritance)
 * 	상위클래스를 상속받아서 하위클래스를 정의하는 방법
 *    class 하위클래스 extends 상위클래스
 *    
 *  자바 에선 오로지 '하나의 부모'로부터 상속받을수 있습니다 (단일 상속)  ***다중 상속 허용하지 않음
 *  
 *  (용어)
 *  Super Class(상위 클래스), Parent Class(부모/조상 클래스), Basic Class(기본 클래스)
 *  Sub Class(하위 클래스), Child Class(자식 클래스), Derived Class(유도 클래스)
 *  	※ 상속받는다..(동사) inherit , subclass
 *  
 *  sub class에서는 super class가 가지고 있는 멤버 변수들은  선언하지 않아도 사용할 수 있다.
 *  super class에 없는 멤버 변수만 선언해 주면 됨
 *  
 *  상속의 이점 :
 *  상속을 통하여 기존의 객체를 그대로 활용하면서, 새로운 객체에서
 *  추가, 변경되는 부분만 작성함으로 소프트웨어 개발 효율을 높일수 있다.
*/
public class Inherit02Main {

	public static void main(String[] args) {
		System.out.println("상속 (Inheritance)");

		// BasicTV 클래스의 인스턴스 생성
		BasicTV tv1 = new BasicTV();
		tv1.displayInfo(); // false , 0 , 0
		
		System.out.println();

		// SmartTV 클래스의 인스턴스 생성
		SmartTV tv2 = new SmartTV();
		tv2.isPowerOn=true;
		tv2.channel=100;
		tv2.volume=10;
		tv2.ip="192.000.000";
		tv2.displayInfo();   // true 100 10 ip
		
		
		

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class










