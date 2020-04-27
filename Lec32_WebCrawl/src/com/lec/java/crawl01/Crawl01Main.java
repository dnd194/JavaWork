package com.lec.java.crawl01;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 
	외부 라이브러리를 사용한 자바 프로젝트
	
	1. 라이브러리 다운로드
	
	2. 프로젝트 내 (혹은 특정경로) 에 라이브러리 저장
	
	3. 프로젝트의 BuildPath 설정
	
*/

/*
* 		1. https://jsoup.org  core library 다운
* 
* 		2. 프로젝트에 libs 같은 폴더를 만들고  다운 받은 라이브러리를 복사.     (jar ==> java archive)
 * 
 * 		3. 프로젝트 우클릭 buildpath -> configure build path - library 탭 -> add jars + 다운받은 라이브러리 추가
 * 
 * 
 * 		혹시라도 jre가 깨지면 당황치말고 build path 들어가서 add library -> jre system library 추가해주면 됨
*/


// 네이버 뉴스 캐스트 (상단)

public class Crawl01Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 뉴스 캐스트");
		
		String url;  // 크롤링할 주소
		Response response;  //(jsoup) Response 객체 선언
		Document doc;       //(jsoup) Document 객체 선언  
		Element element;    //(jsoup) Element ==> HTML 의 요소를 의미
		
		url = "https://www.naver.com";
		response = Jsoup.connect(url).execute();    //원래는 try - catch 같은데   그냥 던졌음  throws ioexception
								// 편리하게 쓰라고 라이브러리 쓰는 거임    위에 한줄로 모두 해결
		//get 방식 request는 다음과 같이해도됨
		//Jsoup.connect(url).get();
		
		System.out.println(response.statusCode());   // ==> 200 이 나와야함    안나오면 안돼염
//		request 결과코드
//		200   =   성공
//		404 url 존재하지 않음
//		500 서버 내부                      500 대는 주로 서버의 문제
//		400 Bad Request : request 문법상의 오류
//		401 권한에러 : 권한 관현 적절한 header 정보가 없는 경우 많이 발생
//		402 권한에러 : 자원에 대한 접근 권한 에러
//		403  권한에러 Forbidden : 파일권한, 읽기권한, SSL, IP, 등...  <--- 웹 크롤링 하다가 은근히 자주 마주치게 되는 에러
		System.out.println(response.statusMessage());  // ==> 200이면 OK
		
		doc = response.parse();
		
		System.out.println(doc.title());  		//<title> element의 텍스트 
		System.out.println(doc.location());     // 현재 웹문서 url
		
		String outerHtml = doc.outerHtml();		// 현재 node 의 outer html 텍스트
//		System.out.println(outerHtml);
		System.out.println(outerHtml.toString().substring(0,200)+ "...");
		
		// Document 나 Element 객체의 
		// select() , selectFirst() 메소드로 특정 element(들)을 추출
		System.out.println("[네이버 뉴스 캐스트]");
		element = doc.selectFirst("#news_cast");    // -> 검색된 Element 들 중 최초 한개만 뽑아서'''' Element'''' 로 리턴 
//		System.out.println(element.outerHtml());
		Elements newsElements  = doc.select("#news_cast li.ca_item");    //id가 news_cast 인 자손 중에서 li 태그에 ca_item 이란 클래스를 가진 친구들을 찾는것
		//검색된 Element 들이 담겨 있는 ''''Elements'''' 들을 return
		//위의 과정은 전체에서 elements 를 끄집어 내는것
		
		// 복수 개  크롤링을 할 때, 내가 원하는 '개수' 만큼 크롤링 되었는지 우선 확인을 해봐야한다.
		
		
		System.out.println(newsElements.size());     //10개가 나와야함  페이지 소스로 확인을 직접해봐야함
		
		for(Element e : newsElements) {                   //뽑아낸 elements들 중에서 다시 element 를 뽑는것
//			System.out.println(e.outerHtml());
			element = e.selectFirst("a");
			System.out.println(element.text());    //element 의 text() 들을 묶어서 하나로 return
			
			System.out.println(element.attr("href"));
		}
		
		
		
		System.out.println("\n 프로그램 종료");
		
	}

}



























