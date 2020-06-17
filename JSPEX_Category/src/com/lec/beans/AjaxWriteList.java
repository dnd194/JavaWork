package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//AjaxWriteResult 를 상속받음  즉 ==> count, message, status 3개는 기본적으로 가지고있음
public class AjaxWriteList extends AjaxWriteResult {
	@JsonProperty("list")
	private List<CategoryDTO> list;		//데이터 목록
	
	//			getter // setter
	public List<CategoryDTO> getList() {
		return list;
	}
	public void setList(List<CategoryDTO> list) {
		this.list = list;
	}
	
	
}
