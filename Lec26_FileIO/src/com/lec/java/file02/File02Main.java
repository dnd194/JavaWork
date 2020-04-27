package com.lec.java.file02;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* FileIO
 Program <=== InputStream <=== Source
 Program ===> OutputStream ===> Source
 Program <=== FileInputStream <=== File
 Program ===> FileOutputStream ===> File

 java.io.InputStream
  |__ java.io.FileInputStream: 파일로부터 데이터를 읽어오는 통로
 java.io.OutputStream
  |__ java.io.FileOutputStream: 파일로 데이터를 쓰는 통로
*/

public class File02Main {

	public static void main(String[] args) {
		System.out.println("File IO");

		InputStream in = null;  //inputstream 변수 선언
		OutputStream out = null;  //outputstream 변수 선언
		int dataRead;
		
		int bytesCopied = 0;  
		
		
		try {
			//fileinputstream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt");

			//fileoutputstream 인스턴스 생성
			out = new FileOutputStream("temp/copy_big_text.text");   	//이렇게하면 이런한 경로에 이러한 이름으로 복사가 됨
																		//위 파일이 없으면 새로 생성
																		//위 파일이 있으면 삭제후 새로 생성
			
			long startTime = System.currentTimeMillis();   //현재시간
			//파일 복사: 읽고 -> 쓰기
			while(true) {
				
				// 데이터 읽기: InputStream에 있는 read() 메소드 사용
				// read()는 InputStream 으로부터 
				// 1byte 씩 읽어서 int(4byte) 에 담아 리턴한다
				// [ ... ][ ... ][ ... ][ 1byte ]

				dataRead = in.read();
				if(dataRead == -1) {   //더이상 읽을 것이 없으면 read()는 -1을 return
					break;
				}
				
				// 데이터 쓰기: OutputStream에 있는 write() 메소드 사용
				// write() 는 
				// int(4byte)에 1byte씩 담아 OutputStream에 쓴다
				// [ ... ][ ... ][ ... ][ 1byte ]

				out.write(dataRead);
				bytesCopied++;   //1  바이트 쓰여질 때마다 1증감
			}
			
			long endTime = System.currentTimeMillis(); //끝나는 시간
			long elapsedTime = endTime - startTime;
			
			System.out.println("읽고 쓴 바이트는 " +bytesCopied );
			System.out.println("경과시간은 "+elapsedTime);
			
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (out != null )out.close();
				
				if(in != null) in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class

