package com.mvn.javaproj2;

/**
 * Hello world!
 *
 */
public class App 
{
	public String getWelcome() {
		return "welcome";
	}
	
	public String getHello() {
		return "hello";
	}
	
	public String getBye() {
		return "bye";
	}
	
	
    public static void main( String[] args )
    {
        System.out.println( "안녕하세요 JUnit" );
        
        App app = new App();
        String welcome = app.getWelcome();
        String hello = app.getHello();
		String bye = app.getBye();
        
		// 위 메소드의 동작한 결과값을 검증하려면?
		if("Welcome".equals(welcome)) System.out.println(true);
		if("hello".equals(hello)) System.out.println(true);
		if("bye".equals(bye)) System.out.println(true);	
        
    }
}

































