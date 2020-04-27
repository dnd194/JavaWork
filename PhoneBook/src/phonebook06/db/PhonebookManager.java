package phonebook06.db;

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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;







// CONTROLLER 객체      ---> 컨트롤러에서는 데이터를 줘야만 하지  직접 출력을 해서는 안된다.
// 		어플리케이션의 동작, 데이터처리(CRUD), (Business logic 담당)

public class PhonebookManager implements Pb, Closeable  {

	//DB를 위한 변수들 선언
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	
	
	
	// -************************************************************ singleton 적용
	private PhonebookManager() {
		
		//TODO : JDBC 프로그래밍 
		//클래스 로딩 그런거 다 박으세여
		
		//STATEMENT(필요하다면 만드세여 ^^)생성
		//conn은 계속 유지가 되어야함
		try {
			Class.forName(DRIVER);
			System.out.println("드라이버 클래스 로딩 성공");
			
			// DB Connection
			conn = DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("DB Connection 성공");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
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

		//TODO DML INSERT 구문 
		//REturn 그거 하세여    
		//sql_insert 사용하여서 하세여
		//			preparedStatement 사용
		//여기서 close 해줘야함
		int cnt = 0;
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1,name);
			pstmt.setString(2,phoneNum);
			pstmt.setString(3,memo);
			cnt = pstmt.executeUpdate();
			
			System.out.println(cnt + "개 행(row) INSERT 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return cnt;
	}

	@Override
	public PhonebookModel[] selectAll() {
		List<PhonebookModel> pbList = new ArrayList<PhonebookModel>();
		//TODO
		//sql_select_all 사용하세여 ^^
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				
				int uid = rs.getInt(COL_LABEL_UID);
				String name = rs.getString(COL_LABEL_NAME);
				String phonenum = rs.getString(COL_LABEL_PHONENUM);
				String memo = rs.getString(COL_LABEL_MEMO);
				Date regdate = rs.getDate(COL_LABEL_REGDATE);
				pbList.add(new PhonebookModel(name, phonenum, memo, uid, regdate));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(pstmt != null)
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pbList.toArray(new PhonebookModel[pbList.size()]); //이것도 수정해야함  오류안나게 널값 너은거임
	}

	// 특정 uid의 데이터 검색 리턴
	// 못찾으면 null 리턴
	@Override
	public PhonebookModel selectByUid(int uid) { // get
		
		//TODO 
		// 이거 query 문은 알아서 만드세여 ^^          시간 남으면 하세염 ^^
		PhonebookModel p1 = null;
		
		try {
			
			pstmt=conn.prepareStatement(SQL_SELECT_BY_UID);
			pstmt.setInt(1, uid);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				p1=new PhonebookModel();
				p1.setUid(uid);
				p1.setName(rs.getString(COL_LABEL_NAME));
				p1.setPhoneNum(rs.getString(COL_LABEL_PHONENUM));
				p1.setMemo(rs.getString(COL_LABEL_MEMO));
				p1.setRegDate((rs.getDate(COL_LABEL_REGDATE)));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
				try {
					if(rs != null)
					rs.close();
					if(pstmt != null)
						pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return p1; // 못찾으면 null 값 리턴
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

		int cnt = 0; 
		try {
			
			pstmt=conn.prepareStatement(SQL_UPDATE_BY_UID);
			pstmt.setString(1, name);
			pstmt.setString(2, phoneNum);
			pstmt.setString(3, memo);
			pstmt.setInt(4, uid);
			
			cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행(row) UPDATE 성공");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				
				if(pstmt !=null)
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//SQL_UPDATE_BY_UID 사용
		
		
		return cnt;   
	}

	@Override
	public int deleteByUid(int uid) { // remove

		// 매개변수 검증
		if (uid < 1) {
			throw new PhonebookException("deleteByUid() uid 오류  : " + uid, Pb.ERR_UID);
		}
		
		int cnt = 0;
		//TODO
		//DELETE BY UID 사용
		try {
			pstmt=conn.prepareStatement(SQL_DELETE_BY_UID);
			pstmt.setInt(1, uid);
			cnt=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	// 현재 데이터중 가장 큰 uid 값을 찾아서 리턴
	private int getMaxUid() { // 인터페이스에 없는 메서드
		int maxUid = 0;

		// TODO  옵션 ^^  MAX 쓰면되는데 하지마

		return maxUid;
	}


	public void close() throws IOException { // close() 오버라이딩
		//TODO
		//자원 닫기 
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
