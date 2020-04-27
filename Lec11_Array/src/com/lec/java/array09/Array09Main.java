package com.lec.java.array09;

/* ragged array: column(열)의 개수가 일정하지 않은 배열

	가변 배열 선언 방법: 행의 개수만 지정을 하고, 열의 개수는 비워둠
	열(column)이 몇 개가 될 지 모르기 때문에 메모리 할당이 되지 않습니다.
	
	=>nullpointexception
 */
public class Array09Main {

	public static void main(String[] args) {
		System.out.println("Ragged Array(가변 배열)");   // 각 각 다른 열( colume ) 을 가져도 된다.
		
//		int[] arr[];    2개다 가능은하지만 되도록 자바식으로 만들것 ===> 보기 쉽게
//		int arr[][];
		
		int[][] arr = new int[3][];  //int[] 3개 짜리 2차원배열 객체만 생성
		
		arr[0] = new int[] {10};    //길이가 1인 배열
		arr[1] = new int[] {20,30};    //길이가 2인 배열
		arr[2] = new int[] {40,50,60};
		
		int[] tmp = arr[1];
		arr[1] = arr[2];
		arr[2] = tmp;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]+" ");
				
			}
			System.out.println();
		}
	} // end main()

} // end class Array09Main

