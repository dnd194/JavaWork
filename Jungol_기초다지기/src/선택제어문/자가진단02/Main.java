package 선택제어문.자가진단02;

import java.util.Scanner;

/*“몸무게+100-키”를 비만수치 공식이라고 하자.

키와 몸무게를 자연수로 입력받아 첫 번째 줄에 비만수치를 출력하고, 비만수치가 0보다 크면 다음줄에 비만("Obesity")이라는 메시지를 출력하는 프로그램을 작성하시오. (출력형식은 아래 출력 예를 참고하세요.)
*/
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int height;
		int weight;
		height = scan.nextInt();
		weight = scan.nextInt();
		
		
		int bmi = weight + 100 - height;
		System.out.println(bmi);
		if(bmi >0 ) {
			System.out.println("Obesity");
		}
	}

}
