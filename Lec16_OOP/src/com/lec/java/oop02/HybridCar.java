package com.lec.java.oop02;

public class HybridCar extends Car{
	
	private int elec;

	
	@Override
	public void displayInfo() {
		
		System.out.println("------- HybridCar 정보 --------");
		System.out.println("speed : "+getSpeed());
		System.out.println("oil : "+getOil());
		System.out.println("elec : "+ getElec());
		
		
	}

	
	
	public int getElec() {
		return elec;
	}

	public void setElec(int elec) {
		this.elec = elec;
	}
	

}
