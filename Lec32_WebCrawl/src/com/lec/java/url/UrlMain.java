package com.lec.java.url;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlMain {
	/* URL (Uniform Resource Locator) 객체
	 *  java.net.URL 객체를 통해  인터넷 관련 리소스 접근.
	 *  
	 *  URL 객체의 메소드를 통해  URL을 분해해볼수 있다. 
	 *  
	 *  가령 : https://aaa.bbb.com:88/abc/def/zzz.ddd?name=uu&age=12 의 경우
	 * 	getProtocol(): https
	 *	getHost(): aaa.bbb.com
	 *	getPath(): /abc/def/zzz.ddd
	 *	getPort(): 88
	 *	getFile(): /abc/def/zzz.ddd?name=uu&age=12
	 *	getQuery(): name=uu&age=12
	 *
	 *  단, 파일 이름의 경우 따로 추출해야 하는 번거로움 있다.
	 *  
	 *  URI (Uniform Resource Identifier) 는 URL 의 상위 개념
	 */


	public static void main(String[] args) {
		System.out.println("URL 객체");

		String[] urls = new String[] {                //문자열 배열에 규격에 맞는 url 도 있고 맞지 않는 것도 있음
				"https://aaa.bbb.com:88/abc/def/zzz.ddd?name=uu&age=12",
				"http://www.example.com/some/path/to/a/file.xml?foo=bar#test",
				"hhh://asdf",
				"ftp://asdf",
				"http://",
				"aaa.bb.com"   // url에 에다가 집어넣으려면 앞에          ''''프로토콜''''         이 존재 해야한다
		};
		
		for(int i = 0 ; i<urls.length; i++) {
			System.out.println(urls[i]);
			URL url = null;         //null 로 초기값 설정
			try {
				url = new URL(urls[i]);               //url 은 문자열배열 urls 를 담는다.
			} catch (MalformedURLException e) {
				System.out.println("\t wrong address "+e.getMessage());    //==> hhh 라는 건 없음
				continue;
			}
			
			System.out.println("\tgetProtocol(): " + url.getProtocol());           
			System.out.println("\tgetHost(): " + url.getHost()); 
			System.out.println("\tgetPath(): " + url.getPath());
			System.out.println("\tgetPort(): " + url.getPort());
			System.out.println("\tgetFile(): " + url.getFile());
			System.out.println("\tgetQuery(): " + url.getQuery());	
			
			//파일 , 확장자명 
			if(url.getPath().length() > 0 ) {          //url의 path 가 0보다 길때만 동작하도록
				String filename = url.getPath().substring(url.getPath().lastIndexOf('/')+1);  // 마지막이 \ 로 끝난 index +1      
				String fileBaseName = filename.substring(0,filename.lastIndexOf('.'));     // 뽑아낸 filename 에서  인덱스[0] ~ . 으로 끝나는 곳 까지의 사이
				String fileExt = filename.substring(filename.lastIndexOf('.')+1); //  뽑아낸 filename 에서  . 으로 끝나는 것의 오른쪽
				
				System.out.println("\t 파일명 : "+filename);
				System.out.println("\t 파일base : "+fileBaseName);
				System.out.println("\t 파일확장자 명 : "+fileExt);
				
			}
			
		}
	}

}



























