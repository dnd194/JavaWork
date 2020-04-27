package com.lec.java.array11;

/* for와 enhanced for의 차이점
	 enhanced for문에서는 배열의 원소를 꺼내서
	 변수에 복사(저장)해서 사용하는 것입니다.
	 즉, 배열의 원소를 직접 변경하는 것은 불가능하다.
 */
public class Array11Main {

	public static void main(String[] args) {
		System.out.println("for와 enhanced for의 차이점");
		int [] arr1 = {10,20,30,40,50};
		System.out.println();
		//배열의 원소를 1씩 증가 시키기
		System.out.println("증가 전");
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i] +" ");
		}
		System.out.println();
		System.out.println("증가 후");
		for (int i = 0; i < arr1.length; i++) {
			arr1[i]+=1;
		}
		for (int i = 0; i < arr1.length; i++) {
			System.out.print(arr1[i]+ " ");
		}
		
		System.out.println("\n\nenhanced for 문 증가 후");
		int[] arr2 = {10,20,30,40,50};
		for ( int num : arr2) {
			num+=1;
		}
		for ( int num : arr2) {
			System.out.println(num);
		}
		
		
		
		
		
	} // end main()

} // end class Array11Main









