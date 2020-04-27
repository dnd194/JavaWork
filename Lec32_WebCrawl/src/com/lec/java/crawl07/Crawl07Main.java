package com.lec.java.crawl07;

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
public class Crawl07Main {

	private static final String PATH = "books";    //썸네일을 저장할 경로 (상수)
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("인터파크  도서 검색결과 페이지");

		Scanner sc = new Scanner(System.in);
		System.out.print("검색어를 입력하세여 : ");
		String search = sc.nextLine();
		sc.close();
		
		Crawl07Main app = new Crawl07Main();     //아래의 arraylist 가 private 이기 때문에 이와같이 main 생성자를 만들어서 호출함
		ArrayList<InfoBook> list = app.crawlInterPark(search);
		
		//썸네일 이미지 다운로드 받아서 
		// thumb001.jpg ~ thumb200.jpg  ... 이런식으로
		
		int fileIndex = 1;
		for ( InfoBook e  :list) {
			System.out.println(e);    //크롤링 정보 출석
			
			
			//썸네일 이미지 다운로드
			String fileName = String.format(PATH + File.separator + "task%03d.jpg" , fileIndex);      //format을 사용 fileindex 번호로 task xxx 로 저장되게
			URL imgUrl = new URL(e.getImgUrl());
			BufferedImage imgData = ImageIO.read(imgUrl);
			File file = new File(fileName);
			ImageIO.write(imgData,"jpg", file);
			
			System.out.println(fileName+ " 이 저장됬습니당");
			fileIndex++;
		}
		
		
		System.out.println("\n 프로그램 종료");
	}
	private ArrayList<InfoBook> crawlInterPark(String search) throws IOException{    // 매개변수로  문자열타입을 받는 메서드 
		ArrayList<InfoBook> list = new ArrayList<InfoBook>();
		
		
		String url;
		Document doc;
		Element element;
		Response response;
		Elements elements;
		//TODO
		//http://book.interpark.com                    yes24 crawl05의 결과랑 똑같으면 됨. 과제임
		url = "http://bsearch.interpark.com/dsearch/book.jsp?sch=all&sc.shopNo=&"
				+ "bookblockname=s_main&booklinkname=s_main&bid1=search_auto&bid2=product&"
				+ "bid3=000&bid4=001&query="+URLEncoder.encode(search,"euc-kr");
		
		//url 한줄 처리  파이썬으로 검색시 6바이트가 나오므로 한글자당 2비트 --> euc-kr 인코딩
//		System.out.println(url);  //확인 작업 확인후 주석처리 
		
		doc = Jsoup.connect(url).execute().parse();
		
		elements = doc.select("#bookresult > form > div.list_wrap");
//		System.out.println(elements.size());  //20개가 나오는지 확인을 위한 출력
		
		for(Element e : elements) {
			String imgUrl = e.selectFirst("div.bookImg > div > div.bimgWrap > a > img").attr("src").trim();
			String bookTitle = e.selectFirst("div.info > p.tit > b > a").text().trim();
//			System.out.println(bookTitle);//출력 확인 후 주석
			String linkUrl = e.selectFirst("div.bookImg > div > div.bimgWrap > a").attr("href");
			double price = Double.parseDouble(e.selectFirst(" div.price > p.FnowCoupon > span").text().trim().replace(",", "")
					.substring(0, 5));
//			System.out.println(price + "원");  //확인 후 주석처리
			list.add(new InfoBook(bookTitle, price, linkUrl, imgUrl));
		}
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
