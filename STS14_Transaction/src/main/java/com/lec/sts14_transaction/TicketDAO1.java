package com.lec.sts14_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class TicketDAO1 {

	JdbcTemplate template;

	public TicketDAO1() {
		System.out.println(template); //무엇이 나오나 찍어보는 용도
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
//	티켓 구매
	public void buyTicket(final TicketDTO dto) {
		System.out.println("buyTicket()");
		System.out.println("userID : "+dto.getUserId());
		System.out.println("ticket count : "+dto.getTicketCount());
		
		
		// 카드 결제 
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into test_card values (?, ?)";   //test_card
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, dto.getUserId());
				ps.setInt(2, dto.getTicketCount());
				return ps;
			}
		});
		
		// 티켓 발권
		template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into test_ticket values (?, ?)";  //test_ticket
				PreparedStatement ps = con.prepareStatement(query);
				ps.setString(1, dto.getUserId());
				ps.setInt(2, dto.getTicketCount());
				return ps;
			}
		});
	}
		
}















