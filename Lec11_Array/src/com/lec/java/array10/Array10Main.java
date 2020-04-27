package com.lec.java.array10;

/* Enhanced for (향상된 for) 문
 	
 	for (배열타입 변수 : 배열이름) { ... }
 	
 */
public class Array10Main {

	public static void main(String[] args) {
		
		int[] arr = {11,22,33,44,55};
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

		System.out.println();
		
		System.out.println("Enhanced for (향상된 for) 문");
		for ( int a : arr) {       //arr 에 담겨져 있을 변수 가 필요 ==> a
			System.out.println(a);
		}
		System.out.println("2차원 배열에서 enhanced for 문 사용");
		
		int[][] arr2 = {
				{1,2},
				{3,4,5,6},
				{7,8,9}
		};
		for (int[] row : arr2) {              //1차원배열로 한법 뽑고 , 1차원배열에 담겨져 있는 인트형을 받아서 마무리
			for (int e : row) {
				System.out.print(e+" ");
			}
		}
		
		
		
		
		
		
		
		
	} // end main()

} // end class Array10Main









