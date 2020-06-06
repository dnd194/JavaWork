package com.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import com.lec.beans.WriteDAO;

public class WriteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int cnt = 0;
		WriteDAO dao = new WriteDAO();
		
		
		String menu_name = request.getParameter("menu_name");
		int  menu_price = Integer.parseInt(request.getParameter("menu_price"));
		HttpSession session = request.getSession();
		int store_uid = (int) session.getAttribute("mem_uid");
		
		if(menu_name != null && menu_name.trim().length()>0) {
			
			try {
				cnt = dao.insert(menu_name, menu_price, store_uid);
			}catch (Exception e) {
				e.printStackTrace();
			}
		}//end if
		
		request.setAttribute("result", cnt);
		//result 로 담았으니 꺼낼때도 result
		
	}//end execute

}//end command
