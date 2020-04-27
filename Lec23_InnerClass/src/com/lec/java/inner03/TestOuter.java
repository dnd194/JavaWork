package com.lec.java.inner03;

public class TestOuter {
	private int value;   //1
	
	public TestOuter(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
	
	public class TestInner{
		
		private int value;   //2
		
		public TestInner(int value) {
			this.value=value;
		}
		public void printValue() {
			int value= 10;
			System.out.println("value 는 어떤 값이 나올까 : "+value);  //지역변수 value
			System.out.println("inner클래스의 value : "+this.value);	//inner클래스의 value
			System.out.println("outer클래스의 value : "+TestOuter.this.value);  //거꾸로 올라가서 내려가면 됨
													//testouter 에 있는 객체의 value 값을 나타냄   (거진 안씀...) 
								
		}
	}

} // end class TestOuter














