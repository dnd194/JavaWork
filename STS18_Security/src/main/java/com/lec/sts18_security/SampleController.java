package com.lec.sts18_security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/*")
public class SampleController {

	
	@GetMapping("/all")
	public void doAll() {   //리턴 타입이 void 이면 url과 같은 경로의 jsp 파일을 찾는다 ==> all.jsp
		System.out.println("doAll() : access everybody");
	}
	
	@GetMapping("/member")	//member.jsp
	public void doMember() {
		System.out.println("doMember() : access member only");
	}

	@GetMapping("/admin")	//admin.jsp
	public void doAdmin() {
		System.out.println("doAdmin() : access admin only");
	}

}
