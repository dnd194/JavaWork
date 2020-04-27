package com.lec.java.file12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * 버퍼사용 문자입출력 : BufferedReader, BufferedWriter
 * 
 * java.lang.Object
 *  └─ java.io.Reader
 *      └─ java.io.BufferedReader
 *       
 * java.lang.Object
 *  └─ java.io.Writer
 *      └─ java.io.BufferedWriter
 *      
 * ★ 문자기반 출력시 꼭 끝에 flush() 해주자 ★     
 *             
*/

/*
 * txt 는 utf-8 로 인코딩 , 영문 텍스트
 */
public class File12Main {

	private static final String BIG_TEXT = "temp/big_eng.txt";

	public static void main(String[] args) {
		System.out.println("FileReader / FileWriter");

		FileWriter fw = null;
		FileReader fr = null;

		BufferedReader br = null;
		BufferedWriter bw = null;
		int charRead = 0;
		int charsCopied = 0; // 복사한 문자의 개수

		long startTime, endTime, elapsedTime;
		startTime = System.currentTimeMillis();
		System.out.println("FileReader / FileWriter  만 사용");
		try {
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy1.txt"); // 파일을 읽어서 복사할거임

			while ((charRead = fr.read()) != -1) {
				// read() 는 한글자식 읽어서 return 더이상 읽을 것이 없으면 -1 리턴
				fw.write(charRead);
				charsCopied++;
			}
			fw.flush(); // ------------------------------------꼭 해줘야함
			endTime = System.currentTimeMillis();

			elapsedTime = endTime - startTime;
			System.out.println("걸리는 시간은 : " + elapsedTime + "milisec");

			System.out.println("읽 고 쓴 문 자 수 : " + charsCopied);

			// ---------------------------------------------------------------------------------------------
			fw.close();
			fr.close();
			// ---------------------------------------------------------------------------------------------
			System.out.println();
			System.out.println("bufferedReader / bufferedWrite + 버퍼 사용");
			fr = new FileReader(BIG_TEXT);
			fw = new FileWriter("temp/big_eng_copy2.txt");
			br = new BufferedReader(fr);
			bw = new BufferedWriter(fw);

			char[] buf = new char[1024]; // 1024바이트의 버퍼
			int charsRead = 0; // 버퍼에 몇글자 읽어들였나??
			charsCopied = 0; // 0으로 다시 초기화

			startTime = System.currentTimeMillis();
			
			while( (charsRead = br.read(buf)) != -1){
				bw.write(buf,0,charsRead);
				charsCopied += charsRead;
			}
			
			endTime = System.currentTimeMillis();
			elapsedTime = endTime - startTime;
			
			System.out.println("걸리는 시간은 : " + elapsedTime + "milisec");

			System.out.println("읽 고 쓴 문 자 수 : " + charsCopied);
			
			
			
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (br != null)
					br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		System.out.println("\n프로그램 종료");

	} // end main()
} // end class
