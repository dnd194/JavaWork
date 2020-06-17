package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.CategoryDAO;
import com.lec.beans.CategoryDTO;

public class CateListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		CategoryDAO dao = new CategoryDAO(); 
		CategoryDTO[] arr = null;  //초기값
		//------------ Ajax Response 에 필요한 값들-----------------------------------
		StringBuffer message = new StringBuffer();
		String status = "FAIL";  //기본은 FAIL로 설정
		
		int depth = Integer.parseInt(request.getParameter("depth"));
//		String parent = "";
		if(request.getParameter("parent") == null) {
			try {
				
				dao = new CategoryDAO();
				arr = dao.select2(depth);
				if(arr==null) {
					message.append("[리스트할 데이터가 없다리]");
				}else {
					status="okeey";
				}
			}catch(SQLException e) {
				//e.printStackTrace();
				message.append("[Transaction error :" +e.getMessage()+"]");
			}//end try
			request.setAttribute("status", status);
			request.setAttribute("message", message.toString());
			request.setAttribute("list", arr);
		}else {
				try {
				int parent = Integer.parseInt(request.getParameter("parent"));
				
				dao = new CategoryDAO();
				arr = dao.select2(depth,parent);
				if(arr==null) {
					message.append("[리스트할 데이터가 없다리]");
				}else {
					status="okeey";
				}
			}catch(SQLException e) {
				//e.printStackTrace();
				message.append("[Transaction error :" +e.getMessage()+"]");
			}//end try
			request.setAttribute("status", status);
			request.setAttribute("message", message.toString());
			request.setAttribute("list", arr);
		}
		

	}

}
