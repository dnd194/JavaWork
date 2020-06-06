package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AjaxWriteList extends AjaxWriteResult {
	@JsonProperty("data")
	List<WriteDTO> list; //데이터 목록
	
	@JsonProperty("totalcnt")
	int totalCnt;  // 메뉴는 총 몇개인가

	public AjaxWriteList() {
		super();
	}

	public List<WriteDTO> getList() {
		return list;
	}

	public void setList(List<WriteDTO> list) {
		this.list = list;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	
	
}
