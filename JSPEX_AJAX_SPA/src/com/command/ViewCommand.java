package com.command;

import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lec.beans.*;
public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO();
		WriteDTO [] arr = null;
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		String param = request.getParameter("uid");
		
		// 유효성 검사
		if(param == null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else {			
			try {
				int uid = Integer.parseInt(param);
				
				arr = dao.readByUid(uid);  // 읽기 + 조회수 증가
				
				if(arr == null) {
					message.append("[해당 데이터가 없습니다]");
				} else {
					status = "OK";
				}
				
			} catch (SQLException e) {  
				//e.printStackTrace();
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			} catch (Exception e) {
				message.append("[예외발생:" + e.getMessage() + "]");
			}// end try
		} // end if

		request.setAttribute("list", arr);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());

	}

}
