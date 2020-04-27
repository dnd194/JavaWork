package com.lec.java.crawl03;

import java.io.IOException;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawl03Main {

	public static void main(String[] args) throws IOException {
		System.out.println("다음 실시간 검색어");

		//TODO
		//http://www.daum.net
		//15개
		
		String url;
		Response response;
		Document doc;
		Element element;
		Elements elements;
		
		url = "https://www.daum.net/";   //url 다음
		response = Jsoup.connect(url).execute();   //그냥 exception 던짐
		System.out.println(response.statusCode());
		
		doc = response.parse();  
		elements = doc.select("div.slide_favorsch ul li a");  //여기에 ul3개  ul은 각각 5개씩 가지고 있음
		for(Element e : elements) {
			System.out.println(e.text().trim());
			System.out.println(e.attr("href").trim());
		}
		
		
		System.out.println("\n 프로그램 종료");
	}

}
