package com.command.write;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ViewCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		
//		view는 uid로 봄
		
		WriteDTO[] arr = null;  //초기값
		WriteDAO dao = new WriteDAO();
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		if(uid < 0 ) uid = 1;
		try {
			arr = dao.readByUid(uid);
			request.setAttribute("view", arr);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
