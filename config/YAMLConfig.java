package com.arma.uetds_boot.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {
	private Object spring;

	public Object getSpring() {
		return spring;
	}

	public void setSpring(Object spring) {
		this.spring = spring;
	}
	
	

}
