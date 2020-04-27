package com.lec.java.inner03;

public class Inner03Main {

	public static void main(String[] args) {
		System.out.println("외부/내부 클래스의 this");
		TestOuter out = new TestOuter(100);
		TestOuter.TestInner in = out.new TestInner(200);
		
		in.printValue();

	} // end main()

} // end class Inner03Main

















