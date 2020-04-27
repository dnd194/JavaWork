package com.lec.java.method12;

/*  가변인자 (가변매개변수,가변인수) Variable arguments
   Java 5.0 부터 등장
     매개변수(argument, 인자)의 개수를 가변적으로 조정하는 기술
     ** 가변인자 기술이 없던 시절에는 '컬렉션' 사용.

     컴파일러에서 가변인자를 아래와 같이 변환해준다.
  
   1) 매개변수를 배열로 변환해준다
        원본 : public static void display(String... args)
        컴파일러 변환 후 : public static void display(String args[])
  
   2) 메소드 호출시 인자들을 이용해서 배열로 만들어 준다
        원본 : VarArgsMain.display("Hello", "World", "Korea");
        컴파일러 변환 후 : VarArgsMain.display(new String[] {"Hello", "World", "Korea" })
*/

public class Method12Main {

	public static void main(String[] args) {
		System.out.println("가변인자 (가변매개변수,가변인수) Variable arguments");

		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()
	
	
	// TODO
	
	
} // end class










