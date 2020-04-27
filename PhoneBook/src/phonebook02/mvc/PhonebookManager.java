package phonebook02.mvc;

import java.util.Arrays;

// CONTROLLER 객체
// 		어플리케이션의 동작, 데이터처리(CRUD), (Business logic 담당)


public class PhonebookManager implements PhonebookController {

	//최대 데이터 개수
	public static final int MAX_DATA = 3;
	
	
	//	배열로 구현.
	private PhonebookModel[] pbList = new PhonebookModel[MAX_DATA];             //처음에는 3개 짜리 (MAX_DATA=3)  배열로 시작  ( 배열이 다 차면 새로운 배열을 만드는 구조 +3 개 씩 )
	
	// 몇개의 데이터가 저장되었는지 관리해야함
	private int count = 0 ;
	
	
	
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
	
	// 전화번호부 생성 등록  (CRUD - Create)
	@Override
	public int insert(String name, String phoneNum, String memo) {
		
		int result = PhonebookController.QEURY_FAIL;    //QUERY_FAIL 는 상수 값 0
		//매개변수 검증 ==========> 이름은 필수  없으면 안되도록
		if(name == null || name.trim().length() == 0) {             //null 도 안되고 '비어있는문자' 도 안됨
			return result;
		}
		
		
		
		//만약 배열이 다 차있으면 , MAX_DATA(3) 만큼 추가된 새 배열 생성
		if(count == pbList.length) {
			pbList = Arrays.copyOf(pbList, pbList.length+MAX_DATA);    //  기존의 있던 데이터들은 copy 하고 새로운 공간에는 null값이 자동적으로 저장됨  ==>   pbList에 덮어씌움 
			
		}
		pbList[count] = new PhonebookModel(name, phoneNum, memo);
		pbList[count].setUid(getMaxUid()+1);    //기존의 최대  uid 값보다 1증가한 값. (uniqie 한 값을 보장하기 위해서)
		//uid 와 배열 index 는 다르다 것 ******
		count++;  //카운트 1증가
		
		
		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {
		return Arrays.copyOfRange(pbList, 0, count);             // 0 ~ count 직전 까지의 배열을 복사해서 리턴 
		//자바는 배열의 길이가 '0' 인 배열도 리턴 해 줄 수 있다
	}
	
	
	
	//특정 uid의 데이터 검색 리턴
	//못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) {
		
		for(int index = 0; index < count; index++) {
			if(pbList[index].getUid() == uid) {
				return pbList[index];  //uid 값 발견하면 리턴
			}
		}
		
		
		return null;     // 못찾으면 null 값 리턴 
	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) {

		int result = PhonebookController.QEURY_FAIL;
		//매개변수 검증
		if(uid < 1) return result;
		if(name == null || name.trim().length() == 0) return result;    //이름필수
		
		
		
		
		
		//특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if(index<0) return result;           //result = 상수값 0
		
		pbList[index].setName(name);
		pbList[index].setPhoneNum(phoneNum);
		pbList[index].setMemo(memo);
		result = 1;  //수정 성공
		
		return result;
	}

	@Override
	public int deleteByUid(int uid) {
		int result = PhonebookController.QEURY_FAIL;
		
		//매개변수 검증
		if(uid < 1) return result;
		int index = findIndexByUid(uid);
		if(index < 0) return result;
		
		//배열 뒤의 원소들을 앞으로 이동
		for(int i = index, j=index+1; j<count; i++ , j++) {
			// j 에 있는 것을 i로 땡겨오는것
			pbList[i] = pbList[j];
		}
		count--;
		result = 1;
		return result;
	}
	
	//현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() {                    //인터페이스에 없는 메서드
		int maxUid = 0 ;
		
		for(int index = 0; index < count; index ++) {             //count는 data의 개수
			if(maxUid < pbList[index].getUid()) {
				maxUid = pbList[index].getUid();
			}
		}
		
		return maxUid;
	}
	
	//특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	//못찾으면  ' -1 ' 리턴
	private int findIndexByUid(int uid) { 		//인터페이스에 없는 메서드
		
		for(int index = 0; index < count; index++) {
			if(pbList[index].getUid() == uid) {
				return index;
			}
		}
		return -1;
		
		
	}
	
	
	
	
	
	
	

}
