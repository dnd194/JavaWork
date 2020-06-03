package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.FileDAO;
import com.lec.beans.WriteDAO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		//첨부파일을 지울거니까 filedao 가 필요한거야
		FileDAO fileDao = new FileDAO();
		
		
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		try {
			//첨부파일 삭제
			//1. 물리적인 파일 삭제
			//2. test_file 테이블 삭제
			fileDao.deleteByWrUid(uid, request);
			
			//3.글 삭제
//.			
			cnt = dao.deleteByUid(uid);
		}catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("delete", cnt);
	}

}
