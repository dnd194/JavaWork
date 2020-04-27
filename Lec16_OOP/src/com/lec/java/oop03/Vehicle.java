package com.lec.java.oop03;

public class Vehicle {
	private int speed;

	public void displayInfo() {
		System.out.println("------- Vehicle 정보 -------");
		System.out.println("speed : "+speed);
		
	}
	
	
	
	
	
	
	
	//getter / setter
	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
}
