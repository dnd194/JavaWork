package com.lec.beans;


/*
 * DTO : Data Transfer Object
 * 			데이터를 담아 나르기 위한 객체
 * 
 * 게시글 DTO, 회원 DTO, ... 필요한 데이터 객체들 만큼 정의
 * 
 * BEAN 객체
 * */

public class WriteDTO {
	private int uid;				//wr_uid
	private String menu_name;
	private int menu_price;
	
	
	public WriteDTO() {
		super();
	}
	
	
	public WriteDTO(String menu_name, int menu_price) {
		super();
		this.menu_name = menu_name;
		this.menu_price = menu_price;
	}


	public WriteDTO(int uid, String menu_name, int menu_price) {
		super();
		this.uid = uid;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getMenu_name() {
		return menu_name;
	}
	public void setMenu_name(String menu_name) {
		this.menu_name = menu_name;
	}
	public int getMenu_price() {
		return menu_price;
	}
	public void setMenu_price(int menu_price) {
		this.menu_price = menu_price;
	}
	
	
	
	

	
	
}
