package com.lec.java.inner04;

/*
 Nested Class(중첩 클래스):
    다른 클래스의 내부에서 멤버로 정의된 클래스인데, 
  static 키워드가 사용된 내부 클래스 (static inner class)
   
   static: 클래스의 인스턴스가 생성되지 않아도 사용될 수 있는 멤버(변수, 메소드)에 사용
     따라서, nested class는 외부 클래스의 인스턴스를 생성하지 않고,
     내부 클래스의 인스턴스를 생성할 수 있다.
   
   nested(static) class는 
   (외부 클래스에서) static으로 선언된 변수와 메소드만 사용 가능
   
	중첩 클래스의 인스턴스 생성:
		타입 참조변수 = new 생성자()
		중첩 클래스의 이름(타입): [외부클래스 이름].[내부클래스 이름]
		중첩 클래스의 생성자: new [외부클래스 이름].생성자()

*/
public class Nested01Main {

	public static void main(String[] args) {
		System.out.println("Nested Class(중첩 클래스): static inner class");

		TestOuter.TestNested nest1 = new TestOuter.TestNested();
		nest1.displayInfo();
		
	} // end main()

} // end class Nested01Main













