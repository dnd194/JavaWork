package com.lec.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

//POJO : Plain Old Java Object 
@JacksonXmlRootElement(localName = "WriteList")
public class AjaxWriteListXML {
	int count;	//데이터 개수
	String status;  //처리 결과
	
	@JsonIgnore
	String memo;   //자바 객체는 존재하지만 response에서는 뺄뿐
	
	@JacksonXmlElementWrapper(useWrapping = false)  //이게 없으면 큰 Data 태그 아래에 Data 태그들이 더 있음
	@JacksonXmlProperty(localName = "Data")
	List<WriteDTO> list;

	//getter / setter
	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public List<WriteDTO> getList() {
		return list;
	}

	public void setList(List<WriteDTO> list) {
		this.list = list;
	}
	
	
	
}
