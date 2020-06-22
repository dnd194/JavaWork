package com.lec.sts10_request.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//이 클래스를 controller로 쓰겠다면 아래 어노테이션이 필요
@Controller
@RequestMapping(value = "/member")  //==> /member 로 시작하는 request 만 처리 한다는 의미
public class MemberController {
	
	@RequestMapping(value="/save") // => /member + /save  ==  /member/save 가 되어보림
	public String saveMember() {
		return "member/save";
	}
	
	@RequestMapping(value ="/load")		//==> member/load 
	public String loadMember() {
		return "member/load";
	}
	
//	@RequestMapping(value ="/search")	//기존에 존재하는 친구를 여기서 다시 한다면 context reloading 중에 에러가 발생한다
//	public String searchMember() {
//		return "member/search";
//	}
}
