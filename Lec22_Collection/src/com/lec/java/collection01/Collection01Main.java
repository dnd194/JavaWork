package com.lec.java.collection01;

import java.util.ArrayList;
import java.util.Iterator;

/* ArrayList<E>
	 ※계층도 숙지 중요
	
	 Collection<E>
	  |__ List<E>
	       |__ ArrayList<E>, LinkedList<E>
	
	 List 특징(ArrayList와 LinkedList의 공통점)
	 1. 중복 저장 허용
	 2. 저장 순서 유지 (인덱스 존재)
	
	 ArrayList:
	 1. 저장 용량을 늘리는 데 많은 시간 소요 - 단점
	 2. 데이터를 삭제하는 데 많은 연산 - 단점
	 3. 데이터 참조 매우 빠름 - 장점
	
	 LinkedList:
	 1. 저장 용량을 늘리는 과정이 매우 간단 - 장점
	 2. 데이터를 삭제하는 과정이 간단 - 장점
	 3. 데이터 참조가 불편 - 단점
	 
	 
	 ※ Vector<E> <-- ArrayList 와 비슷하나... ArrayList 추천.
*/


public class Collection01Main {

	public static void main(String[] args) {
		System.out.println("ArrayList<E>");
		
		// ArrayList 선언 - ArrayList 인스턴스 생성
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		
		// 데이터 추가(저장): add(element) 메소드 사용
		//               add(index, element) -> index 번째 삽입
		
		
		list1.add(100);
		list1.add(300);
		list1.add(400);
		list1.add(400);
		list1.add(500);  
		list1.add(3, 1);    // 3번째 index 에  1 을 추가
		
		
		// 데이터 참조(읽기, 검색): get(index) 메소드 사용
		// size(): ArrayList의 크기를 반환(리턴)
		System.out.println("list1.size() : "+list1.size());
//		System.out.println("list[1] : "+list1.get(1));
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("list["+i+"] : " + list1.get(i));
		}
		
		// 데이터 삭제: remove(index) 메소드 사용
		list1.remove(3);     
		System.out.println("삭제 후 ");
	
		for (int i = 0; i < list1.size(); i++) {
			System.out.println("list["+i+"] : " + list1.get(i));
		}
		// 데이터 수정: set(index, element) 메소드 사용
		list1.set(4, 00);

		// ArrayList 출력 방법
		// 1) for
		// 2) Enhanced-for 사용
		// 3) Iterator(반복자) 사용
		// 4) forEach() 사용

		System.out.println("Enhanced for를 사용한 출력");
		// Enhanced for 사용 가능
		for( Integer e  : list1) {
			System.out.println(e);
		}
		
		System.out.println("Iterator 를 사용한 출력");
		// Iterator(반복자) 사용법
		// iterator() 메소드를 사용해서 인스턴스 생성
		
		// hasNext(): iterator가 다음 원소를 가지고 있는 지         (true/false) 를 리턴      token이랑 비슷
		// next(): 현재 iterator 위치의 원소를 값을 리턴하고,
		//   iterator의 위치를 다음 원소의 위치로 변경
		Iterator<Integer> itr = list1.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		System.out.println("forEach() 를 사용한 출력");
		// forEach() + functional interface
		// Java8 부터 등장
		list1.forEach(System.out::println);
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class










