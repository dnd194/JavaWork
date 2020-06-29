package com.lec.sts11_validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.lec.beans.WriteDTO;

public class BoardValidator implements Validator {

	
	
	
	//이 Validator 가 제공하는 class의 인스턴스 (clazz)를 유효성 검사를 할 수 있는가??
	@Override
	public boolean supports(Class<?> clazz) {

		//검증할 객체의 클래스타입인지 확인 : WriteDTO = class 인가의 가능 여부
		return WriteDTO.class.isAssignableFrom(clazz);
		// boolean 타입을 return 한다.  서로 같은 클래스인지를 확인한다고 보면됨
	}

	
	//주어진 객체(target) 에 대한 유효성 검사를 하고
	//유효성 검사에 오류가 있는 경우, 주어진 객체에 이 오류들을 errors에 등록한다.
	//뽑을때는 getErrorCount
	@Override
	public void validate(Object target, Errors errors) {
		System.out.println("validate() 라구 ^^ 생각해바");
		WriteDTO dto= (WriteDTO) target;
		
		//수행할 parameter 검증들
		int uid = dto.getUid();
		if(uid == 0) {
			System.out.println("uid 오류^^");
			//에러등록  ==> rejectValue(field, errorCode) 둘다 String
			errors.rejectValue("uid", "유효하지않은 uid 값입니다^~^");
		}
		
		String name = dto.getName();
		if(name == null || name.trim().length() ==0) {
			System.out.println("name 오류 : 반드시 한글자라도 입력하가구");
			errors.rejectValue("name", "이름 쓰라구");
		}
		
		//ValidatorUtils 사용
		//단순히 빈 폼 데이터를 처리할 때는 아래와 같이 사용가능.
		//두 번째 매개변수 "subject"는 반드시 target 클래스 ==> dto 필드명이여야한다.
		//이는 Errors에 등록될때 동일한 field 명으로 등록된다.
		//다른 필드명을 쓰면 invalid property 가 뜸
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "subject", "비어있거나 공백이있어욤");
		
		
		
		
		
		
	}

}
