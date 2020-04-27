package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		
		//TODO:
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서
		// 3가지 방법으로 출력해보세요. 
		// for, Enhanced-for, Iterator
		Scanner sc = new Scanner(System.in);
		ArrayList<Student> list = new ArrayList<Student>();
		
//		Score score = new Score(100,200,300);
//		
//		Student student = new Student(0, "ㅇㅇㅇ", score);
//		
//		list.add(student);
//		
//		System.out.println(list);
		
		
		for(int i = 0 ; i<3; i++) {
			int id,a,b,c;
			String name;
			id = sc.nextInt();
			sc.nextLine();
			name = sc.nextLine();
			
			a=sc.nextInt();
			b=sc.nextInt();
			c=sc.nextInt();
			
			Student student = new Student(id,name,new Score(a,b,c));
			
			list.add(student);
		}
			
			System.out.println(list);
		
		
		
		
		System.out.println("\n프로그램 종료");
	}

	

} // end class









