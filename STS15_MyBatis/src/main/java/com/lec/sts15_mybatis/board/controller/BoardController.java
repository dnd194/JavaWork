package com.lec.sts15_mybatis.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.sts15_mybatis.board.C;
import com.lec.sts15_mybatis.board.beans.BWriteDTO;
import com.lec.sts15_mybatis.board.command.BCommand;
import com.lec.sts15_mybatis.board.command.BDeleteCommand;
import com.lec.sts15_mybatis.board.command.BListCommand;
import com.lec.sts15_mybatis.board.command.BSelectCommand;
import com.lec.sts15_mybatis.board.command.BUpdateCommand;
import com.lec.sts15_mybatis.board.command.BViewCommand;
import com.lec.sts15_mybatis.board.command.BWriteCommand;



@Controller
@RequestMapping("/board")
public class BoardController {

	//controller는 서버가 가동될때 만들어지고 container에 저장된다.
	
	private BCommand command;
	private JdbcTemplate template;
	
	
	public BoardController() {
		super();
		System.out.println("BoardController() 생성");
	}

	@Autowired //이미 컨테이너(servlet-context) 에 jdbcTemplate이 있음
	public void setTemplate(JdbcTemplate template) {
		System.out.println("setTemplate() 호출됬다리");
		this.template = template;
		C.template = template;   // c.template 도 세팅
	}
	
	@GetMapping("/list.do")
	public String list(Model model) {
		command = new BListCommand();
		command.execute(model);
		return "board/list";
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/writeOk.do")
	public String writeOk(BWriteDTO dto, Model model) {
		model.addAttribute("dto", dto);
		new BWriteCommand().execute(model);
		return "board/writeOk";
	}
	
	@GetMapping("/view.do")
	public String view(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BViewCommand().execute(model);
		return "board/view";
	}
	@GetMapping("/deleteOk.do")
	public String deleteOk(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BDeleteCommand().execute(model);
		return "board/deleteOk";
	}
	
	@GetMapping("/update.do")
	public String update(int uid, Model model) {
		model.addAttribute("uid", uid);
		new BSelectCommand().execute(model);
		return "board/update";
	}
	@PostMapping("/updateOk.do")
	public String updateOk(Model model, BWriteDTO dto) {
		model.addAttribute("dto", dto);
		new BUpdateCommand().execute(model);
		return "board/updateOk";
	}
	
}
