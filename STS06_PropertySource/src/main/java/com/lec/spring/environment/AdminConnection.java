package com.lec.spring.environment;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class AdminConnection implements EnvironmentAware, InitializingBean, DisposableBean {

	private Environment env;
	private String adminId;
	private String adminPw;
	
	// 빈 이 생성될때 호출
	// afterPropertiesSet() 이전에 호출, 즉 InitializingBean 보다 먼저 호출됨에 주촉
	public void setEnvironment(Environment environment) {
		System.out.println("setEnvironment() 호출");
		setEnv(environment);
	}

	public void destroy() throws Exception {
		// TODO Auto-generated method stub

	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() 호출");
		// 설정파일의 property 들.
		setAdminId(env.getProperty("admin.id"));
		setAdminPw(env.getProperty("admin.pw"));
	}

	public Environment getEnv() {
		return env;
	}

	public void setEnv(Environment env) {
		this.env = env;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminPw() {
		return adminPw;
	}

	public void setAdminPw(String adminPw) {
		this.adminPw = adminPw;
	}


	
	
	
	
}
