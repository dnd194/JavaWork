package com.lec.sts13_jdbc.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(Model model) {

		BWriteDAO dao = new BWriteDAO();
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid"); //형변환
		int result = dao.deleteByUid(uid);
		model.addAttribute("result", result);
	}

}
