package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		//TODO:
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		//  for, Enhanced-for, Iterator

		ArrayList<String> arr = new ArrayList<String>();
		arr.add("안녕하세요");
		arr.add("제 이름은 ");
		arr.add("임상빈입니다");
		arr.add("나이는");
		arr.add("3 입니다");
		arr.add("감사합니다");
		
		for(int i = 0 ; i<arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		
		arr.set(4, "27 입니댜");
		System.out.println();
		
		
		for(String e : arr) {           //enhanced for 
			System.out.println(e);
		}
		
		arr.remove(1);
		arr.remove(arr.size()-1);
		System.out.println();
		
		
		Iterator<String> itr = arr.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












