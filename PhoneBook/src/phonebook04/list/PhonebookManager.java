package phonebook04.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


// CONTROLLER 객체      ---> 컨트롤러에서는 데이터를 줘야만 하지  직접 출력을 해서는 안된다.
// 		어플리케이션의 동작, 데이터처리(CRUD), (Business logic 담당)


public class PhonebookManager implements Pb {

	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
	
	
	
	// -************************************************************  singleton 적용                
	private PhonebookManager() {
	}
	private static PhonebookManager instance = null;
	public static PhonebookManager getInstance() {
		if(instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}
	
	// 전화번호부 생성 등록  (CRUD - Create)   add
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		
		//매개변수 검증 ==========> 이름은 필수  없으면 안되도록
		if(name == null || name.trim().length() == 0) {             //null 도 안되고 '비어있는문자' 도 안됨
			throw new PhonebookException("insert() 이름 입력 오류",Pb.ERR_EMPTY_STRING);  //runtimeException 이라서 강요하지는 않고 있음
		}
		
		PhonebookModel p1 = new PhonebookModel(name, phoneNum, memo);
//		System.out.println(p1.getUid());
		p1.setUid(getMaxUid()+1);          //상관은 없는데 애지간하면 순차적으로 하는걸 추천
		pbList.add(p1);
//		p1.setUid(getMaxUid());
		
		
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		
		return pbList.toArray(new PhonebookModel[pbList.size()]);    //List<> 배열로 변환하는 코드
		//TODO ; 
		//자바는 배열의 길이가 '0' 인 배열도 리턴 해 줄 수 있다
	}
	
	
	
	//특정 uid의 데이터 검색 리턴
	//못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {    //get
		
		//TODO
		for(int index = 0; index < pbList.size(); index++) {
			if(pbList.get(index).getUid() == uid) {
				return pbList.get(index);
			}
		}
		
		
		return null;     // 못찾으면 null 값 리턴 
	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {    //set

		//매개변수 검증
		if(uid < 1) {
			throw new PhonebookException("update() uid 오류  : "+uid, Pb.ERR_UID);
		}
		if(name == null || name.trim().length() == 0) {
			throw new PhonebookException("update() 이름입력 오류: ",Pb.ERR_EMPTY_STRING);//이름필수
		}
		
		//특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if(index<0) {
			throw new PhonebookException("update() 없는 uid : "+uid, Pb.ERR_UID);
		}
		//TODO
		
//		pbList.set(index, new PhonebookModel(name, phoneNum, memo));   //=>>> 여기서 index 매기는 오류가 나오는듯  (이거는 통쨰로 바꾸는거)
		
//		--------------------------------------------------------------------------------------------------------
		
		
		pbList.get(index).setName(name);                  //이렇게 각각 접근해서 바꿔줘야 index 오류가 생기지 않음
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);
		
		
		
		return 1;
	}

	@Override
	public int deleteByUid(int uid) {                //remove
		
		//매개변수 검증
		if(uid < 1) {
			throw new PhonebookException("deleteByUid() uid 오류  : "+uid, Pb.ERR_UID);
		}
		int index = findIndexByUid(uid);
		if(index<0) {
			throw new PhonebookException("deleteByUid() 없는 uid : "+uid, Pb.ERR_UID);
		}
		
		//TODO
		pbList.remove(index);
		
		return 1;
	}
	
	//현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {              //인터페이스에 없는 메서드
		int maxUid = 0 ;
		
		//TODO
		for(int index = 0 ; index < pbList.size(); index++) {
			if(maxUid<pbList.get(index).getUid()) {
				maxUid = pbList.get(index).getUid();
//				System.out.println(maxUid);
			}
		}
		
		
		
		
		return maxUid;
	}
	
	//특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	//못찾으면  ' -1 ' 리턴
	private int findIndexByUid(int uid) { 		//인터페이스에 없는 메서드
		
		//TODO
		for(int index = 0; index < pbList.size(); index++) {
			if(pbList.get(index).getUid() == uid) {
				return index;
			}
		}
		return -1;
		
		
	}
	
	

}  //END PHONEBOOKMANAGER

// 예외 클래스 정의
// 예외 발생하면 '에러코드' + '에러메세지' 를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException{
	private int errCode = Pb.ERR_GENERIC;
	
	//생성자
	public PhonebookException() {
		super("Phonebook 예외 발생");
	}
	
	public PhonebookException(String msg) {
		super(msg);
	}
	public PhonebookException(String msg, int errCode) {
		super(msg);
		this.errCode = errCode;
	}
	@Override
	public String getMessage() {

		String msg = "ERR-"+errCode+"]"+Pb.ERR_STR[errCode]+
						" "+super.getMessage();
		
		return msg;
	}
	
	
	
}



























