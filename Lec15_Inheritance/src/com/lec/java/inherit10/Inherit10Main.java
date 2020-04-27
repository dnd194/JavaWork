package com.lec.java.inherit10;

/*
	final 메소드 
		더이상 오버라이딩 될수 없는 메소드
 */
/*
메소드 오버라이딩(Overriding), 재정의
부모 클래스에 있는 메소드를
자식 클래스에서 리턴 타입, 매개변수 모두 동일하게 유지하면서
메소드의 본체를 다시 정의하는 것
접근권한(private, (default), protected, public)도 동일하게 유지하는 것이
일반적이지만,
접근 범위를 더 넓게 변경하는 것은 가능. 하지만 좁히는 것은 허용 안됨.
*/

public class Inherit10Main {

	public static void main(String[] args) {
		System.out.println("final 메소드");
		
		// TODO
		
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

class TestSuper{
	//access modifier 가 각각 다른 method
	private void test1() {
		System.out.println("부모 private 메소드");
	}
	void test2() {
		System.out.println("부모 default 메소드");
	}
	protected void test3() {
		System.out.println("부모 protected 메소드");
	}
	public void test4() {
		System.out.println("부모 public 메소드");
	}


}
//private < default < protected < public     visibility 볼 수 있는 범위 
//상속시에 접근자 범위를 좁히는거는 불가   ===> 대신 넓히는 것은 가능
class TestSub extends TestSuper{

	@Override
	void test2() {     //private 불가 protected , public 가능
		// TODO Auto-generated method stub
		super.test2();
	}

	@Override
	protected void test3() {			//private , default 불가    public 가능
		// TODO Auto-generated method stub
		super.test3();
	}

	@Override
	public void test4() {
		// TODO Auto-generated method stub
		super.test4();
	}
	
}