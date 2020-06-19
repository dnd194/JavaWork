package com.lec.spring.config04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import com.lec.beans.Score;

@Configuration
@ImportResource("classpath:appCtx04.xml")  //xml의 설정을 자바안으로 가져옴
public class AppConfig04 {

	@Bean
	public Score score2() {
		return new Score(60,40,30,"gdgd");
	}
	
	@Bean
	public Score score1() {
		return new Score(90,90,90,"909090점");
	}
}
