package com.lec.java.inner05;

/*
 Local Inner Class: 블록({ ... }) 내부에서 정의된 클래스
   1. 정의가 된 블록(메소드) 내부에서만 사용 가능 - 참조변수 선언, 인스턴스 생성
   2. 접근 수식어(public, protected, private)는 쓸 수 없다.
   3. 외부 클래스의 멤버 변수(private 포함)는 모두 사용 가능
   4. effectively final인 지역변수나 매개변수만 사용 가능
 
 effectively final 변수란?
  1) final로 선언된 변수, 또는
  2) 한 번 초기화가 된 이후로 값이 변경되지 않은 변수(Java 8에서 도입)
*/

public class Local01Main {

	public static void main(String[] args) {
		System.out.println("Local Inner Class(지역 내부 클래스)");
		
		TestOuter out = new TestOuter();
		out.localMethod(600);
		
		//locatlMethod 를 수행하면서 TestLocal 인스턴스가 생성되고 shownumbers를 실행함
		
		
	} // end main()

} // end class Local01Main





















