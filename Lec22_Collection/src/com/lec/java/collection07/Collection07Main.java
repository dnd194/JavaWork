package com.lec.java.collection07;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// TODO
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		// iterator, enhanced-for 문을 사용해서 출력해보기
		
		HashSet<String> set = new HashSet<String>();
		Scanner sc = new Scanner(System.in);
		String data;
		String remove;
		for(int i = 0 ; i<5; i++) {
			System.out.println("데이터를 입력하세여");
			 data = sc.nextLine();
			
			set.add(data);
		}
		System.out.println("삭제해보세여");
		set.remove(remove=sc.nextLine());
		
		
		
		System.out.println("Iterator() 사용");
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("수정 해보세여");
		String update;
		set.remove(remove=sc.nextLine());
		set.add(update=sc.nextLine());
		
		System.out.println(" 강화 포문");
		for(String e : set) {
			System.out.print(e+" ");
		}
		
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















