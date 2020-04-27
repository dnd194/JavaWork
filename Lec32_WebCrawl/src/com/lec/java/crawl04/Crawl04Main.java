package com.lec.java.crawl04;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.Connection.Response;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl04Main {

	public static void main(String[] args) throws IOException {
		System.out.println("네이버 연관 검색어");
		
		String url;
		Document doc;
		Response response;
		Elements elements;
		Element element;
		
		String searchKeyword;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세요 : ");
		searchKeyword = sc.nextLine();
		sc.close();
		
		String encoded = URLEncoder.encode(searchKeyword,"UTF-8");	//네이버 검색페이지는 UTF-8로 인코딩함(자바6바이트) //사이트가 무슨 인코딩을 쓰고있는지 확인을 해야함 한글이 3바이트인지 2바이트인지 확인
		url ="https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query="+encoded;  
		System.out.println(url);   //위의 작업이 잘 되었는지 확인을 위한 출력   
		
		doc = Jsoup.connect(url).execute().parse();  // ---> 중간에 response 코드는 확인을 안하는 구조
		
		elements = doc.select("ul._related_keyword_ul li");
//		System.out.println(elements.size()); //10개가 나오는지 확인을 위한 출력
		
		for(Element e : elements) {
			System.out.println(e.text().trim());
		}
		
		
		System.out.println("\n 프로그램 종료 ");
	}

}
