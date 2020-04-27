package com.lec.java.inner07;

public class Person {
	// Person 외부 클래스의 멤버 변수
	private String name;

	// Person 외부 클래스의 생성자
	public Person(String name) {
		this.name = name;
	}

	public Readable createInstance(int age) {
		// 익명 내부 클래스:
		// 인스턴스 생성과 동시에 클래스가 정의됨.
		// new 인터페이스() { 익명 클래스 내부 작성 };
		// new 부모클래스() { 익명 클래스 내부 작성 };

		return new Readable() {
			// 내부적으로 이름이 없는 클래스를 만들어냄 (익명클래스)
			@Override
			public void readInfo() {
				System.out.println("이름 : " + name);
				System.out.println("나이 : " + age);
			}
		};
	}
} // end class Person

interface Readable {
	public abstract void readInfo(); // 인터페이스는 추상메서드
}











