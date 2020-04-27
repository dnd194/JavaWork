package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");

		ArrayList<MemberModel> arr = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {

			String id, pw;
			System.out.println("id 를 입력하세요");
			id=sc.nextLine();
			System.out.println("pw를 입력하세요");
			pw=sc.nextLine();
			
			
			//둘다 문자열이라서 버퍼제거가 필요가 없다
			MemberModel m1 = new MemberModel(id, pw);

			arr.add(m1);

			m1.displayInfo();

		}
		System.out.println(arr);

		Iterator<MemberModel> itr = arr.iterator();
		while(itr.hasNext()) {
			itr.next().displayInfo();
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
