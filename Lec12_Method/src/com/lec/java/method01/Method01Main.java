package com.lec.java.method01;

import java.util.Scanner;

/* 메소드 (Method):
 		반복되는 코드, 내용, 재사용해야할 코드들을 한 뭉치로 묶어서
 		따로 메소드로 만들은 다음(정의) 이를 필요할때마다 사용(호출)한다. 
 		
 		※ 자바는 '함수(function)' 가 따로 없습니다
 		  그러나 교육하면서 편의상, 혼용하여 말하겠습니다.
 		
	 메소드 정의:
	 	메소드는 main 메소드 바깥에서!!, class 안에서 정의!!

	 메소드 정의구문:
		수식어        리턴타입              메소드이름(매개변수, ...) { ... }
	    modifier return_type  method_name(parameter, ...) { ... }
	
		수식어(modifier) : public, static, private, ... (생략 가능)
	   
		매개변수 (parameter) : 메소드 호출시 넘겨주는 값.

		리턴타입 (return type) : 메소드 종료후 호출한 쪽에 돌려주는 값
			void, int, double, String ...
			(리턴타입 void의 의미는 되돌려주는 값(return 값)이 없다는 의미)
	
	메소드 signature 란?:
		메소드 이름 + 매개변수 리스트 (매개변수 타입, 순서, 개수)  매개변수이름은 중요치 않음  ++ 타입 ++ 이 중요
			sayAge(int)
			sayHello3(String, int)
			
*/

public class Method01Main {
	
	public static void main(String[] args) {
		System.out.println("메소드(함수) Method(Function)");
		
		System.out.println("안녕하세요");
		System.out.println("제 이름은 쌈빈입니다");
		
		
		System.out.println("안녕하세요");
		System.out.println("제 이름은 쌍삔입니다");
		
		System.out.println("안녕하세요");
		System.out.println("제 이름은 쌈삔입니다");
		
		System.out.println();
		System.out.println("메소드 사용(호출)");
		
		//메소드 호출구문
		//메소드 이름(매개변수 값)  
		
		//메소드 호출  = method call = method invoke
		sayhello("ㅇㅇㅇ");       //메인메소드 (main) 가  메소드(sayhello)를 호출 한 것 
		sayhello("임상빈");
		System.out.println();
		sayAge(3);
		sayAge(5);

		com.lec.java.method01.Method01Main.sayAge(20); //이게 sayAge의 full name
		
		System.out.println();
		sayhello2("쌈빈", 27);
		System.out.println();     // ==>>>> 이 친구도 결국에는 메소드 호출  'println()' 이라는 메소드
		
		//메소드 호출시 매개변수를 맞게 집어 넣어줘야함
//		sayhello2(100, 100);   //not applicable ~~~ 정의되어있지않은 매개변수를 집어넣었을시 나오는 오류
		
		sayhello3("ㅇㅅㅂ", 27);
		
		
		System.out.println("\n프로그램 종료");
	} // end main()
	//********************************   메소드는 항상 메인 밖에서 해야합니다~~~     *******************************************************************
	//자바에서 메소드 안에 메소드 정의는 그딴거 없다
	//  메소드 이름 : sayhello
	//  매개변수 : name(매개변수가 필요 없을시에는 생략 가능)
	
	//메소드 위에 아래와 같이 javadoc 타입 주석을 달 수 있다.
	/**    
	 * 메소드 이름:sayhello         ==> 메소드에 대한 설명을 입력할수 있는 주석  sayhello에 커서 올려놓으면 설명이 나옴
	 * 주어진 이름을 출력합니다 
	 * @param name 이름
	 */
	
	public static void sayhello(String name) {
		System.out.println("안녕하세용");
		System.out.println("제 이름은 "+name+" 입니다");
	}

//	aaaaa() ==> 호출구문  ,      Aaaa = bb ; 변수 선언 
	
	//메소드 이름 : sayAge
	//매개변수 : int 타입 의 age
	//리턴 타입 : void 
	public static void sayAge(int age) {
		System.out.println("hi");
		System.out.println("제 나이는"+age+"입니다");
		
	}
	
	//메소드 이름 : sayhello2
	//매개변수 : 1. 이름, 2. 나이   ==> String name, int age
	//리턴타입 : void
	
	public static void sayhello2(String name, int age) {
		System.out.println("하위");
		System.out.println("이름은 "+name+" 입니다" );
		System.out.println("나이는 "+age+" 입니다" );
	}
	
	
	public static void sayhello3(String name, int age) {
		
		//메소드에서 메소드를 호출 할 수 있다.
		sayhello(name);    //받은 매개변수가 각 각의 메소드에 들어간다.
		sayAge(age);
	}
	
	
	
	
	
	
	
	
	
	
	
	
} // end class

/*
 * 이클립스 단축키 : 메소드 이름위에서
 * 	F3 : Open Declaration  (이 메소드 는 어디서 정의?)  //메소드가 정의된 곳으로 이동 ctrl + 메소드 클릭도 가능
 * 	CTRL + ALT + H : Open Call Hierarchy (이 메소드는 어디서 호출되나?)
 * 
 * 디버깅 :
 *   step into : 현재 디버깅 위치의 메소드 호출 내부 코드 진입
 *   step out (step return) : 현재 디버깅 진행중인 메소드 return 까지 진행후 호출한 측으로 돌아감
 *   resume : 다음 breakpoint 까지 쭈욱 진행 
 */








