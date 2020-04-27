package com.lec.java.oop05;

/*
 인터페이스(interface):
 1. 모든 메소드가 public abstract으로 선언되고,
 2. 모든 멤버 변수가 public static final로 선언된
 ****특별한 종류의 추상 클래스****

 인터페이스는 interface라고 선언
 인터페이스를 구현(상속)하는 클래스에서는 implements 키워드를 사용
 인터페이스를 구현(상속)할 때는 개수 제한이 없다.          ***(다중상속)***
 메소드 선언에서 public abstract는 생략 가능
 멤버 변수 선언에서 public static final은 생략 가능
*/

public class Interface01Main {

	public static void main(String[] args) {
		System.out.println("인터페이스(interface)");
		
//		TestInterface t1 = new TestInterface();  ==>> 에러  추상메서드를 하나라도 가지고 있으면 인스턴스를 만들수없다.
		TestImp1 test1 = new TestImp1();
		test1.testAAA();
		test1.testBBB();
		
		TestImp2 test2 = new TestImp2();
		System.out.println(test1.MIN);
		//System.out.println(test2.MIN);   어느쪽 MIN 인지 모호 ambiguous 
		System.out.println(TestInterface.MIN);
		System.out.println(TestInterface2.MIN);  //그래서 이렇게 인터페이스를 참조해서 표현
		
		
		
		
		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class


interface TestInterface{
	//인터페이스는 모든 멤버변수가 public static final
	
	//interface 특별한 종류의 추상 클래스
	
	public static final int MIN = 0;
	int MAX = 100; // public static final 생략 가능
	public static final String JAVA_STRING = "Java";
	String KOTLIN_STRING = "Kotlin";   //private은 쓸 수 없다 public static final 만 가능
	
	//모든 메서드는 public abstract
	public abstract void testAAA();
	void testBBB();   //없어도 public abstract
	
}
interface TestInterface2{
	
	public static final int MIN = 1;
	public abstract void testAAA();
	public abstract void testCCC();
	
}



//인터페이스는 인스턴스를 만들 수 없고 다른 클래스에서 구현(implement)해야함.
class TestImp1 implements TestInterface{

	@Override
	public void testAAA() {
		System.out.println("AAA");
		
	}

	@Override
	public void testBBB() {

		System.out.println("BBB");
	}
	
}
//인터페이스는 다중 상속이 가능하다
class TestImp2 implements TestInterface, TestInterface2{

	@Override
	public void testCCC() {
		System.out.println("CCC");
		
	}

	@Override
	public void testAAA() {
		System.out.println("AAA");
		
	}

	@Override
	public void testBBB() {
		System.out.println("BBB");
		
	}
	
}




































