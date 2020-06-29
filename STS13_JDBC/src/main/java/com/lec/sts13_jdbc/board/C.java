package com.lec.sts13_jdbc.board;

import org.springframework.jdbc.core.JdbcTemplate;

public class C {

	// 스프링 컨테이너에 생성된 jdbctemplate 을 받아와서
	// 언제든지 원할 때 마다 가져다 쓸 수 있도록
	public static JdbcTemplate template; // ==> public 이고 static이다 => 아무대서나 쓸 수 있다.

	// 게시글 추가 (insert)
	public static String SQL_WRITE_INSERT = "INSERT INTO test_write " + "(wr_uid, wr_subject, wr_content, wr_name) "
			+ "VALUES(test_write_seq.nextval, ?, ?, ?)";

	// 조회수 증가
	public static String SQL_WRITE_INC_VIEWCNT = "UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";

	// 게시글 읽어오기
	public static final String SQL_WRITE_SELECT_BY_UID = 
			"SELECT wr_uid \"uid\", wr_subject subject, "
			+ "wr_content content, wr_name name, wr_viewcnt viewCnt, "
			+ "wr_regdate regDate FROM test_write WHERE wr_uid = ?";


	// 게시글 업데이트
	public static String SQL_WRITE_UPDATE = "UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";

	// 게시글 나열 내림차순
	public static final String SQL_WRITE_SELECT = 
			"SELECT wr_uid \"uid\", wr_subject subject, "
			+ "wr_content content, wr_name name, wr_viewcnt viewCnt, "
			+ "wr_regdate regDate FROM test_write ORDER BY wr_uid DESC";


	// 게시글 삭제
	public static String SQL_WRITE_DELETE_BY_UID = "DELETE FROM test_write WHERE wr_uid = ?";

}
