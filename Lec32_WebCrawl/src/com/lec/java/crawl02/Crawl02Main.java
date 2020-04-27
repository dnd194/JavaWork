package com.lec.java.crawl02;

import org.jsoup.Jsoup;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.sun.corba.se.spi.activation.Repository;

public class Crawl02Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이트 인기 검색어");

		//TODO
		//네이트 주소
		//5개 
		String url;
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		url = "https://www.nate.com/";   //url 네이트
		response = Jsoup.connect(url).execute();   //그냥 exception 던짐
		System.out.println(response.statusCode()); 
		
		doc = response.parse();  
		// 문서객체가 서버의 response 를 파싱해서 담음
//		System.out.println(doc.outerHtml()); //==> 파싱됬는지 확인을 위한 출력 확인되면 주석처리
//		element = doc.selectFirst("div.search_keyword");   //클래스가 search_keyword 인 element 뽑음
		elements = doc.select("div.search_keyword>dl>dd>a");  //5개 임 
//		System.out.println(elements.size());   //5개인 것을 확인 해야함  확인하면 주석처리
		
		for(Element e : elements) {
			
			System.out.println(e.text().trim());
			//주소는 attr 이용해서 뽑아 낼 수 있음
			System.out.println(e.attr("href").trim());
		}
		
		
		
		System.out.println("\n 프로그램 종료");
	}

}
