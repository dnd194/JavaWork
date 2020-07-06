package com.lec.sts19_rest.ticket;

public interface ITicketDAO {
	//메서드 세팅   
//	이 2개가 하나의 트랜젝션으로 돌아가야함  핵심
	public int insertCard(String userId, int buyAmount);
	public int insertTicket(String userId, int ticketCount);
}
