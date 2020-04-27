package 선택제어문.자가진단09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int a;
		int b;
		int c;
		a=scan.nextInt();
		b=scan.nextInt();
		c=scan.nextInt();
		
		int min = (a < b) ? a : b;
		min = (min < c) ? min : c;
		
		System.out.println(min);
		
		
		scan.close();
	}

}
