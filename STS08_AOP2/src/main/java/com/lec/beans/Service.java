package com.lec.beans;

public abstract class Service {
	public abstract void doAction();   // 추상메소드
	
	// 테스트용 : 메소드 호출정보 출력
	public void printInfo() {
		String className = this.getClass().getSimpleName();
		StackTraceElement[] stackTrace = new Throwable().getStackTrace();
		String methodName = stackTrace[1].getMethodName();
		System.out.println(className + " 의 " + methodName + "() 호출");
	}
	
}
