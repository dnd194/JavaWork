package com.lec.java.thread03;

/* 쓰레드와 익명클래스
 */

// runnable 을 사용한 구구단

public class Thread03Main {

	public static void main(String[] args) {
		System.out.println("쓰레드와 익명 클래스");
		
		// 이미 정의된 MyRunnable 클래스의 인스턴스 사용
		 Runnable myRunnable = new MyRunnable();
		Thread th1 = new Thread(myRunnable);
		th1.start();    // => 2단이 돌아가는 thread
		 
		 
		 
		 
		 
		 
		// 익명 클래스를 사용해서 Runnable 인스턴스를 생성
		new Thread(new Runnable() {        //3 단이 돌아가는 thread
			
			@Override
			public void run() {
				for (int i = 1; i<10; i++) {
					System.out.println("3 x "+ i +" = "+(3*1));
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
			}
		}).start();
		
		for(int i = 0; i < 10; i++) {    //=> 메인에서 돌아가는 4단
			System.out.println("4 x "+ i +" = "+(4*1));
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	} // end main()

} // end class Thread03Main


class MyRunnable implements Runnable  {

	@Override
	public void run() {
		for( int i = 1; i < 10; i++) {
			System.out.println("2 x "+ i +" = "+(2*1));
			try {
				Thread.sleep(2000);      //Thread  try catch 필요
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	// TODO
	
} // end class MyRunnable

























