package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		//매개변수 받아오기  .   매개변수들은 이제 전부다 request에 있다
		String name = request.getParameter("name");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		if(name != null && subject !=null 
				&& name.trim().length()>0 && subject.trim().length()>0) {
			
			try {
				cnt = dao.insert(subject, content, name);
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}//end if
		
		request.setAttribute("result", cnt);
		//result 로 담았으니 꺼낼때도 result
		
	}//end execute

}//end command
