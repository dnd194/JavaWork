package com.lec.java.class06;

public class Score {
	// 멤버변수 : 
	// 	학생 이름 String
	// 	국어점수 int 
	// 	수학점수 int
	// 	영어점수 int
	String name;
	int kor;
	int math;
	int eng;
	
	// 생성자: 멤버 변수 초기화
	//   1) 디폴트 생성자
	public Score() {
		
	}
	
	//   2) 매개변수 받는 생성자 (이름, 국어점수, 수학점수, 영어점수)
	public Score(String name, int kor, int math, int eng) {
		this.name=name;
		this.kor=kor;
		this.math=math;
		this.eng=eng;
	}
	
	// 메소드
	// 총점계산 메소드
	// 메소드이름 :calcTotal()
	// 리턴타입 : int
	public int calcTotal() {
		int sum = 0;
		sum = kor + math + eng;
		
		return sum;
		
	}
	
	
	// 평균계산 메소드
	// 메소드 이름 : calcAvg()
	// 리턴타입 : double
	public double calcAvg() {
		
		return (double)calcTotal()/3;
		
	}
	
	// 메소드
	// 이름: displayInfo()
	// 리턴: void
	// 매개변수: none
	//   학생의 이름, 국어, 영어, 수학 점수 출력
	public void displayInfo() {
		
		System.out.println("학생의 이름 : "+name+"국어 : "+kor+"수학 : "+math+"영어 : "+eng);
	}
	
	
	
}


















