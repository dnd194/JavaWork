package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

		WriteDAO dao = new WriteDAO();   //
		WriteDTO[] arr = null;  //초기값
		
		try {
			//트랜잭션수행
			arr = dao.select();
			
			//결과를 담아야한다.  결과 = arr ,  바구니 = request
			// list 란 name 으로 request에 arr 값 전달
			//즉 request에 담아서 컨트롤러에 전달되는 셈.
			request.setAttribute("list", arr);
			// list 로 set 했으니 나중에 꺼낼때도 (get 할때도 ) list로 꺼내야함
			//잊지마세염
			
		}catch(SQLException e) {
			e.printStackTrace();
			
			//만약에 Connection Pool을 사용한다면
			//Naming Exception 도 처리해줘야함
		}
	}

}
