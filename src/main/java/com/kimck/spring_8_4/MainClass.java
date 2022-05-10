package com.kimck.spring_8_4;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.print("개발하려는 서버를 입력해주세요(dev / run) : ");
		Scanner scann = new Scanner(System.in);
		String str = scann.next();
		
		String config = null;
		
		if(str.equals("dev")) {
			config = "dev";
		} else if(str.equals("run")) {
			config = "run";
		}
		
		scann.close();
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.getEnvironment().setActiveProfiles(config);
//		ctx.load("applicationCTX_dev.xml", "applicationCTX_run.xml");
		ctx.register(ApplicationConfig_dev.class, ApplicationConfig_run.class);
		ctx.refresh();
		
		ServerInfo info = ctx.getBean("serverInfo", ServerInfo.class);
		
		System.out.println("Server IP : " + info.getIpNum());
		System.out.println("Server Port : " + info.getPortNum());
		
		ctx.close();
		
	}

}
