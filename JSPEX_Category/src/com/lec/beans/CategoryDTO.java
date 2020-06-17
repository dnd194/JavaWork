package com.lec.beans;

public class CategoryDTO {
	
	private int uid;  //ca_uid
	private String name;	//ca_name
	private int depth;		//ca_depth
	private int parent; 	//ca_parent
	private int order;		//ca_order
	public CategoryDTO() {
		super();
	}
	public CategoryDTO(int uid, String name, int depth, int parent, int order) {
		super();
		this.uid = uid;
		this.name = name;
		this.depth = depth;
		this.parent = parent;
		this.order = order;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public int getParent() {
		return parent;
	}
	public void setParent(int parent) {
		this.parent = parent;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	
	
	
}
