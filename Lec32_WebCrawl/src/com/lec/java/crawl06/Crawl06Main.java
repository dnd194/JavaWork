package com.lec.java.crawl06;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;

import javax.imageio.ImageIO;

/* 웹에서 이미지와 같은 바이너리 형태 리소스 다운로드 받기
 * 
 * 방법1 : URL의 openStream() → InputStream 
 * 방법2 : HttpURLConnection의 getInputStream() → InputStream
 * 방법3 : ImageIO 객체 사용 : 이미지객체
 * 
 *  <프로젝트에 download 폴더 만들고 진행하세요> 
 * 
 * 예제에 사용한 미디어 출처
 *  https://www.w3schools.com/html/html5_video.asp
 *  https://www.w3schools.com/html/html5_audio.asp
 *  https://www.w3schools.com/howto/howto_css_fullscreen_video.asp
 *  
 * 예제에 사용한 이미지 출처
 * 	https://www.w3schools.com/css/css_image_gallery.asp
 * 
 * 예제에 사용한 데이터 출처
 *   공공데이터 포털 - 파일데이터
 *   https://www.data.go.kr/search/index.do?index=DATA&query=&currentPage=1&countPerPage=10&sortType=VIEW_COUNT
 */

public class Crawl06Main {

	public static final String FILEPATH = "download"; // 경로명 상수 변수

	public static void main(String[] args) throws IOException {
		System.out.println("리소스 다운로드");

		Crawl06Main app = new Crawl06Main();

		String[] movUrls = { "https://www.w3schools.com/html/movie.mp4", // 영상
				"https://www.w3schools.com/howto/rain.mp4", "https://www.w3schools.com/html/mov_bbb.mp4",
				"https://www.w3schools.com/html/horse.ogg" // 음성

		};

		// 데이터. URL 에 파일명이 없는 형태 ==> response 안에 담겨져 있는 진짜 이름을 뽑아 낼 거임
		String[] dataUrls = {
				"https://www.data.go.kr/dataset/fileDownload.do?atchFileId=FILE_000000001524257&fileDetailSn=1&publicDataDetailPk=uddi:af2e59b7-9f3a-4624-94ae-9ac9d785b62b", // https://www.data.go.kr/dataset/15007122/fileData.do
																																												// 건강검진정보
				"https://www.data.go.kr/dataset/fileDownload.do?atchFileId=FILE_000000001562989&fileDetailSn=1&publicDataDetailPk=uddi:e9317e2f-fb83-43c8-914e-85ac6cca6736_201909101530", // https://www.data.go.kr/dataset/3038489/fileData.do
																																															// 교통사고통계
				"https://www.data.go.kr/dataset/fileDownload.do?atchFileId=FILE_000000001585803&fileDetailSn=1&publicDataDetailPk=uddi:7a68a482-4e3f-4cf8-851a-d4857fa2bff7" // https://www.data.go.kr/dataset/3041272/fileData.do
																																												// 전국산업단지현황통계
		};

		// 이미지, jpg
		String[] imgUrls = { "https://www.w3schools.com/css/img_5terre.jpg",
				"https://www.w3schools.com/css/img_forest.jpg", "https://www.w3schools.com/css/img_lights.jpg",
				"https://www.w3schools.com/css/img_mountains.jpg" };

		System.out.println();                    
//		for (int i = 0; i < movUrls.length; i++) {
//			app.download1(movUrls[i]);                        //==> 1번째 방법
//		}

//		for (int i = 0; i < dataUrls.length; i++) {
//			app.download2(dataUrls[i]);                        //==> 2번째 방법
//		}
		
		System.out.println();
		for (int i = 0; i < imgUrls.length; i++) {
			app.download3(imgUrls[i]);                        //==> 3번째 방법
		}
		
		
		System.out.println("\n프로그램 종료");
	}

