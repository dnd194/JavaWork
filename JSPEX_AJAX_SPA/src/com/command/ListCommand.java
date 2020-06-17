package com.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.beans.WriteDAO;
import com.lec.beans.WriteDTO;

public class ListCommand implements Command {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		WriteDAO dao = new WriteDAO(); 
		WriteDTO[] arr = null;  //초기값
		//------------ Ajax Response 에 필요한 값들-----------------------------------
		StringBuffer message = new StringBuffer();
		String status = "FAIL";  //기본은 FAIL로 설정
		
		//------------ 페이징 에 필요한 겂들 Default ------------------------------------
		int page = 1;  //현재 페이지 ( 디폴트 = 1)
		int pageRows = 8;  //한 페이지에 8개의 글
		int writePages = 10;  //한 페이징에 몇개의 페이지를 표시 하는지  ==> 아래의 페이지네이션의 개수를 말하는 거임
		int totalCnt = 0;  //글은 총 몇개인지
		int totalPage = 0;  //그리고 페이지는 총 몇 페이지 인지
		
		//2개를 받아와야함 ppt 에 있음
		String param;
		param = request.getParameter("page");
		
		//매개변수 검증
		// page 값 => 현재 몇 페이지?
		if(param != null && param.trim().length() != 0) {
			try {
				page = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				//e.printStackTrace();  
				//예외처리 안함 에러 나면 1로 남아있음
			}
		}
		param = request.getParameter("pageRows");
		//pageRows 값 => '한 페이지' 에 몇개의 글 ?
		if(param != null && param.trim().length() != 0) {
			try {
				pageRows = Integer.parseInt(param);
			} catch (NumberFormatException e) {
				//e.printStackTrace();  
				//예외처리 안함 에러 나면 1로 남아있음
			}
		}
		//---------------------------------------------------------
		
		try {
			//글 전체목록 개수 구하기
			totalCnt = dao.countAll();
			// 총 몇 페이지 분량인가?
			totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
			//몇번째 row 부터?
			int fromRow = (page - 1) * pageRows + 1; //오라클 특징 rownum이 1부터 시작
			//int fromRow = (page - 1) * pageRows;  //MySQL 특징 rownum이 0부터 시작
			dao = new WriteDAO();
			arr = dao.selectFromRow(fromRow, pageRows);
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
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("writePages", writePages);
		request.setAttribute("pageRows", pageRows);
		request.setAttribute("totalCnt", totalCnt);
	}//end execute()
}//end command()
