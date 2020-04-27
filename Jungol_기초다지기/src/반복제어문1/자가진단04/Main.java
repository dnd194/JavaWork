package 반복제어문1.자가진단04;

import java.util.Scanner;


//1 2 3 4 5 6 7 8 9 10 100 입력 값
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int i =0;
//		int count=1;
//		int sum=0;
		Scanner scan = new Scanner(System.in);
//		while(i <= 100) {
//			i = scan.nextInt();
//			
//			sum +=i;
//			
//			count++;
//			
//			
//		}
//		float avg = sum / count;
//		System.out.println(sum);
//		System.out.printf("%.1f",avg);
//		
		int n;
		int sum =0, count = 0;
		
		for(;;) {
			n=scan.nextInt();
			sum += n;
			count++;
			if(n>=100) break;
		}
		System.out.println(sum);
		System.out.printf("%.1f",(double)sum/count);

		
		
		
		scan.close();
	}

}

