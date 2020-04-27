package com.lec.java.crawl17;
/*
 * Selenium 라이브러리 다운로드 (Java 버젼으로!)
 * 	https://www.seleniumhq.org/download/
 * 
 *  BuildPath 추가
 *  
 * 브라우저 드라이버 다운로드 
 *  http://chromedriver.chromium.org/downloads
 *  
 *  
 */

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Crawl17Main {
	// WebDriver
	private WebDriver driver;    
	private WebElement element;
	private String url;
	private static final String WEB_DRIVER_ID="webdriver.chrome.driver";
//	private static final String WEB_DRIBER_PATH="D:/JavaApp1/download/chromedriver.exe";  //학원용
	
	private static final String WEB_DRIBER_PATH="C:\\JavaApp1\\download\\chromedriver.exe";
	//이거 노트북 경로로 알아서 바꿔줘야함 
	
	
	public static void main(String[] args) {
		System.out.println("selenium 사용");
		
		Crawl17Main app = new Crawl17Main();
		app.init();  //초기화
//		app.naverLogin();
		
//		app.likeFaceBook();  //지금은 로그인밖에 안됌
		
		app.naverRelated("자바");
		System.out.println("\n프로그램 종료");
	}//end main
	
	public void init() {
		
		System.setProperty(WEB_DRIVER_ID,WEB_DRIBER_PATH);    //경로 셋팅
		
		//Driver setup
		ChromeOptions options = new ChromeOptions();
		options.setCapability("ignoreProtectedModeSettings", true);
		driver = new ChromeDriver(options);  // 제어되는 브라우저 가동 
		
		//driver 를 통해서 브라우저 제어
		
	}

	public void naverLogin() {
		String url="https://nid.naver.com/nidlogin.login";
		driver.get(url);  //url 주소로 이동
		
		//아이디 입력
		element = driver.findElement(By.id("id"));
		element.sendKeys("dnd194");     //sendKey 는 입력 을 하는 메서드
		
		//패스워드 입력
		element = driver.findElement(By.id("pw"));
		element.sendKeys("1q2w3e4r5t**"); 
		
		// 로그인 버튼  클릭
		element = driver.findElement(By.className("btn_global"));
		element.click();
		
		
	}
	//Facebook 좋아요 클릭
	public void likeFaceBook() {
		String url = "https://www.facebook.com/";
		driver.get(url);
		
		element = driver.findElement(By.id("email"));
		element.sendKeys("01047157676");
		driver.findElement(By.id("pass")).sendKeys("k74231");
		element = driver.findElement(By.id("loginbutton"));
		element.click();
		
		try {
			Thread.sleep(3000);
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void naverRelated(String keyword) {
		driver.get("https://www.naver.com");
		driver.findElement(By.id("query")).sendKeys(keyword);
		driver.findElement(By.id("query")).sendKeys(Keys.ENTER);
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		}           
		
		
		List<WebElement> list = driver.findElements(By.cssSelector("ul._related_keyword_ul li"));
		System.out.println(list.size());
		for(WebElement e : list) {
			System.out.println(e.findElement(By.tagName("a")).getText().trim());
		}
	}
}







































