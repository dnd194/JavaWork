package com.lec.spring.config02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.beans.Score;
import com.lec.beans.Student;

//java 클래스를 이용한 설정
//클래긋 이름앞에 반드시 '''annotation''' 명시 필요
//					@Configuration  --> 이 클래스는 '스프링 설정'에 사용되는 클래스
// 컨테이너의 역할과 비슷

@Configuration
public class AppConfig02 { 
	
	
	@Bean
	public Score score1() {    		// 메서드 이름 score1 이 bean의 id 값 (=name 값)이 된다.
		return new Score(100,70,80,"양호");
	}
	
	@Bean
	public Student stu1() {
		return new Student("삐니",27,score1());
	}
	
}
