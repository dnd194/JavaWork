package phonebook01.class01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PhonebookModel {
	private String name;
	private String phoneNum;
	private String email;
	private int uid; // unique id
	private Date regDate; // 등록일시
	// 기본 생성자

	public PhonebookModel() {
		this.name = "";
		this.phoneNum = "";
		this.email = "";
		this.regDate = new Date(); // 생성되는 현재시간.
	}

	// 매개변수 생성자
	public PhonebookModel(String name, String phoneNum, String email) {
		this();                 //여기서 날짜가 생성됨 ==> 기본생성자를 호출하므로
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	public PhonebookModel(String name, String phoneNum, String email, int uid, Date regDate) {
		super();
		// 전부 다 있는 버전
		this.name = name;
		this.phoneNum = phoneNum;
		this.email = email;
		this.uid = uid;
		this.regDate = regDate;
	}

	// getter / setter
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		String str = String.format("%3d| %s| %s| %s| %20s",uid, name, phoneNum, email,
										new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate));  
																//date (연 월 일 시 분초)

		return str;
	}

}
