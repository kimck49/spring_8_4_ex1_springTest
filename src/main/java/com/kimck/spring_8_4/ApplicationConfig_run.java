package com.kimck.spring_8_4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("run")
public class ApplicationConfig_run {
	
	@Bean
	public ServerInfo serverInfo() {
		
		ServerInfo server = new ServerInfo();
		
		server.setIpNum("211.56.78.114");
		server.setPortNum("80");
		
		return server;
	}
}
