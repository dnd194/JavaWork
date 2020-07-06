package com.lec.sts19_rest.board.beans;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface IAjaxDAO {

	// 페이징용 SELECT
	// from : 몇번재 row 부터
	// pageRows : 몇개의 데이터(게시글)
	public List<BWriteDTO> selectFromRow(
			@Param("from") int from,
			@Param("pageRows") int pageRows
			);
	
	// 전체글의 개수
	public int countAll();
	
	// 글 읽기
	public BWriteDTO selectByUid(int uid);
	
	// 조회수 증가
	public int incViewCnt(int uid);
	
	// 글작성
	public int insert(
			String subject,
			String content,
			String name
			);
	
	// 글수정
	public int update(
			@Param("uid") int uid,
			@Param("subject") String subject,
			@Param("content") String content
			);
	
	// 특정 uid 글(들) 삭제하기
	public int deleteByUid(int [] uids);
	
	/*
	 * DELETE FROM test_write 
	 * WHERE uid in (10, 20, 30)
	 * 
	 * WHERE uid in (1, 2)
	 * 
	 * WHERE uid in (11)
	 * 
	 */
	
	
}



                                                                          















