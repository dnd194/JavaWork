package com.lec.sts19_rest.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BUpdateCommand implements BCommand {

	@Override
	public void execute(Model model) {

		Map<String, Object> map = model.asMap();  //모델에서 꺼낼 때 필 수
		BWriteDTO dto = (BWriteDTO) map.get("dto");	//형변환 또한 필수 
//		BWriteDAO dao = new BWriteDAO();
//		int updateOk = dao.update(dto);
//		model.addAttribute("updateOk", updateOk);
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		//update 메서드가 2가지 매개변수를 받을떄
		model.addAttribute("updateOk", dao.update(dto.getUid(), dto));
		
//		model.addAttribute("updateOk", dao.update(dto));
		
		
	}

}
