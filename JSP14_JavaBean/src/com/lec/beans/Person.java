package com.lec.beans;

public class Person {
	private String name;
	private int age;
	private int id;
	private String gender;
	
	//기본 생성자, 매개변수 생성자, getter/setter
	public Person() {
		super();
	}
	public Person(String name, int id, String gender, int age) {
		super();
		this.name = name;
		this.id = id;
		this.gender = gender;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
//	setname() 혹은 setName() 을 호출한다. setname 해도 잘 동작한다 
	//setname 이 우선순위로 동작한다. 아래의 테스트결과 setname 이있을경우
	//setName 은 찍히지 않는다.
	//그냥 잘하자  
	public void setname(String name) {
		System.out.println("setname() 호출");
		this.name = name;
	}
	public void setName(String name) {
		System.out.println("setName() 호출");
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
