package com.beans;


public class WriteDTO {
	
	public int e_uid;
	public String userID;
	public String userPassword;
	public String userEmail;
	public String userEmailHash;
	public String userEmailChecked;
	
	//기본 생성자, 매개변수 생성자, getter/setter
	public WriteDTO() {
		super();
	}

	public WriteDTO(int e_uid, String userID, String userPassword, String userEmail, String userEmailHash,
			String userEmailChecked) {
		super();
		this.e_uid = e_uid;
		this.userID = userID;
		this.userPassword = userPassword;
		this.userEmail = userEmail;
		this.userEmailHash = userEmailHash;
		this.userEmailChecked = userEmailChecked;
	}

	public int getE_uid() {
		return e_uid;
	}

	public void setE_uid(int e_uid) {
		this.e_uid = e_uid;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserEmailHash() {
		return userEmailHash;
	}

	public void setUserEmailHash(String userEmailHash) {
		this.userEmailHash = userEmailHash;
	}

	public String getUserEmailChecked() {
		return userEmailChecked;
	}

	public void setUserEmailChecked(String userEmailChecked) {
		this.userEmailChecked = userEmailChecked;
	}
	
	

}

