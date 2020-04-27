package com.lec.java.access03;

import com.lec.java.access04.TestPublic2;

//import com.lec.java.access04.TestPublic; //같은 이름을 가진 클래스는 import가 아니라 full name을 써야함

//import com.lec.java.access04.MyDefault2;        --> not visible error

// 클래스의 접근 권한 수식어: public, (default)
// 1. public class: 어디에서나 인스턴스 생성이 가능한 클래스
//   (주의) public 클래스의 이름은 .java 파일 이름과 반드시 같아야 함
// 2. (default) class: 같은 패키지에 있는 클래스들에서만 인스턴스 생성이 가능

public class Access03Main {

	public static void main(String[] args) {
		System.out.println("public, default 클래스");
		
		TestPublic t1 = new TestPublic();
		
		//같은 패키지에 있는 디폴트 클래스에서는 인스턴스 생성 가능
		MyDefault t2 = new MyDefault(); 

		//다른 패키지에 있는 public 클래스
		//--> 인스턴스 생성 가능
		//4번 패키지에 있는 public 클래스를 가져와야할 때는 패키지를 import 해야한다.  3번 line
		TestPublic2 t3 = new TestPublic2();
		
		//다른 패키지에 있는 default 클래스   --> 디폴트클래스는 애시당초 import가 안됌  import 에서 문제가 발생
		//--> 인스턴스 생성 불가
//		MyDefault2 t4;
		
		//다른 패키지의 클래스와 동일 이름의 클래스가 충돌된다면??
		//아래와 같이 full name을 써줘야함 
		com.lec.java.access04.TestPublic t11 = new com.lec.java.access04.TestPublic();
		com.lec.java.access03.TestPublic t12;
		
		
		
	} // end main()

} // end class Access05Main










