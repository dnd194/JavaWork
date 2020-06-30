package com.lec.sts14_transaction;

public class TicketDTO {

	private String userId;
	private int ticketCount;
	
	//getter와 setter 만 일단 추가 했음
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getTicketCount() {
		return ticketCount;
	}
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	
	
	
}
