package com.lec.spring.config03;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.beans.Score;

@Configuration
public class AppConfig03 {

		@Bean
		public Score score1() {   //id가 score1 인 bean 생성
			return new Score(70,60,50,"gdgd");
		}
	
	
}
