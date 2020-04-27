package com.lec.java.wrapper05;

/* Wrapper 클래스의 유용성
 * 1. Object 타입이 모~든 (심지어 primitive) 타입도 받을수 있다.
 * 2. Collection 과 같은 Generic 클래스에선
 *     primitive 타입을 담을수 없다. 그러나 ,Wrapper 를 통해 가능하다.
 */
public class Wrapper05Main {

	public static void main(String[] args) {
		System.out.println("Wrapper 클래스의 유용성");
		
		Object[] obj = new Object[5];
		obj[0] = new Wrapper05Main();   //obj는 최상위 클래스이므로 가능
		obj[1] = new a();
		obj[2] = new a2();
		obj[3] = new b();
		obj[4] = 123;
					//Object 가 primitive 타입도 받을수 있음
					//auto boxing + 다형성 (polymorphism)때문에 가능     
					//Object <-- Integer <-- int   
		
		for (Object e : obj) {
			System.out.println(e);
			
			//알아서 auto unboxing 까지해서 123이 출력이 된다.
		}
		
		System.out.println();
//		int num = obj[4] * 2;  //요부분에서는 Object 와 *2 가 일어남
		int num = (Integer)obj[4] * 2;   // 그래서 캐스팅   (Integer) 해줘야함
		
		

		System.out.println("\n프로그램 종료");
	} // end main()

	// TODO
	
} // end class

class a {
	
}
class a2 extends a{
	
}
class b{
	
}