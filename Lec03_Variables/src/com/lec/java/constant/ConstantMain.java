package com.lec.java.constant;

/*
 * 상수 : final
 * 변수 선언 앞에 final 키워드를 사용하면
 * '상수 (constant)' 가 되어.
 * 한번 값을 대입하면 변경할수 없게 된다.
 * 
 * 관례적으로 상수값을 담는 상수명은 대문자로 작성---------------------
 */


public class ConstantMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int myAge = 12;
		final int MYAGE = 36;
//		MYAGE = 20;  안됨 
		final short MYAGE2;  //변수의 이름을 바꿀때는 REFACTOR기능을 사용
		MYAGE2 = 100;  //한번 초기화 되면 변경불가
//		MYAGE2 = 80; 위에서 초기화를 해서 변경불가
		
		
	}

}
