package common;
/*
 * DB 접속정보, 쿼리문, 테이블명, 컬럼명 등은
 * 별로도 관리하든지
 * XML, 초기화 파라미터등에서 관리하는게 좋다.
 * */
public class D {
	//Connection 에 필요한 값 세팅
		public static String DRIVER = "oracle.jdbc.driver.OracleDriver";
		public static String URL = "jdbc:oracle:thin:@localhost:1521:XE";
		public static String USERID="scott0316";		//유저 아이디
		public static String USERPW="tiger0316";		//유저 비밀번호
		
		//게시글 추가 (insert)
		public static String SQL_WRITE_INSERT = "INSERT INTO test_write "+"(wr_uid, wr_subject, wr_content, wr_name) "+
		"VALUES(test_write_seq.nextval, ?, ?, ?)";
		
		//조회수 증가
		public static String SQL_WRITE_INC_VIEWCNT = 
			"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";

		// 게시글 읽어오기
		public static String SQL_WRITE_SELECT_BY_UID = "SELECT * FROM test_write WHERE wr_uid = ?";
		
		//게시글 업데이트
		public static String SQL_WRITE_UPDATE = 
				"UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";

		//게시글 나열 내림차순
		public static String SQL_WRITE_SELECT = "SELECT * FROM test_write ORDER BY wr_uid DESC";
		
		//게시글 삭제
		public static String SQL_WRITE_DELETE_BY_UID =
				"DELETE FROM test_write WHERE wr_uid = ?";
		
		//첨부파일용 쿼리
		//특정 글 (wr_uid) 의 첨부파일 1개 insert
		public static final String SQL_FILE_INSERT =
				"insert into test_file"+"(bf_uid, bf_source, bf_file, wr_uid) "
				+"values"
				+"(test_file_seq.nextval, ?, ?, ?)"
				;
		
		
		//특정 글 (wr_uid) 의 첨부파일 들을 select  (0개일수도 여러개일 수 도 있음)
		public static final String SQL_FILE_SELECT = 
				"select bf_uid, bf_source, bf_file from test_file "
				+"where wr_uid = ? "
				+"order by bf_uid desc"
				;
		
		
		
		//특정 첨부파일 (bf_uid) 을 select 
		public static final String SQL_FILE_SELECT_BY_UID =
				"select bf_uid, bf_source, bf_file from test_file "
				+"where bf_uid = ?"
			 	;
		
		
		//특정 첨부파일 (bf_uid) 을 delete
		public static final String SQL_FILE_DELETE_BY_UID =
				"delete from test_file where bf_uid = ?"
				;
		
		//특정 글 (wr_uid)의 첨부파일들을 delete
		public static final String SQL_FILE_DELETE_BY_WRUID =
				"delete from test_file where wr_uid = ?"
				;
		
		
		
		
		
		
		
		
}
