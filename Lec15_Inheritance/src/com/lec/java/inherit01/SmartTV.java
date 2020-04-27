package com.lec.java.inherit01;

public class SmartTV {

	// 멤버 변수
	boolean isPowerOn;
	int channel;
	int volume;
	String ip; // 스마트 tv에서 새로이 추가된 필드
	
	// 메서드
	public void displayInfo() {
		System.out.println("--- 스마트 tv 현재 상태 ---");
		System.out.println("전원: " + isPowerOn);
		System.out.println("채널: " + channel);
		System.out.println("볼륨: " + volume);
		System.out.println("인터넷 ip 주소 : " + ip); // 추가된 메서드

	}

}
