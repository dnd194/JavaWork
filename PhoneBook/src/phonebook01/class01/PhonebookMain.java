package phonebook01.class01;

import java.util.Scanner;

public class PhonebookMain {

	Scanner sc;
	PhonebookModel [] bookData = new PhonebookModel[5]; 
	
	public static void main(String[] args) {
		PhonebookMain app = new PhonebookMain();
		app.init();   // 초기화
		app.run();   // 실행
		app.exit();   // 종료
	} // end main()
	
	// 응용프로그램을 초기화 
	public void init() {
		sc = new Scanner(System.in);
	}
	
	// 응용프로그램 구동
	public void run() {
		System.out.println("전화번호부 v1.0");
		
		while(true) {
			showMenu();  // 메뉴 표시
			
			int menu = sc.nextInt(); // 메뉴 입력
			sc.nextLine();
			
			switch(menu) {
			case 1:
				System.out.println("전화번호부를 입력합니다");
				insertPhoneBook();
				break;
			case 2:
				System.out.println("전화번호부 출력(열람)");
				showPhoneBook();
				break;
			case 3:
				System.out.println("프로그램을 종료합니다");
				return;
			default:
				System.out.println("잘못 입력하셨습니다");
			}
			
		} // end while	
	} // end run()
	
	// 응용프로그램 종료
	public void exit() {
		sc.close();
	}	
	
	// 전화번호부 입력
	public void insertPhoneBook() {
		
		// 전화번호부가 다 찼는지 체크
		int i;
		for(i = 0; i < bookData.length; i++) {
			if(bookData[i] == null) break;
		}
		// 다 찼으면 입력불가 처리
		if(i == bookData.length) {
			System.out.println("전화번호부가 다 찼습니다");
			return;
		}
		
		// 이름, 전화번호, 이메일 입력
		System.out.print("이름 입력:");
		String name = sc.nextLine();

		System.out.print("전화번호 입력:");
		String phoneNum = sc.nextLine();
		
		System.out.print("이메일 입력:");
		String email = sc.nextLine();
		
		// --> PhonebookModel 인스턴스 생성
		PhonebookModel pb = new PhonebookModel(name, phoneNum, email);
		pb.setUid(i);   //i를 고유한 값으로 설정
		
		// 배열에 추가
		bookData[i] = pb;
		System.out.println((i + 1) + "번째 전화번호부 추가 성공");
	}
	
	// 전화번호부 출력
	public void showPhoneBook() {
		// 배열안에 저장된 전화번호부들 출력.
		int i;
		for(i = 0; i < bookData.length; i++) {
			PhonebookModel pb = bookData[i];
			if(pb == null) break;
			
			System.out.println(pb);
		}
		System.out.println(i + " 개의 전화번호부 출력");
	}
	
	
	
	public void showMenu() {
		System.out.println();
		System.out.println("전화번호부 프로그램");
		System.out.println("------------------");
		System.out.println("[1] 입력");
		System.out.println("[2] 열람");
		System.out.println("[3] 종료");
		System.out.println("------------------");
		System.out.print("선택: ");
	}

} // end class















