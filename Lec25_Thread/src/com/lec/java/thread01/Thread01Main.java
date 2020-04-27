package com.lec.java.thread01;

/*	쓰레드 Thread
 *  동일 프로세스 내에 '독립'적인 다중 수행하는 프로그램 단위
 *  병행성 증진. 처리율 향상, 응답속도 향상 목적
 * 
 *  자바에서 쓰레드를 만들어서 사용하는 방법1:
 *   1. Thread 클래스를 상속받는 클래스를 정의
 *   2. 정의한 클래스에서 run() 메소드를 override - 쓰레드에서 할 일을 구현
 *   3. Thread 클래스의 인스턴스를 생성
 *   4. 생성된 인스턴스에서 start() 메소드를 호출
 */

public class Thread01Main {

	public static void main(String[] args) {
		System.out.println("쓰레드 생성 1");
		
		// 3. Thread 클래스의 인스턴스를 생성
		Thread th1 = new MyThread("hello java");
		Thread th2 = new MyThread("안녕하세여");
		
		// 4. 생성된 인스턴스에서 start() 메소드를 호출
		
//		th1.run();// 잘못됨                   //==> run 은 thread 의 *** start *** 로 뽑아야함
		th1.start();  // 이렇게 start 로 빱아야함 
		th2.start();
		
		
		// Thread 클래스의 start() 메소드를 호출하면,
		// 내부적으로 run() 메소드가 호출됨
		// start() 메소드가 호출되어야 OS에 의해서 쓰레드로 동작을 하게 됨
		
		// run() 메소드를 직접 호출하는 경우는 쓰레드로 동작하는 것이 아니라,
		// 단순히 run() 메소드만 실행이 되는 것임.
		
		// 이때 발생하는 호출스택 관계도는 '자바의 정석' p626 그림 참조.   p628,629 예제
		
		System.out.println("=======================");
		System.out.println("여기는 언제 출력될까요?");
		System.out.println("=======================");
		
		
		// 하나의 쓰레드는 start() 가 딱 한번만 호출될수 있다.
		// 만약 아래와 같이 다시 start() 하면 IllegalThreadStateException 발생
//		th1.start();  start는 딱 한번만 쓸수 있기때문에 하면 에러가 발생
		
		// 아래와 같이 새로 생성해서 사용하면 가능
		th1 = new MyThread("하위하위하위");
		th1.start();
	
	} // end main()

} // end class


// 1. Thread 클래스를 상속받는 클래스를 정의
class MyThread extends Thread{

	private String msg;
	private int count;
	
	public MyThread() {
	}
	public MyThread(String msg) {
		this.msg = msg;
		count = 0;
	}
	// 2. 정의한 클래스에서 run() 메소드를 override
	// 쓰레드에서 할 일을 구현
	@Override
	public void run() {               //==> thread 에 있는 run 을 오버라이드
		for(int i = 0 ; i<100; i++) {
			System.out.println(getName() + " " +count + " : " +msg);
			count++;
		}
	}
	
} // end class MyThread













