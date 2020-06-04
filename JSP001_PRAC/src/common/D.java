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
		
		
		public static String SQL_INSERT_MENU = "insert into demo_menu_table values (uid_seq.nextval, ?, ?)";
		public static String SQL_SELECT ="select * from demo_menu_table ORDER BY menu_uid ASC";
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
		
		
}
