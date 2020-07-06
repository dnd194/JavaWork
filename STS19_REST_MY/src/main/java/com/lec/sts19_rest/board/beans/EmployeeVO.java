package com.lec.sts19_rest.board.beans;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "employee")  //<-- 이 친구는 employee라는 rootTag 로 만들어짐
public class EmployeeVO {
	
	@XmlAttribute   //  ==> id 란 이름의 attribute
	private Integer id;
	
	@XmlElement
	private String name;
	
	@XmlElement
	private int age;
	
	@XmlElement           // <score> elements
	private int[] score;
	
	//어노테이션이 없으면 xml변환에 포함이 되지 않는다.
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
	//readonly 속성이라서==>immutable    ''getter'' 만 생성해줌
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
