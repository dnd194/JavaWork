package com.lec.java.static03;

import java.util.Calendar;

//Singleton 디자인 패턴  - 절대 new 는 사용 할 수 없다
//생성되는 인스턴스가 최대 1개까지만 허용해야하는 패턴설계


public class Static03Main {

	public static void main(String[] args) {
		System.out.println("Singleton 디자인 패턴"); //인스턴스를 1개만 생성하도록 하는 디자인 패턴
		
//		Test t1 = new Test();
//		Test t2 = new Test();
		
		Test t1 = Test.getInstance();
		System.out.println("t1 : num = "+ t1.getNum());		//0
		t1.setNum(123);
		System.out.println("t1 : num = "+ t1.getNum());		//123
		
		
		Test t2 = Test.getInstance();
		System.out.println("t2 : num + "+ t2.getNum());      // 0 이 아니라 123이 나온다
		
		t2.setNum(500);
		System.out.println("t1 : num = "+ t1.getNum());		//500
		
		//singleton 사용 예
		//Calender c = new Calender();
//		Calendar c = Calendar.getInstance();  
		
	} // end main()

} // end class Static03Main











