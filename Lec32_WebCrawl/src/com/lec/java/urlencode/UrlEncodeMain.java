package com.lec.java.urlencode;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlEncodeMain {

	/*  URLEncoder, URLDecoder
	 * 
	 * URL 은  한글, 특수기호, 공백등의 문자를 담을수 없다.
	 * 따라서 위와 같은 문자를 URL에 담으려면 ''''''''''  URL 인코딩   '''''''''''' 을 하여야 한다.
	 *  
	 * O : https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%ED%8C%8C%EC%9D%B4%EC%8D%AC
	 * X : https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=파이썬
	 * 
	 * 인코딩-디코딩 온라인 테스트 사이트
	 * 	http://coderstoolbox.net/string/#!encoding=xml&action=encode&charset=us_ascii
	 * 
	 */
	
	public static void main(String[] args) {
		System.out.println("URLEncoder, URLDecoder");

		String str = "파이썬";
		
		// 한글관련 자주 사용되는 인코딩
		String charset[] = {                                         // 한글로 인코딩씨   euc-kr     +     utf-8    만 알면 됩니다!!~~~  
			"euc-kr", "ksc5601", "cp949", "ms949", // 한글 표현 -> ''2byte ''
			"iso-8859-1", "8859_1", "ascii",   // 한글 불가
			"UTF-8",   // 한글표현 -> ''3byte''
		};

		for(int i = 0 ; i<charset.length; i++) {
			try {
				System.out.printf("%11s → %s \n", charset[i], URLEncoder.encode(str, charset[i]));			//==> 1번째 매개변수 -- 인코딩할 문자   2번째 매개변수 -- 인코딩할 방법
				
//				URLEncoder.encode(str, charset[i]);   //==> 1번째 매개변수 -- 인코딩할 문자   2번째 매개변수 -- 인코딩할 방법
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
			}          
		}
		
		System.out.println();
		String enc_utf8 = "%ED%8C%8C%EC%9D%B4%EC%8D%AC";
		
		try {
			System.out.printf("%s", URLDecoder.decode(enc_utf8,"UTF-8"));
			System.out.println();
			System.out.printf("%s", URLDecoder.decode(enc_utf8,"euc-kr"));
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

















