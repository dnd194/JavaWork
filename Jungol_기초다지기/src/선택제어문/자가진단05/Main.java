package 선택제어문.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		float a;
		float b;
		a=scan.nextFloat();
		b=scan.nextFloat();
		if(a >= 4.0 && b>=4.0) {
			
			System.out.println("A");
		}
		else if (a>=3.0 && b>=3.0)  {
			
			System.out.println("B");
			
		}else {
			System.out.println("C");
		}
		
	}

}
