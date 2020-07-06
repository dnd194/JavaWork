package com.lec.sts19_rest.board.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "employee")   // <employee>
public class EmployeeVO {
	@XmlAttribute		// "id" attribute
	private Integer id;
	
	@XmlElement         // <name> element
	private String name;
	
	@XmlElement			// <age> element
	private int age;
	
	@XmlElement			// <score> elements !
	private int[] score;
	
	// 어노테이션 없느면 XML변환에 포함 안됨.
	private double point;
	
	public EmployeeVO() {
		super();
	}
	public EmployeeVO(Integer id, String name, int age, int[] score, double point) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.score = score;
		this.point = point;
	}
	
	// getter 만 제공 : read-only 속성, immutable
	
	public Integer getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public int[] getScore() {
		return score;
	}
	public double getPoint() {
		return point;
	}
	
	
	
}








