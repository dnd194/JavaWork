package com.lec.java.crawl00;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Crawk00Main {

	public static void main(String[] args) throws IOException {
		System.out.println("JSOUP");

		Element element;
		Elements elements;

		// hello.html 을 데려올거임
		File f = new File("data/hello.html"); // data/hello.html 은 상대경로 url 임
		Document doc = Jsoup.parse(f, "UTF-8"); // JSOUP를 이용하여 파싱, 첫번째 매개변수는 파싱할 객체, 2번째는 인코딩방법
		// jsoup.parse 파일 객체를 document 객체로 로 바꿔줌

//		System.out.println(doc.outerHtml());
		// 문서가 무엇을 가지고 있는지 보고싶을때는 문서를 담은 변수 . outerhtml() 해주면됨

//		element = doc.selectFirst("div");
////		System.out.println(element.outerHtml());
//		elements = doc.select("div"); // -> html 문서안에 div 태그들을 모두 뽑아냄
//		System.out.println(elements.size()); // size() 를 이용하여 몇개인지 알수 있음
//		element = elements.get(2); // --> 인덱스n 번째 요소를 return (element 객체)
////		System.out.println(element.outerHtml());  //2번째 요소가 담긴 element를 출력해줌

//		for (int i = 0; i < elements.size(); i++) {    //이 방법들로 전체 뽑아낼 수 있음
//			element = elements.get(i); 
//			System.out.println(element.outerHtml());
//		}

//		for(Element e : elements) {   
//			System.out.println(e.outerHtml());
//			System.out.println();
//		}
		element = doc.selectFirst("div#addr");
//		System.out.println(element.outerHtml());
		
		elements = element.select("ul.favorite a");
//		System.out.println(elements.size());
		
		for(Element e : elements) {
//			System.out.println(e.outerHtml());   //각 각 에 대한 element 를 출력  + 출력하고 확인하면 주석처리
			System.out.println(e.text().trim());   //문자열은 trim 해서 공백을 제거해주는게 좋음
			System.out.println(e.attr("href").trim());
		}										
		
		
		
		
		System.out.println("\n프로그램 종료");
	}

}
