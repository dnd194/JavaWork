package com.lec.java.crawl13;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Jackson 라이브러리
 * 	Java Object를 JSON으로 변환하거나 JSON을 Java Object로 변환하는데 사용할 수 있는 Java 라이브러리입니다.
 * 		Jackson Github - https://github.com/FasterXML/jackson
 * 
 * Jackson 특징
 * 	1.Stream API : 스트림 형식으로 데이터를 분석하고 생성하기 때문에 성능이 좋습니다.
 * 	2.Tree Model : XML의 DOM 처럼 Node 형태로 데이터를 다룰 수 있기 때문에 유연성이 좋습니다.
 * 	3.Data Binding : POJO 기반의 자바 객체들을 JSON으로 변환시킬 수 있습니다.
 * 
 * Maven 설정
 * 	jackson-databind 라이브러리는 jackson-core 및 jackson-annotation 라이브러리의 '''''의존성'''''을 포함하기 때문에 메이븐을 사용하는 경우 jackson-databind 라이브러리만 추가해주시면 됩니다.
 * 
 * MVNrepository :
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-core
 * 	https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-annotations
 * 
 * 
 * 
 * JavaScript 의 배열 		 	↔↔↔↔↔↔↔↔  		Java 의 List<>
 * JS의 Object   			↔↔↔↔↔↔↔↔   		Java 의 객체(Class)
 * 
 */


public class Crawl13Main {

	public static void main(String[] args) {
		System.out.println("JACKSON-DATABIND 사용");
		
		User user = new User();
		user.setName("JSON");
		user.setAge(10);
		List<String> list = new ArrayList<String>();
		list.add("json 은 javascript object notation 의 약자 입니다");
		list.add("json 은 데이터 교환 포맷으로 좋슙니다");
		list.add("json 은 배열이있습니다 (XML 보다 장점)");
		list.add("json 은 타입 검증에 대해선 XML 보다 약합니다");
		user.setMessages(list);
		user.setScore1(new Score(100,70,80));
		
		javaToJson(user);
		jsonToJava();
		
		System.out.println("\n프로그램 종료");
	}  //end main
	
	//				java 객체  -- > json 변환
	
	
	//				
	public static void javaToJson(User user) {
		
		ObjectMapper mapper = new ObjectMapper();      //매핑!     1  :  1   대응
		try {
			
			//java 객체(user) --> json 변환  (user.json)
			//user 라는 매개변수를 받아서  data란 폴더 안에 user.json 이란 이름으로 파일형태로 저장할 거임   폴더확인
			mapper.writeValue(new File("data/user.json"), user);
		   
			//Java 객체 --> JSON '''문자열'''
			System.out.println(mapper.writeValueAsString(user));        
			
			//Json 문자열 변환시 이쁜 포맷   writerWithDefaultPrettyPrinter()
			System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(user));
			
			//이쁜 포맷으로 파일 저장 		data란 폴더 안에 user2.json 이란 이름으로 파일을 저장할 거임
			mapper.writerWithDefaultPrettyPrinter().writeValue(
					new File("data/user2.json"),user);
			
			
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//end javaToJson
	
	
	//Json  ---->  Java 객체로 
	public static void jsonToJava() {
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			
			// json 파일 --> java 객체로 변환
			//myUser.json 을 읽은 user1객체를 반환한 거임
			User user1 = mapper.readValue(new File("data/myUser.json"), User.class);       //User 타입을 return;
			System.out.println(user1);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}//end class

@JsonIgnoreProperties(ignoreUnknown = true)    //이런annotation 이 있어야한다   unrecognized 에러 를 처리 해줄 수있다.
class Subway{
	//CardSubwayStatsNew
	Stats CardSubwayStatsNew;
	
	public Stats getCardSubwayStatsNew() {
		return CardSubwayStatsNew;
	}

	public void setCardSubwayStatsNew(Stats cardSubwayStatsNew) {
		CardSubwayStatsNew = cardSubwayStatsNew;
	}
	
}

@JsonIgnoreProperties(ignoreUnknown = true)     //이런annotation 이 있어야한다   unrecognized 에러 
class Stats{
	int list_total_count;

	public int getList_total_count() {
		return list_total_count;
	}

	public void setList_total_count(int list_total_count) {
		this.list_total_count = list_total_count;
	}
	
}























