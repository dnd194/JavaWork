package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class UpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();

		// 매개변수 받아오기 . 매개변수들은 이제 전부다 request에 있다
		String param = request.getParameter("uid");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		// ------------ Ajax Response 에 필요한 값들-----------------------------------
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본은 FAIL로 설정
		if(param == null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		}else if (subject == null || subject.trim().length() == 0){
			message.append("[유효하지않은 parameter: 글 제목(subject) 필수]");
		}else {
			
			try {
				int uid = Integer.parseInt(param);
				cnt = dao.update(uid, subject, content);
				status = "Ok";
				if(cnt == 0) {
					message.append("[0 update]");
				}
			} catch (SQLException e) {
				message.append("[트랜젝션 에러 : "+e.getMessage()+"]");
			}catch(Exception e) {
				message.append("[유효하지 않은 parameter]" +param );
			}
		}

		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
	}

}
