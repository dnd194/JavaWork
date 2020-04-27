package com.lec.java.collection08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enhanced-for 등을 
		// 사용하여 출력해보기
		Scanner sc = new Scanner(System.in);
		HashSet<MyClass> list = new HashSet<MyClass>();
		for(int i = 0 ; i < 3; i++) {
			
			int id;
			String name;
			System.out.println("id를 입력하세요");
			id=sc.nextInt();
			sc.nextLine();
			System.out.println("이름을 입력하세요");
			name = sc.nextLine();
			
			MyClass mc = new MyClass(id,name);
			
			list.add(mc);
			
		}
		System.out.println(list);
		// 데이터 3개 저장
		// TODO
		
		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		Iterator<MyClass> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println();
		System.out.println("enhanced for");
			
		for(MyClass e : list) {
			System.out.println(e);
		}
		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()
} // end class

