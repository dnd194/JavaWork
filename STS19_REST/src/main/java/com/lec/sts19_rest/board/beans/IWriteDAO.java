package com.lec.sts19_rest.board.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;

@MapperScan
public interface IWriteDAO {
	//Interface 이므로 추상메서드 들이 존재함
	
	public List<BWriteDTO> select();
	public int insert(final BWriteDTO dto);
	// 현재 readByUid 에는 쿼리가 2개 있다 
//	mybatis 에는불가하므로 아래에  incViewCnt를 새로 만든다
//	public List<BWriteDTO> readByUid(final int uid);
	public int deleteByUid(final int uid);
	
	public List<BWriteDTO> selectByUid(final int uid);
	public int update(final BWriteDTO dto);
	
	//@mapperscan 과 @param 을 이용한 메퍼설정
	public int update(int uid ,@Param("a") BWriteDTO dto);
	
	//{param} 용
	public int insert(String subject, String content, String name);
	public int incViewCnt(final int uid);
	
	public BWriteDTO searchBySubject(String subject);
	
	public int countAll();
	public List<BWriteDTO> selectFromRow(int from, int rows);
}
