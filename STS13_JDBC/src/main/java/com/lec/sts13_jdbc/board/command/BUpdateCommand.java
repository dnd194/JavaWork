package com.lec.sts13_jdbc.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts13_jdbc.board.beans.BWriteDAO;
import com.lec.sts13_jdbc.board.beans.BWriteDTO;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {

		BWriteDAO dao = new BWriteDAO();
		Map<String, Object> map = model.asMap();  //모델에서 꺼낼 때 필 수
		BWriteDTO dto = (BWriteDTO) map.get("dto");	//형변환 또한 필수 
		int updateOk = dao.update(dto);
		model.addAttribute("updateOk", updateOk);
	}

}
