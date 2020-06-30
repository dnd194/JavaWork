package com.lec.sts15_mybatis.board.command;

import java.util.List;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.beans.BWriteDAO;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		BWriteDAO dao = new BWriteDAO();
		List<BWriteDTO> list = dao.select();
		model.addAttribute("list", list);
	}

}
