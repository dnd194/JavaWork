package 반복제어문3.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		int i = scan.nextInt();
		for (int a = 1; a < 6; a++) {
			for (int b = 1; b <= a; b++) {
				System.out.print("*");
				if(a==i) {
					
				}
			}
			System.out.println();

		}
	}

}
