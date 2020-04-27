package 선택제어문.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		float weight = scan.nextFloat();
		
		if (weight > 88.45) {
			System.out.println("Heavyweight");
		}else if(weight <= 88.45 && weight > 72.57) {
			System.out.println("Cruiserweight");
		}else if(weight <= 72.57&& weight >61.23) {
			System.out.println("Middleweight");
		}else if(weight <= 61.23 && weight > 50.80) {
			System.out.println("Lightweight");
		}else if(weight <= 50.80) {
			System.out.println("Flyweight");
		}
		
		scan.close();
	}

}
