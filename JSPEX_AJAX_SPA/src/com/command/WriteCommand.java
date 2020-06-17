package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int cnt = 0;
		WriteDAO dao = new WriteDAO();

		// 매개변수 받아오기 . 매개변수들은 이제 전부다 request에 있다
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		// ------------ Ajax Response 에 필요한 값들-----------------------------------
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본은 FAIL로 설정

		//유효성 체크
		if(name == null || name.trim().length() == 0) {
			message.append("[유효하지않은 parameter: 작성자 필수]");
		}else if(subject == null || subject.trim().length() == 0){
			message.append("[유효하지않은 parameter: 글 제목(subject) 필수]");
		}else {
	
			try {
				cnt = dao.insert(subject, content, name);
				if(cnt == 0) {
					message.append("[트랜젝션 실패 : 0 insert");
				}else {
					status = "Ok";
				}
			} catch (Exception e) {
//				e.printStackTrace(); 
				message.append("[트랜젝션 에러 :" + e.getMessage()+"]");
			}
		} // end if
		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
	}// end execute

}// end command
