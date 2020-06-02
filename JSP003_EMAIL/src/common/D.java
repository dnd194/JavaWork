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
		
//		//게시글 추가 (insert)
//		public static String SQL_WRITE_INSERT = "INSERT INTO test_write "+"(wr_uid, wr_subject, wr_content, wr_name) "+
//		"VALUES(test_write_seq.nextval, ?, ?, ?)";
//		
//		//조회수 증가
//		public static String SQL_WRITE_INC_VIEWCNT = 
//			"UPDATE test_write SET wr_viewcnt = wr_viewcnt + 1 WHERE wr_uid = ?";
//
//		// 게시글 읽어오기
//		public static String SQL_WRITE_SELECT_BY_UID = "SELECT * FROM test_write WHERE wr_uid = ?";
//		
//		//게시글 업데이트
//		public static String SQL_WRITE_UPDATE = 
//				"UPDATE test_write SET wr_subject = ?, wr_content = ? WHERE wr_uid = ?";
//
//		//게시글 나열 내림차순
//		public static String SQL_WRITE_SELECT = "SELECT * FROM test_write ORDER BY wr_uid DESC";
//		
//		//게시글 삭제
//		public static String SQL_WRITE_DELETE_BY_UID =
//				"DELETE FROM test_write WHERE wr_uid = ?";
		
		public static String SQL_INSERT = "INSERT INTO e_user VALUES (e_seq.nextval, ?, ?, ?, ?, 0)";

		public static String SQL_GET_EMAIL = "SELECT e_email FROM e_user WHERE e_id = ?";
		
		public static String SQL_EMAIL_CHECK = "SELECT e_echeck FROM e_user WHERE e_id = ?";
		
		public static String SQL_SET_EMAIL_CHECK = "UPDATE e_user SET e_echeck = '1' WHERE e_id = ?";

		


}
