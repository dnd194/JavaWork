package com.lec.java.class03;

public class Numeric {
	//멤버변수
	private char ch;
	private byte operator;
	private int operand1;
	private int operand2;
	
	
	//생성자
	public Numeric() {             //기본생성자
		
	}
	

	//매개변수 있는 생성자
	public Numeric(char ch, byte operator, int operand1, int operand2) {
		this.ch=ch;
		this.operator=operator;
		this.operand1=operand1;
		this.operand2=operand2;
	}
	
	//동작         getter/ setter 이름 제대로 안하면 동작이 안하는 프로그램도 있음
	//그러니까 getter setter 프로그램 사용
	public char getCh() {
		return ch;
	}
	public void setCh(char ch) {
		this.ch = ch;
	}
	public byte getOperator() {
		return operator;
	}
	public void setOperator(byte operator) {
		this.operator = operator;
	}
	public int getOperand1() {
		return operand1;
	}
	public void setOperand1(int operand1) {
		this.operand1 = operand1;
	}
	public int getOperand2() {
		return operand2;
	}
	public void setOperand2(int operand2) {
		this.operand2 = operand2;
	}
}
