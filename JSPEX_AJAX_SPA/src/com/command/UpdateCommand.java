package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		WriteDTO[] arr = null;  //초기값
		WriteDAO dao = new WriteDAO();
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		if(uid < 0 ) uid = 1;
		try {
			arr = dao.selectByUid(uid);
			request.setAttribute("update", arr);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
