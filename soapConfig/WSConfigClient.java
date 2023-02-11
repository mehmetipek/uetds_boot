package com.arma.uetds_boot.soapConfig;


import org.apache.http.auth.UsernamePasswordCredentials;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.arma.uetds_boot.implement.PageInputMethodsImpl;
import com.arma.uetds_boot.implement.ServiceGetMethodsImpl;
import com.arma.uetds_boot.implement.ServiceSetMethodsImpl;

@Configuration
public class WSConfigClient {

	@Value("${client.default-uri}")
	private String defaultUri;

	@Value("${client.user.name}")
	private String userName;

	@Value("${client.user.password}")
	private String userPassword;

	@Bean
	public Jaxb2Marshaller jaxb2Marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("com.arma.uetds_boot.wsdl");

		return jaxb2Marshaller;

	}

	@Bean
	public WebServiceTemplate webServiceTemplate() {
		
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(jaxb2Marshaller());
		webServiceTemplate.setUnmarshaller(jaxb2Marshaller());
		webServiceTemplate.setDefaultUri(defaultUri);
		webServiceTemplate.setMessageSender(httpComponentsMessageSender());

		return webServiceTemplate;
	}

	@Bean
	public HttpComponentsMessageSender httpComponentsMessageSender() {
		HttpComponentsMessageSender httpComponentsMessageSender = new HttpComponentsMessageSender();
		httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());

		return httpComponentsMessageSender;
	}

	@Bean
	public UsernamePasswordCredentials usernamePasswordCredentials() {
		
		System.out.println(userName);
		System.out.println(userPassword);
		return new UsernamePasswordCredentials(userName, userPassword);
	}

	
	@Bean
	@Primary
	public PageInputMethodsImpl pageInputClient() {
		PageInputMethodsImpl client=new PageInputMethodsImpl();
		client.setDefaultUri("https://servis.turkiye.gov.tr/services/g2g/kdgm/uetdsesya?wsdl");
		client.setMarshaller(jaxb2Marshaller());
		client.setUnmarshaller(jaxb2Marshaller());
		client.setWebServiceTemplate(webServiceTemplate());
		return client;
	}
	
	@Bean
	public ServiceGetMethodsImpl serviceGetClient() {
		ServiceGetMethodsImpl client=new ServiceGetMethodsImpl();
		client.setDefaultUri("https://servis.turkiye.gov.tr/services/g2g/kdgm/uetdsesya?wsdl");
		client.setMarshaller(jaxb2Marshaller());
		client.setUnmarshaller(jaxb2Marshaller());
		client.setWebServiceTemplate(webServiceTemplate());
		return client;
	}
	
	@Bean
	public ServiceSetMethodsImpl serviceSetClient() {
		ServiceSetMethodsImpl client=new ServiceSetMethodsImpl();
		client.setDefaultUri("https://servis.turkiye.gov.tr/services/g2g/kdgm/uetdsesya?wsdl");
		client.setMarshaller(jaxb2Marshaller());
		client.setUnmarshaller(jaxb2Marshaller());
		client.setWebServiceTemplate(webServiceTemplate());
		return client;
	}



}
