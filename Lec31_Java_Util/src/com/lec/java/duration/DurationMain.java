package com.lec.java.duration;

import java.time.Duration;
import java.time.Instant;

/* 경과시간 (Elapsed Time, Lap Time, Duration) 체크하기
 * 
 * 알고리즘의 성능, 프로그램의 성능을 가늠하는 
 * 대표적인 두가지 척도는
 * 	시간복잡도 (Time Complexity)  : 얼마나 시간이 많이 걸리나? 
 * 	공간복잡도 (Space Complexity) : 얼마나 많은 메모리를 소모하나?
 * 
 * 시간복잡도, 즉 수행 '경과시간'을 정밀하게 체크하려면
 * 연월일시분초 개념의 시간보다는 그보다 더 정밀한 시간, 가령 ms, ns 단위로 체크해봐야 한다.
 * 
 * 
 * 참고]
 * UTC 란?
 * 협정 세계시(協定世界時, 프랑스어: Temps Universel Coordonné, 영어: Coordinated Universal Time) 
 * 또는 UTC(협정 세계표준시)는 1972년 1월 1일부터 시행된 국제 표준시이다. 
 * UTC는 국제원자시와 윤초 보정을 기반으로 표준화되었다.
 * UTC는 그리니치 평균시(GMT)에 기반하므로 GMT로도 불리기도 하는데, 
 * UTC와 GMT는 초의 소숫점 단위에서만 차이가 나기 때문에 일상에서는 혼용되어 사용된다. 
 * 기술적인 표기에서는 UTC가 사용된다.
 * 
 * 현재 UTC 확인해보기 : https://www.worldtimeserver.com/current_time_in_UTC.aspx
 * 
 */
public class DurationMain {

	public static void main(String[] args) {
		
		// 연월일시분초 개념의 시간이 아니라, 현재 시점을 알고 싶을때.
		long millSec = System.currentTimeMillis();  // 현재 시간을 milliseconds 로 리턴 (long)
		long nanoTime = System.nanoTime();  // JVM의 시간을 nanoseconds 로 리턴 (long)
		Instant now = Instant.now();  // JAVA8 에 등장, UTC 기준 현재시각 정보를 담고 있는 java.time.Instant 객체 리턴

		System.out.println(millSec);
		System.out.println(nanoTime);
		System.out.println(now);
		
		//----------------------------------------------------
		// 경과시간 체크하기
		long startTime;
		long endTime;
		long lapTime; 
		
		System.out.println();
		System.out.println("1] System.currentTimeMillis() 사용");
		startTime = System.currentTimeMillis();
		test(2400);
		endTime = System.currentTimeMillis();
		lapTime = endTime - startTime;
		System.out.println("경과시간 (ms): " + lapTime);
		System.out.println("경과시간 (sec): " + lapTime / Math.pow(10, 3));
		
		System.out.println();
		System.out.println("2] System.nanoTime() 사용");
		startTime = System.nanoTime();
		test(2400);
		endTime = System.nanoTime();
		lapTime = endTime - startTime;
		System.out.println("경과시간 (ns): " + lapTime);
		System.out.println("경과시간 (ms): " + lapTime / 1000000);
		System.out.println("경과시간 (sec): " + lapTime / Math.pow(10, 9));  // 10의 9승으로 나누면 됨


		System.out.println();
		System.out.println("3] java.time.Instant 사용");  // Java8 이상
		Instant startInstant = Instant.now();
		test(2400);	
		Instant endInstant = Instant.now();
		lapTime = Duration.between(startInstant, endInstant).toNanos();
		System.out.println("경과시간 (ns): " + lapTime);
		lapTime = Duration.between(startInstant, endInstant).toMillis();  // java.time.Duration  JAVA8 에 등장
		System.out.println("경과시간 (ms): " + lapTime);
		
		System.out.println("프로그램 종료");
	} // end main()
	
	
	// 주어진 시간 (millisec) 만큼 딜레이 발생하는 메소드
	public static void test(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} // end test

} // end class
