package com.lec.java.file16;

import java.io.File;
import java.io.IOException;

public class File16Main {

	public static final String TEST_DIRECTORY = "test";
	public static final String TEMP_DIR = "temp";
	public static final String TEST_FILE = "dummy.txt";
	public static final String TEST_RENAME = "re_dummy.txt";
	
	public static void main(String[] args) {
		System.out.println("폴더/파일 생성, 이름변경, 삭제");
		System.out.println();
		
		String path = System.getProperty("user.dir")
										+File.separator + TEST_DIRECTORY;           //==>   "test" 의 절대경로 를 담은것
		
		System.out.println("절대 경로는 : "+path);
		
		File f = new File(path); //파일객체 생성 => 물리적으로는 생성되지 않음
		
		System.out.println();
		// 폴더 생성: mkdir()             '''''디렉토리'''''''를  물리적으로 만드는 과정
		if(! f.exists()) {  //디렉토리가 존재하는지 여부를 체크
			
			//디렉토리가 존재 하지 않는 다면 생성
			if(f.mkdir()) {   //  f.mkdir() 은  boolean 값을 return 
				
				//생성에 성공하면 true   아니면 false 
				System.out.println("  폴더     생성성공");                //하고서 package explorer에서 확인해야함
			}else {
				System.out.println("   폴더      생성실패 ");        //만들 권한이 없거나 , 디스크상에 오류가 생길경우 다음과 같은 경우가 생김
			}
		}else {
			System.out.println("    폴더     가 이미 존재합니다");
		}
		
		System.out.println();
		// 파일 생성 : createNewFile()         말그대로 새로운 파일을 만드는 것 create File
		File f2 = new File(f, TEST_FILE);  //  "test" 라는 폴더         +   TEST_FILE == dummy.txt  라는 '''''''파일'''''''''' 생성
		            //매개변수로 디렉토리 경로와, 파일이름을 받음
		System.out.println(f2.getAbsolutePath());   //절대경로 출력  (아직까지는 물리적으로 존재 하지 않음)
		
		if(! f2.exists()) {        //이제 createFile을 써서 물리적으로 새로운 ''파일'' 을 만들거임
			//파일이 존재하지 않으면 생성
			try { 
				if(f2.createNewFile()) {    ///createFile() 로 boolean 값을 return                               // 파일과 관련되서 try - catch 로 감싸줘야함
					System.out.println("     파일        생성 성공 ");  //  '''''물리적 '''' 파일 생성
				}else {
					System.out.println("     파일       생성 실패");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			//존재 하면 만들수없다.
			System.out.println("파일이 이미 존재합니다");
		}
		
		System.out.println();
		// 파일 이름 변경: renameTo()
		// renameTo()를 이용해서 다른 폴더로 이동(move)를 할 수도 있다.
		File f3 = new File(f , TEST_RENAME);       // '''test''' 디렉토리 밑에 있는    "re_dummy.txt"        바꾸려고하는 파일객체를 만든것 
						//매개변수로 디렉토리 경로와, 파일이름을 받음
		System.out.println(f3.getAbsolutePath());
		
		//바꾸려고 하는 친구의 존재여부도 확인을 해야함 그래서 2번 체크해야함
		if( f2.exists()) {    //f2 = test/dummy.txt  가 존재하는지 체크
			
			//변경시도
			if (f2.renameTo(f3)) {   // f2 에서 f3 로 변경시도      성공시  ture , 실패시 false
				System.out.println("파일 이름 변경 성공");
			}else {
				System.out.println("파일 이름 변경 실패");          //이미 re_dummy.txt 가 존재하고 있었으면 실패
			}
			
		}else {
			System.out.println("이름을 변경할 파일이 없습니다.");
		}
		
		
		
		System.out.println();
		// 파일 삭제: delete()
		//re_dummy 지울 예정
		
		File f4 = new File(f ,TEST_RENAME);  //상대 경로 
//		System.out.println(f4.getAbsolutePath());    //절대 경로 확인
		if(f4.exists()) {
			if( f4.delete()) {     //삭제에 성공하면 true  실패하면 false
				System.out.println("파일 삭제 성공");
			}else {
				System.out.println("파일 삭제 실패");
			}
		}else {
			System.out.println("삭제할 파일이 없습니다.");
		}
		
	
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class














