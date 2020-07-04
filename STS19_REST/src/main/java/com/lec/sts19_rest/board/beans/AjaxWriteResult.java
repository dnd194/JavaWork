package com.lec.sts19_rest.board.beans;

public class AjaxWriteResult {
	int count;		//데이터 개수
	String status;	// 처리결과
	String message; //결과 메세지
	
	public AjaxWriteResult() {
		super();
	}
	
	
	public AjaxWriteResult(String status, String message) {
		super();
		this.status = status;
		this.message = message;
	}


	public AjaxWriteResult(int count, String status, String message) {
		super();
		this.count = count;
		this.status = status;
		this.message = message;
	}


	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
	
}
