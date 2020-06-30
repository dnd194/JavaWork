package com.lec.sts14_transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class TicketDAO3 {

	JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	// TransactionTemplate 사용
	TransactionTemplate transactionTemplate;

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public TicketDAO3() {
		System.out.println(template); // 무엇이 나오나 찍어보는 용도
	}

//	티켓 구매
	public void buyTicket(final TicketDTO dto) {
		System.out.println("buyTicket()");
		System.out.println("userID : " + dto.getUserId());
		System.out.println("ticket count : " + dto.getTicketCount());

		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				//이 안의 작업들은 하나의 트랜젝션으로 작동한다.
				
				// 카드 결제
				template.update(new PreparedStatementCreator() {
					
					@Override
					public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
						String query = "insert into test_card values (?, ?)"; // test_card
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
						String query = "insert into test_ticket values (?, ?)"; // test_ticket
						PreparedStatement ps = con.prepareStatement(query);
						ps.setString(1, dto.getUserId());
						ps.setInt(2, dto.getTicketCount());
						return ps;
					}
				});
			
			}
		});

	}

}
