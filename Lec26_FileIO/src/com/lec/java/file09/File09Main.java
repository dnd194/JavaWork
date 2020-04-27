package com.lec.java.file09;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import com.lec.java.file08.Member;

// Object Filter Stream + Collection

// Program <=== ObjectInputStream <=== FileInputStream <=== File
// Program ===> ObjectOutputStream ===> FileOutputStream ===> File

// ArrayList<> 와 같은 Collection 에서,
// 모든 데이터들이 Serializable 되어 있으면 ObjectInputStream / ObjectOutputStream 으로
// read/write 가능.

public class File09Main {
	
	public static final String FILEPATH  = "temp/member2.dat";

	public static void main(String[] args) {
		System.out.println("Object Filter Stream");


		try(
				InputStream in = new FileInputStream(FILEPATH);
				ObjectInputStream oin = new ObjectInputStream(in);
				OutputStream out = new FileOutputStream(FILEPATH);
				ObjectOutputStream oout = new ObjectOutputStream(out);
				){
			ArrayList<Member> list = new ArrayList<Member>();
			
			Member m1 = new Member("root", "root234");
			Member m2 = new Member("guest", "guest");
			Member m3 = new Member("산빈","12344");			
			// 리스트에 저장
			list.add(m1);
			list.add(m2);
			list.add(m3);
			
			oout.writeObject(list);  // list를 한번에 저장
			list = null;
			
			list = (ArrayList<Member> )oin.readObject();
			for(Member m : list) {
				m.displayInfo();
			}
			
			//2. 무한루프로 호출하는 readObject 호출하는 방법...
			// 더이상 읽을 object가 없을 경우 EOF Exception 으로 잡기  
			// EOF : End Of File  ==> 파일의 끝에 도달
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(EOFException e ) {
			System.out.println("파일 끝까지 읽었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("\n프로그램 종료");
		
	} // end main()

} // end class File08Main
















