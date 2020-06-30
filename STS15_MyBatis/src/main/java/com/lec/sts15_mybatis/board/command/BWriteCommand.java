package com.lec.sts15_mybatis.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts15_mybatis.board.beans.BWriteDAO;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		//model 안에 있는 값 (attribute) 꺼내기
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto"); //형변환
		BWriteDAO dao = new BWriteDAO();
		int result = dao.insert(dto); 
		model.addAttribute("result", result);
		
;		
	}

}
