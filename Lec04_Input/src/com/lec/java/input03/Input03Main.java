package com.lec.java.input03;

import java.util.Scanner;

public class Input03Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("nextline() vs  next() ");
		
		Scanner scan = new Scanner(System.in);
		
		//nextline()
		
		/*System.out.print("여러 단어의 문장을 입력 > ");
		String line = scan.nextLine(); // ENTER를 치기전까지 한라인 전체 입력

		System.out.println("line = "+line);
		
		
		//next() *********문자열을 입력받음
		//다음 단어(token, 띄어쓰기로 구분되는 단어)을 받아서 String 으로 결과 리턴
		//입력을 한줄로해도 되고 엔터이후에 해도됨
		 * 
		System.out.print("여러 단어의 문장을 입력 > ");
		String token1 = scan.next(); //aaa bbb ccc
		
		//token1에는 aaa만 출력되지만 bbb ccc는 버퍼에 남아있다
		System.out.println("token1 = "+token1);
		
		//next()를 다시 실행시키면
		//기존의 버퍼에 담겨있는 내용 확인가능
		String token2 = scan.next();
		System.out.println("token2 = "+token2);
		
		String token3 = scan.next();
		System.out.println("token3 = "+token3);
		
		
		//nextInt(), nextDouble() <-- next() 처럼 동작함
		
		//따라서 숫자타입도 여러개를 '한줄'로 입력받을 수 있다.
		
		*/
		System.out.println("숫자 3개(int, double, int)를 입력받으세요");
		
		int i1 = scan.nextInt();
		
		double d1= scan.nextDouble();
		
		int i2= scan.nextInt();
		
		System.out.println("i1, d1, i2 : "+i1+", "+d1+", "+i2);
		
		//웹이나 앱에서 받은 데이터는 무조건 문자열
		//그래서 변환하는 작업이 필요 !!
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		scan.close();
		
	}

}
