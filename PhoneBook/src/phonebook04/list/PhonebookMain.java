package phonebook04.list;

import java.util.InputMismatchException;
import java.util.Scanner;

//           M - V - C 중에          			*** VIEW ***          역할 
//		사용자와의 입출력 담당 (	UI,...)
//	
public class PhonebookMain {

	Scanner sc;
	private PhonebookManager pbCtrl; // CONTROLLER 객체

	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init(); // 초기화
		app.run(); // 실행
		app.exit(); // 종료
	} // end main()

	// 응용프로그램을 초기화
	public void init() {
		sc = new Scanner(System.in);
		pbCtrl = PhonebookManager.getInstance(); // Controller 객체 생성 (singleton)
	}

	// 응용프로그램 구동
	public void run() {
		System.out.println(Pb.VERSION); // 전화번호부 2.0 출력

		int menu;    
		while (true) {
			showMenu(); // 메뉴 표시
			try {
				menu = sc.nextInt(); // 메뉴 입력
				sc.nextLine();

				switch (menu) { // 상수화 하는게 좋음
				case Menu.MENU_INSERT:
					insertPhoneBook();
					break;
				case Menu.MENU_LIST:
					listPhonebook();
					break;
				case Menu.MENU_DELETE:
					deletePhonebook();
					break;
				case Menu.MENU_UPDATE:
					updatePhonebook();
					break;
				case Menu.MENU_QUIT:
					System.out.println("프로그램을 종료합니다");
					return;
				default:
					System.out.println("잘못 입력하셨습니다.");
				}// end switch
				
			} catch (PhonebookException e) {
				System.out.println(e.getMessage());   //오버라이딩 된 메세지 함수가 나옴.
			} catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다");
				sc.nextLine();  //버퍼 비우기
			}

		} // end while
	} // end run()

	// 응용프로그램 종료
	public void exit() {
		sc.close();
	}

	// 전화번호부 입력
	public void insertPhoneBook() {
		// VIEW 역할 : 사용자 입출력
		System.out.println("==== 입력 메뉴 ====");

		// 이름, 전화번호, 이메일 입력
		System.out.print("이름 입력:");
		String name = sc.nextLine();

		System.out.print("전화번호 입력:");
		String phoneNum = sc.nextLine();

		System.out.print("메모 입력:");
		String memo = sc.nextLine();

		// Controller 에 연결
		int result = pbCtrl.insert(name, phoneNum, memo); // 클래스 이름 . 메서드 이름 == static 메서드
		
	}

	// 전화번호부 열람
	public void listPhonebook() {
		// Controller 연결
		PhonebookModel[] data = pbCtrl.selectAll();

		// VIEW 역할 : 사용자 입출력
		System.out.println("총 " + data.length + "명의 전화번호 출력");
		for (PhonebookModel e : data) { // data 는 phonbookmodel 타입의 변수 배열
			System.out.println(e);
		}
	}

	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[0] 종료");
		System.out.println("[1] 입력"); // crud - c
		System.out.println("[2] 열람"); // crud - r
		System.out.println("[3] 수정"); // crud - u
		System.out.println("[4] 삭제"); // crud - d
		System.out.println("------------------");
		System.out.print("선택: ");
	}

	// 전화번호부 수정
	public void updatePhonebook() {
		// VIEW 역할 : 사용자 입출력
		System.out.println("=== 수정 메뉴 ===");
		System.out.println("수정할 번호를 입력 하세요");
		int uid = sc.nextInt();
		sc.nextLine(); // 버퍼 지우기

		// Controller 연결
		if (pbCtrl.selectByUid(uid) == null) {
			System.out.println("존재하지 않는 uid 값 입니다 " + uid);
			return;
		}

		// 이름, 전화번호, 이메일 입력
		System.out.print("이름 입력:");
		String name = sc.nextLine();

		System.out.print("전화번호 입력:");
		String phoneNum = sc.nextLine();

		System.out.print("메모 입력:");
		String memo = sc.nextLine();

		// Controller 연결 ====> 수정작업
		int result = pbCtrl.updateByUid(uid, name, phoneNum, memo);
		
		System.out.println(result + " 개의 전화번호 수정 성공");
		

	}

	public void deletePhonebook() {
		// view : 사용자 입출력
		System.out.println("==== 삭제 메뉴 ====");
		System.out.println("삭제할 번호 입력 : ");
		int uid = sc.nextInt();
		sc.nextLine(); // 버퍼지우기

		// Controller 연결
		int result = pbCtrl.deleteByUid(uid);
		
		System.out.println(result+ " 개의 전화번호 삭제");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

} // end class
