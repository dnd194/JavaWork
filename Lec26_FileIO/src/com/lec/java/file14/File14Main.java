package com.lec.java.file14;

import java.nio.charset.Charset;

public class File14Main {

	public static void main(String[] args) {
		System.out.println("시스템 정보 확인");

		System.out.println();
		System.out.println(System.getProperty("os.name"));
		// 현재 자바프로그램이 돌아가고있는 os의 정보를 알 수 있다

		System.out.println(System.getProperty("os.arch"));
		// 64비트에서 돌아가고 있다는 것을 알 수 있다.
		System.out.println(System.getProperty("os.version"));

		System.out.println();
		System.out.println(System.getProperty("java.home"));
		// jre(java runtime environment) 경로를 알려줌
		System.out.println(System.getProperty("java.version"));

		System.out.println();
		// current working directory 현재 작업 경로
		System.out.println(System.getProperty("user.dir"));

		// user home directory("내 문서"가 있는 폴더) 영문이름이여야함 (다른거 들어가면 좋지않음)
		System.out.println(System.getProperty("user.home"));

		System.out.println();
		System.out.println(System.getProperty("file.separator")); // 파일을 구분하는 기준 윈도우는 역슬래시를 사용

		System.out.println();
		//OS 기본 인코딩 값
		System.out.println("default charset : "+ Charset.defaultCharset());
		
		//파일 인코딩 값 확인 가능
		System.out.println("file.encoding : " +System.getProperty("file.encoding") );
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class
