package com.lec.java.input02;

import java.util.Scanner;
//ctrl + shift + o 자동 import


//문자열(String) 입력
//char 입력
public class Input02Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("표준 입력 : String, char");
		
		Scanner scan = new Scanner(System.in);
/*		
//		String 입력
		System.out.print("이름을 입력하세염 : ");
		String name = scan.nextLine(); //enter를 입력하기 전까지의 모든 문자를 담는다.
		
		System.out.print("별명을 입력하세여 : ");
		String nickname = scan.nextLine();
		
//		System.out.println("이름은 "+name+" 별명은 "+nickname);
		
		//char 입력
		// .nextChar() 라는 명령어는 없다. 
		System.out.print("성별을 입력하세요: ");
		char gender = scan.next().charAt(0);
		
		System.out.println("이름은 "+name+" 별명은 "+nickname+" 성별은 "+gender);
*/
		System.out.println("나이를 입력하세여 : ");
		int age= scan.nextInt();
		
		System.out.println();
		
		System.out.println("주소를 입력하세여 :");
		scan.nextLine(); //consume 해주기 위한 nextLine 아래 주석 참고
		
		String address = scan.nextLine();
		
		
		
		//키보드는 버퍼가 있기때문에 엔터가 들어오면 종료되는 nextline()특성상 처리를해줘야함
		
		// ** 숫자를 입력받은 뒤에 문자열 입력시에는 반드시 '/n'을 consume(버퍼에서 제거) 해야한다.
		
		System.out.println("나이는 "+age+" 주소는 "+address);
		
		scan.close();
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
