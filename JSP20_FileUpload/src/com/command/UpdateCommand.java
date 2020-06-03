package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.FileDTO;
import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class UpdateCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		
//		view는 uid로 봄
		
		WriteDTO[] arr = null;  //초기값
		WriteDAO dao = new WriteDAO();
		
		FileDAO fileDao = new FileDAO();
		FileDTO[] fileArr = null;
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		
		try {
			arr = dao.selectByUid(uid);
			request.setAttribute("update", arr);
			if(arr != null && arr.length == 1) {
				fileArr = fileDao.selectFilesByWrUid(uid);
				request.setAttribute("file", fileArr);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	

}
