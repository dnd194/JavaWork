package com.command.write;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class UpdateOkCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		//매개변수 받아오기  .   매개변수들은 이제 전부다 request에 있다
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		
			try {
				cnt = dao.update(uid, subject, content);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		request.setAttribute("updateOk", cnt);
	}

}
