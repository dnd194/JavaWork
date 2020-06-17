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
		
		//특정 depth 의 특정 parent 인 카테고리들 읽어오기
		public static final String SQL_CATEGORY_BY_DEPTH_N_PARENT 
							= "select ca_uid, ca_name, ca_depth, ca_parent, ca_order from test_category "+
								"where ca_depth = 2 and ca_parent = 1 order by ca_order asc";
		
		public static final String SQL_SELECT_ALL =
				"select ca_uid, ca_name, ca_depth, ca_parent, ca_order from test_category ";
				
		
		public static final String SQL_CATEGORY_BY_DEPTH_N_PARENT2 =
					"select ca_uid, ca_name, ca_depth, ca_parent, ca_order from test_category "
				+"where ca_depth = ? and ca_parent = ? order by ca_order asc";
		
		public static final String SQL_CATEGORY_BY_DEPTH_N_PARENT3 =
				"select ca_uid, ca_name, ca_depth, ca_parent, ca_order from test_category "
						+"where ca_depth = ? order by ca_order asc";
		//필요한 쿼리문 만들어 보기
		public static final String SQL_FIND_PARENT = "select ca_uid, ca_name, ca_depth, ca_parent, ca_order from test_category where ca_depth = 1";
		
		
		
//		SELECT ca_uid "uid", ca_name name, ca_depth DEPTH, ca_parent parent, ca_order "order"
//		FROM TEST_CATEGORY 
//		WHERE CA_DEPTH = 2 AND CA_PARENT = 1
//		ORDER BY CA_ORDER ASC;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		// 글 목록 전체 개수 가져오기
		public static final String SQL_WRITE_COUNT_ALL = "SELECT count(*) FROM test_write";
		
		// fromRow 부터 pageRows 만큼 SELECT
		// (몇번째) 부터 (몇개) 만큼
		public static final String SQL_WRITE_SELECT_FROM_ROW =  "SELECT * FROM " + 
				"(SELECT ROWNUM AS RNUM, T.* FROM (SELECT * FROM test_write ORDER BY wr_uid DESC) T) " + 
				"WHERE RNUM >= ? AND RNUM < ?";
		
}
