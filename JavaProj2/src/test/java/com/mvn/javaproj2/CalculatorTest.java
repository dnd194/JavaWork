package com.mvn.javaproj2;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	// JUnit 은 멤버 필드 방식을 비추한다 --> 테스트 결과가 다른 테스트 결과에 영향을 줄수 있다.
	// 각각의 '테스트' 는 '독립적' 으로 실행되는 것을 보장하는 것을 원칙으로 한다.
	
	// 각 테스트 전/후 에 공통으로 수행해야 할 코드가 필요하다면
	// @Before, @After
	
	//private Calculator cal = new Calculator();  // 비추
	
	private Calculator cal;
	
	@Before  //테스트 매서드 실행전에 수행할 메서드
	public void setUp() {
		System.out.println("[테스트 전]");
		cal = new Calculator();
	}
	
	@After	//테스트 매서드 실행후에 수행할 메서드
	public void shutDown() {
		System.out.println("[테스트 후]");
	}
	
	
	
	@Test
	public void testAdd() {
		System.out.println("testAdd()");
		int result = cal.add(10, 20);
		assertEquals(30, result);
	}

	@Test
	public void testSub() {
		System.out.println("testSub()");
		int result = cal.sub(10, 20);
		assertEquals(-10, result);
	}
	@Test
	public void testMul() {
		System.out.println("testMul()");
		int result = cal.mul(10, 20);
		assertEquals(200, result);
	}
	@Test
	public void testDiv() {
		System.out.println("testDiv()");
		int result = cal.div(10, 20);
		assertEquals(0, result);
	}
	
	

}













