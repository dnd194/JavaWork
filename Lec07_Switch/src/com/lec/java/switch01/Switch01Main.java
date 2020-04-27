package com.lec.java.switch01;

/* switch - case 조건문
 * 
 * 	switch (조건값){
 * 	case 값1:
 * 		...
 * 	case 값2:
 * 		...
 *	default:
 *		...
 *	}
 *
 * 	해당 조건의 case문을 찾아서 거기서부터 break를 만날 때까지 실행을 함.
 *  *****************  break를 만나게 되면 switch 문장을 종료.
 *  해당하는 case가 없으면 default 문장을 실행함.
 *  
 *  	※ 모든 switch 조건문은 if - else if - else로 바꿀 수 있다. (할수 있어야 한다)
 */
public class Switch01Main {

	public static void main(String[] args) {
		System.out.println("switch 문");

		int num = 3;
		switch (num) {
		case 1:
			System.out.println("하나");
			System.out.println("one");
			break; // switch 안에서의 수행 종료 break가 없을경우 그 다음 case도 수행

		case 2:
			System.out.println("둘");
			System.out.println("two");
			break;
		case 3:
			System.out.println("셋");
			System.out.println("three");
			break;

		default: // 아무런 해당사항이 없을 떄 나오는 문구
			System.out.println("몰라염");
			break;
		}

		System.out.println();

		// 모든 switch 조건문 if - else if - else로 바꿀 수 있다.
		if (num == 1) {
			System.out.println("하나");
			System.out.println("one");
		} else if (num == 2) {
			System.out.println("둘");
			System.out.println("two");
		} else if (num == 3) {
			System.out.println("셋");
			System.out.println("three");
		} else {
			System.out.println("몰라염");
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
