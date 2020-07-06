package com.lec.sts19_rest.board.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.AjaxWriteList;
import com.lec.sts19_rest.board.beans.AjaxWriteResult;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

import oracle.jdbc.proxy.annotation.Post;

@RestController
@RequestMapping("/board")
public class SpringRestController {

	@GetMapping("/restData/{page}/{pageRows}")
	public AjaxWriteList list(Model model, @PathVariable("page") int page, @PathVariable("pageRows") int pageRows) {
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본은 FAIL로 설정

		int writePages = 10; // 한 페이징에 몇개의 페이지를 표시 하는지 ==> 아래의 페이지네이션의 개수를 말하는 거임
		int totalCnt = 0; // 글은 총 몇개인지
		int totalPage = 0; // 그리고 페이지는 총 몇 페이지 인지

		String param;
		param = (String) model.getAttribute("page");

		if (param != null && param.trim().length() != 0) {
			try {
				page = Integer.parseInt(param);
			} catch (NumberFormatException e) {
			}
		}
		param = (String) model.getAttribute("pageRows");
		if (param != null && param.trim().length() != 0) {
			try {
				pageRows = Integer.parseInt(param);
			} catch (NumberFormatException e) {
			}
		}

		totalCnt = dao.select().size();
		totalPage = (int) Math.ceil(totalCnt / (double) pageRows);
		int fromRow = (page - 1) * pageRows + 1; // 오라클 특징 rownum이 1부터 시작

		List<BWriteDTO> arr = dao.selectFromRow(fromRow, pageRows);
		if (arr == null) {
			message.append("[리스트할 데이터가 없다리]");
		} else {
			status = "okeey";
		}

		AjaxWriteList result = new AjaxWriteList();
		result.setStatus(status);
		result.setMessage(message.toString());
		List<BWriteDTO> dtoArr = dao.selectFromRow(fromRow, pageRows);

		if (dtoArr != null) {
			result.setCount(dtoArr.size());
			result.setList(dtoArr);
		}
		try {
			result.setPage(page);
			result.setTotalPage(totalPage);
			result.setWritePages(writePages);
			result.setPageRows(pageRows);
			result.setTotalCnt(totalCnt);
		} catch (Exception e) {
		}

		return result;

	}

	@GetMapping("/view.ajax/{uid}")
	public AjaxWriteList view(@PathVariable("uid") int uid, Model model) {

		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; 
		AjaxWriteList result = new AjaxWriteList();

		dao.incViewCnt(uid);
		List<BWriteDTO> arr = dao.selectByUid(uid);
		if (arr == null) {
			message.append("[리스트할 데이터가 없다리]");
		} else {
			status = "okeey";
		}
		result.setMessage(message.toString());
		result.setStatus(status);
		result.setList(arr);
		System.out.println(uid);
		return result;

	}

	@PostMapping("/writeOk.ajax")
	public AjaxWriteList write(Model model, String subject, String name, String content) {
		int cnt = 0;
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		AjaxWriteList result = new AjaxWriteList();
		BWriteDTO dto = new BWriteDTO();

		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본은 FAIL로 설정

		// 유효성 체크
		if (name == null || name.trim().length() == 0) {
			message.append("[유효하지않은 parameter: 작성자 필수]");
		} else if (subject == null || subject.trim().length() == 0) {
			message.append("[유효하지않은 parameter: 글 제목(subject) 필수]");
		} else {

			try {
				cnt = dao.insert(subject, content, name);
				if (cnt == 0) {
					message.append("[트랜젝션 실패 : 0 insert");
				} else {
					status = "Ok";
				}
			} catch (Exception e) {
//				e.printStackTrace(); 
				message.append("[트랜젝션 에러 :" + e.getMessage() + "]");
			}
		} // end if
		dto.setContent(content);
		dto.setName(name);
		dto.setSubject(subject);
		List<BWriteDTO> list = new ArrayList<BWriteDTO>();
		list.add(dto);
		result.setMessage(message.toString());
		result.setStatus(status);
		result.setList(list);
		return result;
	}

	@PostMapping("/deleteOk.ajax")
	public AjaxWriteResult delete(int[] uid) {
		AjaxWriteResult result = new AjaxWriteResult();
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		int cnt = 0;
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본은 FAIL로 설정

		if(uid == null || uid.length == 0) {
			message.append("[유효하지 않은 parameter 0 or null]");
		}else {
			for(int i = 0; i< uid.length; i++) {
				try {
					cnt = dao.deleteByUid(uid[i]);
					status = "Ok";
				} catch (Exception e) {
					message.append("유효하지 않은 parameter]" + uid[i]);
				}
			}
		}
		
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);

		return result;
	}
	
	@PostMapping("/updateOk.ajax")
	public AjaxWriteList update(BWriteDTO dto, int uid) {
		
		AjaxWriteList result = new AjaxWriteList();
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		
		int cnt = 0;
		String param = dto.getSubject();
		
		StringBuffer message = new StringBuffer();
		String status = "FAIL"; // 기본은 FAIL로 설정
		
		if(param == null) {
			message.append("[유효하지 않은 parameter 0 or null]");
		}else if (param == null || param.trim().length() == 0){
			message.append("[유효하지않은 parameter: 글 제목(subject) 필수]");
		}else {
			
			try {
				
				cnt = dao. update(uid, dto);
				status = "Ok";
				if(cnt == 0) {
					message.append("[0 update]");
				}
			} catch(Exception e) {
				message.append("[유효하지 않은 parameter]" +param );
			}
		}

		
		result.setCount(cnt);
		result.setMessage(message.toString());
		result.setStatus(status);
		
		
		return result;
	}
	
	
	

}
