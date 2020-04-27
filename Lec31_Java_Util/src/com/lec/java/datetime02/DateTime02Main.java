package com.lec.java.datetime02;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/*
   Calendar 객체
   
   Calendar 는 추상클래스다.  그래서 new로 생성 불가.
     날짜와 시간을 계산하는 방식(역법) 지역, 문화, 나라에 따라 다르기 때문에
     이를 상속받아 개별적으로 구현함
   
   Calendar 는 날짜/시간을 계산하는 꼭 필요한 메소드만 제공하고                                         ***싱글톤으로 만들어짐
     특정한 역법(날싸 시간계산 ex: 음력) 은 상속받은 클래스에서 구현
   
     특별히 상속할 필요 없으면 getInstance() static 메소드 호출
 */
public class DateTime02Main {

	public static void main(String[] args) {
		System.out.println("Calendar객체로 날짜 다루기");

		// 특별한 역법을 쓰지 않는 경우. 우리나라 서력 사용.
		Calendar cal = Calendar.getInstance(); // 현재에 대한 정보가 변수에 담김  *** (매개변수가 없으면 현재 시스템에 적용되고 있는 정보가 전달됨)
//		System.out.println(cal.get(Calendar.YEAR));

		
		System.out.println("get() 으로 날짜/시간 받아오기");
		System.out.println("현재:");
		printDate(cal);   // 아래에 함수가 정의되어있음
		// TODO

		System.out.println();
		System.out.println("TimeZone");
		System.out.println("LA의 시간");
		TimeZone timezone = TimeZone.getTimeZone("America/Los_Angeles");
		cal = Calendar.getInstance(timezone);

		printDate(cal);
		System.out.println();
		// 시간대 문자열들 획득
		System.out.println("시간대 문자열 들 ");
		String[] availableIDs = TimeZone.getAvailableIDs();
		for(String id : availableIDs) {
			System.out.println(id);
		}

		System.out.println();
		System.out.println("Date ↔ Calendar 변환");
		// 상호간에 변환할 일이 생긴다..

		// 1-1. Calendar -> Date    ==> 이 방법이 조금더 직관적
		
		cal = Calendar.getInstance();
		
		
		Date date = cal.getTime();
		System.out.println(new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(date));
		System.out.println();
		
		
		// 1-2 Calendar -> Date
		date = new Date(cal.getTimeInMillis());
		System.out.println(new SimpleDateFormat("yyy-MM-dd HH:mm:ss").format(date));     
		System.out.println();
		// 2. Date -> Calendar
		cal.setTime(date);   //date 의 값이 calender에 들어감

		System.out.println(cal);
		
		
		// 오늘날 우리 대한민국이 쓰는 달력은 GregorianCalendar(국제표준시) 이며
		// 이는 Calendar 를 상속받은 클래스입니다.
		// 기본적으로 시스템 설정 시각 (서울)으로 되어 있으며
		// Locale 값을 설정하면 특정 지역 시각을 알수 있습니다.
		System.out.println();
		System.out.println("GregorianCalendar 사용");      //그냥 calender랑 똑같음
		GregorianCalendar gregCal = new GregorianCalendar();
		printDate(gregCal);

		//윤년 의 case
		int year = 2020;
		System.out.println(year + " 는 윤년?? "+gregCal.isLeapYear(year));   //  isLeapYear() 은 true / false 를 return 함
		
		
		
	} // end main()

	public static void printDate(Calendar now) {

		int year = now.get(Calendar.YEAR); 			// 연도 리턴
		int month = now.get(Calendar.MONTH) + 1; 	// 월을 리턴 0 ~ 11
		int day = now.get(Calendar.DAY_OF_MONTH); 	// 일을 리턴
		int week = now.get(Calendar.DAY_OF_WEEK); 	// 요일을 리턴           일요일: 1 ~ 토요일: 7 ==> switch 사용
		int ampm = now.get(Calendar.AM_PM); 		// AM 0 PM 1
		int hour = now.get(Calendar.HOUR);
		int minute = now.get(Calendar.MINUTE);
		int second = now.get(Calendar.SECOND);

		
		//요일 switch
		String strWeek = null;
		switch(week) {
		case Calendar.MONDAY:
			strWeek = "월";
			break;
		case Calendar.TUESDAY:
			strWeek = "화";
			break;
		case Calendar.WEDNESDAY:
			strWeek = "수";
			break;
		case Calendar.THURSDAY:
			strWeek = "목";
			break;
		case Calendar.FRIDAY:
			strWeek = "금";
			break;
		case Calendar.SATURDAY:
			strWeek = "토";
			break;
		case Calendar.SUNDAY:
			strWeek = "일";
			break;
		}
		
		//am 과 pm 을 구분
		String strAmPm = null;
		switch(ampm) {
		case Calendar.AM:
			strAmPm = "오전";
			break;
		case Calendar.PM:
			strAmPm = "오후";
			break;
		}
		
		
		System.out.println(year + "-" + month + "-" + day + " " + strWeek);
		System.out.println(strAmPm + " " + hour + ":" + minute + ":" + second);


	} // end printDate()

} // end class
