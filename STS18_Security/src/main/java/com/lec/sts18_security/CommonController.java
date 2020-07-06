package com.lec.sts18_security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/accessError")
	public void accessDenied(Authentication auth, Model model) {
					//Authentication   spring security 에서 제공함
		System.out.println("access Denied : "+auth);
		model.addAttribute("msg", "접근 권한 거부");
	}
	
	@RequestMapping("/customLogin")
	public void loginInput(String error, String logout, Model model) {
		
		System.out.println("error : "+error); //로그인 실패했을경우
		System.out.println("logout : "+logout);
		
		if(error != null) {
			model.addAttribute("error", "login Error check your id");
			
		}
		if(logout != null) {
			model.addAttribute("logout", "logout!!");
			
		}
		
	}

	@GetMapping("/customLogout")
	public void logoutGet() {
		System.out.println("customLogout");
	}
	
	
	@PostMapping("/customLogout")
	public void logoutPost() {
		System.out.println("post custom logout");
	}
	
	
	
	
}
