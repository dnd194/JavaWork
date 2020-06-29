package com.lec.sts13_jdbc.old;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import old.*;

@Controller
@RequestMapping("/old")
public class OldController {
	
	@GetMapping("/list.do")
	public String list(HttpServletRequest request, HttpServletResponse response) {
		new ListCommand().execute(request, response);
		return "old/list";
	}
	@GetMapping("/view.do")
	public String view(HttpServletRequest request, HttpServletResponse response) {
		new ViewCommand().execute(request, response);
		return "old/view";
	}
	@GetMapping("/write.do")
	public String write(HttpServletRequest request, HttpServletResponse response) {
		return "old/write";
	}
	@PostMapping("/writeOk.do")
	public String writeOk(HttpServletRequest request, HttpServletResponse response) {
		new WriteCommand().execute(request, response);
		return "old/writeOk";
	}
	@GetMapping("/update.do")
	public String update(HttpServletRequest request, HttpServletResponse response) {
		new UpdateCommand().execute(request, response);
		return "old/update";
	}
	@GetMapping("/updateOk.do")
	public String updateOk(HttpServletRequest request, HttpServletResponse response) {
		new UpdateOkCommand().execute(request, response);
		return "old/updateOk";
	}
	@GetMapping("/deleteOk.do")
	public String deleteOk(HttpServletRequest request, HttpServletResponse response) {
		new DeleteCommand().execute(request, response);
		return "old/deleteOk";
	}
	
}
