package 반복제어문2.형성평가08;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		int j = scan.nextInt();
	
		for(int a=1; a<=i; a++) {
			for(int b=1; b<=j; b++) {
				System.out.print(a*b+" ");
			}
			System.out.println();
		}
	}

}
