package com.lec.spring.beans;


public class DAO {
	String uid; // DAO객체 식별용 필드
	
	public DAO() {
		System.out.println("DAO() 생성");
	}

	public DAO(String uid) {
		super();
		System.out.printf("DAO(%s) 생성\n", uid);
		this.uid = uid;
	}
	
	@Override
	public String toString() {
		return String.format("[DAO: %s]", this.uid);
	}
} // end class

// DAO 상속 받은 클래스
class DAOEx extends DAO{
	public DAOEx() {
		super();
		System.out.println("DAOEx() 생성");
	}

	public DAOEx(String uid) {
		super(uid);
		System.out.printf("DAOEx(%s) 생성\n", uid);
	}
	
	@Override
	public String toString() {
		return String.format("[DAOEx: %s]", this.uid);
	}	
} // end class