package com.lec.sts19_rest.board.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

//AjaxWriteResult 를 상속받음  즉 ==> count, message, status 3개는 기본적으로 가지고있음
public class AjaxWriteList extends AjaxWriteResult {
	@JsonProperty("data")
	private List<BWriteDTO> list;		//데이터 목록
	
	private int page;	//현재 페이지
	@JsonProperty("totalpage")
	private int totalPage;  //총 페이지 분량
	
	@JsonProperty("totalcnt")
	private int totalCnt;  //데이터 (글 or 목록)은 몇개?
	
	@JsonProperty("writepages")
	private int writePages;  // 한[페이징]에 몇개의 페이지를 표현할 것인가
	
	@JsonProperty("pagerows")
	private int pageRows; //한 페이지에 몇개의 글을 리스트 할 것인가
	
	

	//			getter // setter
	public List<BWriteDTO> getList() {
		return list;
	}
	public void setList(List<BWriteDTO> list) {
		this.list = list;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCnt() {
		return totalCnt;
	}
	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}
	public int getWritePages() {
		return writePages;
	}
	public void setWritePages(int writePages) {
		this.writePages = writePages;
	}
	public int getPageRows() {
		return pageRows;
	}
	public void setPageRows(int pageRows) {
		this.pageRows = pageRows;
	}

	
	
	
}
