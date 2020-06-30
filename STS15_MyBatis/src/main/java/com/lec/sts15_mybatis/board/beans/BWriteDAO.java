package com.lec.sts15_mybatis.board.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.lec.sts15_mybatis.board.C;

public class BWriteDAO {
	
	JdbcTemplate template;

	public BWriteDAO() {
		this.template = C.template;
	}
	
	//전체 select 
	public List<BWriteDTO> select(){
		
		return template.query(C.SQL_WRITE_SELECT, 
						new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
					//이 친구가 List를 return 하기 때문
	}
	
	//insert  할때는 PreparedStatementSetter 익명클래스를 이용한다.
	public int insert(final BWriteDTO dto) {
		
//		1. update + PreparedStatementSetter
//		return template.update(C.SQL_WRITE_INSERT, new PreparedStatementSetter() {
//			
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {
//				//여기서 물음표에 들어가야하는 값들을 세팅하면 됨
//				ps.setString(1, dto.getSubject());
//				ps.setString(2, dto.getContent());
//				ps.setString(3, dto.getName());
//			}
//		});  // 이 전체 값을 return 때려버림
		
		//PreparedStatementCreator() 은 아예 새로 만드는것
		//위에 꺼는 PreparedStatement가 이미 있다고 가정하여 하는 메서드
		
//		2. update + PreparedStatementCreator
		return template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_INSERT);
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setString(3, dto.getName());
				
				return ps;
			}
		});
	}
	
	public List<BWriteDTO> readByUid(final int uid){
		int cnt = 0;
		cnt = template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps2 = con.prepareStatement(C.SQL_WRITE_INC_VIEWCNT);
				ps2.setInt(1, uid);
				return ps2;
			}
		});
		return template.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_SELECT_BY_UID);
				ps.setInt(1, uid);
				return ps;
			}
		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
		
	}
	
	public int deleteByUid(final int uid) {
		return template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_DELETE_BY_UID);
				ps.setInt(1, uid);
				return ps;
			}
		});
	}
	
	public List<BWriteDTO> selectByUid(final int uid){
		return template.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_SELECT_BY_UID);
				
				ps.setInt(1, uid);
				return ps;
			}
		}, new BeanPropertyRowMapper<BWriteDTO>(BWriteDTO.class));
	}
	
	public int update(final BWriteDTO dto) {
		return template.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(C.SQL_WRITE_UPDATE);
				ps.setString(1, dto.getSubject());
				ps.setString(2, dto.getContent());
				ps.setInt(3, dto.getUid());
				return ps;
			}
		});
	}
}
