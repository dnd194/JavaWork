package com.lec.java.datetime03;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/* Calendar 객체를 사용한 시간 및 날짜 연산
 *  
 */
public class DateTime03Main {

	public static void main(String[] args) {
		System.out.println("날짜, 시간 연산");

		Calendar cal = Calendar.getInstance();
		DateFormat df = null;
		Date date = null;
		
		//-------------------------------------------------------
		System.out.println("현재 시간에서 날짜 더하고 빼기");
		//cal 에 현재 date 가 가지고 있는 정보가 담김
		cal.setTime(new Date());    // ==> 현재시간
		df = new SimpleDateFormat("yyyy-MM-dd");
		
		System.out.println("현재 : "+df.format(cal.getTime()));
		cal.add(Calendar.MONTH, 6);   // 지금 가지고 있는 날짜 정보에서  2번째 매개변수 만큼 증가 된 값을 return
		
		System.out.println("계산 후 : "+df.format(cal.getTime()));
		
		
		System.out.println("현재 : "+df.format(cal.getTime()));
		cal.add(Calendar.DATE, 6);
		System.out.println("계산 후 : "+df.format(cal.getTime()));
		
        //-------------------------------------------------------
        System.out.println();
        System.out.println("특정 날짜에 더하고 빼기");
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        
        try {
			date = df.parse("2020-03-16 09:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        cal.setTime(date);    //==? date 를 calender 로 변경
        System.out.println("주어진 시간: "+df.format(cal.getTime()));
        
        cal.add(Calendar.HOUR_OF_DAY, 5);                       //Calendar.hour = 12시간, .hour of dat = 24시간
        cal.add(Calendar.MINUTE, 20);
        cal.add(Calendar.SECOND	, 20);
        System.out.println("계산 후 시간 : "+ df.format(cal.getTime()));
        
        //-------------------------------------------------------
        System.out.println();
        System.out.println("날짜 두개 더하기");
        // 두개의 Date를 더하려면 두개의 Calendar를 사용해야 합니다. 

       Calendar cal2 = Calendar.getInstance();
       System.out.println("cal : "+ df.format(cal.getTime()));
       System.out.println("cla2  : "+ df.format(cal2.getTime()));
       
       cal.add(Calendar.DATE, -cal2.get(Calendar.DATE));
       
       System.out.println("날짜 계산 후 ");
       System.out.println("cal : "+ df.format(cal.getTime()));    // cal에 cal2의 date만큼 더 해진 것을 볼 수 있다.
       System.out.println("cla2  : "+ df.format(cal2.getTime()));
       
       
       
       
       System.out.println("\n프로그램 종료");
	} // end main()

} // end class











