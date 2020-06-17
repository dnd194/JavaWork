package com.lec.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WriteDTO {
	private int uid;				//wr_uid
	private String subject;			//wr_subject
	private String content;			//wr_content
	private String name;			//wr_name
	
	@JsonProperty("viewcnt")
	private int viewCnt;			//wr_viewcnt
	
	@JsonProperty("regdate")
	private String regDate;			//wr_regdate
	
	//기본생성자, 매개변수 생성자, getter/setter
	
	public WriteDTO() {
		super();
		System.out.println("WriteDTO() 생성");
	}
	
	public WriteDTO(int uid, String subject, String content, String name, int viewCnt) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
		this.uid = uid;
	}
	
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getViewCnt() {
		return viewCnt;
	}
	
	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	
	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

//	@Override
//	public String toString() {
//		return "WriteDTO [] "+ uid +" : "+subject+" : "+name+" : "+ content+
//				" : "+ viewCnt +" : "+regDate;
//		
//	}
	
	
	
}
