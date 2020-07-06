package com.lec.sts19_rest.board.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");

//		BWriteDAO dao = new BWriteDAO();
//		BWriteDTO dto = dao.readByUid(uid);
//		model.addAttribute("list", Arrays.asList(dto));
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		dao.incViewCnt(uid); // 조회수 증가
		
		BWriteDTO dto = dao.selectByUid(uid);  // 똑똑하게 BWriteDTO 를 리턴한다.
		model.addAttribute("list", Arrays.asList(dto));
		
		// Arrays.asList(new String[]{"aaa", "bbb"})
		// Arrays.asList("aaa", "bbb")

	}

}















