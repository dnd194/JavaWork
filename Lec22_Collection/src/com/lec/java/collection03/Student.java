package com.lec.java.collection03;

public class Student {
	private int id;
	private String name;
	private Score score;
	
	public Student() {}
	public Student(int id, String name, Score s) {
		this.id = id;
		this.name = name;
		this.score = s;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	
	// com.lec.java.colleciton07 이후
	@Override
	public String toString() {
		String str = "";
		str += "id:" + id + "\n";
		str += "name:" + name + "\n";;
		str += "국어:" + score.getKorean() + "\n";
		str += "영어:" + score.getEnglish() + "\n";
		str += "수학:" + score.getMath() + "\n";
		return str;
	}
	
	public static void printTotal(Student stu){
		System.out.println("id:" + stu.getId());
		System.out.println("이름:" + stu.getName());
		System.out.println("총점:" + (stu.getScore().getEnglish() + stu.getScore().getKorean() + stu.getScore().getMath()));
	}

} // end class Student
