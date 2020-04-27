package com.lec.java.file03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 java.io.InputStream
  |__ java.io.FileInputStream
 java.io.OutputStream
  |__ java.io.FileOutputStream
*/

public class File03Main {

	public static void main(String[] args) {
		System.out.println("File IO 2");
		
		// Java 7부터 도입된 try-with-resource
		// try (리소스 생성) { ... }
		// catch (exception ) { ... }
		// 리소스를 close하는 코드가 없어도 자동으로 close가 실행
		//
		// java.lang.AutoCloseable 나 
		//  └─ java.io.Closeable 을 상속받은 어떠한 객체라도 
		//  try(리소스 생성) 안에 '선언' 되어 있으면
		//  try~catch 가 끝나기 전에 close() 됨.
		
		// InputStream, OutputStream 둘다 Closeable 을 상속(implements) 한다
		
	
		try(
				InputStream in = new FileInputStream("temp/big_text.txt");
				OutputStream out = new FileOutputStream("temp/copy_big_text.text")
				){
			
			byte[] buff = new byte[1024];         //1024 길이의 버퍼 생성
			int lengthRead = 0;               	  //버퍼에 읽어드린 byte 수
			int byteCopied = 0;			
			
			long startTime = System.currentTimeMillis();
			//파일복사
			while(true) {
				//데이터 읽기
				
				
				// 매개변수로 주어진 byte[] 배열의 길이 만큼 read한다.
				// 실제 읽어 들인 데이터는 매개변수 byte[] 에 담김.
				// 읽어들인 바이트 리턴,  읽어들인게 없으면 -1 리턴.


				lengthRead = in.read(buff);
				if(lengthRead == -1) {
					break;
				}
				
				//데이터 쓰기
				
				 out.write(buff, 0 , lengthRead);   //직전에 읽어드린 데이터만큼 write 
				 byteCopied+=lengthRead;
			}
			long endTime = System.currentTimeMillis();   
			long elaspsedTime = endTime-startTime;
			System.out.println("경과 시간은 : "+elaspsedTime+"milisec");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class
















