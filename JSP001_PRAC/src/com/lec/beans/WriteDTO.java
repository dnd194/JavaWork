package com.lec.beans;



import org.apache.catalina.Session;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WriteDTO {
	//메뉴 uid, name, price, store uid
	private int uid;	
	private String menu_name;
	private int menu_price;  
	private int store_uid;
	
	public WriteDTO() {
		super();
	}

	public WriteDTO(String menu_name, int menu_price) {
		super();
		this.menu_name = menu_name;
		this.menu_price = menu_price;
	}

	public WriteDTO(int uid, String menu_name, int menu_price, int store_uid) {
		super();
		this.uid = uid;
		this.menu_name = menu_name;
		this.menu_price = menu_price;
		this.store_uid = store_uid;
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

	public int getStore_uid() {
		return store_uid;
	}

	public void setStore_uid(int store_uid) {
		this.store_uid = store_uid;
	}
	
	
	
	
}
