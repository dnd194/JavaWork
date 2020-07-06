package com.lec.sts19_rest.board.beans;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BWriteDTO {
	private int uid;     // wr_uid
	private String subject;   //wr_subject
	private String content;   //wr_content
	private String name;  // wr_name
	@JsonProperty("viewcnt")
	private int viewCnt;   // wr_viewcnt
	@JsonProperty("regdate")
	private Timestamp regDate;   // wr_regdate
	
	public BWriteDTO() {
		super();
	}
	public BWriteDTO(int uid, String subject, String content, String name, int viewCnt, Timestamp regDate) {
		super();
		this.uid = uid;
		this.subject = subject;
		this.content = content;
		this.name = name;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
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
//	public Timestamp getRegDate() {
//		return regDate;
//	}
	
	public String getRegDate() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate);
	}
	
	
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	
	
}














