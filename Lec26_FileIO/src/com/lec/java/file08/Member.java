package com.lec.java.file08;

import java.io.Serializable;

public class Member implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4564811082080172359L;
	private String id;
	private String pw;
	transient private int num;
	transient private boolean isExist;
	
	// transient로 선언된 변수는 serialization(직렬화) 대상에서 제외됨.
	// (파일에 write되지 않는다)
	// de-serializtion(역직렬화, 파일에서 읽기)를 할 때는 
	// 해당 타입의 기본값(0, false, null)으로 초기화됨
	
	public Member() {}
	public Member(String id, String pw) {
		this.id = id;
		this.pw = pw;
		this.num = 123;
		this.isExist = true;
	}
	
	public void displayInfo() {
		System.out.println("--- 회원 정보 ---");
		System.out.println("아이디: " + id);
		System.out.println("비밀번호: " + pw);
		System.out.println("번호: " + num);
		System.out.println("Exist? " + isExist);
	}
	
} // end class Member 






