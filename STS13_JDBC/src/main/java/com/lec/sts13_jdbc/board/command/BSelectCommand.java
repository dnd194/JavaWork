package com.lec.sts13_jdbc.board.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;

public class BSelectCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BWriteDAO dao = new BWriteDAO();
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid"); //형변환
		List<BWriteDTO> update = dao.selectByUid(uid);
		model.addAttribute("update", update);
	}

}
