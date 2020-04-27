package com.lec.java.inner07;

/*
  Anonymous inner class(익명 내부 클래스):
   이름이 없는 local inner class
   이름이 없기 때문에 생성자를 만들 수가 없습니다.
   클래스의 정의와 동시에 인스턴스를 생성합니다.
*/
public class Anonymous01Main {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Class(익명 내부 클래스)");
		
		Person p = new Person("ㅁㄴㅇㅁㄴㅇ");
		Readable r = p.createInstance(150);
		r.readInfo();
		
		Readable r2 = new Readable() {

			@Override
			public void readInfo() {
				System.out.println("r2 의 readInfo 입니다");
				
			}
			
		};
		r2.readInfo();
		
		Readable r3 = new Readable() {
			
			@Override
			public void readInfo() {
				System.out.println("살려주세여");
				
			}
		};
		r3.readInfo();
		
		//------------------------------
		
		
		new Readable() {

			@Override
			public void readInfo() {
				// TODO Auto-generated method stub
				System.out.println("이름이 필요 없는 readInfo");
			}
			
		}.readInfo();
		
		new Movable() {

			@Override
			public void move(int times) {
				// TODO Auto-generated method stub
				System.out.println("move() 호출"+ (times * speed));
			}
			
		}.move(2);
		
		MyClass my2 = new MyClass() {
			
			
			// override 가능
			public void run() {
				System.out.println("바뀌었다");
			}
		};
		my2.run();
		
		MyClass my3 = new MyClass() {
			// alt + shift + s   + v 
			@Override
			public void run() {
				// TODO Auto-generated method stub
				super.run();
			}

			@Override
			public void out() {
				// TODO Auto-generated method stub
				super.out();
			}
			
		};
		
	} // end main()

} // end class Anonymous01Main
abstract class Movable{
	int speed = 100;
	public abstract void move(int times);
}

class MyClass{
	public void run() {
		System.out.println("run()");
	}
	public void out() {
		System.out.println("out()");
	}
}













