package com.lec.java.crawl05;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;

import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/*
 *  1. 검색어 입력 받아서
 *  첫 페이지의 '국내도서' 첫 페이지 20 개 아이템
 *  		책 이름   / 책 가격  / 상세 페이지  / 썸네일 url
 *  		
 *  
 *  yes.24 는 euc-kr 로 인코딩 되어있음   ex) 파이썬- 6바이트  euc-kr 는 한글자당 2바이트
 *  
 *  
 */
public class Crawl05Main {

	private static final String PATH = "books";    //썸네일을 저장할 경로 (상수)
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("yes24.com 검색결과 페이지");

		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세여");
		String search = sc.nextLine();
		sc.close();
		
		Crawl05Main app = new Crawl05Main();     //아래의 arraylist 가 private 이기 때문에 이와같이 main 생성자를 만들어서 호출함
		ArrayList<InfoBook> list = app.crawlYes24(search);
		
		//썸네일 이미지 다운로드 받아서 
		// thumb001.jpg ~ thumb200.jpg  ... 이런식으로
		
		int fileIndex = 1;
		for ( InfoBook e  :list) {
			System.out.println(e);    //크롤링 정보 출석
			
			
			//썸네일 이미지 다운로드
			String fileName = String.format(PATH + File.separator + "thumb%03d.jpg" , fileIndex);      //format을 사용 fileindex 번호로 thumb xxx 로 저장되게
			URL imgUrl = new URL(e.getImgUrl());
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData,"jpg", file);
			
			System.out.println(fileName+ " 이 저장됬습니당");
			fileIndex++;
		}
		
		
		System.out.println("\n 프로그램 종료");
	}
	private ArrayList<InfoBook> crawlYes24(String search) throws IOException{    // 매개변수로  문자열타입을 받는 메서드 
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		//TODO
		// #schMid_wrap > div:nth-child(3) > div.goodsList.goodsList_list   
		
		String url;
		Document doc;
		Elements elements;
		Element element;
		Response response;
		//http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&domain=ALL&qdomain=%C0%FC%C3%BC&Wcode=001_005&query=%C6%C4%C0%CC%BD%E3
		
		url = "http://www.yes24.com/searchcorner/Search?keywordAd=&keyword=&domain=ALL&qdomain=%C0%FC%C3%BC&Wcode=001_005&query="+URLEncoder.encode(search,"euc-kr");
		//urlencoder를 따로 변수에 담지 않고 한방에 처리해준 케이스
		System.out.println(url);  //출력된 url 확인작업 필요
		
		doc = Jsoup.connect(url).execute().parse();    
		
//		elements = doc.select("#schMid_wrap > div:nth-child(3) > div.goodsList.goodsList_list > table > tbody > tr:nth-child(1) > td.goods_infogrp > p.goods_name.goods_icon > a >strong");
		elements = doc.select("#schMid_wrap > div.goods_list_wrap.mgt30").get(0).select("tr:nth-child(odd)");
		System.out.println(elements.size());
		for(Element e : elements) {
			String imgUrl = e.selectFirst("td.goods_img > a > img ").attr("src").trim();
			
			Element infoElement  = e.selectFirst("td.goods_infogrp > p.goods_name > a");
			double price= Double.parseDouble(e.selectFirst("td.goods_infogrp > div.goods_price > em.yes_b").text().trim().replace(",", ""));  //문자열을 double로 변환
			
			String bookTitle = infoElement.text().trim();
			String linkUrl = "http://www.yes24.com"+infoElement.attr("href").trim();
//			System.out.println(bookTitle + " : "+ linkUrl);  //확인용
//			System.out.println(price + "원");				 //확인용
			//위의 매개변수를 받는 생성자를 list 에 담음   list 는 add 이용
			
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
			
		}
		
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
