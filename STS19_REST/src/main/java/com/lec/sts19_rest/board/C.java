package com.lec.sts19_rest.board;

import org.springframework.jdbc.core.JdbcTemplate;
import org.apache.ibatis.session.SqlSession;

public class C {
	// 스프링 컨테이너에 생성된 JdbcTemplate 을 받아와서
	// 언제든지 원할때마다 가져다 쓸수 있도록 public static 으로 설정
	//public static JdbcTemplate template;
	
	// MyBatis 용 SqlSessoin
	public static SqlSession sqlSession;
	
	/*
	// 게시글 관련 쿼리문
	public static final String SQL_WRITE_SELECT = 
			"SELECT wr_uid \"uid\", wr_subject subject, "
			+ "wr_content content, wr_name name, wr_viewcnt viewcnt, "
			+ "wr_regdate regdate FROM test_write ORDER BY wr_uid DESC";

	public static final String SQL_WRITE_SELECT_BY_UID = // 글 읽어 오기
			"SELECT wr_uid \"uid\", wr_subject subject, "
			+ "wr_content content, wr_name name, wr_viewcnt viewcnt, "
			+ "wr_regdate regdate FROM test_write WHERE wr_uid=?";

	public static final String SQL_WRITE_INSERT = "INSERT INTO test_write " +
		"(wr_uid, wr_subject, wr_content, wr_name) " +
		"VALUES(test_write_seq.nextval, ?, ?, ?)";

	public static final String SQL_WRITE_INC_VIEWCNT =  // 조회수 증가
			"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";


	public static final String SQL_WRITE_UPDATE = 
			"UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";

	public static final String SQL_WRITE_DELETE_BY_UID = 
			"DELETE FROM test_write WHERE wr_uid = ?";
*/
	
	
}
