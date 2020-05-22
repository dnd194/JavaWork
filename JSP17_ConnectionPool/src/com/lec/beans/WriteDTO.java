package com.lec.beans;

// DTO : Data Trasfer Object
//    데이터를 담아 나르기 위한 객체

// 게시글DTO, 회원DTO, ... 필요한 데이터 객체들 만큼 정의
// Bean 객체

public class WriteDTO {
	private int uid;     // wr_uid
	private String subject;   //wr_subject
	private String content;   //wr_content
	private String name;  // wr_name
	private int viewCnt;   // wr_viewcnt
	private String regDate;   // wr_regdate
	
	// 개발시..
	// 다음 3가지 네이밍은 일치시켜주는 것이 좋다 .
	// 클래스 필드명 = DB 필드명  = form 의 name명
	
	// 기본생성자, 매개변수 생성자
	public WriteDTO() {
		super();
		System.out.println("WriteDTO() 객체 생성");
	}
	public WriteDTO(int uid, String subject, String content, String name, int viewCnt) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
		System.out.println("WriteDTO(uid, subject, content, name, viewCnt) 객체 생성");
	}
	
	// getter / setter
	public int getUid() {
		System.out.println("getUid() 호출");
		return uid;
	}
	public void setUid(int uid) {
		System.out.println("setUid(" + uid + ") 호출");
		this.uid = uid;
	}
	public String getSubject() {
		System.out.println("getSubject() 호출");
		return subject;
	}
	public void setSubject(String subject) {
		System.out.println("setSubject(" + subject + ") 호출");
		this.subject = subject;
	}
	public String getContent() {
		System.out.println("getContent() 호출");
		return content;
	}
	public void setContent(String content) {
		System.out.println("setContent(" + content + ") 호출");
		this.content = content;
	}
	public String getName() {
		System.out.println("getName() 호출");
		return name;
	}
	public void setName(String name) {
		System.out.println("setName(" + name + ") 호출");
		this.name = name;
	}
	public int getViewCnt() {
		System.out.println("getViewCnt() 호출");
		return viewCnt;
	}
	public void setViewCnt(int viewCnt) {
		System.out.println("setViewCnt(" + viewCnt + ") 호출");
		this.viewCnt = viewCnt;
	}
	public String getRegDate() {
		System.out.println("getRegDate() 호출");
		return regDate;
	}
	public void setRegDate(String regDate) {
		System.out.println("setRegDate(" + regDate + ") 호출");
		this.regDate = regDate;
	}
	
	// 테스트, 개발용으로 toString() 오버라이딩 하면 좋다.
	@Override
	public String toString() {
		return "WriteDTO] " + uid + " : " + subject + " : " 
			+ content + " : " + name + " : " + viewCnt + " : " + regDate;
	}
	
} // end DTO

















