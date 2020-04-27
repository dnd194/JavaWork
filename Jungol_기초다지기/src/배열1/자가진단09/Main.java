package 배열1.자가진단09;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=0;
		int n = 0;
		Scanner scan = new Scanner(System.in);
		int[] arr= new int[10];
		for ( i = 0; i < arr.length; i++) {
			arr[i]= scan.nextInt();
		}
		Arrays.sort(arr);
		for (i = 0; i<arr.length; i++) {
			n= arr.length - i;
			System.out.print(arr[n-1]+ " ");
		}
//		n = arr.length - i
		
//		System.out.println(Arrays.toString(arr));
//		//cycle
//		for(int a = arr.length; a>0; a--) {
//			for(int j =0; j< i-1; j++) {
//				if(arr[j] < arr[j+1]) {
//					int temp = arr[i];
//					arr[j] = arr[j+1];
//					arr[j+1] = temp;
//					
//				}
//			}
//		}
//		
	}
	
}
