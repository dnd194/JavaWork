package com.lec.java.inherit07;


//public final class Person { 으로 할 경우 businessperson에 상속 불가
public class Person {
	private String name;

	
	//getter setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	public void showInfo() {
		System.out.println("이름 : "+name);
	}
	public final void whoAreyou() {    //메소드 앞에 final을 붙이면 그 메서는 더이상 override 할 수 없다.
		System.out.println("이름 : "+name);
	}
}
