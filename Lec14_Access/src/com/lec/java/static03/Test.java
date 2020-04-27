package com.lec.java.static03;

public class Test {
	private int num;
	
	static int count = 0 ; 

	// 기본 생성자
	private Test() {
		count++;  //생성자가 호출될때마다 count 1증가
		System.out.println(count+" 번째 인스턴스 생성");
	}
	
	//sington패턴 
	private static Test instance = null;   //자기 자신을 반환하는 instance 변수를 null 로 초기화
	public static Test getInstance() {		//외부에서 생성 가능하도록 public
		if(instance == null) {				//null 이 아니면 생성을 안하도록 조건
			instance = new Test();          //인스턴스 생성
		}
		
		return instance;
		
	}
	
	
	// getter setter
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
