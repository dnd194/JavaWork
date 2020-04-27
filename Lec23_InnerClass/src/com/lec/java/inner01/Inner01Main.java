package com.lec.java.inner01;

/*
 Inner Class(내부 클래스)
 1. Member inner class(멤버 내부 클래스): 다른 클래스 내부에서 선언된 클래스
 2. Static inner class(static 내부 클래스): 다른 클래스의 내부에서 static으로 선언된 클래스
 3. Local class(지역 클래스)
   1) Local inner class(지역 내부 클래스): 메소드 내부에서 선언된 클래스
   2) Anonymous inner class(익명 내부 클래스): 이름이 없는 local class
*/

public class Inner01Main {

	public static void main(String[] args) {
		System.out.println("Member Inner Class(멤버 내부 클래스)");
		//외부 클래스의 인스턴스 생성
		TestOuter out = new TestOuter(100);
		
		
		// 멤버 내부 클래스의 인스턴스 생성
		// 멤버 내부 클래스의 이름: [외부클래스 이름].[멤버 내부클래스 이름]
		// [외부클래스 이름].[내부클래스 이름] 참조변수 =
		// [외부클래스 인스턴스].new 내부클래스 생성자();
		TestOuter.TestInner in = out.new TestInner(111);
		in.printOuterValue(); // ==> 100
		in.printInnerValue(); // ==> 111
		
		System.out.println();
		//하나의 외부 클래스 인스턴스를 이용해서
		//멤버 내부 클래스의 인스턴스는 여러개 생성 가능.
		TestOuter.TestInner in2 = out.new TestInner(123);
		in2.printOuterValue();
		in2.printInnerValue();
		
		//TODO
		//새로운 외부 인스턴스 생성
		//out2 외부 클래스 인스턴스 생성
		//out2로 부터 in4, in5 라는 이름으로 내부 클래스 객체 만드세여
		
		System.out.println();
		TestOuter out2 = new TestOuter(50);
		TestOuter.TestInner in4 = out2.new TestInner(140);
		TestOuter.TestInner in5 = out2.new TestInner(150);
		in4.printOuterValue();      //50
		in4.printInnerValue();		//140
		System.out.println();
		in5.printOuterValue();		//50
		in5.printInnerValue();		//150
		
		TestOuter.TestInner in6 = new TestOuter(2000).new TestInner(33);
		in6.printOuterValue();      //2000
		in6.printInnerValue();		// 33
	} // end main()

} // end class Inner01Main
