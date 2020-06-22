package com.lec.spring.aop03;

import com.lec.beans.ServiceEx;

public class MyServiceEx32 extends ServiceEx {

	@Override
	public void doWorking() {printInfo();}

	@Override
	public void quitAction() {printInfo();}

	@Override
	public void doAction() {printInfo();}

}
