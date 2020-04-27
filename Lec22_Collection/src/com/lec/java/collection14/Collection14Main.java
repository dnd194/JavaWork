package com.lec.java.collection14;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* java.util.Collections 클래스
	 Collections 클래스는 여러 유용한 알고리즘을 구현한 메소드들을 제공
	 대부분 클래스메소드 (static) 형태로 제공됨
	 
	 정렬(sort)
	 섞기(shuffle)
	 탐색(search)
 */

public class Collection14Main {

	public static void main(String[] args) throws ParseException {
		System.out.println("Collections 메소드");

		List<String> list1 = new LinkedList<String>(); // --> 다형성에 의해서 가능

		list1.add("장수영");
		list1.add("김진영");
		list1.add("고유성");

		System.out.println(list1); // --> list 는 toString 메서드가 있어서 이렇게 바로 찍으면 됨

		System.out.println("sort()");
		// sort() 정렬
		// 기본적으로 속도가 비교적 빠르고 안전성이 보장되는 Merge Sort 사용

		Collections.sort(list1); // collection 의 정렬 함수 오름차순으로 정렬됨
		System.out.println(list1);

		List<Date> list2 = new LinkedList<Date>();
		// "2018-08-16" --> Date 객체
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2017-04-06")); // ==> "2017-04-06" 이 Date 객체로 parse 되고 Date
																			// 객체 생성
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2020-03-27")); // 하고 list2 에 집어넣음
		list2.add(new SimpleDateFormat("yyyy-MM-dd").parse("2015-07-07"));

		System.out.println(list2);
		Collections.sort(list2); // 날짜를 '''오름차순''' 으로 정렬
		System.out.println(list2);

		// String 타입이면 알파벳 순으로 정렬된다.
		// Date 타입이면 날짜순으로 정렬된다
		// ★ String 과 Date 는 기본적으로 Comparable<T> 인터페이스가 구현되었기 때문.
		// ※ String 온라인 도움말 확인해보자

		System.out.println();
		List<Student> list3 = new LinkedList<Student>();
		list3.add(new Student("Zedd", 50));
		list3.add(new Student("James", 70));
		list3.add(new Student("Kelvin", 40));
		System.out.println(list3);

		System.out.println("Comparable 구현, sort() 적용");

		Collections.sort(list3); // 이거 에러남 이거는 대소비교가 불가 Comparable<T>이 구현이 안되어있기때문에 안되는거임
		System.out.println(list3); // 그래서 아래에서 구현했음 compareTo 그러면 에러가 나지않음

		// Student 에 comparable이 구현이 되지않으면 에러가 나므로 사용할때 주의 할 것
		// '점수' 에 대한 정렬

		// 역순 정렬
		System.out.println("reverseOrder() 적용");
		Collections.sort(list3, Collections.reverseOrder()); // Student 제네릭을 가진 'comparator'를 반환함 '점수'
																// 일종의 ''분류기'' 같은거
		System.out.println(list3);

		System.out.println("reverse() 적용"); // 이것도 차순을 뒤짚음 ==> 그냥 자체적인 기능 '점수'
		Collections.reverse(list3);
		System.out.println(list3);
		System.out.println();
		// Comparator<> 적용
		// Collections.sort 메소드는 두 번째 인자로 Comparator 인터페이스를 받을 수 있도록 해놓았습니다.
		// Comparator 인터페이스의 compare 메소드를 오버라이드 하면 됩니다.

		System.out.println("Comparator<> 적용");
		System.out.println("Compatator<> 적용 오름차순");
		Collections.sort(list3, new Asc()); // ==> '이름' 에대한 오름차순으로 바뀜
		System.out.println(list3);
		System.out.println();

		//  '이름' 내림차순
		System.out.println("Compatator<> 적용 내림차순");
		Collections.sort(list3, new Desc());
		System.out.println(list3);
		System.out.println();
		
		// Collections 에서 많이 쓰이는 인터페이스임
		// Comparable 은 클래스 자체에 구현하는 인터페이스 compareTo(자기사진 vs 매개변수)
		// Comparator 는 두개의 객체 비교하는 기능제공 인터페이스 compare(매개변수1 vs 매개변수2)
		// 구현된 객체가 매개변수 등에 넘겨지는 형태로 많이 쓰임

		// Shuffling 하기 (섞기)   할떄 마다 바뀜
		System.out.println();
		System.out.println("shuffle()");
		Collections.shuffle(list1);
		System.out.println(list1);
		Collections.shuffle(list1);
		System.out.println(list1);

		String[] arr = {"aaa","bbb","ccc","Ddd","fff"};
		//배열은 shuffle이 없어서 List 로 바꿔줘야함
		List<String >arrList = Arrays.asList(arr);  //   ==>  배열 [] 을 --> List<> 로 변환       List<> 의 toArray 와 반대  
		Collections.shuffle(arrList);
		arrList = arrList.subList(0, 3);      //index 0 부터 3 전까지의 List<>를 생성하고 기존에 arrList에 덮어 씌움
		
		System.out.println(arrList);
		
		
		// min(), max()
		// Comparable 메소드 영향 받음
		System.out.println();
		System.out.println("min(), max()");
		
		System.out.println(Collections.min(list1));
		System.out.println(Collections.max(list1));

		
		System.out.println(Collections.min(list3));
		System.out.println(Collections.max(list3));    //정의가 된대로 min 과 max 가 나옴  
		

		// copy()
		System.out.println();
		List<Student> list4 = new LinkedList<Student>();
		list4.add(new Student("ㅇㅇㅇ",10));
		list4.add(new Student("ㅌㅌㅌ",30));
		list4.add(new Student("ㅡㅡㅡ",50));
		
		System.out.println("copy() 전");
		System.out.println(list4);
		
		System.out.println("copy() 후");
		Collections.copy(list4, list3);    // 복사할 배열, 복사 배열
		System.out.println(list4);
		
		
		
		System.out.println("\n프로그램 종료");
	} // end main

} // end class

// 우선은 Comparable 구현 없이 해보자
class Student implements Comparable<Student> {
	String name;
	double point;

	public Student(String name, double point) {
		super();
		this.name = name;
		this.point = point;
	}

	@Override
	public String toString() {
		return this.name + ":" + this.point + "점";
	}

	// compareTo 메서드는 매개변수 객체를 자신과 비교하여 작으면 음수, 같으면 0 , 크면 양수를 return 한다.
	@Override
	public int compareTo(Student o) {
		// 정수형 반환하는 함수

		// 점수 오름차순
		/*
		 * if(o.point > this.point) return -1; //작으면 음수
		 * 
		 * if(o.point < this.point) return 1; //크면 양수
		 * 
		 * return 0; //같으면 0
		 */

		// 점수 내림차순 오름차순과 부등호를 반대로하면 내림차순으로 바뀜
		if (o.point < this.point)
			return -1; // 작으면 음수
		if (o.point > this.point)
			return 1;
		return 0;
	}

	// TODO

} // end class

//Student 를 오름차순으로 정렬해주는 comparator<> 제공       ''' 이름'''
class Asc implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// 매개변수를 2개를 받음

		// 이름으로 정렬
		int result = o1.name.compareTo(o2.name); // String은 이미 compareTo가 있어서 쉽게 나옴

		return result;
		// return o1.name.compareTo(o2.name); 이렇게 한줄로 해도 됨
	}

	// TODO

} // end Asc

//Student 를 내림차순으로 정렬해주는 comparator<> 제공           ''' 이름'''
class Desc implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		
		int result = o2.name.compareTo(o1.name);
		
		return result;
	}

	// TODO

} // end Asc
