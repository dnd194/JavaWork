package practice.cardcompany;

//by 윤종섭
public class Company {

	// 필요한 변수, 메소드, 생성자 정의하기
	// 카드번호
	private int cardNumber = 10000;
	
	// default Constructor
	private Company() {}
	
	// instance 주소
	private static Company instance = null;
	// instance 생성, 중복 확인
	static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}

	// 카드 발급
	public Card createCard() {
		cardNumber++;
		return new Card(cardNumber);
	}
	

} // end class
