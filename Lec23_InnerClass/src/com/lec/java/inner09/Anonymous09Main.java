package com.lec.java.inner09;

/*
 * 리스너 (Listener)
 *   이벤트 중심의 프로그래밍 (웹, 앱, GUI 환경 등..) 에선
 *   특정 '객체' 에  특정 '이벤트' 가 발생하면 어떠한 '동작'을 수행하도록 프로그래밍 한다.
 *   
 *   함수형 프로그래밍이 아닌 자바에서는
 *   리스너는 내부클래스(익명클래스)로 제공합니다.
 *   
 */
public class Anonymous09Main {
	public static void main(String[] args) {
		System.out.println("익명 클래스 응용 : Listener");
		
		Button btnOk = new Button("OK");
		btnOk.actionClick();
		
		//리스너 장착
		btnOk.setOnClickListener(new Button.OnClickListener() {
			
			@Override
			public void onClick() {
				System.out.println("딸깍딸깍");
				
			}
		});
		
		btnOk.actionClick();
		
		
		btnOk.actionDblClick();
		
		//리스너 장착
		btnOk.setOnDblClickListener(new Button.OnDblClickListener() {
			
			@Override
			public void onDblClick() {
				// TODO Auto-generated method stub
				System.out.println("딸깍딸각");
				System.out.println("딸깍딸각");
				System.out.println("딸깍딸각");
			}
		});
		
		btnOk.actionDblClick();
		
		System.out.println("\n 프로그램 종료");
	} // end main()
	
} //end class

// TODO










