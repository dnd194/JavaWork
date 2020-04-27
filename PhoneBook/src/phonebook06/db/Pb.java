package phonebook06.db;

//				Controller interface  동작을 정의
//						동작을 정의하기전에 '동작에대한 설계' 를 잘해야함
public interface Pb {

	public static final String VERSION = "전화번호부 6.0";

	// 만들고자 하는 응용프로그램의
	// '동작' 을 설계하는 것이 인터페이스다.
	// 이 인터페이스는 View 와 Controller 의 연결고리 역할을 하여. 모듈단위 유지관리를 용이하게 해준다.

	// [동작 설계]
	// 1. 이름(name) 과 전화번호(phoneNum) 과 메모 (memo) 값이 주어지면
	// 전화번호 데이터(PhonebookModel) 를 생성하여 저장
	// 날짜(regDate) 는 생성한 날짜로, uid 값은 자동 증가 값으로
	// 성공하면 1, 실패하면 0 리턴
	// 2. 현재 전화번호부에 저장된 전화번호 데이터(PhonebookModel) 들을 전부 불러들여서 리턴 (PhonebookModel 배열로)
	// 3. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 리턴 , 없으면 null 리턴 (검색기능)
	// 4. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서
	// 주어진 이름(name) 과 전화번호(phoneNum) 과 메모(memo) 값 으로 변경. 성공하면 1, 실패하면 0 리턴
	// 5. 특정 uid 값을 가진 전화번호 데이터(PhonebookModel) 을 찾아서 삭제. 성공하면 1, 실패하면 0 리턴

	public abstract int insert(String name, String phoneNum, String memo); // 요구사항 1번 성공하면 1, 실패하면 0 리턴

	public abstract PhonebookModel[] selectAll(); // 요구사항 2번

	public abstract PhonebookModel selectByUid(int uid); // 요구사항 3번

	public abstract int updateByUid(int uid, String name, String phoneNum, String memo); // 요구사항 4번 변경 = update

	public abstract int deleteByUid(int uid); // 요구사항 5번

//	public static final int QEURY_FAIL = 0; // 실패하면 ' 0 ' 을 리턴하도록하는 상수 선언

	// 에러
	// ex) 인덱스 범위 벗어나는 것,
	// 입력문자열이 empty or null 인 경우
	// uid 가 없는 경우

	// 에러코드 상수
	public static final int ERR_GENERIC = 0; 				// ==> 일반 오류
	public static final int ERR_INDEXOUTOFRANGE = 1; 		// ==> 인덱스 범위 벗어나는 것,
	public static final int ERR_EMPTY_STRING = 2; 			// ==> 입력문자열이 empty or null 인 경우
	public static final int ERR_UID = 3;			 		// ==> uid 가 없는 경우

	// 에러문자열
	public static final String[] ERR_STR = { 
			"일반오류 ", 			// 0
			"인덱스 오류", 		// 1
			"문자열 오류", 		// 2
			"UID 오류",			// 3
	};
	
	// JDBC 드라이버 클래스 정보
		public static final String DRIVER =
				"oracle.jdbc.driver.OracleDriver";
		// DB 서버 정보
		public static final String URL =
				"jdbc:oracle:thin:@localhost:1521:XE";
		// DB 사용자 계정 정보
		public static final String USER = "scott0316";
		public static final String PASSWD = "tiger0316";
		
		
		public static final String TBL_NAME = "phonebook";
		
		public static final String COL_LABEL_UID = "pb_uid";
		public static final String COL_LABEL_NAME = "pb_name";
		public static final String COL_LABEL_PHONENUM = "pb_phonenum";
		public static final String COL_LABEL_MEMO = "pb_memo";
		public static final String COL_LABEL_REGDATE = "pb_regdate";
		public static final String SEQ_NAME = "phonebook_seq";

		//쿼리 문자열
		//PreparedStatement
		
		public static final String SQL_COUNT_ALL  
										= "SELECT COUNT(*) AS CNT FROM "+TBL_NAME;        //레코드의 개수 뽑기
		
		public static final String SQL_SELECT_ALL = "SELECT * FROM "+TBL_NAME 
												+" ORDER BY "+ COL_LABEL_UID + " DESC";  
		public static final String SQL_INSERT = "INSERT INTO "+TBL_NAME + "(pb_uid, pb_name, pb_phonenum, pb_memo) "+
													"VALUES ("+SEQ_NAME+".nextval , ?, ?, ?)";     //uid 는 시퀀스
		
		public static final String SQL_UPDATE_BY_UID 
									= "UPDATE "+TBL_NAME+ " SET "
											+COL_LABEL_NAME+ " = ? ," 
											+COL_LABEL_PHONENUM+ " = ? ,"
											+COL_LABEL_MEMO+ " = ? "
											+" WHERE "+COL_LABEL_UID+ " = ?";
		//		"UPDATE phonebook SET pb_name = ?, pb_phonenum = ?, pb_memo = ? WHERE pb_uid = ?"
		
		public static final String SQL_DELETE_BY_UID 
									= "DELETE FROM "+TBL_NAME+" WHERE "+ COL_LABEL_UID+ " = ?";
		
		//TODO : 추가로 필요한 QUERY문
		public static final String SQL_SELECT_BY_UID
								= "SELECT * FROM phonebook where "+COL_LABEL_UID+" = ?";
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	

}
