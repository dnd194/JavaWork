package phonebook05.file;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

// CONTROLLER 객체      ---> 컨트롤러에서는 데이터를 줘야만 하지  직접 출력을 해서는 안된다.
// 		어플리케이션의 동작, 데이터처리(CRUD), (Business logic 담당)

public class PhonebookManager implements Pb, Closeable {

	private ArrayList<PhonebookModel> pbList = new ArrayList<PhonebookModel>();

	public static final String PB_DATA_DIR = "data";

	public static final String PB_DATA_FILE = "phonebook.dat"; // data 폴더에 phonebook.dat 이름으로 저장

	private File pbDir;
	private File pbFile;

	// -************************************************************ singleton 적용
	private PhonebookManager() {
		
		pbDir = new File(PB_DATA_DIR);   //폴더 생성
		if(!pbDir.exists()) {
			if(!pbDir.mkdir()) {
				System.out.println("폴 더 생성 성공");
			}else {
				System.out.println("폴 더 생성 실패");
			}
		}else {
			System.out.println("폴더가 이미 존재 :"+pbDir.getAbsolutePath() );
		}
		
		pbFile = new File(pbDir, PB_DATA_FILE);   //파일 생성
		if(pbFile.exists()) {
			System.out.println("파일의 데이터를  읽습니다..");
			try (InputStream in = new FileInputStream(pbFile);
					ObjectInputStream oin = new ObjectInputStream(in);
					
					) {
				pbList = (ArrayList<PhonebookModel>) oin.readObject();
				// file09 참고 (캐스팅)해줘야함  
			}
				// 파일이 존재하면 파일 읽어들이기 --> pblist;
				// 읽어 들이려 할 때 없으면 filenotfound exception 으로 만들면 됨 될듯 catch로 잡고 만들기??
				catch (FileNotFoundException e) {
					System.out.println("저장된게 없슙니다");
					
				} catch (IOException e) {
					
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					
					e.printStackTrace();
				}
		
		}else {
			System.out.println("읽어올 파일이 없습니다.");
		}
	}

	private static PhonebookManager instance = null;

	public static PhonebookManager getInstance() {
		if (instance == null) {
			instance = new PhonebookManager();
		}
		return instance;
	}

	// 전화번호부 생성 등록 (CRUD - Create) add
	@Override
	public int insert(String name, String phoneNum, String memo) {

		// 매개변수 검증 ==========> 이름은 필수 없으면 안되도록
		if (name == null || name.trim().length() == 0) { // null 도 안되고 '비어있는문자' 도 안됨
			throw new PhonebookException("insert() 이름 입력 오류", Pb.ERR_EMPTY_STRING); // runtimeException 이라서 강요하지는 않고 있음
		}

		PhonebookModel p1 = new PhonebookModel(name, phoneNum, memo);
//		System.out.println(p1.getUid());
		p1.setUid(getMaxUid() + 1); // 상관은 없는데 애지간하면 순차적으로 하는걸 추천
		pbList.add(p1);
//		p1.setUid(getMaxUid());

		return 1;
	}

	@Override
	public PhonebookModel[] selectAll() {

		return pbList.toArray(new PhonebookModel[pbList.size()]); // List<> 배열로 변환하는 코드
		// 자바는 배열의 길이가 '0' 인 배열도 리턴 해 줄 수 있다
	}

	// 특정 uid의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) { // get

		for (int index = 0; index < pbList.size(); index++) {
			if (pbList.get(index).getUid() == uid) {
				return pbList.get(index);
			}
		}

		return null; // 못찾으면 null 값 리턴
	}

	@Override
	public int updateByUid(int uid, String name, String phoneNum, String memo) { // set

		// 매개변수 검증
		if (uid < 1) {
			throw new PhonebookException("update() uid 오류  : " + uid, Pb.ERR_UID);
		}
		if (name == null || name.trim().length() == 0) {
			throw new PhonebookException("update() 이름입력 오류: ", Pb.ERR_EMPTY_STRING);// 이름필수
		}

		// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
		int index = findIndexByUid(uid);
		if (index < 0) {
			throw new PhonebookException("update() 없는 uid : " + uid, Pb.ERR_UID);
		}

//		pbList.set(index, new PhonebookModel(name, phoneNum, memo));   //=>>> 여기서 index 매기는 오류가 나오는듯  (이거는 통쨰로 바꾸는거)

//		--------------------------------------------------------------------------------------------------------

		pbList.get(index).setName(name); // 이렇게 각각 접근해서 바꿔줘야 index 오류가 생기지 않음
		pbList.get(index).setPhoneNum(phoneNum);
		pbList.get(index).setMemo(memo);

		return 1;
	}

	@Override
	public int deleteByUid(int uid) { // remove

		// 매개변수 검증
		if (uid < 1) {
			throw new PhonebookException("deleteByUid() uid 오류  : " + uid, Pb.ERR_UID);
		}
		int index = findIndexByUid(uid);
		if (index < 0) {
			throw new PhonebookException("deleteByUid() 없는 uid : " + uid, Pb.ERR_UID);
		}

		pbList.remove(index);

		return 1;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() { // 인터페이스에 없는 메서드
		int maxUid = 0;

		// TODO
		for (int index = 0; index < pbList.size(); index++) {
			if (maxUid < pbList.get(index).getUid()) {
				maxUid = pbList.get(index).getUid();
//				System.out.println(maxUid);
			}
		}

		return maxUid;
	}

	// 특정 uid 값을 가진 데이터의 배열 인덱스 찾기
	// 못찾으면 ' -1 ' 리턴
	private int findIndexByUid(int uid) { // 인터페이스에 없는 메서드

		// TODO
		for (int index = 0; index < pbList.size(); index++) {
			if (pbList.get(index).getUid() == uid) {
				return index;
			}
		}
		return -1;

	}

	public void close() throws IOException { // close() 오버라이딩
		// TODO 여태까지의 파일을 저장하도록 해야할듯
		// 저장할 때 지정된 폴더에 write 하도록??
		// close 하는 습관을 가집시다! try-with-resource
		// 저장이 안될 수도 있음
		try (OutputStream out = new FileOutputStream(pbFile);
				ObjectOutputStream oout = new ObjectOutputStream(out);

		) {
			oout.writeObject(pbList);
			System.out.println("파일 저장 완료");

		}
	}

} // END PHONEBOOKMANAGER

// 예외 클래스 정의
// 예외 발생하면 '에러코드' + '에러메세지' 를 부여하여 관리하는게 좋다.
class PhonebookException extends RuntimeException {
	private int errCode = Pb.ERR_GENERIC;

	// 생성자
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

		String msg = "ERR-" + errCode + "]" + Pb.ERR_STR[errCode] + " " + super.getMessage();

		return msg;
	}

}
