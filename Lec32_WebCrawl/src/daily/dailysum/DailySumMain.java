package daily.dailysum;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * 연습 : 자치구단위 서울 생활인구 일별 집계표
 * ■자치구단위 서울 생활인구 일별 집계표
 * 	http://data.seoul.go.kr/dataList/datasetView.do?infId=OA-15379&srvType=S&serviceKind=1&currentPageNo=1
 * 	http://openapi.seoul.go.kr:8088/(인증키)/(요청파일타입)/SPOP_DAILYSUM_JACHI/(요청시작INDEX)/(요청종료INDEX)/(기준일ID)/(시군구코드)
 * 
 * 샘플url
 * 	XML 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/xml/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * 	JSON 버젼
 * 	http://openapi.seoul.go.kr:8088/(인증키)/json/SPOP_DAILYSUM_JACHI/1/5/
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/	
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101
 * 		예] http://openapi.seoul.go.kr:8088/4d46796d7366726f3833774a774955/json/SPOP_DAILYSUM_JACHI/1/5/20190101/11000
 * 
 * ※ 한번에 1000개 까지의 데이터만 볼수 있슴
 * 
 */

/*  입력예]
 *  날짜입력: 20190101
 *  시작Index : 1
 *  끝Index: 5
 *  
 *  [XML]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490
 *   
 *  [JSON]
 *  날짜             구ID        총생활인구수           일최대이동인구수
 *  ----------------------------------------------------------------------
 *  20190101	11000    11121182.98210      4764635.18080 
 *  20190101    11110    274919.65940        177877.95000 
 *  20190101    11140    267096.65940        149729.45840 
 *  20190101    11170    315220.18480        149329.14120 
 *  20190101    11200    351993.77950        153738.94490 
 * 
 */

// ★ 주목 ★
// XML 은 Jsoup 를 활용하여 파싱하세요
// JSON 은  jackson 을 활용하여 파싱하세요

public class DailySumMain {

	public static final String REQ_SECVICE = "SPOP_DAILYSUM_JACHI"; // 서비스명
	public static final String API_KEY = "616a757750646e643736526f415644"; // 내 api 값

	public static void main(String[] args) throws IOException, InterruptedException {
		String STDR_DE_ID;
		int START_INDEX;
		int END_INDEX;
		String type;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("xml파싱타입 입력 : ");
		type = sc.nextLine();
		System.out.print("날짜 입력 : ");
		STDR_DE_ID = sc.nextLine();
		System.out.print("시작Index : ");
		START_INDEX = sc.nextInt();
		System.out.print("끝Index : ");
		END_INDEX = sc.nextInt();
		String url = buildUrlAddress(type, START_INDEX, END_INDEX, STDR_DE_ID);
		System.out.println("날짜             구ID        총생활인구수           일최대이동인구수");
		System.out.println("\n--------------------------------------------------");
//		System.out.println(url);  //url 출력 확인  확인후 주석처리
		
		Document doc = Jsoup.connect(url).parser(Parser.xmlParser()).get(); //IOException 으로 던져줌
		Elements elements = doc.select("row");
		for(Element e : elements) {
			String date = e.selectFirst("STDR_DE_ID").text().trim();
			String id = e.selectFirst("SIGNGU_CODE_SE").text().trim();
			String maxPop= e.selectFirst("DAIL_MXMM_LVPOP_CO").text().trim();
			String totalPop= e.selectFirst("TOT_LVPOP_CO").text().trim();
			
			
			System.out.printf("%8s   %5s      %14s   %10s ",date,id,maxPop,totalPop);
			System.out.println();
		}
		
		System.out.println();
		sc = new Scanner(System.in);
		
		System.out.print("json파싱타입 입력 : ");
		type = sc.nextLine();
		System.out.print("날짜 입력 : ");
		STDR_DE_ID = sc.nextLine();
		System.out.print("시작Index : ");
		START_INDEX = sc.nextInt();
		System.out.print("끝Index : ");
		END_INDEX = sc.nextInt();
		
		url = buildUrlAddress(type, START_INDEX, END_INDEX, STDR_DE_ID);
		System.out.println("날짜             구ID        총생활인구수           일최대이동인구수");
		System.out.println("\n--------------------------------------------------");
//		System.out.println("json url : "+url);  //확인하고 주석
		ObjectMapper mapper = new ObjectMapper();
		URL jsonURL = new URL(url);
		
		PopulationInfo pop = mapper.readValue(jsonURL, PopulationInfo.class);
//		System.out.println(pop.getSPOP_DAILYSUM_JACHI().getList_total_count()); //확인용
		for(PopRow e : pop.getSPOP_DAILYSUM_JACHI().getRow()) {
			System.out.printf("%8s   %5s      %14s   %10s ",e.getSTDR_DE_ID(),e.getSIGNGU_CODE_SE(),e.getDAIL_MXMM_LVPOP_CO(),e.getTOT_LVPOP_CO());
			System.out.println();
		}
		
		System.out.println("\n 프로그램 종료");
	} // end main

	public static String buildUrlAddress(String reqType, int START_INDEX, int END_INDEX, String STDR_DE_ID) {

		String url_address = String.format("http://openapi.seoul.go.kr:8088/%s/%s/%s/%d/%d/%s", API_KEY, reqType,
				REQ_SECVICE,START_INDEX, END_INDEX, STDR_DE_ID);

		return url_address;

	}// END buildUrlAddress
	
}
@JsonIgnoreProperties (ignoreUnknown = true)
class PopulationInfo{
	public Stats SPOP_DAILYSUM_JACHI;

	public Stats getSPOP_DAILYSUM_JACHI() {
		return SPOP_DAILYSUM_JACHI;
	}

	public void setSPOP_DAILYSUM_JACHI(Stats SPOP_DAILYSUM_JACHI) {
		this.SPOP_DAILYSUM_JACHI = SPOP_DAILYSUM_JACHI;
	}
	
	
}
@JsonIgnoreProperties (ignoreUnknown = true)
class Stats{
	private int list_total_count;

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	private List<PopRow> row;

	public List<PopRow> getRow() {
		return row;
	}

	public void setRow(List<PopRow> row) {
		this.row = row;
	}
	
	
}
@JsonIgnoreProperties (ignoreUnknown = true)
class PopRow{
	@JsonProperty("STDR_DE_ID")  
	private String date;
	
	@JsonProperty("SIGNGU_CODE_SE")  
	private String id;
	
	@JsonProperty("DAIL_MXMM_LVPOP_CO")  
	private String max;
	
	@JsonProperty("TOT_LVPOP_CO")  
	private String total;
	
	
	public PopRow() {
		super();
	}


	public PopRow(String date, String id, String max, String total) {
		super();
		this.date = date;
		this.id = id;
		this.max = max;
		this.total = total;
	}


	public String getSTDR_DE_ID() {
		return date;
	}


	public void setSTDR_DE_ID(String date) {
		this.date = date;
	}


	public String getSIGNGU_CODE_SE() {
		return id;
	}


	public void setSIGNGU_CODE_SE(String id) {
		this.id = id;
	}


	public String getDAIL_MXMM_LVPOP_CO() {
		return max;
	}


	public void setDAIL_MXMM_LVPOP_CO(String max) {
		this.max = max;
	}


	public String getTOT_LVPOP_CO() {
		return total;
	}


	public void setTOT_LVPOP_CO(String total) {
		this.total = total;
	}


	
	
}










