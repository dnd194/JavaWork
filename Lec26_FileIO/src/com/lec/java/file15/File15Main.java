package com.lec.java.file15;

import java.io.File;    //주로 디렉토리 관련 작업을 함

public class File15Main {

	public static void main(String[] args) {
		System.out.println("디렉토리 정보 확인");
		System.out.println();
		// current working directory : 현재작업경로
		String curWorkingDir = System.getProperty("user.dir");
		System.out.println("현재 작업 경로 : "+curWorkingDir);
		
		System.out.println();
		// 현재 작업 디렉토리의 파일 리스트 출력
		// File 클래스: 파일(txt, doc, ...) 객체 또는 디렉토리(폴더) 객체
		File curDir = new File(curWorkingDir); //현재 작업 디렉토리 (폴더)  객체
		File[] list = curDir.listFiles(); // listFiles() : 디렉토리 안에 있는 '파일' 과 ' 디렉토리 ' 를   File 배열로 리턴
		
		System.out.println(list.length);   // 해당 디렉토리에 있는 파일 이나 디렉토리 가 나옴 : 7개 
		
		for (int i = 0; i < list.length; i++) {
			if(list[i].isDirectory()) {   
				//디렉토리인가 ? 의 여부를 확인하는 조건문
				// isDirectory(): File 객체가 디렉토리이면 true 리턴
				// isFile(): File 객체가 파일이면 true 리턴

				System.out.print("DIR\t");
			}else {
				System.out.print("FILE\t");
			}
			System.out.print(list[i].getName()+"\t");
			System.out.println(list[i].length());  // length() '파일' 의 크기
													// 디렉토리인인데도 숫자가 나오는 경우가 있지만 의미가 없는 숫자임.
			
		}
		
		
		System.out.println();
		// 디렉토리의 내용 출력, enhanced for 문 이용
//		File tempDir = new File("temp");       //   temp에 있는 내용 뽑아내기     현재작업경로가 항상 기준  => 상대 경로  
		
		//절대 경로
		String tempDirPath = System.getProperty("user.dir")+File.separator+"temp";    //file.seperator 는 ' \ ' 임
		System.out.println("절대 경로 : "+tempDirPath);
		File tempDir = new File(tempDirPath);
		
		File[] list2 = tempDir.listFiles();  //temp 폴더 안에 있는 내용을 File배열로 리턴
		System.out.println(list2.length);  //길이 출력
		
		for(File f : list2) {
			if(f.isDirectory()) {              //temp 폴더 안에는 file들 밖에 없으므로 file만 나옴   .txt => file
				System.out.print("Dir\t");
			}else {
				System.out.print("File\t");
			}
			System.out.print(f.getName()+"\t");
			System.out.println(f.length()+"\t");
		}
		
		System.out.println();
		// 파일 하나에 대한 정보
		String path = "dummy.txt";
		File f = new File(path);  //새로운 File  객체 생성
		
		
							      // *** File 객체를 new 했다고해서 물리적인 파일 or 디렉토리가 만들어지는 것은 아니다. ***
		System.out.println("파일 이름 : "+ f.getName());      // 절대 경로가 아니라 '상대 경로' 가 뽑힘
		System.out.println("파일 이름 : "+ f.getAbsolutePath()); //이거는 절대 경로가 뽑힘    'absolute'
		System.out.println("파일이 있습니까?? "+f.exists()); //물리적으로 존재하는지를 확인가능함
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end File11Main





