	// 방법1
	// URL 의 openStream()
	// 단순히 byte 스트림으로만 입력 가능
	// **** 파일 이름, 타입등 의 정보 *****는 알수 없다.
	public void download1(String srcUrl) throws IOException {

		// 첫번째 방법
		URL url = null;
		InputStream in = null;
		OutputStream out = null;
		BufferedOutputStream bout = null;
		BufferedInputStream bin = null;
		String dstFile = null; // 저장할 파일 이름

		url = new URL(srcUrl);
		in = url.openStream(); // 웹서버에 빨대 꽂음      URL -> inputStream  하는 과정
		dstFile = fileNameFromURL(url);

		out = new FileOutputStream(FILEPATH + File.separator + dstFile); // 저장할 파일 경로
		bin = new BufferedInputStream(in);
		bout = new BufferedOutputStream(out);

		while (true) {
			int data = bin.read();
			if (data == -1) { // 더이상 읽어드릴 data가 없을 때 break;
				break;
			}
			bout.write(data);
		}
		bin.close();
		bout.close();
		System.out.println("다운로드 성공 : " + srcUrl + " >>> " + dstFile);

	}

	// 방법2
	// HttpURLConnection 객체 사용
	// HttpURLConnection 의 getInputStream()
	// ***    장점: 파일사이즈, 타입, 이름 등을 미리 알수 있다.  ***  ==> 버퍼를 파일사이즈에 맞게 만들수가있다.
	public void download2(String srcUrl) throws IOException {

		URL url = null;
		HttpURLConnection conn = null;
		InputStream in = null;
		BufferedInputStream bin = null;
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		String dstFile = null;
		
		url = new URL(srcUrl);
		conn = (HttpURLConnection) url.openConnection();
		int contentLength = conn.getContentLength();		//다운 받을 파일크기를 알아낼 수 있음.  그래서 미리 버퍼를 정확히 만들 수가 있음
		String contentType = conn.getContentType();  		//파일 종류 MIME-TYPE 확인가능
		
		
		
		//다운로드 받는 파일 이름 확인 가능
		String raw = conn.getHeaderField("Content-Disposition");         //content disposition 값을 뽑아낼 수 있음
//		System.out.println(raw);
		
		if(raw != null && raw.indexOf("=") != -1) {
			String fileName = raw.split("=")[1].trim();
			dstFile = URLDecoder.decode(fileName, "utf-8");
			System.out.println(dstFile);
		}
		in = conn.getInputStream(); // inputstream  <- http Url connection
		bin = new BufferedInputStream(in);
		out = new FileOutputStream(FILEPATH + File.separator + dstFile);
		bout = new BufferedOutputStream(out);
		
		byte[] buf = new byte[contentLength];           //contentLength 를 이용하여 custom 버퍼 생성
		int byteImg;
		while((byteImg = bin.read(buf)) !=-1) {
			bout.write(buf , 0 , byteImg);
		}
		
		bout.close();
		bin.close();
		
		System.out.println("다운로드: " + srcUrl + "\n\t → " + dstFile);
		System.out.println("\t"+ contentLength + " bytes \t"  +contentType );
		//application / octect 모든 종류의 이진 데이터를 나타냅니다
		// google에 mime type 검색  (mdn)
	}

	// 방법3
	// ImageIO 객체 사용
	public void download3(String srcUrl) throws IOException {
		
		String dstFile = null;
		URL url = new URL(srcUrl);
		dstFile = fileNameFromURL(url);
		
		BufferedImage imgData = ImageIO.read(url);   // 특정 url 로 부터 읽어드림              ***  이미지 일때만 동작함
		File file = new File(FILEPATH + File.separator + dstFile);
		ImageIO.write(imgData, "jpg", file);
		System.out.println("다운로드 : "+ srcUrl + " >>> "+dstFile);
		System.out.println("\t "+imgData.getWidth()+ "\t"+imgData.getHeight());

	}
	
	
	
	// url에서 파일명 추출 하는 메서드
	public String fileNameFromURL(URL url) {
		return url.getPath().substring(url.getPath().lastIndexOf('/') + 1); // urlMain 파일에 설명되어있음
	}
	
	
	
}
