package com.lec.java.oop06;

import java.util.Scanner;

public class Interface02Main {

	public static void main(String[] args) {
		System.out.println("인터페이스");

		Scanner scan = new Scanner(System.in);
		System.out.println("메뉴 선택: ");
		int menu = scan.nextInt();

		scan.close();

		switch (menu) {
		case Menu.MENU_QUIT:
			System.out.println(Menu.STR_QUIT);
			return;
		case Menu.MENU_INSERT:
			System.out.println(Menu.STR_INSERT);
			break;
		case Menu.MENU_SEARCH:
			System.out.println(Menu.STR_SEARCH);
			break;
		default:
			System.out.println(Menu.STR_ERROR);
			break;
		}

		switch (menu) {     //리터럴 사용은 가급적 자제  위에처럼 상수를 이용하는 게 좋음
		case 0:
			System.out.println("프로그램 종료");
			return;
		case 1:
			System.out.println("입력 메뉴");
			break;
		case 2:
			System.out.println("검색 메뉴");
			break;

		default:
			System.out.println("잘 못 입력했습니다");
			break;
		}

		System.out.println("\n 프로그램 종료");
	} // end main()

} // end class
