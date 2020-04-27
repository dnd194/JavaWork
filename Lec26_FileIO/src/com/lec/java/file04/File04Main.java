package com.lec.java.file04;
/* 보조스트림 (filter stream)
Program <=== FilterInputStream <=== InputStream <=== Source
					↓ 상속					↓ 상속
Program <=== BufferedInputStream <=== FileInputStream <=== File

Program ===> FilterOutputStream ===> OutputStream ===> Source
					↓ 상속					↓ 상속
Program ===> BufferedOutputStream ===> FileOutputStream ===> File

java.io.InputStream
 |__ java.io.FilterInputStream
      |__ java.io.BufferedInputStream

java.io.OutputStream
 |__ java.io.FilterOutputStream
      |__ java.io.BufferedOutputStream

참고 ) 보조스트림 (filter stream)
보조스트림(filter stream) 이란 다른 스트림과 연결되어 여러가지 편리한 기능을 제공해주는 스트림
*/

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class File04Main {

	public static void main(String[] args) {
		System.out.println("BufferedInputStream, BufferedOutputStream");


		InputStream in = null;  //inputstream 변수 선언
		BufferedInputStream bin = null;    //BufferedInputStream
		
		OutputStream out = null;  //outputstream 변수 선언
		BufferedOutputStream bout = null;   //BufferedOutputStream
		int dataRead;
		
		int bytesCopied = 0;  
		
		
		try {
			//fileinputstream 인스턴스 생성
			in = new FileInputStream("temp/big_text.txt");
			bin = new BufferedInputStream(in);   //기존의 inputstream 에 버퍼 장착
			//fileoutputstream 인스턴스 생성
			out = new FileOutputStream("temp/copy_big_text.text");   	
			bout = new BufferedOutputStream(out);															
			
			long startTime = System.currentTimeMillis();   //현재시간
			//파일 복사: 읽고 -> 쓰기
			while(true) {
				
				

				dataRead = bin.read();       //장착한 bufferedinputstream으로 읽으면 됨
				if(dataRead == -1) {   //더이상 읽을 것이 없으면 read()는 -1을 return
					break;
				}
				
				bout.write(dataRead);
				bytesCopied++;   //1  바이트 쓰여질 때마다 1증감
			}
			
			long endTime = System.currentTimeMillis(); //끝나는 시간
			long elapsedTime = endTime - startTime;
			
			System.out.println("읽고 쓴 바이트는 " +bytesCopied );
			System.out.println("경과시간은 "+elapsedTime +"milisec");
			
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bout != null )bout.close();
				//bin , bout을 close 하면 bin, bout을 만든 in,out도 close 됨
				if(bin != null) bin.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class














