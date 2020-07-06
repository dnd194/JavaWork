package com.lec.sts19_rest.ajaxcommand;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IAjaxDAO;

public class ListCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		IAjaxDAO dao = C.sqlSession.getMapper(IAjaxDAO.class);
		List<BWriteDTO> arr = null;
		
		//WriteDAO dao = new WriteDAO();  // DAO 객체 생성
		//WriteDTO [] arr = null;  
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL
		
		// 페이징 관련 세팅값들
		int page = 1;  // 현재 페이지 (디폴트는 1 page)
		int pageRows = 8;   // 한 '페이지' 에 몇개의 글을 리스트? (디폴트 8개)
		int writePages = 10;  // 한 [페이징] 에 몇개의 '페이지' 를 표시? (디폴트 10)
		int totalCnt = 0;    // 글은 총 몇개인지?
		int totalPage = 0;   // 총 몇 '페이지' 분량인지?
		
		String param;
		
		// page 값 : 현재 몇 페이지?
		param = request.getParameter("page");
		if(param != null && param.trim().length() != 0) {
			try {				
				page = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		// pageRows 값 :  '한 페이지' 에 몇개의 글?
		param = request.getParameter("pageRows");
		if(param != null && param.trim().length() != 0) {
			try {				
				pageRows = Integer.parseInt(param);
			} catch(NumberFormatException e) {
				// 예외 처리 안함
			}
		}
		
		
		try {
			// 글 전체 개수 구하기
			totalCnt = dao.countAll();
			
			// 총 몇 페이지 분량인가?
			totalPage = (int)Math.ceil(totalCnt / (double)pageRows);
			
			// 몇번재 row 부터 ?
			int fromRow = (page - 1) * pageRows + 1;  // ORACLE 은 1부터 ROWNUM시작
			//int fromRow = (page - 1) * pageRows;  // MySQL 은 0부터 시작
			
			//dao = new WriteDAO();
			arr = dao.selectFromRow(fromRow, pageRows);
			
			if(arr == null) {
				message.append("[리스트할 데이터가 없습니다]");
			} else {
				status = "OK";
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
			message.append("[트랜잭션 에러:" + e.getMessage()+ "]");
		} // end try
		
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
		request.setAttribute("list", arr);
		
		request.setAttribute("page", page);
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("writePages", writePages);
		request.setAttribute("pageRows", pageRows);
		request.setAttribute("totalCnt", totalCnt);
		
	} // end execute()
} // end Command























