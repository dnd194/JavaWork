package com.lec.java.inherit03;

/* java.lang.Object
 * 	자바의 모든 클래스는 java.lang.Object로부터 상속 받는다.
 *  java.lang.Object 클래스는 모든 클래스의 부모클래스이다.
 *  Object 클래스에 있는 메소드를 다른 클래스에서도 사용 가능
 */
public class Inherit03Main {

	public static void main(String[] args) {
		System.out.println("상속 연습");
		System.out.println("java.lang.Object");
		
		System.out.println();
		Person p1 = new Person();
		p1.name="쌍빈";
		p1.whoAmI();
		
		BusinessPerson p2 = new BusinessPerson();
		p2.name="kelvin";
		p2.whoAmI();
		p2.company="asdasd";
		p2.showInfo();
		
		System.out.println();
		System.out.println(p2);   //내부적으로는 p2.toString()의 결과값이 나온다.
		System.out.println(p2.toString());  //toString() 은 Object 소속 메서드
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class









