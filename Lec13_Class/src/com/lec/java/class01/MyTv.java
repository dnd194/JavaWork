package com.lec.java.class01;
/*
클래스:
우리가 만들고자 하는 대상의 '상태' 와 '기능' 을 함께 가지고 있는 '데이터 타입'
상태(속성, 필드) -> 클래스의 멤버변수로 정의 
    field, attribute, member variable 라고 함
기능(동작) -> 클래스의 멤버메소드로 정의  
    behavior, member method 라고 함


일반적으로 
 멤버변수(필드)는 private 으로 설정. 
 멤버메소드는 public 으로 설정.
*/



public class MyTv {
	//tv의 상태(속성) --> 멤버변수
	//멤버변수: 같은 클래스에서 정의된 모든 메소드에서 사용가능
	
	private boolean isPowerOn;		//전원의 상태 on/off
	private int channel;			//현재 채널의 정보
	private int volume;				//현재 tv의 볼륨
	
	
	//tv의 기능 (동작) -->멤버 메서드 (method)
	//현재 상태표시
	public void displayStatus() {
		System.out.println("현재 tv상태는");
		System.out.println("------------------");
		System.out.println("전원 상태 :"+isPowerOn); //동일 클래스안의 멤버들 서로 사용가능
		System.out.println("채널 상태 :"+channel);
		System.out.println("볼륨 상태 :"+volume);
		System.out.println("------------------");
	}
	
	//전원 토글 동작
	public void powerOnOff() {
		if(isPowerOn) {  //티비가 켜져있다면 끌것
			isPowerOn=false;
			System.out.println("티비를 끕니다");
		}else {
			isPowerOn=true;
			System.out.println("티비를 킵니다");
		}
	}
	//채널 + 동작
	public int channelUp() {
		channel++;
		System.out.println("현재 채널: "+channel);
		return channel;
	}
	//채널 - 동작
	public int channelDown() {
		channel--;
		System.out.println("현재 채널: "+channel);
		return channel;
	}
	//볼륨 + 동작
	public int volumeUp() {
		volume++;
		System.out.println("현재 볼퓸: " +volume);
		return volume;
	}
	//볼륨 - 동작
	public int volumeDown() {
		volume--;
		System.out.println("현재 볼퓸: " +volume);
		return volume;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
