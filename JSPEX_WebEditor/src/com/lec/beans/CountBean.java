package com.lec.beans;

public class CountBean {
	private int cntNumber;
	
	
	//멤버변수의 이름보다  get/set 함수 이름이 더 중요해요~~
	public CountBean() {
		System.out.println("CountBean 생성");
	}
	
	public void setCount(int n ) {
		cntNumber += n;  //기존의 값에 더해진다.
	}
	
	public int getCount() {
		return cntNumber;
	}
}
