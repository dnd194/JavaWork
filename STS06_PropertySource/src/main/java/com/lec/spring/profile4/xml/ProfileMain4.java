package com.lec.spring.profile4.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class ProfileMain4 {

	public static void main(String[] args) {
		String config = "run";   //변경 할 부분  'run' or 'dev'
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext();
		//profile이 지정되있을 경우 활성화할 profile을 지정해줘야한다.
		//그렇지 않으면 noSuchBean
		ctx.getEnvironment().setActiveProfiles(config);
		
		//해당 profile의 설정파일만 설정된다.
		ctx.load("appCtx4_dev.xml", "appCtx_run.xml");
		ctx.refresh();
		
		ServiceInfo info = ctx.getBean("serverInfo", ServiceInfo.class);
		System.out.println("ip: "+info.getIpNum());
		System.out.println("port: "+info.getPortNum());
		
		ctx.close();
	}

}
