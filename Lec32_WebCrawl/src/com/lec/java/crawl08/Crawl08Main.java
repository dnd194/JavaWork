package com.lec.java.crawl08;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 *   		크롤링 검색 페이징
 *   			-첫페이지 url
 *   			두번째 페이지부터의 url 변화 확인 : 어떤 방식인지?? , 어떤 parameter인지??
 *   			검색결과 페이징의 '''마지막 페이지'''는 어떻게 처리하는 지 확인
 *			
 */

public class Crawl08Main {

	public static void main(String[] args) throws IOException {
		System.out.println("페이징 : pagination");

//		crawlDaumBlog("파이썬", 2);  //검색어와 페이지 확인용  확인되면 주석
		for(int i = 0 ; i < 10; i++) {
			crawlDaumBlog("파이썬", i);
		}
		
		
		System.out.println("\n프로그램 종료");
	}

	/**
	 * 
	 * @param search 검색어
	 * @param page   검색할 결과 page 번호
	 * @throws IOException 
	 */
	public static void crawlDaumBlog(String search, int page) throws IOException {
		//목록에서 크롤링할 사이트
		//post title
		//post ~~~~
		//blog title
		
		
		if(search == null || search.trim().length() == 0 || page<1) return;  //매개변수 검증 (검색이 안되는)  공백제거 해줄것
		
		String url;
		Document doc;
		Element element;
		Response response;
		Elements elements;
		
		
		url = String.format("https://search.daum.net/search?w=blog&DA=PGD&enc=utf8&q=%s&page=%d"
				, URLEncoder.encode(search,"utf-8"),page);
		
		System.out.println(page + " 페이지]");
		
		doc = Jsoup.connect(url).execute().parse();
		elements = doc.select("#blogColl .list_info li .wrap_cont");
		
//		System.out.println(elements.size()); 갯수가 맞게 나오는지 확인하고 주석
		for (Element e : elements) {
			String postTitle = e.selectFirst("a").text().trim();
//			String postUrl = e.selectFirst("a").attr("href");               //이렇게 해도 되고
			String postUrl = e.selectFirst("a.f_url").text().trim();		//저렇게 해도되고
			String blogTitle = e.selectFirst("a.f_nb").text().trim();
			
//			System.out.println(postTitle);// 확인하고 주석
			System.out.println(postTitle + " : " +blogTitle+ " : "+ postUrl );
			
		}
		
		
//		System.out.println(url);  //확인 후 주석
		//검색부분 과 페이지 부분을 %s 와 %d 로 바꿔줌  %s부분에는 문자를 encode 한 게 들어가고 page에는 매개변수 int page가 들어감
	}

}
