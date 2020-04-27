package practice.cardcompany;

/* 
 * 카드회사가 있습니다. 카드회사는 '유일한 객체' 이고, 
 * 이 회사에서는 카드를 발급하면 항상 '고유번호' 가 자동으로 생성됩니다.
 * 10001 부터 시작하여 카드가 생성될때마다 10002, 10003 식으로 증가됩니다.
 * 다음 코드가 수행되도록 Card클래스와 Company 클래스를 구현하세요
 */

public class CardCompanyMain {

	// ★ 아래 main() 코드는 손대지 마세요 ★
	public static void main(String[] args) {
//// 주석해제하세요
		Company com = Company.getInstance();  // 싱글톤 패턴
		Company company = Company.getInstance();  // 여러번 호출해도 동일 객체
				
		// ↓ '동일객체' 라고 결과가 나와야 한다.
		System.out.println((com == company) ? "동일객체" : "다른객체");
		
		Card myCard = company.createCard();  // 첫번째 카드생성 고유번호 10001 부여 
		Card yourCard = company.createCard();
		
		//클래스 이름.메서드 이름 ==> static 메서드
		
		System.out.println(myCard.getCardNumber());  // 10001 출력
		System.out.println(yourCard.getCardNumber()); // 10002출력			 
		
	} // end main

} // end class
