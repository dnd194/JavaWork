package com.lec.java.crawl13;

import java.util.List;

public class User {
	private String name;
	private int age;
	private List<String> messages;
	private Score score1;
	
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
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	@Override
	public String toString() {
		return "[name = " + name + ", age = " + age + ", messages = " + messages + "]";
	}
	
	public Score getScore1() {
		return score1;
	}
	public void setScore1(Score score1) {
		this.score1 = score1;
	}
	
}
class Score{
	private int kor;
	private int math;
	private int eng;
	
	//기본 생성자
	public Score() {
		
	}
	
	//매개변수를 받는 생성자 
	public Score(int kor, int math, int eng) {
		super();
		this.kor = kor;
		this.math = math;
		this.eng = eng;
	}
	
	
	//getter / setter
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	
	
}