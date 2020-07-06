package com.lec.sts19_rest.board.command;

import java.util.Arrays;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BSelectCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid");

//		BWriteDAO dao = new BWriteDAO();
//		BWriteDTO dto = dao.selectByUid(uid);
//		model.addAttribute("list", Arrays.asList(dto));
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("list", Arrays.asList(dao.selectByUid(uid)));
		

	}

}















