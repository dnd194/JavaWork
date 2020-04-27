package 반복제어문1.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Scanner scan = new Scanner(System.in);
		
		int sum = 0;
		int count=0;
		int n;
		for(;;) {
			n=scan.nextInt();
			sum += n;
			count++;
			if(n>100) {
				sum-=n;
				count--;
				break;
			}
		}
		scan.close();
		System.out.println("sum : "+sum);
		System.out.printf("avg : %.1f",(double)sum/count);
		
	}

}
