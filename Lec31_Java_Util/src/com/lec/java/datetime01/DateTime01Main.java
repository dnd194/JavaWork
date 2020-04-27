package com.lec.java.datetime01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * 날짜를 다루기 위해 자바에선 java.util.Date 클래스 제공   JDK 1.0 부터..
 * 이후 보완하여 java.util.Calendar 등장   JDK 1.1 부터..
 * java.time 패키지 제공 JDK 1.8 (Java8)부터
 * 
 * 지금은 java.time 패키지만으로 충분하긴 하나.. 
 * 오랜시간 Date, Calendar 를 사용하여 만들었으므로 이 또한 알긴 알아야 한다
 * 
 */
public class DateTime01Main {

	public static void main(String[] args) throws Exception{
		System.out.println("Date객체로 날짜 다루기");

		// 현재 날짜 얻어오기,  생성자가 현재 날짜, 시간을 얻어온다.
		Date now = new Date();
		String strNow = now.toString();
		
		System.out.println("1. Date 의 toString() 사용한 출력");
		System.out.println(strNow);
		
		System.out.println();
		System.out.println("2. Date 의 get..()을 사용한 출력");
		// Date객체의 대부분의 메소드들은 현재 deprecated 됨.    deprecated ==> 앞으로는 이거 안쓴다고 그냥 경고하는것
		int year = now.getYear() + 1900;		// 연도는 1900 이후 경과 년도를 뽑아옴  ==> 그래서 1900을 더해야함
		int month = now.getMonth() +1 ;         //getmonth 는 0부터 시작하기 떄문에  '+ 1' 해주는 작업이 필요함
		int date = now.getDate();				//날짜
		int day = now.getDay();					//요일  요일은 숫자로 나옴   일요일 = 0 
		int hour = now.getHours();
		int min = now.getMinutes();
		int sec = now.getSeconds();
		//위에거는 옛날에 썻던거 하지마세염
		System.out.println(year+ "년 "+month+ "월 "+date+"일 "+day+"요일 "+hour+"시 "+min+"분 "+sec+"초 ");
		
		System.out.println();
		
		//아래 처럼 하면 훨씬 더 쉬움
		System.out.println("3. SimpleDateFormat 사용한 출력");
		SimpleDateFormat fmt = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");    // 문자열에는 타입을 정의
		String strNow2 = fmt.format(now);
		System.out.println(strNow2);
		// yyyy-MM-dd hh:mm:ss 형식 출력
		fmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String strNow3 = fmt.format(new Date());
		System.out.println(strNow3);
		// 포맷에 사용되는 문자열 종류 : 자바의 정석 교재 p544
		// H: 시간 (0~23),  h : 시간 (1~12)
		
		// ※ 현재 Date() 객체는 생성자를 제외하고는 거의다 deprecated 되어 있다.
		
		System.out.println();
		System.out.println("Date 테스트");
		long baseTime = System.currentTimeMillis();  //  ==> 현재시간을 ms로 리턴
													 //  ==> 1970-01-01 00:00:00 UTC 기준으로 경과된 ms 를 의미함
		long curTime = baseTime + 2000;  //2000 = 2초 의 ms
		
		SimpleDateFormat msimDateFormat = new SimpleDateFormat("YYYY:MM:dd-HH:mm:ss" , Locale.KOREA);
		// 년도는 대문자 Y로 해도 상관없다.  locale 로 지역을 정할 수 있음
		String mTime = msimDateFormat.format(new Date(baseTime));    // Date 객체를 문자열로 바꿔주는 format() 함수
		String mTime2= msimDateFormat.format(new Date(curTime));
		System.out.println(mTime);
		System.out.println(mTime2);
		
		// 문자열을 Date 타입으로 파싱하기
		System.out.println();
		System.out.println("문자열 -> Date");
		String oldstring = "2018-08-16 14:21:52.3";    //0.3초 까지 표현
		
		Date date2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S", Locale.KOREA).parse(oldstring);  //문자열을 Date 객체로 바꿔주는 parse()
		System.out.println(date2);
		
		
		// 경과시간 체크하기        == lap time
		System.out.println();
		System.out.println("경과시간");
		
		
		long start=System.currentTimeMillis();
		for(int i = 0 ; i<5; i++) {
			System.out.println(i);
			Thread.sleep(1000);      //   1초 쉼
		}
		long end =System.currentTimeMillis();
		long lapTime = end - start ; 
		System.out.println("경과 시간 : "+lapTime+" ms");   // 5002  --> 5초002초
		
		//자바에서는 나노 세컨드 가능 nanosec = 10^-9  나노까지 할 필요가 있나싶음
//		start = System.nanoTime();
//		end = System.nanoTime();
		
		
		System.out.println();
		System.out.println("millisec -> time");
		long durationInMillis = 1000000;
		long millis = durationInMillis % 1000; 
		long sececond = (durationInMillis / 1000) % 60;
		long minute = (durationInMillis /( 1000 * 60))%60 ;
		long hr = (durationInMillis/(1000*60*60))%24;
		
		
		String time = String.format("%02d:%02d:%02d.%d", hr,min,sec,millis);  //보통 알고리즘 시간 체크할때 사용함
		System.out.println(time);
	} // end main()

} // end class
