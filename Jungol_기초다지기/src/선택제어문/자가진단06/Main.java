package 선택제어문.자가진단06;

import java.util.Scanner;

//남자는 'M' 여자는 'F'로 나타내기로 하고 18세 이상을 성인이라고 하자.
//
////성별('M', 'F')과 나이를 입력받아 "MAN"(성인남자), "WOMAN"(성인여자), "BOY"(미성년남자), "GIRL"(미성년여자)을 구분하여 출력하는 프로그램을 작성하시오.
public class Main {

	public static void main(String[] args) {

		
		Scanner scan = new Scanner(System.in);
		String gender = scan.next();
		
		int age = scan.nextInt();
		
		switch (gender) {
		case "M":
		case "m":
			if(age >= 18) {
				System.out.println("MAN(성인남자)");
			}else {
				System.out.println("BOY(미성년남자)");
			}
			break;
		case "f":
		case "F":
			if(age >= 18) {
				System.out.println("WOMAN(성인여자)");
			}else {
				System.out.println("GIRL(미성년여자)");
			}
			break;
		default:
			break;
		}
		
		
		
		
		scan.close();
		
		
		
		
		
	}

}
