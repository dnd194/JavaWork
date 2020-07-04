package com.lec.sts19_rest.board.beans;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="employees")
public class EmployeeListVO {
	
	@XmlElement				//<emp>~</emp> 들로 만들어진다.
	private List<EmployeeVO> emp = new ArrayList<EmployeeVO>();;
	
	
	public List<EmployeeVO> getEmployees() {
		return emp;
	}
	
	
	
	
	
	
	
	
	
	
	
}
