package com.lec.sts19_rest.board.command;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BViewCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		Map<String, Object> map = model.asMap();
		int uid = (Integer)map.get("uid"); //형변환
//		BWriteDAO dao = new BWriteDAO();
//		List<BWriteDTO> list = dao.readByUid(uid);
//		model.addAttribute("view", list);
		
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		dao.incViewCnt(uid);
		model.addAttribute("view", dao.selectByUid(uid));
//		model.addAttribute("view", dao.incViewCnt(uid));
		
		
		
		
		
		
		
	}

}
