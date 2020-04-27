package com.lec.java.collection11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/* Map<K, V>, HashMap<K, V>
	 Collection<E>
	  |__ List<E>, Set<E>
	
	 List<E>
	  |__ ArrayList<E>, LinkedList<E>
	
	 Set<E>
	  |__ HashSet<E>, TreeSet<E>
	
	 Map<K, V>
	  |__ HashMap<K, V>, TreeMap<K, V>
	
	 Map: key-value 저장 방식의 자료 구조
	  1. key는 중복되지 않는 값만 허용
	  2. value는 같더라도 key 값이 다르면 저장 가능
	  3. 검색, 수정, 삭제를 할 때 key를 사용
*/


public class Collection11Main {

	public static void main(String[] args) {
		System.out.println("HashMap 클래스");
		
		// HashMap 인스턴스 생성
		// Key - Integer 타입
		// Value - String 타입
		HashMap<Integer, String> hmap = new HashMap<Integer, String>();
		// 데이터 저장: put() 메소드 사용
		// put()할때 새로운 key 값이면 null 리턴
		//          기존의 key 값이면 기존의 값을 리턴
		
		System.out.println(hmap.put(1, "kim"));
		System.out.println(hmap.put(2, "im"));
		System.out.println(hmap.put(3, "lee"));
		System.out.println(hmap.put(4, "kal"));
		System.out.println(hmap.put(4, "quaaa"));
//		hmap.put(1, "kim");
//		hmap.put(2, "im");
//		hmap.put(3, "lee");
//		hmap.put(4, "kal");
//		hmap.put(4, "quaaa");      //    kal    --->>     quaaa
		// 같은 키 값으로 데이터를 put하게 되면, 기존 값이 수정(replace)이 됨.
		
		// 저장된 데이터 개수 확인 : size()
		System.out.println(hmap.size());
		
		System.out.println();
		
		
		// 데이터 읽기
		// get(key) 사용해서 읽기
		System.out.println(hmap.get(1));
		System.out.println(hmap.get(3));
		System.out.println(hmap.get(100));

		//데이터 삭제
		//remove(key) : 삭제된 value 리턴
		System.out.println("삭제 : "+hmap.remove(2));
		
		
		
		
		// 방법1 HashMap에서 Iterator 사용
		// 1. HashMap의 keySet() 메소드를 사용해서
		// 저장된 키(key)값들로만 이루어진 Set을 만듬.
		// 2. 1에서 만들어진 Set에 있는 iterator() 메소드를 사용해서
		// Iterator를 생성

		Set<Integer> keySet = hmap.keySet();   // key 값은 integer 이기때문
		Iterator<Integer> itr = keySet.iterator();
		while(itr.hasNext()) {
			int key = itr.next();
			System.out.println(key +" : "+hmap.get(key));
		}
		
		System.out.println();
		
		// 방법2 : Map.Entry 사용
		// entrySet() 은 Set<Entry<Integer, String>> 리턴함

		for ( Map.Entry<Integer, String> m : hmap.entrySet()) {
			System.out.println(m.getKey() + " : "+m.getValue());
		}
		
		
		System.out.println();
		
		// 도전과제
		// arr[] = {2, 4, 5, 4, 3, 3, 4}
		// 주어진 배열이 위와 같을때 다음과 같이 발생회수 나타내기 
		
		// key : value
		// 2 : 1개 
		// 3 : 2개 
		// 4 : 3개 
		// 5 : 1개
		
		System.out.println("HashMap 응용: 배열에서 발생빈도 구하기");
		int arr[] = {2, 4, 5, 4, 3, 3, 4,2,4,1,2,5,6,4,3,1,2,3,1,2,3,3};
		// TODO
		printFreq(arr);
		
		System.out.println("\n프로그램 종료");
	} // end main()

	static void printFreq(int arr[]) {
		HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
		
		//발생빈도
		for (int i = 0; i < arr.length; i++) {
			Integer v = hmap.get(arr[i]);  //    v에 key 값이 담김  ===>        arr[i] 가 key
			if(v==null) {   //기존에 해당 키값이 없는 경우   == 처음 등장한 경우
				
				hmap.put(arr[i], 1);	//	등장 횟수 1 
				
			}else {     // 최소한 한번 등장했다 라는 것을 의미
				hmap.put(arr[i],v+1);
			}
			
		}
		for(Map.Entry<Integer, Integer> e : hmap.entrySet()) {
			System.out.println(e.getKey() + " : "+ e.getValue()+"개");
		}
		
		
		
	}
	
} // end class















