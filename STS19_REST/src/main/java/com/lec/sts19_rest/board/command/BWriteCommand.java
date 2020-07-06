package com.lec.sts19_rest.board.command;

import java.util.Map;

import org.springframework.ui.Model;

import com.lec.sts19_rest.board.C;
import com.lec.sts19_rest.board.beans.BWriteDTO;
import com.lec.sts19_rest.board.beans.IWriteDAO;

public class BWriteCommand implements BCommand {

	@Override
	public void execute(Model model) {
		
		// Model 안에 있는 값(attribute) 꺼내기
		Map<String, Object> map = model.asMap();
		BWriteDTO dto = (BWriteDTO)map.get("dto");

//		BWriteDAO dao = new BWriteDAO();
//		int result = dao.insert(dto);
//		model.addAttribute("result", result);
		
		// MyBatis 사용
		IWriteDAO dao = C.sqlSession.getMapper(IWriteDAO.class);
		model.addAttribute("result", dao.insert(dto));
		
		System.out.println("생성된 uid 는 " + dto.getUid());
		
		//model.addAttribute("result",
		//		dao.insert(dto.getSubject(), dto.getContent(), dto.getName()));
		
		
		
	}

}











