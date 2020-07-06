package com.lec.sts19_rest.ajaxcommand;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.IAjaxDAO;


public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int cnt = 0;

		IAjaxDAO dao = C.sqlSession.getMapper(IAjaxDAO.class);
		
		// ajax response 에 필요한 값들
		StringBuffer message = new StringBuffer();
		String status = "FAIL";   // 기본 FAIL

		// 유효성 검증
		String [] params = request.getParameterValues("uid");
		int [] uids = null;
		
		if(params == null || params.length == 0) {
			message.append("[유효하지 않은 parameter 0 or null]");
		} else {
			uids = new int[params.length];
			try {
				for(int i = 0; i < params.length; i++) {
					uids[i] = Integer.parseInt(params[i]);
				}
				cnt = dao.deleteByUid(uids);
				status = "OK";
			} catch (NumberFormatException e) {
				//e.printStackTrace();
				message.append("[유효하지 않은 parameter]" + Arrays.toString(params));
			} catch (Exception e) {
				message.append("[트랜잭션 에러:" + e.getMessage() + "]");
			}
		} // end if

		request.setAttribute("result", cnt);
		request.setAttribute("status", status);
		request.setAttribute("message", message.toString());
	}

}











