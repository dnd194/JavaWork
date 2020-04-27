package com.lec.java.collection05;

import java.util.LinkedList;

/* LinkedList

	Collection<E>
	 |__ List<E>
	      |__ ArrayList<E>, LinkedList<E>
	
	 List:
	 1. 중복 저장 허용
	 2. 저장 순서 유지(인덱스 존재)
	
	ArrayList:
	1. 저장 용량을 늘리는 데 많은 시간 소요 - 단점
	2. 데이터를 삭제하는 데 많은 연산 - 단점
	3. 데이터 참조 매우 빠름 - 장점
	
	LinkedList:
	1. 저장 용량을 늘리는 과정이 매우 간단 - 장점
	2. 데이터를 삭제하는 과정이 간단 - 장점
	3. 데이터 참조가 불편 - 단점
	
	
	*********************************************************************   Arraylist 쓰세여  
	*사용법은 arraylist 와 똑같음 
*/

public class Collection05Main {

	public static void main(String[] args) {
		System.out.println("Linked List");
		
		// Integer 타입을 저장할 수 있는 LinkedList 인스턴스 생성
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		
		
		// LinkedList에 데이터 저장: add()
		// TODO
		
		System.out.println();
		
		// 검색: get()
		// TODO
		
		System.out.println();
		
		// 데이터 삭제: remove()
		// TODO
		
		System.out.println();
		
		
		// 데이터 수정: set()
		// TODO
		
		System.out.println();
		
		// Iterator 만들어서 데이터 출력
		System.out.println("Iterator 사용");
		// TODO
		
		System.out.println();
		// Java 8에 있는 forEach() 메소드
		System.out.println("Java 8 forEach()메소드");
		// TODO

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class











