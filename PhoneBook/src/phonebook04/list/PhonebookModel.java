package phonebook04.list;

import java.text.SimpleDateFormat;
import java.util.Date;


//                MODEL (M  V  C  중에 MODEL)
//				데이터 표현 객체               (데이터를 저장하는 객체가 아님)
public class PhonebookModel {
	private String name;
	private String phoneNum;
	private String memo;           //			메모 
	private int uid; // unique id
	private Date regDate; // 등록일시
	// 기본 생성자

	public PhonebookModel() {
		this.name = "";
		this.phoneNum = "";
		this.memo = "";
		this.regDate = new Date(); // 생성되는 현재시간.
	}

	// 매개변수 생성자
	public PhonebookModel(String name, String phoneNum, String memo) {
		this();                 //여기서 날짜가 생성됨 ==> 기본생성자를 호출하므로
		this.name = name;
		this.phoneNum = phoneNum;
		this.memo = memo;
	}

	public PhonebookModel(String name, String phoneNum, String memo, int uid, Date regDate) {
		super();
		// 전부 다 있는 버전
		this.name = name;
		this.phoneNum = phoneNum;
		this.memo = memo;
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

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		String str = String.format("%3d| %s| %s| %s| %20s",uid, name, phoneNum, memo,
										new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(regDate));  
																//date (연 월 일 시 분초)
		return str;
	}

}
