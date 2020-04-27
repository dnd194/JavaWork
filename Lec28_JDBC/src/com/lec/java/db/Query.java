package com.lec.java.db;

public interface Query {
	// 1. Oracle 연동을 위한 정보들(상수들)을 정의(세팅)
	// JDBC 드라이버 클래스 정보
	public static final String DRIVER =
			"oracle.jdbc.driver.OracleDriver";
	// DB 서버 정보
	public static final String URL =
			"jdbc:oracle:thin:@localhost:1521:XE";
	// DB 사용자 계정 정보
	public static final String USER = "scott0316";
	public static final String PASSWD = "tiger0316";

	public static final String TBL_NAME = "test_member";
	public static final String COL_LABEL_NO = "mb_no";
	public static final String COL_LABEL_NAME = "mb_name";
	public static final String COL_LABEL_BIRTHDATE = "mb_birthdate";
	public static final String SEQ_NAME = "test_member_seq";
	
	// PreparedStatement에서 사용될 SQL 문장
	public static final String SQL_SELECT_ALL =
			"SELECT * FROM " + TBL_NAME;
	
	public static final String SQL_INSERT =
			"INSERT INTO " + TBL_NAME + " VALUES(?, ?, ?)";
	
	public static final String SQL_INSERT_SEQ = 
			"INSERT INTO " + TBL_NAME + " VALUES(" + SEQ_NAME + ".nextval, ?, SYSDATE)";
	
	public static final String SQL_UPDATE_BIRTHDATE =
			"UPDATE " + TBL_NAME 
			+ " SET " + COL_LABEL_BIRTHDATE + " = ?"
			+ " WHERE " + COL_LABEL_NO + " = ?";
	
	public static final String SQL_DELETE_BY_NO =
			"DELETE FROM " + TBL_NAME 
			+ " WHERE " + COL_LABEL_NO + " = ?";

} // end Query(I)
