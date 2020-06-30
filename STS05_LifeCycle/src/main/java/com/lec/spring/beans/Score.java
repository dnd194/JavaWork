package com.lec.spring.beans;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Score implements InitializingBean, DisposableBean{
	int kor;   //국어점수
	int eng;	//영어점수
	int math;	//수학점수
	String comment; 	//평가 comment
	List score;
	
	public Score() {
		super();
		System.out.println("score 기본 생성자 생성이라구");
	}
	
	public List getScore() {
		return score;
	}

	public void setScore(List<Integer> score) {
		this.kor = score.get(0);
		this.eng = score.get(1);
		this.math = score.get(2);
		
	}

	public Score(int kor, int eng, int math, String comment) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.comment = comment;
		System.out.printf("score (%d, %d, %d, %s) 생성\n", kor, eng, math, comment);
	}
	public Score(int kor, int eng, String comment, int math) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.comment = comment;
		System.out.printf("score (%d, %d, %s, %d) 생성\n", kor, eng, comment, math);
	}
	
	public Score(int[] arr, String comment) {
		System.out.printf("Score(%s) 생성\n", Arrays.toString(arr));
		this.kor = arr[0];
		this.eng = arr[1];
		this.math = arr[2];
		this.comment = comment;
	}
	
	
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Score [국어 = " + kor + ", 영어 = " + eng + ", 수학 = " + math + ", 평가 = " + comment + "]";
	}
	
	
	public void afterPropertiesSet() throws Exception {
		//빈 초기화 과정에서 호출
		System.out.println("빈 초기화 afterPropertiesset 호출()");
	}
	
	public void destroy() throws Exception {
		//빈 소멸 과정에서 호출
		System.out.println("빈 소멸 destroy 호출");
	}
	
}
