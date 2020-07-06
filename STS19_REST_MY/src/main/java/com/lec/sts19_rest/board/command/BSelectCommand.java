package com.lec.sts19_rest.board.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BSelectCommand implements BCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid"); //형변환
//		BWriteDAO dao = new BWriteDAO();
//		List<BWriteDTO> update = dao.selectByUid(uid);
//		model.addAttribute("update", update);
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("update", dao.selectByUid(uid));
		
		
		
	}

}
