package com.lec.sts11_validation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec.beans.WriteDTO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	
	@GetMapping("write.do")
	public String write() {
		
		return "board/write";
	}
	
	@GetMapping("writeOk.do")
	public String writeOk(@ModelAttribute("w") @Validated WriteDTO dto,
								BindingResult result) {
		//BindingResult => validator가 유효성 검사를 한 결과가 담긴 객체
		//이친구는 유효성검사를 기본적으로 한다. 1차적인 검증 역할을 함
		System.out.println("writeOk(): "+dto.getUid() +" : " + dto.getName());
//		System.out.println("발생한 에러의 개수 "+ result.getErrorCount()+ " 개");
//		System.out.println("validate 전"); showErrors(result); //매개변수로 result
		String page = "board/writeOk";
		
		
		//validator를 수행 직접 꺼내와야함   객체를 생성해서 함수를 실행시켜
//		BoardValidator boardValidator = new BoardValidator();
//		boardValidator.validate(dto, result);  
		System.out.println("validate 후 "); showErrors(result);
		
		if(result.hasErrors()) {	//파라메터에 하나라도 에러가있으면
			page = "board/write";
		}
		
		
		return page;
	}
	
	//ERROR 에 담겨 있는 에러들을 다 출력해보기
	//도우미 함수  Errors도 import 해줘야함   error는 BindingResult 의 조상
	public void showErrors(Errors errors) {
		if(errors.hasErrors()) {
			System.out.println("에러 개수 : "+errors.getErrorCount());
			System.out.println("\t[field]\t|[code]");
			
			List<FieldError> errList = errors.getFieldErrors();
			//getFieldErrors() 의 return 값이 List<FieldError>
			for(FieldError err : errList) {
				System.out.println("\t"+err.getField() + "\t|"+err.getCode());
//				각 에러에대한 필드 값과 코드 값을 출력
			}
			
		}else {
			System.out.println("에러가 없네염");
		}
		
	}
	
	//이 컨트롤러 클래스의 handler 에서 폼데이터를 바인딩 할 때 검증하는 개체 지정
	@InitBinder    // ==> 폼데이터를 바인딩 할 때 검증하는 개체 지정 를 의미한다.
	public void initBinder(WebDataBinder binder) {
		binder.setValidator(new BoardValidator());
	}
	
	
	
	
	
	
	
	
}
