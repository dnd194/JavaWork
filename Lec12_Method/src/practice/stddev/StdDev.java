package practice.stddev;

import java.util.Arrays;
import java.util.Random;

public class StdDev {

	public static void main(String[] args) {

		
		// 임의정수 5개로 초기화한 정수로    //random 함수 사용하면 될듯??
		Random random = new Random();
		int[] arr = new int[5];
		for(int i = 0; i<arr.length; i++) {
			arr[i] = ((random.nextInt(100)+1));   // 1~ 100 까지의 랜덤정수 생성 후 배열에 담는다
			
			System.out.print(arr[i] +" ");
		}
		
//		//과제확인용 배열 88 76 81 55 36
//		int[]arr = {81, 76, 81 ,55 ,36} ;
//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(arr[i] +" ");
//		}
		
		
		System.out.println();			//줄 바꿈
		// 평균, 분산, 표준편차 구하기
		System.out.println("평균 : "+calcAvg(arr));
		System.out.printf("분산 : %.2f",calcVariance(arr));
		System.out.println();
		System.out.println("표준편차 : "+calcStdDev(arr));
	} // end main
	
	/**
	 * 메소드 이름 : calcAvg
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '평균값' 리턴
	 */
	public static double calcAvg(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		double avg = (double)sum / arr.length;
		
		return avg;
		
		
	}
	
	/**
	 * 메소드 이름 : calcVariance
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '분산값' 리턴
	 */
	public static double calcVariance(int[]arr) {
		double diff[] = new double[5];
		double vSum=0;		//편차 제곱의 합
		double variance;    //분산
		for (int i = 0; i < arr.length; i++) {
			diff[i]= arr[i] - calcAvg(arr);
//			System.out.print(diff[i]+ " ");  // 편차를 출력 
			vSum += diff[i]*diff[i];   		 //편차 제곱의 총 합
		}
		
		variance = vSum/arr.length;   //분산 의 연산공식
		
		return variance;			//분산 return
	}	
	/**
	 * 메소드 이름 : calcStdDev
	 * 매개변수 : int []
	 * 리턴값 : double
	 * 
	 * 주어진 배열의 '표준편차' 리턴
	 */
	public static double calcStdDev(int[] arr) {
		double stddev = Math.sqrt(calcVariance(arr));
		
		
		return stddev;
	}
} // end class
