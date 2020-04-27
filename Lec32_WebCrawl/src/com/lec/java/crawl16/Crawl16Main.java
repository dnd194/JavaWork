package com.lec.java.crawl16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.5108593855466&lng=127.029258482886&order=rank&page=0&search=
public class Crawl16Main {

	public static void main(String[] args) throws IOException {
		System.out.println("요기요 맛집 정보 : header 추가");
		String url = "https://www.yogiyo.co.kr/api/v1/restaurants-geo/?items=20&lat=37.5108593855466&lng=127.029258482886&order=rank&page=0&search="; //헤더가 없는 url
		
		StringBuffer sb = readFromUrl(url);
//		System.out.println(sb);
		
		ObjectMapper mapper = new ObjectMapper();
		
		//TODO  valueType에 들어갈 친구 
		restaurants restaurants = mapper.readValue(sb.toString(), restaurants.class);
		for (restaurantStats e : restaurants.getRestaurants()) {
			System.out.printf("%5s : %.1f",e.getSlug(),e.getReview_avg());
			System.out.println();
		}
//		mapper.readValue(sb.toString(), valueType)
		//맛집 이름 과 평점
		
		
		System.out.println("\n 프로그램 종료");
	}// end main

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
			url = new URL(urlAddress); // 매개변수로 받은 urladdress를 객체에 넣어줌
			conn = (HttpURLConnection) url.openConnection(); // 형변환 해주는 것 기억
			// 해당 주소가 없을 경우를 대비 실패할 경우 null 을 return
			if (conn != null) { // conn 이 null 이 아닐때만 다음 단계 처리 해줘야함

				conn.setConnectTimeout(2000); // 2초 이내에 '연결' 이 되지않으면
												// java.net.socketTimeoutException이 발생

				// 서버에 담기전에 부가적인 정보를 더 담아야함
				conn.setRequestMethod("GET"); // GET 방식 request
				// "GET" , "POST" ...
				conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
				conn.setUseCaches(false); // 캐시 사용을 안하겠습니다.

				
				//헤더 정보 추가
				conn.setRequestProperty("X-Apikey", "iphoneap");     //대소문자 상관 안함
				conn.setRequestProperty("x-apisecret", "fe5183cc3dea12bd0ce299cf110a75a2");
		
				
				
				System.out.println("request 시작 : " + urlAddress);
				conn.connect(); // request 발생 ---> 이후 response 받을 때까지 delay(delay에는 여러가지가 있음)
				// 서버가 폭주하다 == request가 폭주한다.
				System.out.println("response 완료");

				int responseCode = conn.getResponseCode();
				System.out.println("response code : " + responseCode); // 200이 나와야 정상임 나머지는 아님 , 에러상황

				// https://developer.mozilla.org/ko/docs/Web/HTTP/Status 에러 코드 참조

				if (responseCode == HttpURLConnection.HTTP_OK) { // 200일때만 정상이므로 다음단계를 처리 HttpURLConnection.HTTP_OK==200
																	// 으로 상수화 되어있음

					// bufferedreader <- inputstreamReader <- inputstream <- Httpurlconnection 이런 개념
					// 해체쇼 할거임

					in = conn.getInputStream(); // inputstream <- Httpurlconnection
					reader = new InputStreamReader(in, "UTF-8"); // inputstreamReader <- inputstream
					br = new BufferedReader(reader); // bufferedreader <- inputstreamReader
					// 한꺼번에 해도 되지만 순차적으로 하는게 좋을듯
					int cnt; // 읽은 글자의 개수
					while ((cnt = br.read(buf)) != -1) {
						sb.append(buf, 0, cnt); // 더이상 읽어 들일 수 없는 동안 response 받은 텍스트 들을 Stringbuffer sb에 추가(append)
					}

				} else {
					System.out.println("response 실패");
					return null;
				}

			} else {
				System.out.println("conn null"); // 커넥션이 안잡힌것 커넥션 == conn
				return null;
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (conn != null)
				conn.disconnect(); // conn 도 자원이지만 close() 가 아닌 disconnect()로 해제함
		}

		return sb;
	}// end readFromUrl

}
@JsonIgnoreProperties (ignoreUnknown = true) 
class restaurants{
	public List<restaurantStats> restaurants;

	public List<restaurantStats> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<restaurantStats> restaurants) {
		this.restaurants = restaurants;
	}
	
}
@JsonIgnoreProperties (ignoreUnknown = true) 
class restaurantStats{
	
	private String slug;
	private double review_avg;
	
	
	
	public restaurantStats() {
		super();
	}

	public restaurantStats(String slug, int review_avg) {
		super();
		this.slug = slug;
		this.review_avg = review_avg;
	}

	public String getSlug() {
		return slug;
	}

	public void setSlug(String slug) {
		this.slug = slug;
	}

	public double getReview_avg() {
		return review_avg;
	}

	public void setReview_avg(double review_avg) {
		this.review_avg = review_avg;
	}
	
	
}




























