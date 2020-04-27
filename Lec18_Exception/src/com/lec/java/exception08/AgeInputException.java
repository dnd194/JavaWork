package com.lec.java.exception08;

// TODO : Exception 상속받은 예외 클래스 만들기
public class AgeInputException extends Exception{
	
	//기본생성자
	public AgeInputException() {
		super("점수 입력 오류");
	}
	//오버 로딩
	public AgeInputException(String msg) {
		super(msg);
	}

	
} // end class AgeInputException
