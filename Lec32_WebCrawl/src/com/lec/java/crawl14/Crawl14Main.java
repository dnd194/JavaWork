package com.lec.java.crawl14;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;


/* XML, Json 파싱1
 * 
 * ■서울시 지하철호선별 역별 승하차 인원 정보 
 * http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-12914&srvType=A&serviceKind=1&currentPageNo=1
 * 
 * 샘플url
 * XML 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/xml/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/616a757750646e643736526f415644/xml/CardSubwayStatsNew/1/5/20181001
 *   
 * JSON 버젼
 * http://openapi.seoul.go.kr:8088/키값을넣으세요/json/CardSubwayStatsNew/1/5/20181001
 * 예) http://openapi.seoul.go.kr:8088/616a757750646e643736526f415644/json/CardSubwayStatsNew/1/5/20181001 
 * */

/* JSON 파싱
java.io.Reader    프로그램이 '문자 단위' 데이터를 읽어들이는(read) 통로
	├─ java.io.InputStreamReader    // 스트림 기반의 reader
 	└─ java.io.BufferedReader 		// 문자(character) 기반 reader
 */

public class Crawl14Main {

	public static void main(String[] args) throws IOException {
		System.out.println("JACKSON-DATABIND 연습 : URL ->JSON -> JAVA");
		
		ObjectMapper mapper = new ObjectMapper();
		URL url = new URL("http://openapi.seoul.go.kr:8088/616a757750646e643736526f415644/json/CardSubwayStatsNew/1/5/20181001");   //IOException 으로 던져줌
		
		Subway subway = mapper.readValue(url, Subway.class);    //subway class 형태로 반환함
		
		System.out.println(subway.getCardSubwayStatsNew().getList_total_count());  
		
		for(SubRow e : subway.getCardSubwayStatsNew().getRow())  {                       //getRow 는 list 형태 이고    그 안에는 SubRow 타입이 담겨져있음
			
			System.out.printf("%5s : %8s역 [승차:%6s 하차:%6s]\n", e.getLineNum(), e.getStationName(), e.getRidePassenger(),
					e.getAlightPassenger());
		}
		
		
		System.out.println("\n프로그램 종료");
		
	}

}

//대소문자도 틀리면 그대로 못받아오니 항상 주의 할 것
//json 의 object 형태는 자바에서 클래스 형태로 받아줘야함

//annotation 은 컴파일러에게 알려주는 역할임
//annotation 도 import 해줘야함
@JsonIgnoreProperties(ignoreUnknown = true)    //이런annotation 이 있어야한다   unrecognized 에러 를 처리 해줄 수있다.
class Subway{
	//CardSubwayStatsNew
	public Stats CardSubwayStatsNew;
	
	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		CardSubwayStatsNew = cardSubwayStatsNew;
	}
	
}

@JsonIgnoreProperties(ignoreUnknown = true)     //이런annotation 이 있어야한다   unrecognized 에러 
class Stats{
	private int list_total_count;
	
	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}

	private List<SubRow> row;   //SubRow 타입 형태를 받는 리스트 선언
	// 리스트 getter / setter
	public List<SubRow> getRow() {
		return row;
	}
	
	public void setRow(List<SubRow> row) {
		this.row = row;
	}
	
} //end Stats

//json 필드명과 매핑되는 java 객체의 변수명을 달리 하고 싶다면
///@JsonProperty 를 사용하면됨  (아래에 있음)           ---->    이쁘게 만드는 용도?/

@JsonIgnoreProperties (ignoreUnknown = true)     //(ignoreUnknown = true) ==> 나머지 명시되지 않은 json 변수들을 무시하겠다는 의미  (원래 없으면 에러남)
class SubRow{
	//변환 하고자의 json데이터를 자바에서도 똑같이 해줘야함  근데 아래거 쓰면 됨   
	
	@JsonProperty("LINE_NUM")          //Json의 LINE_NUM --> lineNum 으로 매핑해줌
	private String lineNum;
	
	@JsonProperty("SUB_STA_NM")         //각 각 매핑
	private String stationName;
	
	@JsonProperty("RIDE_PASGR_NUM")		//각 각 매핑
	private int ridePassenger;
	
	@JsonProperty("LINEALIGHT_PASGR_NUM_NUM")	//각 각 매핑
	private int alightPassenger;
	
	
	//기본 생성자
	public SubRow() {
		super();
	}
	

	// 매개변수를 받는 생성자 생성
	public SubRow(String lineNum, String stationName, int ridePassenger, int alightPassenger) {
		super();
		this.lineNum = lineNum;
		this.stationName = stationName;
		this.ridePassenger = ridePassenger;
		this.alightPassenger = alightPassenger;
	}
	// getter // setter

	public String getLineNum() {
		return lineNum;
	}

	public void setLineNum(String lineNum) {
		this.lineNum = lineNum;
	}

	public String getStationName() {
		return stationName;
	}

	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public int getRidePassenger() {
		return ridePassenger;
	}

	public void setRidePassenger(int ridePassenger) {
		this.ridePassenger = ridePassenger;
	}

	public int getAlightPassenger() {
		return alightPassenger;
	}

	public void setAlightPassenger(int alightPassenger) {
		this.alightPassenger = alightPassenger;
	}
	
	
	
}






























