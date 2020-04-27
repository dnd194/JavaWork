package 반복제어문3.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		
		for(int i = 0; i<a; i++) {
			for(int j = 0; j<=i; j++) {
				System.out.print("*");
				
			}
			System.out.println();
		}
	}

}
