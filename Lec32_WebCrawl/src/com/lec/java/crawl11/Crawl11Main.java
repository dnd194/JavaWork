package com.lec.java.crawl11;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/*/
 *  xml , json 파싱 연습
 *  
 *  ■서울시 지하철 역사 정보
http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12753&srvType=A&serviceKind=1&currentPageNo=1

샘플url

XML 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/xml/stationInfo/1/5/서울

JSON 버젼
http://swopenAPI.seoul.go.kr/api/subway/4d46796d7366726f3833774a774955/json/stationInfo/1/5/서울

 */
public class Crawl11Main {

	// api의 사용방법을 알아야함 홈페이지 에 나와있음
	// http://data.seoul.go.kr/dataList/OA-12914/A/1/datasetView.do;jsessionid=97BA047CFC2D7EDF79590BD1AF979404.new_portal-svr-21
	public static final String REQ_SECVICE = "stationInfo"; // 서비스명 //TODO
	public static final String API_KEY = "616a757750646e643736526f415644"; // 내 api 값

	public static void main(String[] args) throws IOException {
		System.out.println("서울시 지하철 역사 정보");

		String statnNm; // 지하철역명
		int endIndex; // 정수 입력 (페이징 끝번호 입니다 : 데이터 행 끝번호)
		int startIndex; // 정수 입력 (페이징 시작번호 입니다 : 데이터 행 시작번호)
		startIndex = 1;
		endIndex = 4;
		statnNm = "서울";
		String url_address = "";
		StringBuffer sb;

		// TODO api url 에 필요한 parameter 들

		System.out.println("---- XML 파싱 ----");
		// TODO
		url_address = buildUrlAddress("xml", startIndex, endIndex, statnNm); // 매개변수 '''''순서''''' 조심
//		System.out.println(url_address); //확인용 하고 주석처리
		sb = readFromUrl(url_address);
//		System.out.println(sb);
		parseXML(sb.toString());

		// --------------------------------------------------------------------------------------------------
		System.out.println();
		// --------------------------------------------------------------------------------------------------

		System.out.println("---- JSON 파싱 ----");
		// TODO
		url_address = buildUrlAddress("json",startIndex, endIndex ,statnNm);   //매개변수 순서 조심				 
//		System.out.println(url_address);확인용
		sb = readFromUrl(url_address);
		parseJson(sb.toString());
//		System.out.println(sb);

		System.out.println("\n프로그램 종료");
	}// end main

	public static String buildUrlAddress(String reqType, int startIndex, int endIndex, String statnNm)
			throws IOException { // TODO

		String url_address = String.format("http://swopenapi.seoul.go.kr/api/subway/%s/%s/%s/%d/%d/%s", API_KEY,
				reqType, REQ_SECVICE, startIndex, endIndex, URLEncoder.encode(statnNm, "utf-8")); // TODO

		return url_address;
	}

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

	public static void parseXML(String xmlText) {
		// TODO
		// ''''XML''' 파싱 위에 import 보면 '''''xml'''' 이라 되어있음
		DocumentBuilderFactory dbFactory; // DocumentBuilderFactory 를 경유해야 DocumentBuilder 를 만들 수 있다.
		DocumentBuilder dBuilder;

		// DOM parser
		try {
			dbFactory = DocumentBuilderFactory.newInstance(); // 기본생성자가 따로 없다
			dBuilder = dbFactory.newDocumentBuilder();

			// String -> InputStream 변환
			InputStream in = new ByteArrayInputStream(xmlText.getBytes("utf-8"));

			// InputStream -> DOM객체 생성
			Document dom = dBuilder.parse(in); // 여기 Document 는 jsoup 가 아니라 ''''''org.w3c''''''''' 임

			// DOM 최상위 document element 추출 뽑아낼때 최상위 객체를 뽑아야함
			Element docElement = dom.getDocumentElement(); // DOM 의 최상위 element ==> Document (root)를 뽑아냄

			// 파싱하기 전 normalize
			docElement.normalize(); // 흩어진 text node 들을 정렬하는 등의 절차
									// xml 파싱하기 전에 꼭 normalize() 해줘야 한다.
			// DOM 내의 데이터 파싱

			NodeList nList = docElement.getElementsByTagName("row"); // 특정태그들을 가진 요소들을 '''''태그이름'''''으로 뽑아냄 " row "
			System.out.println("<row> 의 개수 : " + nList.getLength());

			System.out.println();
			for (int i = 0; i < nList.getLength(); i++) {
				Node node = nList.item(i);

//						System.out.println("node type : "+node.getNodeType());   1 = element   == Element_node 로 상수화 되어있음

				if (node.getNodeType() != Node.ELEMENT_NODE) { // 1이 아닐 경우 제낀다.
					continue;
				}
				Element rowElement = (Element) node; // 노드를 element 타입으로 캐스팅 node 가 부모 ----- Element 가 자식

				String rowNum = rowElement.getElementsByTagName("rowNum").item(0).getChildNodes().item(0).getNodeValue()
						.trim();
				// 태그가 rowNum 인 것 중의 첫번째 를 뽑는 것 거기서 자식 노드에서 getNodeValue 를 사용하여 text를 뽑아내는 코드
				
				String statnNm = rowElement.getElementsByTagName("statnNm").item(0).getChildNodes().item(0)
						.getNodeValue().trim();

				String subwayId = rowElement.getElementsByTagName("subwayId").item(0).getChildNodes().item(0)
						.getNodeValue().trim();

				String subwayNm = rowElement.getElementsByTagName("subwayNm").item(0).getChildNodes().item(0)
						.getNodeValue().trim();
//						System.out.println(LINE_NUM);//확인을 위한 출력
//						System.out.println(LINE_NUM + " : " + SUB_STA_NM+" : "+RIDE_PASGR_NUM+ " : "+ALIGHT_PASGR_NUM);

				System.out.printf("%5s : %8s역 [ID:%6s 호선:%6s]\n", rowNum, statnNm, subwayId, subwayNm);

			}

		} catch (ParserConfigurationException e) {

			e.printStackTrace();
		} catch (UnsupportedEncodingException e) { // 인코딩이 틀렸을 경우

			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}// end parseXML

	// -----------------------------------------------------------------------------------------------
	// org.json 라이브러리 다운로드
	// https://mvnrepository.com/artifact/org.json/json
	// 최신버젼 클릭후, Files 항목 클릭해서 다운로드

	public static void parseJson(String jsonText) {
		JSONObject jObj = new JSONObject(jsonText); // 곧바로 String --->>> JsonObject 형태로 파싱된다
		// response 받은게 object 이기 때문

		JSONArray row = jObj.getJSONArray("stationList"); // json의 구성원?? 이름으로 뽑아냄
		System.out.println("rowNum 의 개수 : " + row.length());
		System.out.println();
		for (int i = 0; i < row.length(); i++) {
			JSONObject station = row.getJSONObject(i); // row의 object 구성원을 station 이라는 변수에 담음
			int rowNum = station.getInt("rowNum");
			String statnNm = station.getString("statnNm");
			String subwayId = station.getString("subwayId");
			String subwayNm = station.getString("subwayNm");
			

			System.out.printf("%5s : %8s역 [ID:%6s 호선:%6s]\n", rowNum, statnNm, subwayId, subwayNm);
		}

	}

}// end class
