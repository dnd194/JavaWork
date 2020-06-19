package com.lec.spring;

public class Student {

	String name;
	int age;
	Score score;    //reference 타입
	public Student() {
		System.out.println("Student 기본 생성자라구");
	}
	public Student(String name, int age, Score score) {
		super();
		this.name = name;
		this.age = age;
		this.score = score;
		System.out.printf("Student 매개변수 생성자 라구  (%s, %d, %s) 생성\n",name,age,score.toString());
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [name = " + name + ", age = " + age + ", score = " + score + "]";
	}
	
	
}
