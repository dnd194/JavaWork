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
		public static String SQL_WRITE_INSERT = "INSERT INTO cs_board "+"(cs_uid,  cs_name, cs_subject, cs_content) "+
		"VALUES(test_write_seq.nextval, ?, ?, ?)";
		
		

		// 게시글 읽어오기
		public static String SQL_WRITE_SELECT_BY_UID = "SELECT * FROM cs_board WHERE cs_uid = ?";
		
		//게시글 업데이트
		public static String SQL_WRITE_UPDATE = 
				"UPDATE cs_board SET cs_subject = ?, cs_content = ? WHERE cs_uid = ?";

		//게시글 나열 내림차순
		public static String SQL_WRITE_SELECT = "SELECT * FROM cs_board ORDER BY cs_uid DESC";
		
		//게시글 삭제
		public static String SQL_WRITE_DELETE_BY_UID =
				"DELETE FROM cs_board WHERE cs_uid = ?";
		
		
}
