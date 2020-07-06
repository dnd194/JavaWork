package com.lec.sts19_rest.ticket;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.lec.sts19_rest.board.C;

public class TicketService {

	//mybatis 객체 가져오기~~
	private SqlSession sqlSession;

	@Autowired
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//transactionTemplate 사용
	private TransactionTemplate transactionTemplate;

	@Autowired
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	public void buyTicket(final TicketDTO dto) {
		//Mybatis 를 사용하여 이 트랜젝션 안의 여러동작(쿼리들) 을 실행
		//중간에 실패하면 트랜잭션 실패하고 자동으로 rollback 하는 역할
		
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				ITicketDAO dao = C.sqlSession.getMapper(ITicketDAO.class);
				dao.insertCard(dto.getUserId(), dto.getTicketCount());
				dao.insertTicket(dto.getUserId(), dto.getTicketCount());
//				하나라도 실패하면 rollback
				
			}
		});
		
	}
	
	
}
