package com.lec.sts15_mybatis.board.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.sts15_mybatis.board.beans.BWriteDAO;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		BWriteDAO dao = new BWriteDAO();
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid"); //형변환
		List<BWriteDTO> list = dao.readByUid(uid);
		model.addAttribute("view", list);
		
	}

}
