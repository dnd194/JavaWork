package com.lec.java.file17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

/* HTML 데이터, 웹데이터 (텍스트)
 * Java 에서 웹 연결을 위한 객체 두가지
 * 	1. URL : 웹 상의 주소, 
 * 	2. HttpURLConnection : 웹연결
 * 		URLConnection
 * 		 └─ HttpURLConnection
 * 
 * 	java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
 * 		├─ java.io.InputStreamReader    // 스트림 기반의 reader
 * 		└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class File17Main {

	public static void main(String[] args) {
		System.out.println("웹데이터 가져오기(텍스트)");

		String url =  "https://www.naver.com/srchrank?frm=main&ag=all&gr=1&ma=-2&si=0&en=0&sp=0"; // 풀네임 해줘야함   www.daum.net
		StringBuffer sb = readFromUrl(url);
//		System.out.println(sb.toString().substring(0,200));
		System.out.println(sb);
		System.out.println("\n프로그램 종료");
	} // end main()

	/**
	 * 
	 * @param urlAddress : 주어진 url주소
	 * @return 서버로부터 받은 텍스트데이터 (HTML) 리턴
	 */
	public static StringBuffer readFromUrl(String urlAddress) {

		StringBuffer sb = new StringBuffer(); // response 받은 데이퍼 담을 객체
		// stringbuffer 는 mutable(변경가능)
		URL url = null; // java.net.Url 다른거 import 하면 오류납니다!@@@
		HttpURLConnection conn = null; // java.net.http

		InputStream in = null; // 애는 byte 임
		InputStreamReader reader = null; // byte 스트림을 문자 기반 Reader reader는 문자
		BufferedReader br = null; // 버퍼리더 장착

		char[] buf = new char[512]; // 문자용 버퍼

		// bufferedreader <- inputstreamReader <- inputstream <- Httpurlconnection 이런 개념

		try {
			url = new URL(urlAddress);     // 매개변수로 받은 urladdress를 객체에 넣어줌
			conn = (HttpURLConnection) url.openConnection();    //형변환 해주는 것 기억
			//해당 주소가 없을 경우를 대비      실패할 경우 null 을 return
			if(conn!=null) {			// conn 이 null 이 아닐때만 다음 단계 처리 해줘야함
				
				conn.setConnectTimeout(2000);     // 2초 이내에  '연결' 이 되지않으면  
												  //java.net.socketTimeoutException이 발생
				
				//서버에 담기전에 부가적인 정보를 더 담아야함
				conn.setRequestMethod("GET");     //GET 방식 request  
				//"GET" , "POST" ...
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false);   		//캐시 사용을 안하겠습니다.  
				
				System.out.println("request 시작 : " + urlAddress);
				conn.connect();     		//request 발생 ---> 이후 response 받을 때까지 delay(delay에는 여러가지가 있음)
				// 서버가 폭주하다 == request가 폭주한다.
				System.out.println("response 완료");
				
				int responseCode = conn.getResponseCode();
				System.out.println("response code : "+ responseCode);    //200이 나와야 정상임     나머지는 아님 , 에러상황
				
				//https://developer.mozilla.org/ko/docs/Web/HTTP/Status 에러 코드 참조 
				
				if(responseCode == HttpURLConnection.HTTP_OK) {   //200일때만 정상이므로 다음단계를 처리    HttpURLConnection.HTTP_OK==200 으로 상수화 되어있음
					
					// bufferedreader <- inputstreamReader <- inputstream <- Httpurlconnection 이런 개념   해체쇼 할거임
					
					in = conn.getInputStream();          		  //  inputstream <- Httpurlconnection
					reader = new InputStreamReader(in,"UTF-8");   // inputstreamReader <- inputstream
					br = new BufferedReader(reader);              // bufferedreader <- inputstreamReader
					//한꺼번에 해도 되지만 순차적으로 하는게 좋을듯  
					int cnt; //읽은 글자의 개수
					while((cnt = br.read(buf) ) != -1){
						sb.append(buf,0,cnt);      // 더이상 읽어 들일 수 없는 동안   response 받은 텍스트 들을 Stringbuffer sb에 추가(append) 
					}
					
					
				}else {
					System.out.println("response 실패");
					return null;
				}
				
			}else {
				System.out.println("conn null");   // 커넥션이 안잡힌것   커넥션 == conn
				return null;
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			if(conn!=null) conn.disconnect();    // conn 도 자원이지만 close() 가 아닌 disconnect()로 해제함
		}

		return sb;
	}

} // end class






















