package 선택제어문.자가진단07;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String a = scan.nextLine();
		
		switch (a) {
		case "A":
			System.out.println("Excellent");
			break;

		case "B":
			System.out.println("Good");
			break;
		case "C":
			System.out.println("Usually");
			break;
		case "D":
			System.out.println("Effort");
			break;
		case "F":
			System.out.println("Failure");
			break;

		default:
			System.out.println("error");
			break;
		}
	}

}
