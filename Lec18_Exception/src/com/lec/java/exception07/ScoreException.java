package com.lec.java.exception07;

// 우리가 만드는 예외 클래스
// Exception 또는 RuntimeException 클래스를 상속 받아서 만듬

// TODO : Exception 을 상속받아 예외 클래스 정의하기

public class ScoreException extends Exception {

	// 생성자
	public ScoreException() {
		//기본생성자
		super("점수입력오류");  //예외 메세지 설정
		//부모 클래스인 Exception의 생성자중에 문자열을 받는 생성자가 존재하는 것을 알 수 있음
	}

	public ScoreException(String msg) {   //오버로딩
		super(msg);
	}
	
} // end class ScoreException




